package in.origo.unethune.smartfridge.model;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
	
	
	
	     
	    Optional get(long id);
	     
	    List<T> getAll();
	     
	    void save(T t);
	     
	    void update(T t, String[] params);
	     
	    void delete(T t);
	

}
