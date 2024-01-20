package son.lab2.controller;

import son.lab2.model.CheckResult;
import son.lab2.model.ResultBank;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AreaCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        double x = 0;
        double y = 0;
        double r = 0;
        try {
            x = ControllerServlet.getDouble(request, "x");
            y = ControllerServlet.getDouble(request, "y");
            r = ControllerServlet.getDouble(request, "r");
        } catch(Exception e) {
            response.sendRedirect("index.jsp");
        }
        boolean result = isInArea(x, y, r);
        Date time = new Date();
        CheckResult model = new CheckResult(x, y, r, result, time);
        HttpSession session = request.getSession();
        ResultBank sessionData = (ResultBank) session.getAttribute("data");
        sessionData = sessionData == null ? new ResultBank() : sessionData;
        sessionData.addResult(model);
        session.setAttribute("data", sessionData);
        response.sendRedirect("table.jsp");
    }
    private boolean isInArea(double x, double y, double r) {
        return (x <= 0 && y >= 0 && x >= -r && y <= r) ||
                (x <= 0 && y <= 0 && y > -2*x - r) ||
                (x >= 0 && y <= 0 && x*x + y*y <= r*r);
    }
}