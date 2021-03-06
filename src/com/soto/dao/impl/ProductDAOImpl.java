package com.soto.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.soto.dao.ProductDAO;
import com.soto.pojo.Product;

@Repository("productDAO")
public class ProductDAOImpl extends HibernateTemplate implements ProductDAO{
    @Resource(name="sf")
    public void setSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    };

    public List<Product> list() {
        return find("from Product");
    }

    @Override
    public void add(Product p) {
        save(p);
    }

}