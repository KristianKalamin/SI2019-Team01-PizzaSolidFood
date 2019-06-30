package com.psf.psfrest.service;

import com.psf.psfrest.entity.OrderWithAddition;
import com.psf.psfrest.entity.OrderWithoutAddition;
import com.psf.psfrest.repository.OrderWithAdditionRepository;
import com.psf.psfrest.repository.OrderWithoutAdditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService implements IOrdersService{

    @Autowired
    private OrderWithAdditionRepository orderWithAdditionRepository;

    @Autowired
    private OrderWithoutAdditionRepository orderWithoutAdditionRepository;


    @Override
    public List<OrderWithAddition> getOrdersWithAdditionWith(int orderNum) {
        return orderWithAdditionRepository.findByOrderNumEquals(orderNum);
    }

    @Override
    public List<OrderWithoutAddition> getOrdersWithoutAdditionWith(int orderNum) {
        return orderWithoutAdditionRepository.findByOrderNumEquals(orderNum);
    }
}
