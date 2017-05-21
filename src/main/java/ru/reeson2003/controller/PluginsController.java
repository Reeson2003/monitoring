package ru.reeson2003.controller;

import ru.reeson2003.model.AppContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Date: 21.05.2017.
 * Time: 15:03.
 *
 * @author Pavel Gavrilov.
 */
public class PluginsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String > plugins =  AppContext.getInstance().getPluginsManager().getPluginsNames();
        req.setAttribute("plugins", plugins);
        req.getRequestDispatcher("WEB-INF/jsp/plugins.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String file = req.getParameter("file");
        AppContext.getInstance().getPluginsManager().addPlugin(name, file);
        resp.sendRedirect("plugins");
    }
}
