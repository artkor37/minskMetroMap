package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor



public enum ColorName {
    BLUE("Синий"),
    RED("Красный"),
    GREEN("Зеленый");

    private String colorName;
}
