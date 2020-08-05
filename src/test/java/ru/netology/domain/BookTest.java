package ru.netology.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    private Product product = new Book(1,"Book1", 10, "Author1");

    @Test
    void shouldFindByName() {
        boolean actual = product.matches("Book1");
        assertTrue(actual);
    }

    @Test
    void shouldFindByAuthor() {
        boolean actual = product.matches("Author1");
        assertTrue(actual);
    }

    @Test
    void shouldNotFindByName() {
        boolean actual = product.matches("Book10");
        assertFalse(actual);
    }

    @Test
    void shouldNotFindByAuthor() {
        boolean actual = product.matches("Author10");
        assertFalse(actual);
    }
}
