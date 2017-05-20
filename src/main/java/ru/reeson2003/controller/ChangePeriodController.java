package ru.reeson2003.controller;

import ru.reeson2003.model.Model;
import ru.reeson2003.model.domain.Parameter;
import ru.reeson2003.model.main.AppContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Date: 20.05.2017.
 * Time: 17:49.
 *
 * @author Pavel Gavrilov.
 */
public class ChangePeriodController extends HttpServlet {
    private Model model;

    @Override
    public void init() throws ServletException {
        model = AppContext.getInstance().getModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameterName = req.getParameter("parameter");
        Parameter parameter = model.getParameter(parameterName);
        Integer period = null;
        try {
            String p = req.getParameter("period");
            period = Integer.parseInt(p);
        } catch (NumberFormatException e) {

        }
        if(period != null && period >= 0)
            parameter.setRequestPeriod(period);
        resp.sendRedirect("/");
    }
}
