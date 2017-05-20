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
 * Time: 15:19.
 *
 * @author Pavel Gavrilov.
 */
public class StatusSwitchController extends HttpServlet {
    private Model model;

    @Override
    public void init() throws ServletException {
        model = AppContext.getInstance().getModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameterName = req.getParameter("parameter");
        Parameter parameter = model.getParameter(parameterName);
        parameter.setRequestStatus(!parameter.getRequestStatus());
        resp.sendRedirect("/");
    }
}
