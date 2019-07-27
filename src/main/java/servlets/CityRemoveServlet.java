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

@WebServlet("/city/remove")
public class CityRemoveServlet extends HttpServlet {
    private EntityDao dao=new EntityDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long identifierToRemove=Long.parseLong(req.getParameter("cityId"));

        dao.removeById(City.class,identifierToRemove);

        resp.sendRedirect("/city/list");
    }
}
