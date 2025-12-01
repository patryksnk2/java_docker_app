package com.example.myapp.functional_interfaces;

import java.math.BigInteger;

@FunctionalInterface
public interface PaymentProcess {
    BigInteger pay(double a, double b);
}
