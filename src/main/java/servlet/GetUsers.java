package servlet;

import dao.IndividualDao;
import dao.ProfessionalDao;
import entities.Individual;
import entities.Professional;
import entities.User;
import jpa.EntityManagerHelper;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetUsers extends HttpServlet {

    @Override
    public void init(final ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();


        final var individual = new IndividualDao().findAll();
        final var professional = new ProfessionalDao().findAll();

        out.println("<HTML>");
        out.println("<HEAD><TITLE> Titre </TITLE></HEAD>");
        out.println("<BODY><TABLE><thead><tr>");
        out.println("<th> Firstname </th><th> LastName </th> <th> Type </th>");
        out.println("</tr></thead>");
        out.println("<tbody>");
        individual.forEach(user -> {
            out.println("<tr>");
            out.println("<td>" + user.firstName + "</td><td>"
                    + user.lastName  + "</td><td> Individual </td></tr>");
        });
        professional.forEach(user -> {
            out.println("<tr>");
            out.println("<td>" + user.firstName + "</td><td>"
                    + user.lastName  + "</td><td> Professional ");
            out.println("</td></tr>");
        });
        out.println("</tbody</TABLE>");
        out.println("</BODY>");
        out.println("</HTML>");



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }
}
