package com.example.myapp.singleton_learn;

public class LazySingleton {

    //Tutaj mamy zmienna ale bez utwrozenia jej instancji
    private static LazySingleton INSTANCE;

    private LazySingleton() {
        System.out.println("called constr " + this.hashCode());
    }



    public static LazySingleton getInstance() {
        try {
            //Zwięszkamy możliwość race condition
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (INSTANCE == null) {
            INSTANCE = new LazySingleton();
        }
        return INSTANCE;

    }
}
