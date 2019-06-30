package com.psf.psfrest.service;

import com.psf.psfrest.entity.Additions;
import com.psf.psfrest.repository.AdditionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class AdditionsService implements IAdditionsService {

    @Autowired
    private AdditionsRepository additionsRepository;

    @Override
    public List<Additions> getAllAdditions() {
        List<Additions> list = new LinkedList<>();
        additionsRepository.findAll().forEach(list::add);
        return list;
    }
}
