package com.example.myapp.compose;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class comp {
    public static void main(String[] args) {


        Integer apply = sum().apply(1).apply(5);
        Boolean apply1 = threshold().apply(5).apply(10);

        Function<Integer, Integer> add = add(3);

        Function<Integer, Function<String, List<String>>> apply2 = curr().apply(List.of("a", "b", "c"));
        Function<String, List<String>> apply3 = curr().apply(List.of("a", "b", "c")).apply(5);
    }
    //NAUKA
//  COMPOSE Tutaj uczyliśmy się w sumie takiego bardoz rpsotego funckyjnego javy chodzi o to ze funckja kt©óa zwraca typy rposte
    //Mamy zarobić funckję która zwraca funckje któ©a wykonuje  sume
    public static Function<Integer,Integer> makeDoubler(){
        return (a)->a*2;
    }

    public static Integer calculator(int a, int b,Function<Integer,Function<Integer,Integer>> f){
        return f.apply(a).apply(b);
    }

    //CURRYING
    //Łańcuch funckji zwracających funckję

    public static Function<Integer,Function<Integer,Integer>> sum () {
        //WKUĆ SOBIE DO GŁOWY ZE JA TUTAJ NIE ZWRACA WYNIKU TYLKO FUNCKJE KTORA ZROBI DANE ZACHOWANIE
        return (a) -> (b) -> a + b;
    }

    public static Function<Integer,Function<Integer,Boolean>> threshold(){
        return (a)->(b)->b>a;
    }

    public static Function<String,Function<String,Integer>> format(){
        return (a)->(b)-> a.length() + b.length();
    }

    //KOMPOZYCJA FUNCKJI
    public static Function<Integer,Integer> add(int a) {
        return (x) -> x + a;
    }


    //CURSYING LAST ONE
    //Ogólnie patrzy ma to zase jesli may funckje któ©e przyjmuje wiele arguemnnt ow lub wiem ze jeden z nich będzie argumentem ot©óy sie bedzie lekko zmieniał ilosc jego zmianyh
    // bedzie maał to mzona dac ucrrying lub wime zey moze byc zamrozony
    public static Function<List<String>,Function<Integer,Function<String,List<String>>>> curr(){
        return (list)->(strLength)->(str)->list.stream().filter(el->el.length()>strLength).filter(el->el.equals(str)).toList();
    }
}









