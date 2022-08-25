package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.Book;
import ru.netology.data.Product;
import ru.netology.data.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Product product1 = new Product(1, "Product1", 100);
    private Product product2 = new Book(2, "Book1", 200, "Autor1");
    private Product product3 = new Smartphone(3, "Phone", 300, "Manufacture1");
    private Product product4 = new Product(4, "Product1" ,400);
    private Product product5 = new Book(5, "Book2", 500, "Autor2");
    private Product product6 = new Smartphone(6, "Phone", 600,"Manufacture2");

    @BeforeEach
    public void setInitialState() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
        manager.add(product6);
    }

    @Test
    public void  findAll() { // возврат всех товаров добавленных в массив в порядке добавления

        Product[] expected = {
                product1,
                product2,
                product3,
                product4,
                product5,
                product6
        };
        Product[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByName() { // поиск добавленого товара по названию продукта
//        manager.add(product1);
//        manager.add(product2);
//        manager.add(product3);
//        manager.add(product4);
//        manager.add(product5);
//        manager.add(product6);

        Product[] expected = {product3, product6};
        Product[] actual = manager.searcBy("Phone");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeById() { //удаление продукта из массива по Id

        manager.removeById(2);

        Product[] expected = {
                product1,
                product3,
                product4,
                product5,
                product6
        };
        Product[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected,actual);
    }
}
