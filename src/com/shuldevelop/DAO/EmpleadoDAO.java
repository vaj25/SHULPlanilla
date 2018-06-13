package com.shuldevelop.DAO;

import java.util.Hashtable;
import java.util.List;

import com.shuldevelop.model.Empleado;
import com.shuldevelop.model.EmpleadoView;

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
	public List<Empleado> getOneEmpleado(int idEmpleado);
	public List<EmpleadoView> getViewEmpleado(Hashtable<String, String> listParameter);
	
}
