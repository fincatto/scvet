package com.fincatto.views;

import com.fincatto.views.sistema.DFSistemaViewTutores;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.spring.security.AuthenticationContext;

@Route("login")
@PageTitle("Login")
@AnonymousAllowed
public class DFViewLogin extends VerticalLayout implements BeforeEnterObserver {

    private final transient AuthenticationContext authContext;

    private LoginForm login = new LoginForm();

    public DFViewLogin(AuthenticationContext authContext) {
        this.authContext = authContext;

        //addClassName("login-view");
        setSizeFull();

        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);

        login.setAction("login");

        add(new H1("Test Application"), login);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if (this.authContext.isAuthenticated()) {
            beforeEnterEvent.rerouteTo(DFSistemaViewTutores.class);
        } else if (beforeEnterEvent.getLocation()
                .getQueryParameters()
                .getParameters()
                .containsKey("error")) {
            login.setError(true);
        }
    }
}