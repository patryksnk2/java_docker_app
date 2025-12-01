package com.example.myapp.fabrics;

import java.math.BigDecimal;

public record Item(String name, int itemCount, ItemDescription description, BigDecimal value) {

}
