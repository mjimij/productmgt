package com.example.Product_Management.service;

import com.example.Product_Management.model.Product;
import com.example.Product_Management.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;

@Service

public class productServiceImpl implements productService{

    @Autowired
    private productRepository productRepo ;
    @Override
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepo.findById(id).get();
    }

    @Override
    public String deleteProduct(Integer id) {
        Product product = productRepo.findById(id).get();

        if (product != null){
            productRepo.delete(product);
            return "deleted successfully" ;
        }
        return "something wrong on server" ;
    }


    @Override
    public Product editProduct(Product p, Integer id) {
        Product oldproduct = productRepo.findById(id).get();
        oldproduct.setProductName(p.getProductName());
        oldproduct.setDescription(p.getDescription());
        oldproduct.setPrice(p.getPrice());
        oldproduct.setStatus(p.getStatus());

        return productRepo.save(oldproduct);
    }
}
