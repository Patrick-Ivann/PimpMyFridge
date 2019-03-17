/**
 * 
 */
package in.origo.unethune.smartfridge.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author ivann 	VVV CESI Toulouse 29 nov. 2018 
 *
 */
public class WriterMacro {
	
	private static WriterMacro instance;

	private WriterMacro() {
		// TODO Auto-generated constructor stub
	}

	public static WriterMacro getInstance() {
		
						
		// TODO Auto-generated method stub	
		
		if (instance == null) {
			instance = new WriterMacro();
		}
		return instance;
	}
	
	public String writeFile() throws IOException {
		
		
		return null;
		
	}



}
