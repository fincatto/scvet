package com.fincatto;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.util.Objects;

/**
 * The entry point of the Spring Boot application.
 * <p>
 * Use the @PWA annotation make the application installable on phones, tablets
 * and some desktop browsers.
 */
@SpringBootApplication
@Theme(value = "scvet")
public class DFApplication implements AppShellConfigurator {

    @Autowired
    DataSource dataSource;

    @Autowired
    private Environment environment;

    public static void main(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(DFApplication.class, args);
        if (context.getEnvironment().getActiveProfiles().length > 0) {
            DFLoggable.getLogger(DFApplication.class).info("Sistema iniciando em modo de produção");
        } else {
            final String porta = Objects.requireNonNullElse(context.getEnvironment().getProperty("local.server.port"), "8080");
            DFLoggable.getLogger(DFApplication.class).info("Sistema em modo de desenvolvimento: http://localhost:{}", porta);
        }
    }
}
