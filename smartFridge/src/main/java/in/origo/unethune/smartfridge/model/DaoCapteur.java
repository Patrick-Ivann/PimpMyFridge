/**
 * 
 */
package in.origo.unethune.smartfridge.model;

/**
 * @author ivann 	VVV CESI Toulouse 29 nov. 2018 
 * @param <T>
 *
 */
public abstract class DaoCapteur<T> implements Dao<T> {

	public LecteurThermi lecteurThermi = LecteurThermi.getInstance();
	
	public LecteufrHumidite lecteufrHumidite = LecteufrHumidite.getInstance();
	
	public WriterMacro writerMacro = WriterMacro.getInstance();

	

	
	
}
