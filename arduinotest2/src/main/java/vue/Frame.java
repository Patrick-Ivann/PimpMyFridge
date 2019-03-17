package vue;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Observer;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import interfaces.IModel;
import interfaces.IView;


public class Frame extends JFrame implements IView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Panel_Tab2 panel_tab2;
	private Panel_Body panel_body;
	private Panel_tab1 panel_tab1;


	private JTabbedPane tabbedPanel;
	
	/**
	 * 
	 */
	public Frame(IModel model) {
		//this.panel = new Panel(this, model);		
		
		this.tabbedPanel = new JTabbedPane(JTabbedPane.TOP);		
		this.panel_body = new Panel_Body(this,tabbedPanel, model);
		this.panel_tab1 = new Panel_tab1(this,tabbedPanel, model);
		
		double[] d = { 0, 10.0,
				230.0,  85.0,
	            200.0,  400.0,
	            1.0,  45 };
		
		ArrayList<Double> dr = new ArrayList<Double>();
		
		dr.add((double) 0);		
		dr.add((double) 15.5);
		dr.add((double) 10.7);

		dr.add((double) 22.5);
		dr.add((double) 33.5);
		dr.add((double) 22.7);		
		dr.add((double) 23.7);
		dr.add((double) 27.7);
		dr.add((double) 22.7);

		dr.add((double) 50);

		
		for (int i = 0; i < 19; i++) {
			
			Random rand = new Random();
			
			dr.add((double)rand.nextInt(20 - 5 + 1) + 5);
			
		}
		
		
		//this.panel_tab2 = new Panel_Tab2(this,tabbedPanel, model);
		this.panel_tab2 = new Panel_Tab2(model, dr);


		// TODO Auto-generated constructor stub
	}

	
	public void build() {
		this.setTitle("fridgeInterface" );
		this.setSize(667,667);
		this.setLocationRelativeTo(null); 
		this.setResizable(false); 
		this.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE); //Close the app when the user click the red cross
		
		this.setBounds(100, 100, 450, 300);
		
		this.getContentPane().add(panel_body, BorderLayout.CENTER);
		tabbedPanel.addTab("Summary", null, panel_tab1, null);

	
		
		tabbedPanel.addTab("Graph", null, panel_tab2, null);

		panel_body.add(tabbedPanel);
		this.add(panel_body);
		this.setContentPane(this.getContentPane());
		this.setVisible(true);
	
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public String getValeurModele() {
		// TODO Auto-generated method stub
		return null;
	}


	public void setValeurModele(String arg) {
		// TODO Auto-generated method stub
		
	}


	public IModel getModel() {
		// TODO Auto-generated method stub
		return null;
	}


	public void setModel(IModel model) {
		// TODO Auto-generated method stub
		
	}


	public JTextField getTextField() {
		// TODO Auto-generated method stub
		return null;
	}


	public void setTextField(JTextField textField) {
		// TODO Auto-generated method stub
		
	}


	public JTextField getTextField_1() {
		// TODO Auto-generated method stub
		return null;
	}


	public void setTextField_1(JTextField textField_1) {
		// TODO Auto-generated method stub
		
	}


	public JSpinner getjSpinner1() {
		
		return this.panel_tab1.getjSpinner1();
	}


	public void setjSpinner1(JSpinner jSpinner1) {
		// TODO Auto-generated method stub
		
	}


	public JSpinner getjSpinner2() {
		return this.panel_tab1.getjSpinner2();

	}


	public void setjSpinner2(JSpinner jSpinner2) {
		// TODO Auto-generated method stub
		
	}


	public JLabel getLblNewLabel_1() {
		// TODO Auto-generated method stub
		return null;
	}


	public void setLblNewLabel_1(JLabel lblNewLabel_1) {
		// TODO Auto-generated method stub
		
	}


	public JLabel getLblNewLabel() {
		// TODO Auto-generated method stub
		return null;
	}


	public void setLblNewLabel(JLabel lblNewLabel) {
		// TODO Auto-generated method stub
		
	}


	public JProgressBar getProgressBar() {
		// TODO Auto-generated method stub
		return null;
	}


	public void setProgressBar(JProgressBar progressBar) {
		// TODO Auto-generated method stub
		
	}


	public JProgressBar getProgressBar_1() {
		// TODO Auto-generated method stub
		return null;
	}


	public void setProgressBar_1(JProgressBar progressBar_1) {
		// TODO Auto-generated method stub
		
	}


	public int getTempMax() {
		// TODO Auto-generated method stub
		return 0;
	}


	public void setTempMax(int tempMax) {
		// TODO Auto-generated method stub
		
	}


	public int getTemp() {
		// TODO Auto-generated method stub
		return 0;
	}


	public void setTemp(int temp) {
		// TODO Auto-generated method stub
		
	}


	public Observer getPanel_tab1() {
		
		return this.panel_tab1.getPanel_tab1();
	}

	
public Observer getPanel_tab2() {
		
		return this.panel_tab2.getPanelTab2();
	}
}
