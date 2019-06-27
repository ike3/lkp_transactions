package ru.lanit.lkp.transactions;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * http://localhost:8080/caller/call?name=caller_error
 */
@WebServlet(urlPatterns = "/call")
public class CallerServlet extends HttpServlet {

    @Inject
    @Named("ProducedClient")
    private CallerService caller;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("CALLER SERVLET STARTED");

        String name = req.getParameter("name");
        if (StringUtils.isEmpty(name)) {
            name = "(empty)";
        }

        String result;
        try {
            result = caller.doSomething(name);
        } catch (Exception e) {
            result = e.getClass() + ": " + e.getMessage();
        }

        req.setAttribute("result", result);
        req.getRequestDispatcher("WEB-INF/jsp/call.jsp").forward(req, resp);
        System.out.println("CALLER SERVLET FINISHED");
    }

}
