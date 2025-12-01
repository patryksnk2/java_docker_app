package com.example.myapp.singleton_learn;

import lombok.Getter;

public class EagerSingleton {
    //Tworzymy instacnje swojej własnej klasy
    //Tworzy sie ona od razu przy dotkneicu klasy  wystaczry ze jakkolwiek uzyjemy jej i ona sie stworzy od razu
    public static final EagerSingleton INSTANCE = new EagerSingleton();
    @Getter
    private static  int created = 0;

    //konstruktor wykonuej sie przy dtrokniecu klasy naszego singeltona
    private  EagerSingleton(){
        created++;
    };


    //metoda getInstance któ©a zwraca nam tylko i wyłącznei ta jeedną instancje klasy naszego EagerSingletona a więc
    // mozna poweidzieć a wrećz trzeba ze to jest typowy przykąłsd singeltona
    public static EagerSingleton getInstance(){
        return INSTANCE;
    }

    public void sayHello(){
        System.out.println("Jedna instancja naszego EagerSingletona jak widać po hasCode: " + this.hashCode());
    }
}
