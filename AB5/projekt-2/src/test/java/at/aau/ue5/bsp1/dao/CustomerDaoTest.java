package at.aau.ue5.bsp1.dao;

import at.aau.ue5.bsp1.dao.impl.ListCustomerDao;
import at.aau.ue5.bsp1.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerDaoTest {
    private ListCustomerDao listCustomerDao;
    private Customer customer0;
    private Customer customer1;
    private Customer customer2;
    private Customer customer3;

    @BeforeEach
    public void initialize(){
        listCustomerDao = new ListCustomerDao();
    }

    @Test
    public void shouldReturnCustomer_WhenCustomerGetsInserted(){
        customer0 = new Customer(25L,"Nico","Klagenfurt");
        assertEquals(customer0, listCustomerDao.insert(customer0));
    }

    @Test
    public void shouldReturnAllCustomers_WhenCallingFindAll(){
        customer0 = new Customer(1L,"Nico","Klagenfurt");
        customer1 = new Customer(2L,"Tina","Wien");
        customer2 = new Customer(3L,"Michi","Techelsberg");
        listCustomerDao.insert(customer0);
        listCustomerDao.insert(customer1);
        listCustomerDao.insert(customer2);

        assertEquals(customer0, listCustomerDao.findAll().get(0));
        assertEquals(customer1, listCustomerDao.findAll().get(1));
        assertEquals(customer2, listCustomerDao.findAll().get(2));

    }

    @Test
    public void shouldFindFirstCustomer_WhenLookingForFirstID(){
        customer0 = new Customer(25L,"Nico","Klagenfurt");
        listCustomerDao.insert(customer0);
        assertEquals(customer0,listCustomerDao.findOne(1L));
    }

    @Test
    public void shouldFindNoCustomer_WhenLookingForWrongID(){
        assertNull(listCustomerDao.findOne(1L));
    }

    @Test
    public void shouldIncreaseCustomerID_WhenAddingMultipleCustomers(){
        customer0 = new Customer(25L,"Nico","Klagenfurt");
        customer1 = new Customer(30L,"Tina","Wien");

        listCustomerDao.insert(customer0);
        listCustomerDao.insert(customer1);

        assertEquals(customer0,listCustomerDao.findOne(1L));
        assertEquals(customer1,listCustomerDao.findOne(2L));
    }

    @Test
    public void shouldDeleteCustomerFromList_WhenDeletingItsID(){
        customer0 = new Customer(25L,"Nico","Klagenfurt");
        listCustomerDao.insert(customer0);

        listCustomerDao.delete(1L);
        assertNull(listCustomerDao.findOne(1L));
    }

    @Test
    public void shouldReturnOverwrittenCustomer_WhenUpdated(){
        customer0 = new Customer(25L,"Nico","Klagenfurt");
        listCustomerDao.insert(customer0);

        customer1 = new Customer(1L,"Franz","Wernberg");
        assertEquals(customer0,listCustomerDao.update(customer1));
    }


    @Test
    public void shouldOverwriteCustomer_WhenUpdated(){
        customer0 = new Customer(25L,"Nico","Klagenfurt");
        listCustomerDao.insert(customer0);

        customer1 = new Customer(1L,"Franz","Wernberg");
        listCustomerDao.update(customer1);
        assertEquals(customer1,listCustomerDao.findOne(1L));
    }

    @Test
    public void shouldReturnCustomer_WhenLookingForName(){
        customer0 = new Customer(25L,"Nico","Klagenfurt");
        listCustomerDao.insert(customer0);

        assertEquals(customer0, listCustomerDao.findCustomerByName("Nico").get(0));
    }


}
