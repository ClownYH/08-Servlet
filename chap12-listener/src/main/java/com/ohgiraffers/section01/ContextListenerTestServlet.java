package com.ohgiraffers.section01;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/context")
public class ContextListenerTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // context는 뭔가를 저장하고 있는 공간, container랑 같은 의미다.
        System.out.println("context listener 확인용 서블릿");

        ServletContext context = req.getServletContext();
        context.setAttribute("test" , "value"); // added
        context.setAttribute("test", "value2"); // replaced
        context.removeAttribute("test"); // removed

    }
}
