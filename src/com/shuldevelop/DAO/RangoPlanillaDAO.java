package com.shuldevelop.DAO;

import java.util.List;

import com.shuldevelop.model.RangoPlanilla;
import com.shuldevelop.model.RangoPlanillaId;

public interface RangoPlanillaDAO {

	public void add(RangoPlanilla rangoPlanilla);
	
	public void edit(RangoPlanilla rangoPlanilla);
	
	public void deleteRangoPlanilla(RangoPlanillaId id);
	
	public RangoPlanilla getRangoPlanilla(RangoPlanillaId id);
	
	public List<RangoPlanilla> getAllRangoPlanilla();
	
}
