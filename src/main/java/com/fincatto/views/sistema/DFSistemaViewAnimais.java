package com.fincatto.views.sistema;

import com.fincatto.services.DFServiceEmpresa;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Animais")
@RolesAllowed("USER")
@Route(value = "animais", layout = DFSistemaLayout.class)
public class DFSistemaViewAnimais extends VerticalLayout {

    public DFSistemaViewAnimais(@Autowired DFServiceEmpresa service) {
        this.add("Animais");
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

