package at.aau.ue5.bsp1.dao;

import at.aau.ue5.bsp1.dao.impl.ListInvoiceDao;
import at.aau.ue5.bsp1.entity.Customer;
import at.aau.ue5.bsp1.entity.Invoice;
import at.aau.ue5.bsp1.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvoiceDaoTest {
    private Invoice invoice0;
    private Invoice invoice1;
    private Invoice invoice2;
    private Customer customer0;
    private List<Product> products0;
    private ListInvoiceDao listInvoiceDao;

    @BeforeEach
    public void init(){
        listInvoiceDao = new ListInvoiceDao();
        customer0 = new Customer(1L,"Nico","Klagenfurt");
        products0 = new ArrayList<Product>();
        products0.add(new Product(1L,"Apfel",1.59));
        products0.add(new Product(2L,"Banane",2.29));
        products0.add(new Product(3L,"Kiwi",0.89));
        invoice0 = new Invoice(1L,customer0,products0,true);
    }

    @Test
    public void shouldReturnInvoice_WhenInvoiceGetsInserted(){
        invoice0 = new Invoice(1L,customer0,products0,true);
        assertEquals(invoice0, listInvoiceDao.insert(invoice0));
    }

    @Test
    public void shouldReturnAllInvoices_WhenCallingFindAll(){
        invoice0 = new Invoice(1L,customer0,products0,true);
        invoice1 = new Invoice(1L,customer0,products0,true);
        invoice2 = new Invoice(1L,customer0,products0,true);

        listInvoiceDao.insert(invoice0);
        listInvoiceDao.insert(invoice1);
        listInvoiceDao.insert(invoice2);

        assertEquals(invoice0, listInvoiceDao.findAll().get(0));
        assertEquals(invoice1, listInvoiceDao.findAll().get(1));
        assertEquals(invoice2, listInvoiceDao.findAll().get(2));
    }


}
