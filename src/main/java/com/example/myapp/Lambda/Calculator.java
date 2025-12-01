package com.example.myapp.Lambda;
//bardzo dobry przykląłd interfejsu funckyjnego gdzie mamy jedną metoda która mozemy wykonać na kilka sposób
// wieloktornie wykorzytac mozmey dany interfejs w wielu klasach
//mozna powiedziec ze t worzmy go wtdy kiedy wiemy ze daan metoda przyda sie wielkotrnie w ilus miejachw  kodzie w roznych przypkdach
//Bo tak naprawde metody calucalkte mozmey uzyc obszernie
//Tworzymt go wtedy gdy cchemy uporzadkować KOD bo lambda musi miec typ docelowy a sa juz 4 wbudwoane lambdy COnsumer SUpplier i FUnction i predicate jesli chdozi o takie ogolne
//Mozna by sobie to przypomniec z JSEM jak sie przekzywało funckje jkako parametr do metody i ta funckja była wykorzystywana do tego ze na  taje funckji
// wykonywalsimy rozne reczy z roznymi przekaznaymi parametrami
@FunctionalInterface
public interface Calculator {
    int calculate(int a,int b);

    default void info(){
        System.out.println("infop");
    }

}
