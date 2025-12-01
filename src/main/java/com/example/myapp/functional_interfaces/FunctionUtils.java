package com.example.myapp.functional_interfaces;

import java.util.List;
import java.util.function.Function;

public class FunctionUtils {


    public static Function<Integer, Integer> makeDoubler() {
        //Tutja jak by silnik intellij sam podpwiada ze bedzie zwracany typ lambdy
        //BARDZO WAZNE!@!
        return (a) -> a * a;
    }

    public static Function<Integer, Function<Integer, Integer>> makeAdder() {
        //Czyli tutaju zwracamy funckje która przyjmuje parmetr a jako Integer która zwraca funckje któ©a takze przymuje parametr b jako integer i zwraca integer czyli wynik;

        Function<Integer, Function<Integer, Integer>> f = (a) -> (b) -> a + b;

        return (a) -> (b) -> a + b;
//        FunctionUtils.makeAdder().apply(2).apply(2);
    }

    public static Function<Function<Integer, Integer>, Function<Integer, Integer>> makeJoin() {
        //Zapamieta ze my nie chcemu zwróć czadnego wyniku tylko chcemy zwróćcoi koljena FUNCKJE!!!

        return (a) -> (b) -> a.apply(b);
    }

    public static Function<String, Function<String, String>> makePrefixer() {
        Function<String, String> f = (str) -> str;
        Function<String, Function<String, String>> g = (prefix) -> (str) -> prefix + str;
        return (prefix) -> (str) -> prefix + str;
    }

    public static Function<List<String>, Function<String, Integer>> getIndex() {
        return (arr) -> (s) -> arr.indexOf(s);
    }

    public static <T> Function<List<T>, Function<T, List<T>>> removeGiven() {
        return (a) -> (b) ->a.stream().filter((el)->!el.equals(b)).toList();
    }

    public static Function<String,Function<String,String>> sufix (){
        return (a)->(b)->b+a;
    }

    public static <T,U,V> Function <T,V> composeSimple(Function<T,U> f,Function<U,V> g){

        return (a)->g.apply(f.apply(a));
    }
}
