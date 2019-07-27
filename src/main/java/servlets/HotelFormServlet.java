package servlets;

import database.EntityDao;
import model.City;
import model.Country;
import model.Hotel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Collectors;

@WebServlet("/hotel/add")
public class HotelFormServlet extends HttpServlet {
    private EntityDao dao=new EntityDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("countryList", dao.findAll(Country.class));
        if (req.getParameter("countryId") != null) {
            Long countryId = Long.valueOf(req.getParameter("countryId"));
            req.setAttribute("cityList",
                    dao.findAll(City.class)
                            .stream()
                            .filter(city -> city.getCountry().getId().equals(countryId))
                            .collect(Collectors.toList()));
        }else {
            req.setAttribute("cityList", dao.findAll(City.class));
        }

        req.getRequestDispatcher("/hotel/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String selectedCityId = req.getParameter("cityId");

        Optional<City> cityOptional = dao.findById(City.class, Long.parseLong(selectedCityId));

        if (cityOptional.isPresent()) {
            City city=cityOptional.get();
            Hotel hotel=new Hotel();
            hotel.setName(req.getParameter("name"));
            hotel.setStars(Integer.parseInt(req.getParameter("stars")));
            hotel.setDescription(req.getParameter("description"));
            hotel.setCity(city);
            dao.saveOrUpdate(hotel);

            city.getHotels().add(hotel);
            dao.saveOrUpdate(city);

        }

        resp.sendRedirect("/hotel/list");

    }
}
