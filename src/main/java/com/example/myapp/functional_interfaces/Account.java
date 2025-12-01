package com.example.myapp.functional_interfaces;

import lombok.Getter;

import java.math.BigInteger;

public record Account(@Getter BigInteger money,@Getter String name) {
}
