package servlets;

import database.EntityDao;
import model.Country;
import model.Hotel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hotel/remove")
public class HotelRemoveServlet extends HttpServlet {
    private EntityDao dao=new EntityDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long identifierToRemove=Long.parseLong(req.getParameter("hotelId"));

        dao.removeById(Hotel.class,identifierToRemove);

        resp.sendRedirect("/hotel/list");
    }
}
