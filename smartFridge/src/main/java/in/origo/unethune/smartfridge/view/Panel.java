/**
 * 
 */
package in.origo.unethune.smartfridge.view;

import java.awt.Graphics;
import java.io.IOException;

import javax.swing.JPanel;

import in.origo.unethune.smartfridge.interfaces.IModel;
import in.origo.unethune.smartfridge.interfaces.IView;



/**
 * @author ivann 	VVV CESI Toulouse 29 nov. 2018 
 *
 */
public class Panel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IView frame;
	
	private IModel model;
	
	
	/**
	 * 
	 */
	public Panel(IView frame, IModel model) {
		this.frame = frame;
		this.model = model;
	}
	
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		
		
		
		
		final Thread thread = new Thread(new Runnable() {

			public void run() {
				try {
					Thread.sleep(500);
					repaint();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		thread.start();
	}

}