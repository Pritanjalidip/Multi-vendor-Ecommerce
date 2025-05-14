package com.ecommerce.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class AddProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("productName");
        String productDescription = request.getParameter("productDescription");
        double productPrice = Double.parseDouble(request.getParameter("productPrice"));

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_db", "username", "password");
            String query = "INSERT INTO products (name, description, price) VALUES (?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, productName);
            pst.setString(2, productDescription);
            pst.setDouble(3, productPrice);
            pst.executeUpdate();

            response.sendRedirect("vendorDashboard.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
