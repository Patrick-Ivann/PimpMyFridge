/**
 * 
 */
package controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import interfaces.IController;
import interfaces.IModel;
import interfaces.IView;

/**
 * @author ivann
 *
 */
public class Controller implements IController, ActionListener, ChangeListener {

	private IView view;
	private IModel model;
	private Observable modelObser;
	
	public Controller(IView view, IModel model) {
		// TODO Auto-generated constructor stub
		
			this.view = view;	
			this.model = model;
			
			this.startListeners();
			this.startNotify();
			
		
			
			
		
	}
	
	private void startListeners() {

		this.view.getjSpinner1().addChangeListener(this);
	
		
	}
	
	private void startNotify() {
		this.modelObser = (Observable) this.model;
		this.modelObser.addObserver(this.view.getPanel_tab1());
		this.modelObser.addObserver(this.view.getPanel_tab2());
		
	}

	
	public void start() {
		this.view.build();
	}

	public void actionPerformed(ActionEvent e) {

		
	}

	public void stateChanged(ChangeEvent e) {

		if (e.getSource() ==  this.view.getjSpinner1()) {
			
					this.model.setTempRequest((Integer) this.view.getjSpinner1().getValue());

					

		}
		
		

	}

}
