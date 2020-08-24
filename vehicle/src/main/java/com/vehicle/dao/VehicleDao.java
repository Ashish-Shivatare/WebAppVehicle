package com.vehicle.dao;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.vehicle.entities.Vehicle;
import com.vehicle.service.VehicleService;

public class VehicleDao {

	SessionFactory factory = new Configuration().configure("cfgs/hibernate.cfg.xml").addAnnotatedClass(Vehicle.class).buildSessionFactory();

	public boolean addVehicle(String vehicleType,String vehicleName,String vehicleModel,String vehicleDate,String vehicleCompany,int vehicleCategory,double vehicleTorque,double vehicleHp,double vehicleMaxSpeed,double vehicleAcc,double vehicleRun) {
		boolean flag = true;
		Session session=factory.openSession();

		Vehicle v1 = new Vehicle();
		v1.setVehicleId(0);
		v1.setVehicleType(vehicleType);
		v1.setVehicleName(vehicleName);
		v1.setVehicleModel(vehicleModel);
		v1.setVehicleDate(vehicleDate);
		v1.setVehicleCompany(vehicleCompany);
		v1.setVehicleCategory(vehicleCategory);
		v1.setVehicleTorque(vehicleTorque);
		v1.setVehicleHp(vehicleHp);
		v1.setVehicleMaxSpeed(vehicleMaxSpeed);
		v1.setVehicleAcc(vehicleAcc);
		v1.setVehicleRun(vehicleRun);

		Transaction transaction=session.beginTransaction();
		try { 
			session.save(v1);
			transaction.commit();
		}catch (Exception e) 
		{
			transaction.rollback();
			flag = false;
		}
		session.close();
		return flag;
	}

	public List<Vehicle> displayByCategory() {
		Session session = factory.openSession();

		Criteria crt = session.createCriteria(Vehicle.class);
		crt.addOrder(Order.asc("vehicleCategory"));

		List<Vehicle> categoryList = crt.list();
		session.close();
		return categoryList;
	}

	public List<Vehicle> displayByName() {
		Session session = factory.openSession();

		Criteria crt = session.createCriteria(Vehicle.class);
		crt.addOrder(Order.asc("vehicleName"));

		List<Vehicle> nameList = crt.list();
		session.close();

		return nameList;
	}

	public List<Vehicle> displayByMaxspeed() {
		Session session = factory.openSession();

		Criteria crt = session.createCriteria(Vehicle.class);
		crt.addOrder(Order.asc("vehicleName"));
		crt.addOrder(Order.asc("vehicleMaxSpeed"));

		List<Vehicle> maxList = crt.list();
		session.close();

		return maxList;
	}

	public List<Vehicle> displayByMfgDate(String lowerMfgDate, String uppderMfgDate) {
		Session session = factory.openSession();

		Criteria crt = session.createCriteria(Vehicle.class);
		crt.add(Restrictions.ge("vehicleDate", lowerMfgDate));
		crt.add(Restrictions.le("vehicleDate", uppderMfgDate));

		List<Vehicle> dateList = crt.list();
		session.close();

		return dateList;
	}
}
