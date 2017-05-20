package ru.reeson2003.controller;

import ru.reeson2003.model.domain.Parameter;
import ru.reeson2003.model.main.AppContext;
import ru.reeson2003.model.Model;

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
    private Model model;

    @Override
    public void init() throws ServletException {
        model = AppContext.getInstance().getModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        if(model != null) {
            req.setAttribute("module", model.getModuleName());
            req.setAttribute("parameters", model.getParameters());
            req.setAttribute("update", updatePeriod());
        }
        req.getRequestDispatcher("WEB-INF/jsp/parameters.jsp").forward(req, resp);
    }

    private int updatePeriod() {
        int i = Integer.MAX_VALUE;
        for (Parameter p :
                model.getParameters()) {
            i = (i > p.getRequestPeriod()&& p.getRequestStatus()) ? p.getRequestPeriod() : i;
        }
        i *= 1000;
        return i;
    }
}
