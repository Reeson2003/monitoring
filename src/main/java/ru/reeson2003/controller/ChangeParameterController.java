package ru.reeson2003.controller;

import ru.reeson2003.Parameter;
import ru.reeson2003.model.AppContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Date: 21.05.2017.
 * Time: 22:08.
 *
 * @author Pavel Gavrilov.
 */
public class ChangeParameterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameterName = req.getParameter("parameter");
        Parameter parameter = AppContext.getInstance().getModel().getParameter(parameterName);
        String p = req.getParameter("value");
        parameter.setName(p);
        resp.sendRedirect("index.html");
    }
}
