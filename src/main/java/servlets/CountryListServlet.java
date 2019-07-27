package servlets;

import database.EntityDao;
import model.Country;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/country/list")
public class CountryListServlet extends HttpServlet {
    private EntityDao dao = new EntityDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Country> countries = dao.findAll(Country.class);

        req.setAttribute("countryList", dao.findAll(Country.class));
        req.getRequestDispatcher("/country/list.jsp").forward(req, resp);
    }
}
