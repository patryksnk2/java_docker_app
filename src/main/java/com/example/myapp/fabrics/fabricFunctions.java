package com.example.myapp.fabrics;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class fabricFunctions {
    public static void main(String[] args) {

//        TODO:--Farbyki funckji
        //Funckje które zwracają inne funckje na podstawie konfiguracji i parametrów

//        -=-Pojęcia
        //Funckja fabryczna - metoda która przyjmuje parametry konfigruacyjne i zwraca Function,SUpplier lub inny interfejs funckyjny
        //TODO:Closures - Zwróćna funckja pamięta parametry z fabryki funckji czyli funckji z któ©ej zostałą zwrócona
        //Kompozycja z istniejącymiu Funckjami - Łączenie base + postProcess
        //Obsługa błędów w zwróconjej funckji - warppery(ratry,fallback)
        //Warianty: Czyste(niemutaowalny) vs stanowe - kiedy zwróconna funckja powinna być czysta(Bez side effectów) a kiedy mieć stan


        Function<Object, Integer> res = makeConverter((a) -> (100) + (Integer) a, (a) -> a * 5);
        res.apply(2);


        Function<String, Integer> musicSubject = compareSubjectsPower("Music");
        Integer isMusicBetter = musicSubject.apply("Mathematics");

        //Tutaj funckja któ©a jest zwróćna w zmiennej result zapamiętuje wartość 10
        // przez co wie ze dostała zmeinan o wartosci 10 i zwraca wynik 15 bo 10+5
        //Lambda nadal pamięta że a = 10 zamraza te wartosc zapamietuje ją

        var result = makeAdder(10);

        result.apply(5);


        String[] itemNames = {"mouse","pad","laptop","monitor","system"};
        Integer r = new Random().nextInt(1,20);
        String desc = "None";
        String randomValue = String.valueOf(new Random().nextInt(1,2000));
        BigDecimal itemValue = new BigDecimal(randomValue);

//        initializeItems();
        Predicate<Item> isHigherThan1000 = (item)->item.value().compareTo(BigDecimal.ZERO)>0;
        Function<List<Item>,Boolean> validateItems = (items)->items.stream().allMatch(isHigherThan1000);
    }

    public static Function<String[],List<String>> initializeItems(Function<String[],List<String>> base, Function<List<Item>,Boolean> postProcess){
        return base.andThen(postProcess);
    }



    public static Function<Integer,Integer> makeAdder(int b){
        //b jest zmienna z funckji zewnetrznej
        //a jest parametrem lambda

        return (a)->a+b;
    }

    public static <T,R> Function<T,R> maker(Function<T,R> base, UnaryOperator<R> postProcess){
        //Przyjmuje input jako wartość zwracanej przeze mnie funkji w metodzie
        return input->{
            // wywkonuje funckje  base ze zmienna input
            //input-. base.andTHen(postProcess)
            //Tutaj jest zapamiętywana zmienna inter to jest clousura bo zapamiętuuje zmienną inter
            //Te dwie funckje na dolem zyja w tej fucnkji na dole
            R inter = base.apply(input);
            return postProcess.apply(inter);
            //Jakby java nie miaął closures to po wywołaniu metody maker wraz z jej parametrami
            // bae i postProces zniknełyby i ich  wyniki nie miałby sensu
        };
    }



    public static <T,R> Function<T,R> makeConverter(Function<T,R> base, UnaryOperator<R> postProcess){
        //Tutaj chodzi o to ze fucnkja base to ejst właśnie ta funckja bazowa któ©a wykonuje główna operacje a funckja postProcess
        // TO fucnkja któ©a już wykona sie po głównej oepracji an wyniku kt©óy zwróci funckaj bazowa czyli postProcess nazwa jest idealna
        // BO wykonuje sie po procesie
        //Chcemy łączyć je dynbamiczne

        //TODO: Sedno całej farbyki funckji czyli tworze nową funckje na podstawie dwóch innych czyli jeśli wiem że
        return base.andThen(postProcess);
    }

    public static Function<String,Integer> compareSubjectsPower(String subject){
        return (a)-> Math.max(a.length(), subject.length());
    }
    public static Function<Integer,String> getBetterSubjectName(){
        return (a)-> "Stronger subject is"+getSubjectNameBaseOnPower(a);
    }
    public static String getSubjectNameBaseOnPower(int power){
        return switch (power){
            case 5->"Music";
            case 11->"Mathematics";
            default -> "Wrong subject";
        };
    }
    //Mamy 2 funckje któ©a w sumie jedna wykonuje sie po drjugiej jak widać najpierw chcemyt pow©ónac ze sobą przedmioty a pozniej wyciąganć nazwę z ich mocy
    //a wieć mozna zrobic fabrykę któ©a bedzie ejdna nowa ą funckja na podstawie tych dwóch
//

    public static <T,R> Function<T,R> compareSubject(Function<T,R> base, UnaryOperator<R> postProcess){
        //TUtaj funckje którą zwracam ma w sobie referencje do base i do postProcess ale co nam to daje ?
        //input->PostProcess.apply(base.apply(input)) - Lambda zapamiętuje base i postProcess
        //TODO:Closures-> Funckja zwrócona z innej funckji pamięta zmienne w momemcnie jej tworzenia nawet wtedy gdy już się skończyła
        return base.andThen(postProcess);
    }
    //TODo:Clousures



    //CO musze opanować w D1
    //Typy base i postProcess
    //UnaryOperator<T> to po prostu Function<T,T>
    // input->base->postProcess->output
    //Zrozumieć clousures bo funckja która zwróce ma przechowywać w sobie referencje do base

    //SUMMARY:
//    closures
    //UnaryOperator
    //base i postProcess czyli funckaj abzowa i postProcess to funckja dodatkowa któ©a wykonmuej załóżmy walidacje
    //
}
