package at.aau.ue5.bsp1.service;

import at.aau.ue5.bsp1.dao.impl.ListCustomerDao;
import at.aau.ue5.bsp1.dao.impl.ListInvoiceDao;
import at.aau.ue5.bsp1.dao.impl.ListProductDao;
import at.aau.ue5.bsp1.entity.Customer;
import at.aau.ue5.bsp1.entity.Invoice;
import at.aau.ue5.bsp1.entity.Product;
import at.aau.ue5.bsp1.service.exception.InvoiceServiceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InvoiceServiceImplIntegrationTest {

    private InvoiceServiceImpl invoiceService;
    private Customer customer0;
    private Customer customer1;
    private Product product0;
    private Product product1;
    private ArrayList<Product> products;
    ListCustomerDao listCustomerDao;
    ListProductDao listProductDao;
    ListInvoiceDao listInvoiceDao;



    @BeforeEach
    public void init() throws InvoiceServiceException {
        invoiceService = new InvoiceServiceImpl();

        listCustomerDao = new ListCustomerDao();
        customer0 = new Customer(1L, "Nico", "Klagenfurt");
        customer1 = new Customer(2L, "Tina", "Wien");
        listCustomerDao.insert(customer0);
        listCustomerDao.insert(customer1);
        invoiceService.setCustomerDao(listCustomerDao);

        listProductDao = new ListProductDao();
        product0 = new Product(1L, "Apfel", 1.59);
        product1 = new Product(2L, "Banane", 2.29);
        listProductDao.insert(product0);
        listProductDao.insert(product1);
        invoiceService.setProductDao(listProductDao);

        listInvoiceDao = new ListInvoiceDao();
        invoiceService.setInvoiceDao(listInvoiceDao);

        products = new ArrayList<>();
        products.add(product0);
    }

    @Test
    public void shouldAddCorrectInvoice_WhenNewInvoiceIsCreated()throws InvoiceServiceException{
        invoiceService.createInvoice(products, customer0);

        ListInvoiceDao testListInvoiceDao = new ListInvoiceDao();
        testListInvoiceDao.insert(new Invoice(1L, customer0, products, false));
        assertEquals(testListInvoiceDao.findAll(), invoiceService.getInvoiceDao().findAll());
    }

    @Test
    public void shouldDeleteInvoice_WhenGivenExistingInvoice()throws InvoiceServiceException{
        invoiceService.createInvoice(products, customer0);

        Invoice testInvoice = new Invoice(1L,customer0,products,false);
        invoiceService.deleteInvoice(testInvoice);
        ArrayList<Invoice> emptyInvoiceList = new ArrayList<>();
        assertEquals(emptyInvoiceList,invoiceService.getInvoiceDao().findAll());
    }

    @Test
    public void shouldThrowException_WhenDeletingNonExistentInvoice()throws InvoiceServiceException{
        Invoice testInvoice = new Invoice(1L,customer0,products,false);
        assertThrows(InvoiceServiceException.class,()->invoiceService.deleteInvoice(testInvoice));
    }

    



}
