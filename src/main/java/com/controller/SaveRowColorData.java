package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import com.model.CustomerBean;
import com.util.Database;

@WebServlet("/SaveRowColorData")
public class SaveRowColorData extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SaveRowColorData() {
        super();
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        /* 把前端送來的 JSON資料 在後端程式進行解析。 */
        String jsonInputString = "";
        JSONArray jsonArray = null;
        Enumeration<String> enumeration = request.getParameterNames();
        while (true == enumeration.hasMoreElements()) {
            jsonInputString = enumeration.nextElement();
            System.out.println("jsonInputString = " + jsonInputString);
            jsonArray = new JSONArray(jsonInputString);
        }

        /* 把陣列拆分成一個一個物件，開始取出資料。 */
        for (int i = 0, len = jsonArray.length(); i < len; i++) {
            JSONObject unitObject = (JSONObject) jsonArray.get(i);
            Integer customerObjKey = (Integer) unitObject.get("customerObjKey");
            String backgroundColor = (String) unitObject.get("backgroundColor");

            /* 這邊我沒有把資料存進資料庫，只是儲存進一個 static ArrayList而已。本專案主要目的是練習前後端傳遞解析JSON格式資料。 */
            Database.settingRowColorData(customerObjKey.intValue(), backgroundColor);
        }

        /* 把最新版本的ArrayList物件資料，更新進session裡面。 */
        List<CustomerBean> customerBeanList = Database.getDatabaseList();
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("customerBeanList", customerBeanList);

        PrintWriter printWriter = response.getWriter();
        printWriter.print("isOK");
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
