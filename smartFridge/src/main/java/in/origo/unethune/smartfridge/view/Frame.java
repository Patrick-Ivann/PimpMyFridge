package in.origo.unethune.smartfridge.view;

import java.awt.CardLayout;

import javax.swing.JFrame;

import in.origo.unethune.smartfridge.interfaces.IModel;
import in.origo.unethune.smartfridge.interfaces.IView;

public class Frame extends JFrame implements IView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Panel panel;
	
	/**
	 * 
	 */
	public Frame(IModel model) {
		this.panel = new Panel(this, model);
		// TODO Auto-generated constructor stub
	}

	
	public void build() {
		this.setTitle("fridgeInterface");
		this.setSize(532,412);
		this.setLocationRelativeTo(null); //Put the window in the center of the screen
		this.setResizable(false); //to forbid the user to resize the window
		CardLayout layout = new CardLayout();
		this.setLayout(layout);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Close the app when the user click the red cross
		this.setContentPane(this.panel);
		this.setVisible(true);
	
	}

}
