package servlets;

import database.EntityDao;
import model.City;

import model.Trip;
import model.TypeOfMeal;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@WebServlet("/trip/add")
public class TripFormServlet extends HttpServlet {
    private EntityDao dao=new EntityDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("cityList", dao.findAll(City.class));
        req.getRequestDispatcher("/trip/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cityFrom=req.getParameter("cityIdFrom");
        String cityTo=req.getParameter("cityIdTo");
        String isPromotion = req.getParameter("promotion");

        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Optional<City> cityOptionalFrom = dao.findById(City.class, Long.parseLong(cityFrom));
        Optional<City> cityOptionalTo = dao.findById(City.class, Long.parseLong(cityTo));

        boolean promotion =((isPromotion != null)&& isPromotion.equalsIgnoreCase("on"));

        TypeOfMeal typeOfMeal = TypeOfMeal.valueOf(req.getParameter("typeOfMeal").toUpperCase());

        if (cityOptionalTo.isPresent() && cityOptionalFrom.isPresent()) {
            City city1=cityOptionalFrom.get();
            City city2=cityOptionalTo.get();

            Trip trip=new Trip();
            trip.setFromCity(city1);
            trip.setToCity(city2);

            trip.setDateDeparture(LocalDate.parse(req.getParameter("dateDeparture"),formatter));
            trip.setDateReturn(LocalDate.parse(req.getParameter("dateReturn"),formatter));
            trip.setTypeOfMeal(typeOfMeal);
            trip.setPriceForAdult(Integer.parseInt(req.getParameter("priceForAdult")));
            trip.setPriceForChild(Integer.parseInt(req.getParameter("priceForChild")));
            trip.setDays(Integer.parseInt(req.getParameter("days")));
            trip.setPromotion(promotion);
            trip.setSeatsForAdult(Integer.parseInt(req.getParameter("seatsForAdult")));
            trip.setSeatsForChild(Integer.parseInt(req.getParameter("seatsForChild")));
            dao.saveOrUpdate(trip);
        }
        resp.sendRedirect("/trip/list");

    }
}
