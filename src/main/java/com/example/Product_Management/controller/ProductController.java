package com.example.Product_Management.controller;

import com.example.Product_Management.model.Product;
import com.example.Product_Management.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    private productService productservice;
    @PostMapping("/saveProduct")
    public ResponseEntity<?> saveProduct(@RequestBody Product product)
    {

        return new ResponseEntity<>(productservice.saveProduct(product),
                HttpStatus.CREATED);
    }
    @GetMapping("/")
    public ResponseEntity<?> getAllProduct()
    {
        return new ResponseEntity<>(productservice.getAllProduct(),changement1);
    }
    @GetMapping("/id")
    public ResponseEntity<?> getProductById(@PathVariable Integer id )
    {
        return new ResponseEntity<>(productservice.getProductById(id), HttpStatus.OK);
    }
    @GetMapping("/deleteProduct/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id )
    {
        return  new ResponseEntity<> (productservice.deleteProduct(id),HttpStatus.OK);
    }

    @PostMapping("/editProduct/{id}")
    public ResponseEntity<?> editProduct(@RequestBody Product product, @PathVariable Integer id)
    {

        return new ResponseEntity<>(productservice.editProduct(product,id), HttpStatus.CREATED);
    }
}
