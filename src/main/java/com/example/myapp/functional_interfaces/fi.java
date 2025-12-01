package com.example.myapp.functional_interfaces;

import com.example.myapp.Lambda.Calculator;

import java.math.BigInteger;
import java.nio.file.Path;
import java.sql.Array;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.random.RandomGenerator;

public class fi {
    public static void main(String[] args) {
        //TODO: przed przejscime do lambdy

        //Myslenie interfejsu funckyjnego:
        //Przekazac zachowanie  zamiast klasy chce przekazasc pojedyncze zachowanie do metody zamioast wtorzyc klase

        //Kiedy tworzymy swój właśny interfejs funckyjny??
        //1. Kiedy żadne z gotowych z java.util.function czyli Function,Supplier,Consumer,.Predicate niepomogą nam
        //2. Kiedy sama nazwa mówi więcej niż  Supplier, COnsumer, Function wtedy warto stworzyc swoj wlasny interfejs funckyjny
        //3. Kiedy musi rzucić wyjątek włąsny
        //4, najwzniejśzniej to tworzym wtedy kiedy bedzie wieloktornie uzywany w wielu miejsach

//        Czy to jest jedyna operacja? Czy istnieje juz interfejs fucnyjny który moŋe wykorzystać? Czy potrzebuyje aby nazwa byłą bardzije konkretna?
        //Czy chce swoje exceptiony?


        StringTransformer joinS = makeTransform("join");

        // pierwszyn psopsób uzycia intefejksun fucnkyjnego
        String joined = joinS.transform("ala", "kot");
        System.out.println(joined);
        //TO nam zwróci StringTRansformer  bo  wejdziemy w case w switchu i

//        System.out.println(makeTransform("join").transform());

        Account[] accs = new Account[2];
        accs[0] = new Account(new BigInteger("1"), "a1");
        accs[1] = new Account(new BigInteger("10"), "a2");

        Predicate<String> p = (s) -> s.equals("Trawa");

        ThrowingSupplier<String> supp = () -> String.valueOf(2);

        Function<Integer,Integer> multiply = FunctionUtils.makeDoubler();

        Integer result = multiply.apply(5);

        Function<Integer,Function<Integer,Integer>> f = (a)->(b)->a*b;

        FunctionUtils.makeAdder().apply(2).apply(3);

        FunctionUtils.makeJoin().apply((a)->a+5).apply(5);

        Integer indx = FunctionUtils.getIndex().apply(List.of("a","b","c")).apply("b");

        //Tutaj chodzi o to że my już sobiw sadzilismy te toys jako taki hm cos takiego na czym bedzime ymogli wykonywac pare razy danza czynnosc

        Function<Object, List<Object>> withoutToy = FunctionUtils.removeGiven().apply(List.of("a", "a", "b", "c", "a"));
        //Jak widać możemy sobie uzyć naszej funckji wiele razy na innych zmiennych
        List<Object> toysWithoutA = withoutToy.apply("a");
        List<Object> toysWithoutB = withoutToy.apply("b");

        Function<Integer,Integer> multi = (a)->a*a;
        Function<Integer,Integer> add10 = (b)->b+10;
        FunctionUtils.composeSimple(multi,add10);



    }

    public static <T> List<T> filter(T[] arr, Predicate<T> p) {
        List<T> finded = new ArrayList<T>();
        for (int i = 0; i < arr.length; i++) {
            if (p.test(arr[i])) {
                finded.add(arr[i]);
            }
        }
        return finded;
    }

    public static int operate(int a, int b, Calculator calculator) {
        return calculator.calculate(a, b);
    }

    public static Calculator makeOperation(String op) {
        //Tutaj zwracamy same lambdy ale WAŻNE ŻE TE LAMBDY SA ODPOWIEDNIKIEM METODY CALCUILATE Z INTERFEJSU FUNCYJNEGO CALCUALTOR
        //CZylki one sa odpwoidnei i daltego silnik nie ruzca błedem bo one tutaj maja poprwany typ danych taki jaki jest w metodize calcualtor
        return switch (op) {
            case "add" -> (a, b) -> a + b;
            case "sub" -> (a, b) -> a - b;
            case "mul" -> (a, b) -> a * b;
            default -> throw new IllegalStateException("Unexpected value: " + op);
        };
    }

    //Tutja w zelznosci od tego
    public static StringTransformer makeTransform(String operation) {
        return switch (operation) {
            case "join" -> (a, b) -> a + b;
            default -> throw new IllegalArgumentException("Bad argument");
        };
    }

//    public static BigInteger getAccountAmount(String accountName, Account[] accounts) {
//        //find account
//        Optional<Account> ac = Arrays.stream(accounts).filter((acc) -> acc.getName().equals(accountName)).findFirst();
//    }

    //To jest Retry pattern stooswanie w bzie dancyh ze gdy coś czasem zawiedzie to próbujemy jeszcze raz
    //możemy założyc ze defautlwoo jest 10 attempów i jesli coś za 1 razem pójdzie nie tka no bo może byc chwilwo coś z internetne no nie no to nie mozmey za 1 razem
    // odpuścic  i po prostu próbujemy ilośc razy daną
    public static <T,U,F> T retry(ThrowingSupplier<T> supplier, int attempts) throws Exception {
        Exception last = null;
        for (int i = 0; i < attempts; i++) {
            try {
                return supplier.get();
            } catch (Exception e) {
                last = e;
            }
        }
        throw last;
    }

    public static int loadUserProfile() throws Exception {
        int r = (int) (Math.random() *50);
        if(r>25){
            return r;
        }
        throw new Exception("problem");
    }

    public static void connectToDatabase() throws Exception{
        for (int i = 0; i < 3; i++) {
            throw new Exception("Problem z serwerem");
        }
        System.out.println("wydobyto dane");
    }
    public static String readSettingsFile(Path path) throws Exception{
        Exception ex = new Exception("ex");
        if(!path.getFileName().equals("test")){
            return "good";
        }
        throw ex;
    }

    //TODO:SUMMARY Z POPRZEDNIEJ NAUKI:
    //INTERFEJSY FUNCKYJNE TWORZYMW TEDY KEIDY CHCEMY PRZEKAZAC ZACHOWANIE CZYLI WTEDY KIEDY CCHEMYH POWEIDZIEC FUNCKJI
    // ZACHOUJ SIE TAK ZEBY PO PRZEKAZANIU TYCH PARAMETRÓW WYKONASZ TE FUNCKJE ALBO ZWR ÓC TE FUNCKJE
    // ALBO WYKONAS ZTE FUNCKJE KTÓ®E POZNIEJ WYKONA TE FUNCKJE NA TEJ FUNCKJI DZIEKI CZEMU ZWROCI NAM  TO
    // PAMIETAJMY ZE  WAZNE JEST TO ABY PRZY TWOREZNIU INTERFEJSU FUCNKJYUNNEGO POMYLSLSI O TYM ZE MA BYC ON UZYYTY WEIELKTORNIE uzywany w wielu miejscach
    // i jesli to jest najweniszje jesli chcemy już stworzyc włąsny interfejs funckyjny to pomyślmy o tym czy juz taki nie istnieje w java.util bo mozę juz tam byc



}



















