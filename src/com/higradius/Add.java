package com.higradius;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add
 */

public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Name=request.getParameter("customerName");
		String s=request.getParameter("dueDate");
		SimpleDateFormat sfd=new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
			try 
			{
				 date=sfd.parse(s);
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
		java.sql.Date dueDate=new java.sql.Date(date.getTime());
		String Number=request.getParameter("customerNumber");
		String invNo=request.getParameter("invoiceNo");
		String invAmt=request.getParameter("invoiceAmt");
		String notes=request.getParameter("notes");
		
		Connection conn=null;
		try {
			conn = DbConnection.connection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("insert into highradius values(?,?,?,?,?,?,?,?)");
			ps.setString(1, Name);
			ps.setString(2, Number);
			ps.setString(3, invNo);
			ps.setInt(4,Integer.parseInt(invAmt));
			ps.setDate(5, dueDate);
			ps.setDate(6,null);
			ps.setString(7, notes);
			ps.setString(8, null);
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		response.setContentType("text/html");
		String back=new String("http://localhost:8085/H2HBABBA1678/");
		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("index", back);
		response.sendRedirect(back);
		
	}

}
