package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import interfaces.IModel;
import interfaces.IView;

public class Panel_tab1 extends JPanel implements Observer, IView {

	private IModel model;
	private JTextField textField;
	private JTextField textField_1;
	private JSpinner jSpinner1;
	private JSpinner jSpinner2;

	private int tempMax;
	private int temp;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel ;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JProgressBar progressBar;
	private JProgressBar progressBar_1;

	private Observable observable = null;
	private Observer panel_tab1 = null;
	private IView frame;


	public Panel_tab1(IView frame, JTabbedPane tabbedPanel, IModel model) {
		this.model = model;
		this.frame = frame;

		this.setPanel_tab1(this);
		this.observable = (Observable) model;


		this.observable.addObserver(this);


		this.setLayout(new BorderLayout(0, 0));

		progressBar = new JProgressBar();
		progressBar.setBackground(Color.RED);
		progressBar.setForeground(Color.cyan);
		progressBar.setValue(100);
		progressBar.setString("DEW");

		this.add(progressBar, BorderLayout.EAST);

		progressBar_1 = new JProgressBar();
		progressBar_1.setToolTipText("jhh");
		progressBar_1.setForeground(Color.RED);

		progressBar_1.setValue(100);
		this.add(progressBar_1, BorderLayout.WEST);

		JPanel panel_2 = new JPanel();
		this.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));

		lblNewLabel_1 = new JLabel("Requested Temperature :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_1);

		//textField_1 = new JTextField();
		//textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		//panel_2.add(textField_1);
		//textField_1.setColumns(10);

		jSpinner1 = new JSpinner(new SpinnerNumberModel(10, 0, 24, 1));

		panel_2.add(jSpinner1);

		lblNewLabel = new JLabel("Current Temperature");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel);



		//textField.setHorizontalAlignment(SwingConstants.CENTER);
		//textField.setColumns(10);

		JTextPane txtpnDsds = new JTextPane();
		txtpnDsds.setEnabled(false);
		txtpnDsds.setEditable(false);
		this.add(txtpnDsds, BorderLayout.CENTER);

		JPanel panel_4 = new JPanel();
		this.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new BorderLayout(0, 0));

		lblNewLabel_2 = new JLabel("");
		panel_4.add(lblNewLabel_2, BorderLayout.WEST);

		lblNewLabel_3 = new JLabel("");
		panel_4.add(lblNewLabel_3, BorderLayout.EAST);

		JTextPane textPane = new JTextPane();
		textPane.setEnabled(false);
		textPane.setEditable(false);
		panel_4.add(textPane, BorderLayout.CENTER);
	}




	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);

		System.out.println("panel1");

		this.getLblNewLabel().setText( (String.valueOf( "Current Temperature: " +	this.model.getTempCurrent()))  );
		this.getLblNewLabel_1().setText( (String.valueOf( "Requested Temperature: " +	this.model.getTempRequest()))  );

		this.getLblNewLabel_2().setText(String.valueOf( "input (5 cooling - 0 IDLE): " +	this.model.regulation()));

		//this.getLblNewLabel_2().setText(String.valueOf(	this.model.getDuePoint()));
		this.getLblNewLabel_3().setText("External Temperature: " +String.valueOf(	this.model.getTempCurrentExt()));
		//this.getLblNewLabel_4().setText(String.valueOf(	this.model.getTempCurrentExt()));
		//this.getLblNewLabel_5().setText(String.valueOf(	this.model.getTempPelletier()));





	}

	public void update(Observable o, Object arg) {


		System.out.println(this.model.getTempCurrent() + "si on repaint le panel tab1 la température actu");
		this.setTemp( (int) this.model.getTempCurrent());

		if (this.model.getDuePoint()) {

			this.getProgressBar().setValue(100);
			this.getProgressBar().setString("DEW");

		}else {

			this.getProgressBar().setValue(0);

		}

		if (this.getProgressBar().getValue() == 100) {

			this.getProgressBar().setString("DEW");

		} else {
			this.getProgressBar().setString("");

		}





		if (this.getProgressBar_1().getValue() == 100) {

			this.getProgressBar_1().setString("CRITICAL TEMPERATURE");

		} else {
			this.getProgressBar_1().setString("");

		}


		this.repaint();

	}

	public void build() {
		// TODO Auto-generated method stub

	}






	public void alertCondensaiton(int n ) {
		this.getProgressBar().setValue(n);
	}

	public void alertTempMax(int n ) {
		this.getProgressBar_1().setValue(n);
	}






	/* (non-Javadoc)
	 * @see vue.IView#getModel()
	 */
	public IModel getModel() {
		return model;
	}

	/* (non-Javadoc)
	 * @see vue.IView#setModel(interfaces.IModel)
	 */
	public void setModel(IModel model) {
		this.model = model;
	}

	/* (non-Javadoc)
	 * @see vue.IView#getTextField()
	 */
	public JTextField getTextField() {
		return textField;
	}

	/* (non-Javadoc)
	 * @see vue.IView#setTextField(javax.swing.JTextField)
	 */
	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	/* (non-Javadoc)
	 * @see vue.IView#getTextField_1()
	 */
	public JTextField getTextField_1() {
		return textField_1;
	}

	/* (non-Javadoc)
	 * @see vue.IView#setTextField_1(javax.swing.JTextField)
	 */
	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	/* (non-Javadoc)
	 * @see vue.IView#getjSpinner1()
	 */
	public JSpinner getjSpinner1() {
		return jSpinner1;
	}

	/* (non-Javadoc)
	 * @see vue.IView#setjSpinner1(javax.swing.JSpinner)
	 */
	public void setjSpinner1(JSpinner jSpinner1) {
		this.jSpinner1 = jSpinner1;
	}

	/* (non-Javadoc)
	 * @see vue.IView#getjSpinner2()
	 */
	public JSpinner getjSpinner2() {
		return jSpinner2;
	}

	/* (non-Javadoc)
	 * @see vue.IView#setjSpinner2(javax.swing.JSpinner)
	 */
	public void setjSpinner2(JSpinner jSpinner2) {
		this.jSpinner2 = jSpinner2;
	}

	/* (non-Javadoc)
	 * @see vue.IView#getLblNewLabel_1()
	 */
	public JLabel getLblNewLabel_1() {
		return lblNewLabel_1;
	}

	/* (non-Javadoc)
	 * @see vue.IView#setLblNewLabel_1(javax.swing.JLabel)
	 */
	public void setLblNewLabel_1(JLabel lblNewLabel_1) {
		this.lblNewLabel_1 = lblNewLabel_1;
	}

	/* (non-Javadoc)
	 * @see vue.IView#getLblNewLabel()
	 */
	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	/* (non-Javadoc)
	 * @see vue.IView#setLblNewLabel(javax.swing.JLabel)
	 */
	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}

	public JLabel getLblNewLabel_2() {
		return lblNewLabel_2;
	}

	public void setLblNewLabel_2(JLabel lblNewLabel_2) {
		this.lblNewLabel_2 = lblNewLabel_2;
	}

	public JLabel getLblNewLabel_3() {
		return lblNewLabel_3;
	}

	public void setLblNewLabel_3(JLabel lblNewLabel_3) {
		this.lblNewLabel_3 = lblNewLabel_3;
	}

	/* (non-Javadoc)
	 * @see vue.IView#getProgressBar()
	 */
	public JProgressBar getProgressBar() {
		return progressBar;
	}

	/* (non-Javadoc)
	 * @see vue.IView#setProgressBar(javax.swing.JProgressBar)
	 */
	public void setProgressBar(JProgressBar progressBar) {
		this.progressBar = progressBar;
	}

	/* (non-Javadoc)
	 * @see vue.IView#getProgressBar_1()
	 */
	public JProgressBar getProgressBar_1() {
		return progressBar_1;
	}

	/* (non-Javadoc)
	 * @see vue.IView#setProgressBar_1(javax.swing.JProgressBar)
	 */
	public void setProgressBar_1(JProgressBar progressBar_1) {
		this.progressBar_1 = progressBar_1;
	}



	/* (non-Javadoc)
	 * @see vue.IView#getTempMax()
	 */
	public int getTempMax() {
		return tempMax;
	}

	/* (non-Javadoc)
	 * @see vue.IView#setTempMax(int)
	 */
	public void setTempMax(int tempMax) {
		this.tempMax = (Integer) jSpinner2.getValue();
	}

	/* (non-Javadoc)
	 * @see vue.IView#getTemp()
	 */
	public int getTemp() {
		return temp;
	}

	/* (non-Javadoc)
	 * @see vue.IView#setTemp(int)
	 */
	public void setTemp(int temp) {
		this.temp =  (Integer) jSpinner1.getValue();;
	}

	/**
	 * @return the panel_tab1
	 */
	public Observer getPanel_tab1() {
		return panel_tab1;
	}

	/**
	 * @param panel_tab1 the panel_tab1 to set
	 */
	public void setPanel_tab1(Observer panel_tab1) {
		this.panel_tab1 = panel_tab1;
	}




	public Observer getPanel_tab2() {
		// TODO Auto-generated method stub
		return this.frame.getPanel_tab1();
	}

}
