package ru.lanit.lkp.transactions;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import org.apache.commons.lang3.StringUtils;

import ru.lanit.lkp.transactions.ws.api.CallerService;

/**
 * http://localhost:8080/caller/call?name=caller_error
 */
public class CallerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        if (StringUtils.isEmpty(name)) {
            name = "(empty)";
        }

        CallerService caller = new CallerClient().getService();
        String result;
        try {
            InitialContext initCtx = new InitialContext();
            UserTransaction userTran = (UserTransaction)initCtx.lookup("java:comp/UserTransaction");
            userTran.begin ();
            result = caller.doSomething(name);
            userTran.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        req.setAttribute("result", result);
        req.getRequestDispatcher("WEB-INF/jsp/call.jsp").forward(req, resp);
    }

}
