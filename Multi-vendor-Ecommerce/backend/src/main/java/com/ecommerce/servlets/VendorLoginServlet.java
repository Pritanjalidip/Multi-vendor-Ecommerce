package com.ecommerce.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class VendorLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vendorEmail = request.getParameter("vendorEmail");
        String vendorPassword = request.getParameter("vendorPassword");

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_db", "username", "password");
            String query = "SELECT * FROM vendors WHERE email = ? AND password = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, vendorEmail);
            pst.setString(2, vendorPassword);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                response.sendRedirect("vendorDashboard.jsp");
            } else {
                response.sendRedirect("vendorLogin.jsp?error=Invalid credentials");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
