package com.fincatto.views.publicas;

import com.fincatto.views.admin.DFAdminLayout;
import com.fincatto.views.admin.DFAdminViewEmpresas;
import com.fincatto.views.sistema.DFSistemaViewTutores;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

@PageTitle("SCVet")
@AnonymousAllowed
@Route(value = "", layout = DFPublicasLayout.class)
public class DFPublicasViewHome extends VerticalLayout {

    public DFPublicasViewHome() {
        setSpacing(false);

        Image img = new Image("images/empty-plant.png", "placeholder plant");
        img.setWidth("200px");
        add(img);

        H2 header = new H2("This place intentionally left empty");
        header.addClassNames(Margin.Top.XLARGE, Margin.Bottom.MEDIUM);
        add(header);

        add(new Paragraph("It’s a place where you can grow your own UI 🤗"));

        add(new Button("Autenticar", l-> UI.getCurrent().navigate(DFSistemaViewTutores.class)));

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

}
