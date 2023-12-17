package com.example.Product_Management.service;

import com.example.Product_Management.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface productService {

    public  Product saveProduct(Product product);
    public List<Product> getAllProduct();
    public Product getProductById(Integer id);
    public  String deleteProduct(Integer id);
    public Product editProduct(Product product, Integer id);
}
