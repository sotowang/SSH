package com.soto.service.impl;

import com.soto.dao.ProductDAO;
import com.soto.pojo.Product;
import com.soto.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDAO productDAO;

    @Transactional(propagation = Propagation.REQUIRED, rollbackForClassName = "Exception")
    public List<Product> list() {
        List<Product> products = productDAO.list();
        if (products.isEmpty()) {
            for (int i = 0; i < 5; i++) {
                Product p = new Product();
                p.setName("product " + i);
                productDAO.add(p);
                products.add(p);
            }
        }
        return products;
    }

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }
}
