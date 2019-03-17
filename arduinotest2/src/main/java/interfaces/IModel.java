package interfaces;

import java.util.ArrayList;

public interface IModel {
	

	int getTempRequest();

	int getTempMax();


	public int regulation();
	
	
	void setTempRequest(int tempRequest);
	
	ArrayList<Double> getTempList();



	

	boolean getDuePoint();
	
	 boolean getCriticPoint();
	 
	 
	 public double getTempCurrent();
	 public void setTempCurrent(int tempCurrent);
	
	 public double getTempCurrentExt();
	 public void setTempCurrentExt(int tempCurrentExt);
	 
	 public double getTempPelletier();
	 public void setTempPelletier(double resistance);

	void setDewPointTemp(double d);

	void setHumidite(int parseInt);


}
