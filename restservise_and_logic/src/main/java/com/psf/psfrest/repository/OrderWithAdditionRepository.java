package com.psf.psfrest.repository;


import com.psf.psfrest.entity.OrderWithAddition;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderWithAdditionRepository extends CrudRepository<OrderWithAddition, Integer> {
    List<OrderWithAddition> findByOrderNumEquals(int orderNum);
}
