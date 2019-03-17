/**
 * 
 */
package modele;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import interfaces.IModel;

/**
 * @author ivann
 *
 */
public class Model extends Observable implements IModel  {
	
	
	private ArrayList<Observer> panelsToUpdate = new ArrayList<Observer>();
	private ArrayList<Double> tempList = new ArrayList<Double>();

	
	private int valeur;
	private int tempRequest;
	private double tempCurrent;
	private double tempCurrentExt;
	private double tempPelletier;
	private double tempCondensation;
	
	
	private double dewPointTemp;
	
	static final int TEMP_MAX = 15;

	

	
	private Icommunication communication;
	private Icalculus calculus;

	private int humidite;
	

public Model() {
	// TODO Auto-generated constructor stub
	

	
		//this.communication = new Communication(this);
		this.calculus = new Calculus(this);
	
	
	
	
	
}	




public int regulation() {
	
	if (this.getTempCurrent() >= this.getTempRequest()) {
		
		setChanged();
		//();
		return 5; // fait trop chaud
	} else if (this.getTempCurrent() <= this.getTempRequest()) {

		return 0; //troi froid ou bon
		
		
	} else if ( this.getTempCurrent() > this.getDewPointTemp() - 2 ) { // si on approche du point de rosée
		
		return 0;
	}else if ( this.getTempCurrent() > this.TEMP_MAX - 2 ) { // si on approche du point de rosée
		
		return 5;
	}else if ( this.getTempCurrent() - this.getTempRequest() < 0 ) { // si on approche du point de rosée
		
		return 5;
	}
	
	
	return 5;
	

}







 



/* (non-Javadoc)
 * @see modele.IModel#getValeur()
 */
public int getValeur() {
	return valeur;
}






public boolean getDuePoint() {

	if (this.getDewPointTemp() <= this.getTempCurrent()) {
		setChanged();
		//();

		return true;
		
	}else {
		setChanged();
		//();

	return false;
	
	}
}

public boolean getCriticPoint() {

	if (this.getTempMax() <= this.getTempCurrent()) {
		setChanged();

		return true;
		
	}else {
		setChanged();

	return false;
	
	}
}


/**
 * @return the dewPointTemp
 */
public double getDewPointTemp() {
	return dewPointTemp;
}


/**
 * @param dewPointTemp the dewPointTemp to set
 */
public void setDewPointTemp(double dewPointTemp) {
	this.dewPointTemp = dewPointTemp;
	setChanged();
	////(this.getDewPointTemp());
	//();
}

/* (non-Javadoc)
 * @see modele.IModel#getTempRequest()
 */
public int getTempRequest() {
	return tempRequest;
}


/* (non-Javadoc)
 * @see modele.IModel#setTempRequest(int)
 */
public void setTempRequest(int tempRequest) {

	
	this.tempRequest = tempRequest;
	setChanged();
	notifyObservers();
}


/* (non-Javadoc)
 * @see modele.IModel#getTempMax()
 */
public int getTempMax() {
	return TEMP_MAX;
}



/* (non-Javadoc)
 * @see modele.IModel#getTempCurrent()
 */
public double getTempCurrent() {
	return tempCurrent;
}


public void setTempCurrent(int temperature) {
	this.tempCurrent = temperature;
	this.tempList.add((double)temperature);
	setChanged();
	//();

	////(tempCurrent);
	
}


/**
 * @return the tempList
 */
public ArrayList<Double> getTempList() {
	return tempList;
}




/**
 * @param tempList the tempList to set
 */
public void setTempList(ArrayList<Double> tempList) {
	setChanged();
//();	
	this.tempList = tempList;
}




/**
 * @return the tempPelletier
 */
public double getTempPelletier() {
	return tempPelletier;
}


/**
 * @param tempPelletier the tempPelletier to set
 */
public void setTempPelletier(double resistance) {
	
	
	
	this.tempPelletier = this.calculus.steinhartHart(resistance);
	setChanged();
	//();
}


/**
 * @return the tempCurrentExt
 */
public double getTempCurrentExt() {
	return tempCurrentExt;
}


/**
 * @param tempCurrentExt the tempCurrentExt to set
 */
public void setTempCurrentExt(double resistance) {
	this.tempCurrentExt = this.calculus.steinhartHart(resistance);
	setChanged();
	//();
}




public void setTempCurrentExt(int tempCurrentExt) {
	// TODO Auto-generated method stub
	
}




public void setHumidite(int parseInt) {
	
	this.calculus.condensation(this.getTempCurrent(), parseInt);

	this.humidite = parseInt;
	
	setChanged();
	//();
}




public int getHumidite() {
	return humidite;
}




/**
 * @return the tempCondensation
 */
public double getTempCondensation() {
	return tempCondensation;
}




/**
 * @param tempCondensation the tempCondensation to set
 */
public void setTempCondensation(double tempCondensation) {
	this.tempCondensation = tempCondensation;
}








//@Override
//	public synchronized void addObserver(Observer o) {
//		// TODO Auto-generated method stub
//		//super.addObserver(o);
//	
//	panelsToUpdate.add(o);
//
//	}

//@Override
//	public void notifyObservers() {
//		// TODO Auto-generated method stub
//		//super.notifyObservers(arg);
//	
//	for (Observer observer : panelsToUpdate) {
//	 observer.update(this, 1);
//	}
//	}



}
