package ru.netology.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SmartphoneTest {
    private Product product = new Smartphone(3,"Smart1", 30, "Manuf1");

    @Test
    void shouldFindByName(){
        boolean actual = product.matches("Smart1");
        assertTrue(actual);
    }

    @Test
    void shouldFindByManufacturer(){
        boolean actual = product.matches("Manuf1");
        assertTrue(actual);
    }

    @Test
    void shouldNotFindByName(){
        boolean actual = product.matches("Smart10");
        assertFalse(actual);
    }

    @Test
    void shouldNotFindByManufacturer(){
        boolean actual = product.matches("Manuf10");
        assertFalse(actual);
    }
}
