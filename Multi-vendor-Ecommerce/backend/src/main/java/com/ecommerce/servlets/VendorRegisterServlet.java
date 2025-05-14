package com.ecommerce.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class VendorRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vendorName = request.getParameter("vendorName");
        String vendorEmail = request.getParameter("vendorEmail");
        String vendorPassword = request.getParameter("vendorPassword");

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_db", "username", "password");
            String query = "INSERT INTO vendors (name, email, password) VALUES (?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, vendorName);
            pst.setString(2, vendorEmail);
            pst.setString(3, vendorPassword);
            pst.executeUpdate();

            response.sendRedirect("vendorLogin.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
