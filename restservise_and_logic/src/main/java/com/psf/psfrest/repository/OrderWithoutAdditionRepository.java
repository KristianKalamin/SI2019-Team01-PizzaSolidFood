package com.psf.psfrest.repository;

import com.psf.psfrest.entity.OrderWithoutAddition;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderWithoutAdditionRepository extends CrudRepository<OrderWithoutAddition, Integer> {
    List<OrderWithoutAddition> findByOrderNumEquals(int orderNum);
}
