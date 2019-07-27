package servlets;

import database.EntityDao;
import model.Country;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/country/remove")
public class CountryRemoveServlet extends HttpServlet {
    private EntityDao dao=new EntityDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long identifierToRemove=Long.parseLong(req.getParameter("countryId"));

        dao.removeById(Country.class,identifierToRemove);

        resp.sendRedirect("/country/list");
    }
}
