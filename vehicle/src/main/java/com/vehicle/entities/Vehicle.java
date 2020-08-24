package com.vehicle.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vehicle_info")
public class Vehicle
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="v_id")
	private int vehicleId;
	
	@Column(name="v_type")
	private String vehicleType;
	
	@Column(name="v_name")
	private String vehicleName;

	@Column(name="v_model")
	private String vehicleModel;

	@Column(name="v_date")
	private String vehicleDate;

	@Column(name="v_company")
	private String vehicleCompany;

	@Column(name="v_category")
	private int vehicleCategory;

	@Column(name="v_torque")
	private double vehicleTorque;

	@Column(name="v_hp")
	private double vehicleHp;

	@Column(name="v_maxspeed")
	private double vehicleMaxSpeed;

	@Column(name="v_acc")
	private double vehicleAcc;

	@Column(name="v_run")
	private double vehicleRun;

	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public String getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getVehicleDate() {
		return vehicleDate;
	}
	public void setVehicleDate(String vehicleDate) {
		this.vehicleDate = vehicleDate;
	}
	public String getVehicleCompany() {
		return vehicleCompany;
	}
	public void setVehicleCompany(String vehicleCompany) {
		this.vehicleCompany = vehicleCompany;
	}
	public int getVehicleCategory() {
		return vehicleCategory;
	}
	public void setVehicleCategory(int vehicleCategory) {
		this.vehicleCategory = vehicleCategory;
	}
	public double getVehicleTorque() {
		return vehicleTorque;
	}
	public void setVehicleTorque(double vehicleTorque) {
		this.vehicleTorque = vehicleTorque;
	}
	public double getVehicleHp() {
		return vehicleHp;
	}
	public void setVehicleHp(double vehicleHp) {
		this.vehicleHp = vehicleHp;
	}
	public double getVehicleMaxSpeed() {
		return vehicleMaxSpeed;
	}
	public void setVehicleMaxSpeed(double vehicleMaxSpeed) {
		this.vehicleMaxSpeed = vehicleMaxSpeed;
	}
	public double getVehicleAcc() {
		return vehicleAcc;
	}
	public void setVehicleAcc(double vehicleAcc) {
		this.vehicleAcc = vehicleAcc;
	}
	public double getVehicleRun() {
		return vehicleRun;
	}
	public void setVehicleRun(double vehicleRun) {
		this.vehicleRun = vehicleRun;
	}
}
