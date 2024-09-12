package com.fincatto.repositories;

import com.fincatto.entities.DFEntityEmpresa;
import com.fincatto.entities.DFEntityUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DFRepositoryUsuario extends JpaRepository<DFEntityUsuario, Integer>, DFRepository {
}