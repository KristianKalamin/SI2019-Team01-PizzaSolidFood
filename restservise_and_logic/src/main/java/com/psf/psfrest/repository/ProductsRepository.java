package com.psf.psfrest.repository;

import com.psf.psfrest.entity.Products;
import org.springframework.data.repository.CrudRepository;

public interface ProductsRepository extends CrudRepository<Products, Integer> {
    Products findByIdProdEquals(int productId);
}
