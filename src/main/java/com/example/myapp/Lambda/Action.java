package com.example.myapp.Lambda;
@FunctionalInterface
//Tutaj chodzi o to że przechowumjeym
//Tworzymy go wtedy gdy mamy kod któ©ego chcemy uzyć w kilku miejsach
// Troche jak sytuacja z JSA gdzie  jedną metode możemy uzyć na kilka sposób jak by add/substract
public interface Action<T> {
    T doAction();

}
