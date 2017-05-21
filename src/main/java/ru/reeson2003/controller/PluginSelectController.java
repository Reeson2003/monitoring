package ru.reeson2003.controller;

import ru.reeson2003.model.AppContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Date: 21.05.2017.
 * Time: 16:48.
 *
 * @author Pavel Gavrilov.
 */
public class PluginSelectController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        AppContext.getInstance().getPluginsManager().selectPlugin(name);
        resp.sendRedirect("index.html");
    }
}
