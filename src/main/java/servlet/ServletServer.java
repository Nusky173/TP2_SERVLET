package servlet;

import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.handlers.PathHandler;
import io.undertow.server.handlers.resource.FileResourceManager;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;

import javax.servlet.ServletException;
import java.io.File;

import static io.undertow.servlet.Servlets.defaultContainer;
import static io.undertow.servlet.Servlets.servlet;

public class ServletServer {

    public static final String MYAPP = "/api";

    public static void main(final String[] args) {
        try {
            DeploymentInfo servletBuilder = Servlets.deployment().setClassLoader(ServletServer.class.getClassLoader())
                    .setContextPath(MYAPP).setDeploymentName("test/war")
                    .setResourceManager(new FileResourceManager(new File ("src/main/webapp"), 1024))
                    .addServlets(
                            servlet("GetUser", GetUsers.class).addMapping("/users"),
                            servlet("UserInfo", UserInfo.class).addMapping("/UserInfo")
                    );

            DeploymentManager manager = defaultContainer().addDeployment(servletBuilder);
            manager.deploy();

            HttpHandler servletHandler = manager.start();
            PathHandler path = Handlers.path(Handlers.redirect(MYAPP)).addPrefixPath(MYAPP, servletHandler);
            Undertow server  = Undertow.builder().addHttpListener(8080, "localhost").setHandler(path).build();
            server.start();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
