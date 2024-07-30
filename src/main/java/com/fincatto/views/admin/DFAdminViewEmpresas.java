package com.fincatto.views.admin;

import com.fincatto.entities.DFEntityEmpresa;
import com.fincatto.services.DFServiceEmpresa;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@PageTitle("Empresas")
@RolesAllowed("ADMIN")
@Route(value = "empresas", layout = DFAdminLayout.class)
@RouteAlias(value = "", layout = DFAdminLayout.class)
public class DFAdminViewEmpresas extends VerticalLayout {

    public DFAdminViewEmpresas(@Autowired DFServiceEmpresa service) {
        Grid<DFEntityEmpresa> grid = new Grid<>(service.findAll());
        grid.addColumn(DFEntityEmpresa::getDocumento).setHeader("Documento").setSortable(true);
        grid.addColumn(DFEntityEmpresa::getNome).setHeader("Nome").setSortable(true);
        grid.addSelectionListener(selection -> {
            Optional<DFEntityEmpresa> optionalEmpresa = selection.getFirstSelectedItem();
            optionalEmpresa.ifPresent(DFEntityEmpresa -> System.out.printf("Empresa selecionada: %s%n", DFEntityEmpresa.getId()));
        });
        this.add(grid);
    }

}
