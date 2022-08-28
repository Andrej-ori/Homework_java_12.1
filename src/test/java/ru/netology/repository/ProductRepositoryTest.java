package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.Product;
import ru.netology.data.Book;
import ru.netology.data.Smartphone;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {

    private ProductRepository repository = new ProductRepository();

    private Product product1 = new Product(1, "Product1", 100);
    private Product product2 = new Book(2, "Book1", 200, "Author1");
    private Product product3 = new Smartphone(3, "Phone1", 300, "Manufacture1");
    private Product product4 = new Product(4, "Product2", 400);
    private Product product5 = new Book(5, "Book2", 500, "Author2");
    private Product product6 = new Smartphone(6, "Phone2", 600, "Manufacturer2");

    @BeforeEach  // подготовка для проведения тестов (добавляем товары в массив)
    public void preparationForTests() {
        repository.addProduct(product1);
        repository.addProduct(product2);
        repository.addProduct(product3);
        repository.addProduct(product4);
        repository.addProduct(product5);
        repository.addProduct(product6);
    }

    @Test // тест на вывод товара из массива в порядке добавления
    public void findAll() {

        Product[] expected = new Product[]{
                product1,
                product2,
                product3,
                product4,
                product5,
                product6
        };
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test // тест на поиск товара по индетификатору Id
    public void ShouldFindByIdSuccess() {

        int id = 3;

        Product expected = product3;

        Product actual = repository.findById(id);

        assertEquals(expected, actual);

    }

    @Test // тест на поиск товара по не не существующему индетификатору Id
    public void souldByIdFailed() {

        int id = 20;

        assertNull(repository.findById(id));
    }

    @Test // тест на удаление товара из массива по индетификатору id (id существующего товара)
    public void removeByIdSuccess() {

        repository.removeById(3);

        Product[] expected = new Product[]{
                product1,
                product2,
                product4,
                product5,
                product6
        };
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test // тест на удаление товара по не существующему индетификатору Id
    public void removeByIdFailed() {

        int id = 9;

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(id);
        });
    }
}
