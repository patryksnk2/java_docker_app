package com.example.myapp.compose;

import com.example.myapp.domain.user.User;

import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;

public class compose {

    public static void main(String[] args) {

        //Chodzi o toże wynikiem pierwszej funckji będzie typem w drugiej fucnkji dczyli
        // jesli ja dek0laruje funckje f któ©a wiem ze bedzie zwracałą integer lub String lub jakikolwiek typ to ten typ
        // bedzie typem wejsciowym w funckji g a to co zwróci funckja g będzie typem wejsciowmy w funckji któ©a zwsraca funckje
        Random r = new Random();
        Function<String,Person> entry = (a)->new Person(a,r.nextInt());
//        List<Function<String,Person>> list = List.of()
//        applyAll("Patrick",)
    }

    public static <T,R> List<R> applyAll(T value,List<Function<T,R>> fs){
        return fs.stream().map(f->f.apply(value)).toList();
    }


}
