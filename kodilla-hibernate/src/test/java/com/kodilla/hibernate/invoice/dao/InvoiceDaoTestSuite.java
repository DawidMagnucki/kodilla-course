package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ItemDao itemDao;

    @Test
    void testInvoiceDaoSave() {
        //Given
        Product earbuds = new Product("earbuds");
        Product phone = new Product("phone");
        Product pc = new Product("pc");
        Invoice invoice = new Invoice("FV/2025/11/001");
        Item item1 = new Item(earbuds, new BigDecimal(49.00), 1, new BigDecimal(49.00),invoice);
        Item item2 = new Item(phone, new BigDecimal(499.00), 1, new BigDecimal(499.00), invoice);
        Item item3 = new Item(pc, new BigDecimal(1500.00), 1, new BigDecimal(1500.00),invoice);
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);

        //When
        productDao.save(earbuds);
        productDao.save(phone);
        productDao.save(pc);
        invoiceDao.save(invoice);
        itemDao.save(item1);
        itemDao.save(item2);
        itemDao.save(item3);
        int invoiceId = invoice.getId();

        //Then
        assertNotEquals(0, invoiceId);
    }
}
