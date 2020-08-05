package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;
import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    private Product first = new Book(1,"Book1", 10, "Author1");
    private Product second = new Book(2,"Book2", 20, "Author2");
    private Product third = new Smartphone(3,"Smart1", 30, "Manuf1");
    private Product fourth = new Smartphone(4,"Smart2", 50, "Manuf2");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
    }

    @Test
    void shouldSearchByBookName() {
        Product[] expected = {first};
        Product[] actual = manager.searchBy("Book1");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphoneName() {
        Product[] expected = {third};
        Product[] actual = manager.searchBy("Smart1");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotSearchByNameIfNotExists() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Book3");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByAuthor() {
        Product[] expected = {second};
        Product[] actual = manager.searchBy("Author2");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByManufacturer() {
        Product[] expected = {fourth};
        Product[] actual = manager.searchBy("Manuf2");
        assertArrayEquals(expected, actual);
    }
}
