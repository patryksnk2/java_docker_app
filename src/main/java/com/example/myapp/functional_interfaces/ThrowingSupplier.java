package com.example.myapp.functional_interfaces;
@FunctionalInterface
public interface ThrowingSupplier<T> {
    T get() throws Exception;
}
