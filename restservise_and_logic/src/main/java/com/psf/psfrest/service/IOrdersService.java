package com.psf.psfrest.service;

import com.psf.psfrest.entity.OrderWithAddition;
import com.psf.psfrest.entity.OrderWithoutAddition;

import java.util.List;

public interface IOrdersService {
    List<OrderWithAddition> getOrdersWithAdditionWith(int orderNum);
    List<OrderWithoutAddition> getOrdersWithoutAdditionWith(int orderNum);
}
