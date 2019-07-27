package servlets;

import database.EntityDao;
import model.City;
import model.Hotel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/hotel/list")
public class HotelListServlet extends HttpServlet {
    private EntityDao dao=new EntityDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Hotel> hotels = dao.findAll(Hotel.class);

        req.setAttribute("hotelList", dao.findAll(Hotel.class));
        req.getRequestDispatcher("/hotel/list.jsp").forward(req, resp);
    }
}
