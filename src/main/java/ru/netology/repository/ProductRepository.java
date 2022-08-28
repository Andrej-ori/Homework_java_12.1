package ru.netology.repository;

import ru.netology.data.Product;
import ru.netology.exception.NotFoundException;

public class ProductRepository {
    private Product[] products = new Product[0];


    public ProductRepository() {
    }

    // добавление нового продукта в массив
    public void addProduct(Product addProduct) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[products.length] = addProduct;
        products = tmp;
    }

    // получить все добавленые продукты в порядке добавления
    public Product[] findAll() {
        return products;
    }

    // удалить товар по инднтификатору Id
    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with Id: " + id + " not found");
        }
        Product[] tmp = new Product[products.length - 1];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
        }
        products = tmp;
    }

    // Поиск товара в массиве по индетификатору Id
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}