package servlets;

import database.EntityDao;
import model.City;
import model.Country;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/city/list")
public class CityListServlet extends HttpServlet {
    private EntityDao dao = new EntityDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<City> cities = dao.findAll(City.class);

        req.setAttribute("cityList", dao.findAll(City.class));
        req.getRequestDispatcher("/city/list.jsp").forward(req, resp);
    }
}
