package ru.reeson2003.controller;

import ru.reeson2003.Model;
import ru.reeson2003.Parameter;
import ru.reeson2003.model.AppContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Date: 20.05.2017.
 * Time: 11:59.
 *
 * @author Pavel Gavrilov.
 */
public class IndexController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        Model model = AppContext.getInstance().getModel();
        if(model != null) {
            req.setAttribute("module", model.getModuleName());
            req.setAttribute("parameters", model.getParameters());
            req.setAttribute("update", updatePeriod(model));
        }
        req.getRequestDispatcher("WEB-INF/jsp/parameters.jsp").forward(req, resp);
    }

    private int updatePeriod(Model model) {
        int i = Integer.MAX_VALUE;
        for (Parameter p : model.getParameters()) {
            i = (i > p.getRequestPeriod()&& p.getRequestStatus()) ? p.getRequestPeriod() : i;
        }
        i *= 1000;
        return i;
    }
}
