package in.origo.unethune.smartfridge.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ThermistanceDao implements Dao<Thermistance> {
	
	private List<Thermistance> thermistance = new ArrayList<Thermistance>();

	public ThermistanceDao() {
		// TODO Auto-generated constructor stub
	}
	
	public Optional<Thermistance> get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Thermistance> getAll() {
		// TODO Auto-generated method stub
	return thermistance;

	}

	public void save(Thermistance t) {
		// TODO Auto-generated method stub
		
		thermistance.add(t);
		
	}

	public void update(Thermistance t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Thermistance t) {
		// TODO Auto-generated method stub
		
	}

	

}
