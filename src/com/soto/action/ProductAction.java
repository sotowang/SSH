package com.soto.action;

import com.soto.pojo.Product;
import com.soto.service.ProductService;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Namespace("/")
@ParentPackage("struts-default")
@Results({@Result(name="listJsp", location="/list.jsp")})
public class ProductAction {
    @Autowired
    ProductService productService;
    List<Product> products;
    @Action("listProduct")
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
