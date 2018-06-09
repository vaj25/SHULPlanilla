package com.shuldevelop.DAO;

import java.util.List;

import com.shuldevelop.model.Empleado;

public interface EmpleadoDAO {
	public void add(Empleado empleado);
	public void edit(Empleado empleado);
	public void delete(int idEmpleado);
	public Empleado getEmpleado(int idEmpleado);
	public List<Empleado> getAllEmpleado();
	public List<Empleado> getAllSub(int idEmpleado);
	public List<Empleado> getDui(String Ndui);
	public List<Empleado> getNit(String Nnit);
	public List<Empleado> getIsss(int Nisss);
	public List<Empleado> getNup(long Nnup);
	public List<Empleado> getEmpEmail(String emailEmp);
	public List<Empleado> getInsEmail(String emailInst);
	
	
}
