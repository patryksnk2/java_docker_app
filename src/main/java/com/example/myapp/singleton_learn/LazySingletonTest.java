package com.example.myapp.singleton_learn;

public class LazySingletonTest {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(()->{
           LazySingleton l = LazySingleton.getInstance();
            System.out.println(l.hashCode());
        });

        Thread t2 = new Thread(()->{
            LazySingleton l = LazySingleton.getInstance();

        });

        //Wydaje mi się ze tutaj oba wątki ”eda tworzył← nową instancje lazySingletona
        // ponieważ metoda statyczna getInstance nie jest THread Ssave a wiec jesli jeden wątek preszkodzi drugiemu to oba znajdą
        // sie w momencie sprwadzania czy INSTANE == null i wejdą do ifa i stworza instance

        //Uzycie joina ale sekwecyjnego czyli jnapierw odpalenie jednego watku i
        // wykonanie na nim  metody joiun pozwala na to aby tylko jedna instancja klasy sie utworzyła a wiec tutaj nie
        // dajemy pzowlic na race conditioin
//        t1.start();
//        t1.join();
//        t2.start();
//        t2.join();

        //Dodałem synchronized aby był thread save i tylko jeden wątek mógł wejść do metody getInstance w trakcie wywołania jej

        Runnable r = ()->{
            LazySingleton lazy = LazySingleton.getInstance();
        };

        Thread[] threads = new Thread[20];


        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(r,"T" + i);
            threads[i].start();
        }

        for (Thread thread : threads) {

            //dodajmey join aby nie dopusci do race condition tylko tutaj jest sekwencyjny
            // bo w przypadku gdybysmy odpalili pierw wsyzstkie 20 a pomte wykonali join to i tak by był race conditon bo kazdy kadzemu by sobier wcvhodziłw droge
            thread.join();
        }


    }
}
