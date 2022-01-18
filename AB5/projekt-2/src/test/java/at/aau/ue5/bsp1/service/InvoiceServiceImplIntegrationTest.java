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

    @BeforeEach
    public void init(){
        invoiceService = new InvoiceServiceImpl();
    }

    @Test
    public void shouldSetupInvoiceService_WhenAddingParameters() throws InvoiceServiceException {
        ListCustomerDao listCustomerDao = new ListCustomerDao();
        Customer customer0 = new Customer(1L,"Nico","Klagenfurt");
        Customer customer1 = new Customer(2L,"Tina","Wien");
        listCustomerDao.insert(customer0);
        listCustomerDao.insert(customer1);
        invoiceService.setCustomerDao(listCustomerDao);

        ListProductDao listProductDao = new ListProductDao();
        Product product0 = new Product(1L,"Apfel",1.59);
        Product product1 = new Product(2L,"Banane",2.29);
        listProductDao.insert(product0);
        listProductDao.insert(product1);
        invoiceService.setProductDao(listProductDao);

        ListInvoiceDao listInvoiceDao = new ListInvoiceDao();
        invoiceService.setInvoiceDao(listInvoiceDao);

        ArrayList<Product> products = new ArrayList<>();
        products.add(product0);
        invoiceService.createInvoice(products, customer0);
        ListInvoiceDao testListInvoiceDao = new ListInvoiceDao();
        testListInvoiceDao.insert(new Invoice(1L,customer0,products,false));
        assertEquals(testListInvoiceDao.findAll(), invoiceService.getInvoiceDao().findAll());

    }
}
