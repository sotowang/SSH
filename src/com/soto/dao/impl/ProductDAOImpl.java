package com.soto.dao.impl;

import com.soto.pojo.Product;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.List;

public class ProductDAOImpl extends HibernateTemplate implements com.soto.dao.ProductDAO {

    public List<Product> list() {
        return find("from Product");
    }

    @Override
    public void add(Product p) {
        save(p);
    }
}
