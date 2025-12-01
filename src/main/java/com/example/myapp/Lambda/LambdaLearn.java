package com.example.myapp.Lambda;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class LambdaLearn {
    public static void main(String[] args) {
        //Wywołanie interfejsu Klasyh lambdy
//
//        //Jest to labmda bez parametru tak zwana
//        //Tutaj kompilator ustawia jakioego interfejsu funckjyjnego oczekuje kontekst wywołania
//        //Czyli w naszym przypadku będzie to metgoda Void to oznacza ze Lambda implementuje metode VOid
//
//        //Typ Zwracany: Zależy od funckyjnego interfejsu i jego metody W interfejsie RUnnable Typ zwracany to void daltego nie zwracamy i nie przyjmuemy nic
//        Runnable r = System.out::println;
//
//        //Przykłąd rtypu zwracanego Int z dwoa argumenbtami
//        //Zapisane stylem starym
//        MathOperations add = (a, b) -> a + b;
//        //Przekszatałcone na styl nowy - Kompilator wie że metoda max w typie Integer przyjmuje Dwa parametry i zwraca typ Integer i daltego to działa
//        MathOperations max = Integer::max;
//
//        //TODO:Rodzaje Lambdy
//        /*Supplier*/
//        //Zwraca wartość nie przyjmuje parametrów
//        Supplier<Integer> s = () -> 10 + 10;
//
//        //LAMBDA - 2
//        //Rodzaje lambdy
//        //FUnction
//
////        Function<String,Character> getLatestCharacterFrom = (word)->word.charAt(word.length()-1);
//
////        Character c = getLatestCharacterFrom("Patryk to dbil");
//
//        Function<String, Character> getLatestCharacterFrom = (word) -> word.charAt(word.length() - 1);
//
//        Character c = getLatestCharacterFrom.apply("Patryk to dbil");
//
//        System.out.println(c); // wypisze 'l'
//
//        /*ZADANIA*/
//
//        //Consumer - Przyjmuje wartość i nic nie zwraca
//        //Supplier - Nie przyjmuje wartościk i zwraca podany typ
//        //Function - przyjmuje i zwraca
//
//        //TODO:Consumer
//
//        List<String> texts = List.of("elo", "melo", "asd");
//
//        //Przyjmowanie wartości odbywa sie w deklaracji generyku danego Consumera
//        Consumer<List<String>> display = System.out::println;
//
//        display.accept(texts);
//        //2
//        Consumer<String> getLength = (word) -> System.out.println(word.length());
//
//        getLength.accept("asdasdsa");
//
//        //3
//        Consumer<String> getName = (name) -> System.out.println("Hello" + name);
//        //4
//
//        Consumer<Integer> asd = (n) -> Arrays.stream((int[]) Array.newInstance(Integer.class, n)).forEach(System.out::println);
//
//
//        Integer[] arr = (Integer[]) Array.newInstance(Integer.class, 10);
//
//        for (Integer i : arr) {
//            System.out.println(i);
//        }


        //TODO:LAMBDA POWRÓT
        //lambda zawsze dotyczy tylko i wyłączni interrfejsu fynckjenyego

//        Woiemy że są wbudwoane interfejsy funckyjne takie jak Runnable
//TODO:Lambda działą w konktekście metody interfejsu funckyjnego poniewaz musi on posiadac jedna metode abstrakcyjna i to na nia powinnismy patrzec przy lambdzie
        // Bardzo wazne zapamiętac że kaązdy interfejs funckyjny musi miec tlyko jedna metoder abstrackyjna
        Runnable r = () -> {
            System.out.println("interfejs funckyjny runnable jest voide bez parametrow");
        };

        r.run();

        Comparator<String> cmp = (String s1, String s2) -> {
            return s1.length() - s2.length();
        };

//nauczy ć sie takego myslenia przypomnie csobie jak to sie robiło żeby  nie powielac kodu i tworzyło interfejs funckyjny
        // lub metode ktora pryjmuje interfejs funckyjny jako parametr


        getLengthSum("abc", "def", String::length);

    }

    public static int getLengthSum(String a, String b, StringProcessor s) {
        return s.process(a) + s.process(b);
    }

}
