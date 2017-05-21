package ru.reeson2003.controller;

import ru.reeson2003.model.AppContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Date: 21.05.2017.
 * Time: 16:38.
 *
 * @author Pavel Gavrilov.
 */
public class PluginsRemoveController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> params = req.getParameterMap();
        String[] plugins = params.get("remove");
        for (String s: plugins) {
            AppContext.getInstance().getPluginsManager().removePlugin(s);
        }
        resp.sendRedirect("plugins");
    }
}
