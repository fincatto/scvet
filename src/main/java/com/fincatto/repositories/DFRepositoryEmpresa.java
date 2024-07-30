package com.fincatto.repositories;

import com.fincatto.entities.DFEntityEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DFRepositoryEmpresa extends JpaRepository<DFEntityEmpresa, Integer>, DFRepository {
}