package com.fincatto.services;

import com.fincatto.entities.EntityEmpresa;
import com.fincatto.repositories.RepositoryEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceEmpresa extends com.fincatto.services.Service {

    @Autowired
    RepositoryEmpresa repository;

    public List<EntityEmpresa> findAll() {
        return repository.findAll();
    }
}
