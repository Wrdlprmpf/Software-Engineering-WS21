package at.aau.ue5.bsp1.dao;

import at.aau.ue5.bsp1.dao.impl.ListProductDao;
import at.aau.ue5.bsp1.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductDaoTest {
    private Product product0;
    private Product product1;
    private Product product2;
    private ListProductDao listProductDao;

    @BeforeEach
    public void init() {
        listProductDao = new ListProductDao();
        product0 = new Product(1L, "Apfel", 1.59);
        product1 = new Product(1L, "Banane", 2.29);
        product2 = new Product(3L, "Kiwi", 0.89);
    }

    @Test
    public void shouldReturnProduct_WhenProductGetsInserted() {
        assertEquals(product0, listProductDao.insert(product0));
    }

    @Test
    public void shouldReturnAllProducts_WhenCallingFindAll() {
        listProductDao.insert(product0);
        listProductDao.insert(product1);
        listProductDao.insert(product2);

        assertEquals(product0, listProductDao.findAll().get(0));
        assertEquals(product1, listProductDao.findAll().get(1));
        assertEquals(product2, listProductDao.findAll().get(2));
    }

    @Test
    public void shouldReturnProduct_WhenLookingForID() {
        listProductDao.insert(product0);
        assertEquals(product0, listProductDao.findOne(1L));
    }

    @Test
    public void shouldFindNoProduct_WhenLookingForNonExistentID() {
        assertNull(listProductDao.findOne(1L));
    }

    @Test
    public void shouldIncreaseProductID_WhenAddingMultipleProducts() {
        listProductDao.insert(product0);
        listProductDao.insert(product1);
        listProductDao.insert(product2);

        assertEquals(product0, listProductDao.findOne(1L));
        assertEquals(product1, listProductDao.findOne(2L));
        assertEquals(product2, listProductDao.findOne(3L));
    }

    @Test
    public void shouldDeleteProductFromList_WhenDeletingItsID() {
        listProductDao.insert(product0);
        assertEquals(product0, listProductDao.findOne(1L));

        listProductDao.delete(1L);
        assertNull(listProductDao.findOne(1L));
    }


    @Test
    public void shouldNotThrow_WhenDeletingWrongID() {
        assertDoesNotThrow(() -> listProductDao.delete(1L));
    }

    @Test
    public void shouldReturnOverwrittenProducts_WhenUpdated() {
        listProductDao.insert(product0);

        assertEquals(product0, listProductDao.update(product1));
    }

    @Test
    public void shouldOverwriteProduct_WhenUpdated() {
        listProductDao.insert(product0);
        listProductDao.update(product1);
        assertEquals(product1, listProductDao.findOne(1L));
    }

    @Test
    public void shouldNotThrow_WhenUpdatingNonAvailableID() {
        assertNull(listProductDao.update(product0));
    }


}
