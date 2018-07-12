package com.soto.action;

import com.soto.pojo.Product;
import com.soto.service.ProductService;

import java.util.List;

public class ProductAction {
    ProductService productService;
    List<Product> products;

    public String list() {
        products = productService.list();
        return "listJsp";
    }

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
