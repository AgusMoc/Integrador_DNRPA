package com.company;

public interface NombresSimples {
    default String getNombre() {
        return this.getClass().getSimpleName();
    }
}
