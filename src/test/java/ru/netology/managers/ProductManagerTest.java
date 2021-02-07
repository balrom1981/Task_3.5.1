package ru.netology.managers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class ProductManagerTest {
    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductManager manager;

    private Product first = new Book(1, "Firs", 100, "Gogl");
    private Product second = new Book(2, "Second", 200, "Pushkin");
    private Product third = new Book(3, "Third", 300, "Tolstoi");
    private Product fourth = new Smartphone(4, "IphoneX", 100000, "Apple");
    private Product fifth = new Smartphone(5, "Galaxy", 900000, "Samsung");
    private Product sixth = new Smartphone(6, "Fusion", 5000, "Lenovo");


    @Test
    public void shouldFind() {
        Product[] returned = new Product[]{first, second, third, fourth, fifth, sixth};
        doReturn(returned).when(repository).findAll();

        Product[] actual = manager.searchBy("Pushkin");
        Product[] expected = new Product[] {second};

        assertArrayEquals(actual, expected);

    }
}