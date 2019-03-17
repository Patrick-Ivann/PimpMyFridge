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
public class LecteufrHumidite {
	
	private static LecteufrHumidite instance;

	private LecteufrHumidite() {
		// TODO Auto-generated constructor stub
	}

	public static LecteufrHumidite getInstance() {
		
						
		// TODO Auto-generated method stub	
		
		if (instance == null) {
			instance = new LecteufrHumidite();
		}
		return instance;
	}
	
	public String readFile() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("F://ecole/Projet/A1 - Projet INTEGRATEUR/processing_toTXT/data.txt"));
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();
		   
		    
		    return line;
		} finally {
		    br.close();
		}
	}



}
