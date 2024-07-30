package com.fincatto.views.admin;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RoutePrefix;
import com.vaadin.flow.spring.security.AuthenticationContext;
import com.vaadin.flow.theme.lumo.LumoUtility;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.core.userdetails.UserDetails;
import org.vaadin.lineawesome.LineAwesomeIcon;

//@RolesAllowed("ADMIN")
@RoutePrefix(value = "admin")
public class DFAdminLayout extends AppLayout {

    private final transient AuthenticationContext authContext;

    private H1 viewTitle;

    public DFAdminLayout(AuthenticationContext authContext) {
        this.authContext = authContext;

        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");

        viewTitle = new H1();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

        HorizontalLayout
                header =
                authContext.getAuthenticatedUser(UserDetails.class)
                        .map(user -> {
                            Button logout = new Button("Logout", click ->
                                    this.authContext.logout());
                            Span loggedUser = new Span("Welcome " + user.getUsername());
                            return new HorizontalLayout(viewTitle, loggedUser, logout);
                        }).orElseGet(() -> new HorizontalLayout(viewTitle));


        addToNavbar(true, toggle, header);
    }

    private void addDrawerContent() {
        Span appName = new Span("SCVet");
        appName.addClassNames(LumoUtility.FontWeight.SEMIBOLD, LumoUtility.FontSize.LARGE);

//        Span appMoto = new Span("Sistemas Veterinários");

//        VerticalLayout vlHeader = new VerticalLayout(appName, appMoto, new Hr());
//        vlHeader.setSpacing(false);
//        vlHeader.setPadding(false);

        //Header header = new Header(vlHeader);
        Header header = new Header(appName);

        Scroller scroller = new Scroller(createNavigation());
        addToDrawer(header, scroller, createFooter());
    }

    private SideNav createNavigation() {
        SideNav nav = new SideNav();
        nav.addItem(new SideNavItem("Empresas", DFAdminViewEmpresas.class, LineAwesomeIcon.BUILDING.create()));
        nav.addItem(new SideNavItem("Usuários", DFAdminViewUsuarios.class, LineAwesomeIcon.USERS_SOLID.create()));
        nav.addItem(new SideNavItem("Tutores", DFAdminViewTutores.class, LineAwesomeIcon.PERSON_BOOTH_SOLID.create()));
        nav.addItem(new SideNavItem("Animais", DFAdminViewAnimais.class, LineAwesomeIcon.DOG_SOLID.create()));
        return nav;
    }

    private Footer createFooter() {
        Footer layout = new Footer();
        return layout;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
