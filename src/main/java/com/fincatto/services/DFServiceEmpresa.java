package com.fincatto.services;

import com.fincatto.entities.DFEntityEmpresa;
import com.fincatto.repositories.DFRepositoryEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DFServiceEmpresa extends DFService {

    @Autowired
    DFRepositoryEmpresa repository;

    public List<DFEntityEmpresa> findAll() {
        return repository.findAll();
    }
}
