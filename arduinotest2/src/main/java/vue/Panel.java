/**
 * 
 */
package vue;

import java.awt.Button;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import interfaces.IModel;
import interfaces.IView;




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
		
//		JTabbedPane tabbedPane = new JTabbedPane();
//
//		JComponent panel1 = (JComponent) makeTextPanel("Panel #1");
//		tabbedPane.addTab("Tab 1", null, panel1,
//		                  "Does nothing");
//		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
//
//		JComponent panel2 = (JComponent) makeTextPanel("Panel #2");
//		tabbedPane.addTab("Tab 2", null, panel2,
//		                  "Does twice as much nothing");
//		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
//
//		JComponent panel3 = (JComponent) makeTextPanel("Panel #3dscsdhdskdshghdsg	 bnnnnnnnnnnb ");
//		tabbedPane.addTab("Tab 3", null, panel3,
//		                  "Still does nothing");
//		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
//
//		JComponent panel4 = (JComponent) makeTextPanel(
//		        "Panel #4 (has a preferred size of 410 x 50).");
//		panel4.setPreferredSize(new Dimension(410, 50));
//		tabbedPane.addTab("Tab 4", null, panel4,
//		                      "Does nothing at all");
//		tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
//		
//		
//        add(tabbedPane);
        
        System.out.println("si n repaint le panel");

		
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
	
	protected Component makeTextPanel(String text) {
	    JPanel panel = new JPanel(false);
	    JLabel filler = new JLabel(text);
	    filler.setHorizontalAlignment(JLabel.CENTER);
	    panel.setLayout(new GridLayout(1, 1));
	    panel.add(filler);
	    return panel;
	}

}