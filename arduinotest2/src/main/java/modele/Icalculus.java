/**
 * 
 */
package modele;

/**
 * @author ivann 	VVV CESI Toulouse 3 déc. 2018 
 *
 */
public interface Icalculus {

	double steinhartHart(double resistance);
	double steinhartHartInversion(double T);

	double condensation(double T, double rh);

}
