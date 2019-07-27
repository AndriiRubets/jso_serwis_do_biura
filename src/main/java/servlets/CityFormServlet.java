package servlets;

import database.EntityDao;
import model.City;
import model.Continent;
import model.Country;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/city/add")
public class CityFormServlet extends HttpServlet {
    private EntityDao dao = new EntityDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("countryList", dao.findAll(Country.class));
        req.getRequestDispatcher("/city/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String selectedCountryId = req.getParameter("countryId");

        Optional<Country> countryOptional = dao.findById(Country.class, Long.parseLong(selectedCountryId));

        if (countryOptional.isPresent()) {
            Country country = countryOptional.get();
            City city = new City();
            city.setName(req.getParameter("name"));
            city.setCountry(country);
            dao.saveOrUpdate(city);

            country.getCities().add(city);
            dao.saveOrUpdate(country);

        }

        resp.sendRedirect("/city/list");
    }
}
