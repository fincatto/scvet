package com.fincatto.services;

import com.fincatto.entities.DFEntityEmpresa;
import com.fincatto.entities.DFEntityUsuario;
import com.fincatto.repositories.DFRepositoryEmpresa;
import com.fincatto.repositories.DFRepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DFServiceUsuario extends DFService {

    @Autowired
    DFRepositoryUsuario repository;

    public List<DFEntityUsuario> findAll() {
        return repository.findAll();
    }
}
