package servlets;

import database.EntityDao;
import model.Continent;
import model.Country;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/country/add")
public class CountryFormServlet extends HttpServlet {
    private EntityDao dao=new EntityDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/country/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Continent continent = Continent.valueOf(req.getParameter("continent").toUpperCase());


        Country country=new Country();
        country.setName(req.getParameter("name"));
        country.setContinent(continent);
        dao.saveOrUpdate(country);

        resp.sendRedirect("/country/list");
    }
}
