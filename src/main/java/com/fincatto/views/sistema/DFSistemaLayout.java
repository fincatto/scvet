package com.fincatto.views.sistema;

import com.fincatto.DFApplication;
import com.fincatto.DFLoggable;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RoutePrefix;
import com.vaadin.flow.spring.security.AuthenticationContext;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIcon;

//@RolesAllowed("USER")
@RoutePrefix(value = "sistema")
public class DFSistemaLayout extends AppLayout implements DFLoggable {

    private final AuthenticationContext authContext;
    private H1 viewTitle;

    public DFSistemaLayout(AuthenticationContext authContext) {
        this.authContext = authContext;

        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
    }

    private void addHeaderContent() {
        final var toggle = new DrawerToggle();
        //toggle.setAriaLabel("Menu toggle");

        this.viewTitle = new H1();
        this.viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
        this.addToNavbar(true, toggle, viewTitle);
    }

    private void addDrawerContent() {
        final var appName = new Span(DFApplication.NAME);
        appName.addClassNames(LumoUtility.FontWeight.SEMIBOLD, LumoUtility.FontSize.LARGE);
        final var header = new Header(appName);
        final var scroller = new Scroller(createNavigation());
        this.addToDrawer(header, scroller, createFooter());
    }

    private SideNav createNavigation() {
        final var nav = new SideNav();
        nav.addItem(new SideNavItem("Tutores", DFSistemaViewTutores.class, LineAwesomeIcon.PERSON_BOOTH_SOLID.create()));
        nav.addItem(new SideNavItem("Animais", DFSistemaViewAnimais.class, LineAwesomeIcon.DOG_SOLID.create()));
        return nav;
    }

    private Footer createFooter() {
        final var footer = new Footer();
        footer.add(new Button("Logout", l -> this.authContext.logout()));
        return footer;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        final var title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
