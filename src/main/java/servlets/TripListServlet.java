package servlets;

import database.EntityDao;
import model.Hotel;
import model.Trip;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/trip/list")
public class TripListServlet extends HttpServlet {
    private EntityDao dao=new EntityDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Trip> trips=dao.findAll(Trip.class);

        req.setAttribute("tripList", dao.findAll(Trip.class));
        req.getRequestDispatcher("/trip/list.jsp").forward(req, resp);
    }
}
