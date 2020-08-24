package com.vehicle.service;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vehicle.dao.VehicleDao;
import com.vehicle.entities.Vehicle;

@WebServlet("/vehicle")
public class VehicleService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("this is servlet");
		String vehicleType = request.getParameter("vType");
		String vehicleName = request.getParameter("name");
		String vehicleModel = request.getParameter("model");
		String vehicleDate = request.getParameter("date");
		String vehicleCompany = request.getParameter("company");
		int vehicleCategory = Integer.parseInt(request.getParameter("category"));
		double vehicleTorque = Double.parseDouble(request.getParameter("torque"));
		double vehicleHp = Double.parseDouble(request.getParameter("hp"));
		double vehicleMaxSpeed = Double.parseDouble(request.getParameter("maxSpeed"));
		double vehicleAcc = Double.parseDouble(request.getParameter("acc"));
		double vehicleRun = Double.parseDouble(request.getParameter("run"));
		
		
		VehicleDao vehicleDao = new VehicleDao();
		boolean b = vehicleDao.addVehicle(vehicleType, vehicleName, vehicleModel, vehicleDate, vehicleCompany, vehicleCategory, vehicleTorque, vehicleHp, vehicleMaxSpeed, vehicleAcc, vehicleRun);
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		if(b==true)
		{
			pw.println("<h1>Vehicle details sucessfully saved.</h1>");

		}
		else
		{
			pw.println("<h1>Error saving vehicle details</h1>"); 
		}
		pw.println("");
		pw.close();
	}
}
