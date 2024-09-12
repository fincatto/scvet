package com.fincatto.views.admin;

import com.fincatto.entities.DFEntityUsuario;
import com.fincatto.services.DFServiceUsuario;
import com.fincatto.DFApplicationRoles;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@PageTitle("Usuários")
@RolesAllowed(DFApplicationRoles.ROLE_ADMIN)
@Route(value = "usuarios", layout = DFAdminLayout.class)
public class DFAdminViewUsuarios extends VerticalLayout {

    public DFAdminViewUsuarios(@Autowired DFServiceUsuario service) {
        this.add("Usuarios");
        final var grid = new Grid<>(service.findAll());
        grid.addColumn(DFEntityUsuario::getDocumento).setHeader("Documento").setSortable(true);
        grid.addColumn(DFEntityUsuario::getNome).setHeader("Nome").setSortable(true);
        grid.addSelectionListener(selection -> {
            Optional<DFEntityUsuario> optionalEmpresa = selection.getFirstSelectedItem();
            optionalEmpresa.ifPresent(entityEmpresa -> System.out.printf("Usuario selecionado: %s%n", entityEmpresa.getId()));
        });
        this.add(grid);
    }
}
