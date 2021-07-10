package com.higradius;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
/**
 * Servlet implementation class Fetch
 */

public class Fetch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fetch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			ArrayList<Invc> i=new ArrayList<Invc>();
			Connection con=DbConnection.connection();
			Statement st=con.createStatement();
			
			ResultSet rs = st.executeQuery("select name_customer,cust_number,invoice_id,total_open_amount,due_in_date,clear_date,Notes from highradius limit 10");
			while(rs.next())
			{
				Invc invc=new Invc();
				invc.setCustomerName(rs.getString(1));
				invc.setCutomerNumber(rs.getString(2));
				invc.setInvoiceID(rs.getString(3));
				invc.setOpenAmount(rs.getLong(4));
				invc.setDueDate(rs.getDate(5));
				invc.setClearDate(rs.getDate(6));
				invc.setNote(rs.getString(7));
				i.add(invc);
			}
			Gson gson=new Gson();
			PrintWriter pw=response.getWriter();
			String data=gson.toJson(i);
			//System.out.println(data);
			
			response.setContentType("application/json");
			 response.setCharacterEncoding("UTF-8");
			 pw.write(data);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
