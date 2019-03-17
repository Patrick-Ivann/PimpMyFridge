/**
 * 
 */
package vue;

import java.awt.Graphics;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import interfaces.IModel;
import interfaces.IView;

/**
 * @author ivann 	VVV CESI Toulouse 1 déc. 2018 
 *
 */
public class Panel_Body extends JPanel{
	
	
	private IView frame;
	private IModel model;
	private JTabbedPane tabbedPanel;

	public Panel_Body(IView frame, JTabbedPane tabbedPanel, IModel model) {
		this.frame = frame;
		this.model = model;
		this.tabbedPanel = tabbedPanel;
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
	}

}
