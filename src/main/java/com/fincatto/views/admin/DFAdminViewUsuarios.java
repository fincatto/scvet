package com.fincatto.views.admin;

import com.fincatto.services.DFServiceEmpresa;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Usuários")
@RolesAllowed("ADMIN")
@Route(value = "usuarios", layout = DFAdminLayout.class)
public class DFAdminViewUsuarios extends VerticalLayout {

    public DFAdminViewUsuarios(@Autowired DFServiceEmpresa service) {
        this.add("Usuarios");
//        Grid<EntityEmpresa> grid = new Grid<>(service.findAll());
//        grid.addColumn(EntityEmpresa::getDocumento).setHeader("Documento").setSortable(true);
//        grid.addColumn(EntityEmpresa::getNome).setHeader("Nome").setSortable(true);
//        grid.addSelectionListener(selection -> {
//            Optional<EntityEmpresa> optionalEmpresa = selection.getFirstSelectedItem();
//            optionalEmpresa.ifPresent(entityEmpresa -> System.out.printf("Empresa selecionada: %s%n", entityEmpresa.getId()));
//        });
//        this.add(grid);
    }

}
