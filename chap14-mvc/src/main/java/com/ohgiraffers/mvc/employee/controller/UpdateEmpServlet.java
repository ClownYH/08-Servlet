package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.dto.EmpUpdateDTO;
import com.ohgiraffers.mvc.employee.service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employees2")
public class UpdateEmpServlet extends HttpServlet {

    private EmpService empService;

    @Override
    public void init() throws ServletException { // init이 없으면 시행자체가 불가능하다.
        empService = new EmpService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        EmpUpdateDTO update = new EmpUpdateDTO();

        update.setEmpId(req.getParameter("empId"));
        update.setEmail(req.getParameter("email"));
        update.setPhone(req.getParameter("phone"));
        update.setDeptCode(req.getParameter("deptCode"));
        update.setJobCode(req.getParameter("jobCode"));
        update.setSalLevel(req.getParameter("salLevel"));
        update.setSalary(Integer.parseInt(req.getParameter("salary")));
        update.setBonus(Double.parseDouble(req.getParameter("bonus")));
        update.setManagerId(req.getParameter("managerId"));

        int result = empService.update(update);
        String path;

        if(result > 0){
            path = "/WEB-INF/views/common/successPage.jsp";
            req.setAttribute("message", "직원 정보 수정 성공");
        }else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "직원 정보 수정 실패");
        }

        req.getRequestDispatcher(path).forward(req, resp);

    }

    @Override
    public void destroy() {
        empService = null;
    }
}
