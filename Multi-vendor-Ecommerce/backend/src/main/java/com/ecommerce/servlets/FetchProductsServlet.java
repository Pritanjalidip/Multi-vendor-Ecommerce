package com.ecommerce.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class FetchProductsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_db", "username", "password");
            String query = "SELECT * FROM products";
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            List<String> products = new ArrayList<>();
            while (rs.next()) {
                products.add(rs.getString("name"));
            }

            request.setAttribute("products", products);
            RequestDispatcher dispatcher = request.getRequestDispatcher("productList.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
