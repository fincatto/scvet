package com.fincatto.views.admin;

import com.fincatto.services.DFServiceEmpresa;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Tutores")
@Route(value = "tutores", layout = DFAdminLayout.class)
public class DFAdminViewTutores extends VerticalLayout {

    public DFAdminViewTutores(@Autowired DFServiceEmpresa service) {
        this.add("Tutores");
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
