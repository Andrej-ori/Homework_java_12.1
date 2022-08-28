package ru.netology.manager;

import ru.netology.data.Product;
import ru.netology.repository.ProductRepository;

public class ProductManager {

    private ProductRepository repository;

    // методы зависимые от репозитория
    // добавление продукта в массив
    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    // получить все продукты сохраненые в массиве в порядке добавления
    public Product[] findAll() {
        return repository.findAll();
    }

    // сохранить продукт в массив
    public void add(Product product) {
        repository.addProduct(product);
    }

    // удаление продукта из массива по Id
    public void removeById(int id) {
        repository.removeById(id);
    }

    // логика менеджера
    // поиск по названию продукта
    public Product[] searcBy(String text) {
        Product[] results = new Product[0]; // тут будем хранить прошедшие запросу продукты
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[results.length + 1];
                int i = 0;
                for (Product result : results) {
                    tmp[i] = result;
                    i++;
                }
                tmp[results.length] = product;
                results = tmp;
            }
        }
        return results;
    }

    //определение соответствия товара запросу
    private boolean matches(Product product, String search) {
//        if (product.getName().contains(text)) {
//            return true;
//        }else {
//            return false;
//        }
        return product.getName().contains(search);
    }
}