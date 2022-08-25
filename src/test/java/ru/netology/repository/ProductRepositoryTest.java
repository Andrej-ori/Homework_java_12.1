package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.Product;
import ru.netology.data.Book;
import ru.netology.data.Smartphone;

public class ProductRepositoryTest {

    private ProductRepository repository = new ProductRepository();

    private Product product1 = new Product(1, "Product1", 100);
    private Product product2 = new Book(2, "Book1", 200, "Author1");
    private Product product3 = new Smartphone(3, "Phone1", 300, "Manufacture1");
    private Product product4 = new Product(4, "Product2", 400);
    private Product product5 = new Book(5, "Book2", 500, "Author2");
    private Product product6 = new Smartphone(6, "Phone2", 600, "Manufacturer2");


    @Test
    public void findAll() {
        repository.addProduct(product1);
        repository.addProduct(product2);
        repository.addProduct(product3);
        repository.addProduct(product4);
        repository.addProduct(product5);
        repository.addProduct(product6);

        Product[] expected = new Product[] {
            product1,
            product2,
            product3,
            product4,
            product5,
            product6
        };
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeById() {
        repository.addProduct(product1);
        repository.addProduct(product2);
        repository.addProduct(product3);
        repository.addProduct(product4);
        repository.addProduct(product5);
        repository.addProduct(product6);

        repository.removeById(3);

        Product[] expected = new Product[] {
                product1,
                product2,
                product4,
                product5,
                product6
        };
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected,actual);
    }

}
