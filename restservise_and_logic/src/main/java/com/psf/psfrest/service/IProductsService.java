package com.psf.psfrest.service;

import com.psf.psfrest.entity.Products;

import java.util.List;

public interface IProductsService {
    List<Products> getAllProducts();
    Products getProduct(String productName);
}
