package com.vehicle.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vehicle.dao.VehicleDao;
import com.vehicle.entities.Vehicle;

@WebServlet("/date")
public class DateService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String lowerMfgDate = req.getParameter("lowerMfgDate");
		String upperMfgDate = req.getParameter("upperMfgDate");

		VehicleDao vehicleDao = new VehicleDao();
		List<Vehicle> dateList = new ArrayList<Vehicle>();
		dateList = vehicleDao.displayByMfgDate(lowerMfgDate, upperMfgDate);
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		pw.println("<h1>Vehicle details displayed by category:</h1>");

		pw.print("<table border='2'>");

		pw.print("<thead>");
		pw.print("<tr>");
		pw.print("<th>VEHICLE ID</th>");
		pw.print("<th>VEHICLE TYPE</th>");
		pw.print("<th>VEHICLE NAME</th>");
		pw.print("<th>VEHICLE MODEL</th>");
		pw.print("<th>VEHICLE DATE</th>");
		pw.print("<th>VEHICLE COMPANY</th>");
		pw.print("<th>VEHICLE WHEELER CATEGORY</th>");
		pw.print("<th>VEHICLE TORQUE</th>");
		pw.print("<th>VEHICLE HP</th>");
		pw.print("<th>VEHICLE MAXSPEED</th>");
		pw.print("<th>VEHICLE ACC</th>");
		pw.print("<th>VEHICLE RUN</th>");
		pw.print("</tr>");
		pw.print("</thead>");

		pw.print("<tbody>");
		for (Vehicle vlist : dateList) {
			pw.print("<tr>");
			pw.print("<td>"+vlist.getVehicleId()+"</td>");
			pw.print("<td>"+vlist.getVehicleType()+"</td>");
			pw.print("<td>"+vlist.getVehicleName()+"</td>");
			pw.print("<td>"+vlist.getVehicleModel()+"</td>");
			pw.print("<td style='color:red'>"+vlist.getVehicleDate()+"</td>");
			pw.print("<td>"+vlist.getVehicleCompany()+"</td>");
			pw.print("<td>"+vlist.getVehicleCategory()+"</td>");
			pw.print("<td>"+vlist.getVehicleTorque()+"</td>");
			pw.print("<td>"+vlist.getVehicleHp()+"</td>");
			pw.print("<td>"+vlist.getVehicleMaxSpeed()+"</td>");
			pw.print("<td>"+vlist.getVehicleAcc()+"</td>");
			pw.print("<td>"+vlist.getVehicleRun()+"</td>");
			pw.print("</tr>");
		}

		pw.print("</tbody>");
		pw.print("</table");
	}
}
