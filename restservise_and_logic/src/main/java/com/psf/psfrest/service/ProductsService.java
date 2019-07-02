package com.psf.psfrest.service;

import com.psf.psfrest.entity.Products;
import com.psf.psfrest.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ProductsService implements IProductsService{
    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public List<Products> getAllProducts() {
        List<Products> list = new LinkedList<>();
        productsRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Products getProduct(String productName) {
        return productsRepository.findByProductNameEquals(productName);
    }
}
