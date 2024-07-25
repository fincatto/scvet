package com.fincatto.views.admin;

import com.fincatto.entities.EntityEmpresa;
import com.fincatto.services.ServiceEmpresa;
import com.fincatto.views.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@PageTitle("Empresas")
@Route(value = "empresas", layout = MainLayout.class)
public class ViewEmpresas extends VerticalLayout {

    public ViewEmpresas(@Autowired ServiceEmpresa service) {
        Grid<EntityEmpresa> grid = new Grid<>(service.findAll());
        grid.addColumn(EntityEmpresa::getDocumento).setHeader("Documento").setSortable(true);
        grid.addColumn(EntityEmpresa::getNome).setHeader("Nome").setSortable(true);
        grid.addSelectionListener(selection -> {
            Optional<EntityEmpresa> optionalEmpresa = selection.getFirstSelectedItem();
            optionalEmpresa.ifPresent(entityEmpresa -> System.out.printf("Empresa selecionada: %s%n", entityEmpresa.getId()));
        });
        this.add(grid);
    }

}
