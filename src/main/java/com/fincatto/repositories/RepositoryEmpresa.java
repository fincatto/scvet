package com.fincatto.repositories;

import com.fincatto.entities.EntityEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryEmpresa extends JpaRepository<EntityEmpresa, Integer>, com.fincatto.repositories.Repository {
}