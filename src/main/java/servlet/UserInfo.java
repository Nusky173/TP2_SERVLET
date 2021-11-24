package servlet;

import dao.AgendaDao;
import dao.IndividualDao;
import dao.ProfessionalDao;
import entities.Agenda;
import entities.Individual;
import entities.Professional;
import jpa.EntityManagerHelper;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInfo extends HttpServlet {

    @Override
    public void init(final ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        final var professionalDao = new ProfessionalDao();
        final var individualDao = new IndividualDao();
        final var agendaDao = new AgendaDao();

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();


        final var type = request.getParameter("type-user");
        final var name = request.getParameter("name");
        final var firstname = request.getParameter("firstname");
        final var login = request.getParameter("login");
        final var password = request.getParameter("password");
        final var tel = request.getParameter("tel");
        final var agendaUrl = request.getParameter("agenda-url");
        final var agendaLogin = request.getParameter("agenda-login");
        final var agendaPassword = request.getParameter("agenda-password");

        out.println("<HTML>\n<BODY>\n" +
                "<H1>Recapitulatif des informations</H1>\n" +
                "<UL>\n" +
                " <LI>Nom: "
                + name + "\n" +
                " <LI>Prenom: "
                + firstname + "\n" +
                " <LI>Age: "
                + request.getParameter("age") + "\n" +
                " <LI>Type: "
                + type+ "\n");
        if(Objects.equals(type, "individual")) {
            out.println("<li>Tel: " + tel + "\n");
        } else if (Objects.equals(type, "professional")){
            out.println(" <LI>Agenda url: " + agendaUrl + "\n" +
                    " <LI>Agenda login: " + agendaLogin + "\n" +
                    " <LI>Agenda password: " + agendaPassword + "\n");
        }
        out.println("</UL></BODY></HTML>");

        if( Objects.equals(type, "individual")) {
            individualDao.save(new Individual(firstname, name, login, password, tel));
        } else if (Objects.equals(type, "professional")){
            final var agenda = new Agenda(agendaUrl, agendaLogin, agendaPassword);
            agendaDao.save(agenda);
            professionalDao.save(new Professional(firstname, name, login, password,
                    agenda));
        }
    }
}
