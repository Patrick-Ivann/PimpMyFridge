package interfaces;


import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public interface IView {

	void build();

	


	IModel getModel();

	void setModel(IModel model);

	JTextField getTextField();

	void setTextField(JTextField textField);

	JTextField getTextField_1();

	void setTextField_1(JTextField textField_1);

	JSpinner getjSpinner1();

	void setjSpinner1(JSpinner jSpinner1);

	JSpinner getjSpinner2();

	void setjSpinner2(JSpinner jSpinner2);

	JLabel getLblNewLabel_1();

	void setLblNewLabel_1(JLabel lblNewLabel_1);

	JLabel getLblNewLabel();

	void setLblNewLabel(JLabel lblNewLabel);

	JProgressBar getProgressBar();

	void setProgressBar(JProgressBar progressBar);

	JProgressBar getProgressBar_1();

	void setProgressBar_1(JProgressBar progressBar_1);


	public Observer getPanel_tab1();
	
	public Observer getPanel_tab2();

	
	/**
	 * @return the tempMax
	 */
	int getTempMax();

	/**
	 * @param tempMax the tempMax to set
	 */
	void setTempMax(int tempMax);

	/**
	 * @return the temp
	 */
	int getTemp();

	/**
	 * @param temp the temp to set
	 */
	void setTemp(int temp);


}
