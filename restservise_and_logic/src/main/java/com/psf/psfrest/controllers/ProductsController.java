package com.psf.psfrest.controllers;

import com.psf.psfrest.entity.Additions;
import com.psf.psfrest.entity.Products;
import com.psf.psfrest.service.AdditionsService;
import com.psf.psfrest.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;

@RestController
@CrossOrigin
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @Autowired
    private AdditionsService additionsService;

    @PostMapping("/public/products")
    public @ResponseBody List getProducts() throws IOException {
        List<Products> products = new LinkedList<>(productsService.getAllProducts());
        Resource resource;
        for (Products product : products) {
            resource = new ClassPathResource(product.getImgPath());
            product.setImage(Base64.getEncoder().encodeToString(Files.readAllBytes(resource.getFile().toPath())));
        }
        return products;
    }

    @GetMapping("/public/product/{productName}")
    public Products getProduct(@PathVariable("productName") String productName) throws IOException {
        Products product = productsService.getProduct(productName);
        Resource resource = new ClassPathResource(product.getImgPath());
        product.setImage(Base64.getEncoder().encodeToString(Files.readAllBytes(resource.getFile().toPath())));
        return product;
    }

    @PostMapping("/public/additions")
    public @ResponseBody List<Additions> getAdditions() {
        return additionsService.getAllAdditions();
    }
}
