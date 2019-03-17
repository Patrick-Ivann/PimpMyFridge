/**
 * 
 */
package modele;

import interfaces.IModel;

/**
 * @author ivann 	VVV CESI Toulouse 3 déc. 2018 
 *
 */
public class Calculus implements Icalculus {
	
	static final double A = 17.27 ;
	static final double B = 237.7 ; 
	
	static final double COEF_A = 0.8222127604*Math.pow(10, -3);
	static final double COEF_B = 2.678362573*Math.pow(10, -4) ;
	static final double COEF_C = 0.8311685960*Math.pow(10, -7) ;
	
	
	
	private IModel modele;

	public Calculus(IModel modele) {

		 this.modele = modele;
	}

	

public double steinhartHart(double R) {
	
	double T = this.COEF_A + this.COEF_B*Math.log(R) + this.COEF_C*Math.pow(Math.log(R), 3);
			
			return 1/(T-25);    //temp pelletier 
			
			
}

/* (non-Javadoc)
 * @see modele.IModel#steinhartHartInversion(double)
 */
public double steinhartHartInversion(double T) {
	
			double x=(1/COEF_C)*(COEF_A-1/T);
			double y = ((COEF_B/3/COEF_C)*3+(x/2)*2)*0.5;
			double R = Math.exp(Math.pow((y-(x/2)),1/3.0)-(Math.pow((y+(x/2)),1/3.0)));
			
			
	return R;
	
}




/* (non-Javadoc)
 * @see modele.IModel#condensation(double, double)
 */
public double condensation(double T,double rh) {
	
	/*
Point de rosée : Tr=(b*k)/(a-k) et K=(a*T)/(b+T)+ln(Rh)
T = température ext (0 - 60°C)
Rh = Humidité relative (pourcentage)
Tr = température de rosée (0 - 50°)
a = 17.27
b = 237.7*/
	
	double K = (A*T)/(B/T)+Math.log(rh);	
	
 
 modele.setDewPointTemp( (B*K)/(A-K));
 
 
 System.out.println("condensation - " + (B*K)/(A-K) ); 
 
 
 
return   (B*K)/(A-K);

}






}
