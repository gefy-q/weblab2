package son.lab2.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            double x = getDouble(request, "x");
            double y = getDouble(request, "y");
            double r = getDouble(request, "r");
            if(x < -5 || x > 3) throw new RuntimeException();
            if(y < -3 || y > 5) throw new RuntimeException();
            if(r < 2 || r > 5) throw new RuntimeException();
            getServletContext().getRequestDispatcher("/AreaCheckServlet").forward(request, response);
        } catch(Exception e) {
            response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }
    }
    public static double getDouble(HttpServletRequest request, String parameter) {
        String param = request.getParameter(parameter);
        return Double.parseDouble(param.replace(",", "."));
    }
}
