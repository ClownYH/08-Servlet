package com.ohgiraffers.section01;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/forward")
public class ReceiveInformationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userId = req.getParameter("userId");
        String password = req.getParameter("password");

        System.out.println("user ID : " + userId);
        System.out.println("password : " + password);

        req.setAttribute("userId", userId);
        RequestDispatcher rd = req.getRequestDispatcher("print"); // 요청을 전파 지시
        rd.forward(req, resp); // forward가 요청을 전달(실제 동작은 /print에서 하지만 /forward에서 한 것처럼 표시)

    }
}
