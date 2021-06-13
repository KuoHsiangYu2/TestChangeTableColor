package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.CustomerBean;
import com.util.Database;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
        Database.initializeDatabaseList();
    }

    private static String encryptStr(String inputStr) {
        /* 字串加密 */

        int length = inputStr.length();
        String result = "";
        for (int i = 0; i < length; i++) {
            char unit = inputStr.charAt(i);
            int unit2 = (int) unit;
            unit2 = unit2 ^ 3;
            result = result + String.valueOf((char) unit2);
        }
        return result;
    }

    private static String getSafeString(String input) {
        if (input == null) {
            return "";
        }
        return input;
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String accountName = getSafeString(request.getParameter("accountName"));
        String passwordName = getSafeString(request.getParameter("passwordName"));
        accountName = encryptStr(accountName);
        passwordName = encryptStr(passwordName);

        boolean isCorrectAccount = false;

        if (accountName.length() == 0 || passwordName.length() == 0) {
            isCorrectAccount = false;
        } else if (!"bgnjm".equals(accountName) || !"bgnjm".equals(passwordName)) {
            isCorrectAccount = false;
        } else {
            isCorrectAccount = true;
        }

        RequestDispatcher requestDispatcher = null;
        if (isCorrectAccount) {
            List<CustomerBean> customerBeanList = Database.getDatabaseList();
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("customerBeanList", customerBeanList);
            System.out.println("request.getContextPath() = [" + request.getContextPath() + "]");
            response.sendRedirect(request.getContextPath() + "/tableData.jsp");
        } else {
            requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}