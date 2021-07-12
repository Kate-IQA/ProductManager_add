package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager productManager = new ProductManager(repository);
    private Book first = new Book(1, "name1", 750, "author1");
    private Book second = new Book(2, "name2", 680, "author2");
    private Smartphone third = new Smartphone(3, "name3", 7800, "producer1");
    private Smartphone forth = new Smartphone(4, "name4", 24999, "producer2");
    private Smartphone fifth = new Smartphone(4, "name5", 59990, "producer2");

    @BeforeEach
    void setUp() {
        productManager.add(first);
        productManager.add(second);
        productManager.add(third);
        productManager.add(forth);
        productManager.add(fifth);
    }

    @Test
    public void shouldSearchBookName() {
        String text = "name1";

        Product[] expected = new Product[]{first};
        Product[] actual = productManager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBookAuthor() {
        String text = "author2";

        Product[] expected = new Product[]{second};
        Product[] actual = productManager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneName() {
        String text = "name3";

        Product[] expected = new Product[]{third};
        Product[] actual = productManager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfNotExist() {
        String text = "IPHONE";

        Product[] expected = new Product[0];
        Product[] actual = productManager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAllItems() {
        String text = "Producer2";

        Product[] expected = new Product[]{forth, fifth};
        Product[] actual = productManager.searchBy(text);
        assertArrayEquals(expected, actual);
    }
}
