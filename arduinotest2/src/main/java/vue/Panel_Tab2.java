/**
 * 
 */
package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import interfaces.IModel;

/**
 * @author ivann 	VVV CESI Toulouse 1 déc. 2018 
 *
 */
@SuppressWarnings("serial")
public class Panel_Tab2 extends JPanel implements Observer {

	
	
	private String xlabel;
    private String ylabel;
	
	 
	
	
	 private Double[] data;
     private int points;
     private int[] XData;
     private double Ymax;
     private Double[] YData;
     Double[] dataArray;
     private IModel model;
	private Observer panelTab2;
	private double Ymin;
	
     public Panel_Tab2(IModel model, ArrayList<Double> dr) {
    	 
    	 super();
    	 this.setBackground(Color.black);

    	 this.model = model;
    	 this.panelTab2 = this;
    	 
    	 
    	  //dataArray = this.model.getTempList().toArray(new Double[this.model.getTempList().size()]);
    	 dataArray = dr.toArray(new Double[dr.size()]);
    	 data = dataArray;

    	 points = data.length;
    	 YData = new Double[points];
    	 XData = new int[points];
    	 for (int i = 0; i < points; i++) {
    		 
    	 
			YData[i] = data[i];
			XData[i] = ((i*100)*4/(points));
			
			//System.out.println(YData[i] + "gjbfrgk");
			//System.out.println(XData[i]);

		}
     }
     
     public Observer getPanelTab2() {
		return panelTab2;
	}

	public void setPanelTab2(Observer panelTab2) {
		this.panelTab2 = panelTab2;
	}

	public Double[] getDataArray() {
		return dataArray;
	}

	public void setDataArray(Double[] dataArray) {
		this.dataArray = dataArray;
	}

	public void paint(Graphics g) {
         Graphics2D g2 = (Graphics2D) g;

         
         xlabel = ("Progress");
         ylabel = ("Temperature");

         
         
         
         for(int i = 0; i < points - 1; i++) {
        	 
             int x0 = (int) (XData[i] + 0.5);
             int x1 = (int) (XData[i + 1] + 0.5);
             int y0 = (int) (200-YData[i] +0.5);
             int y1 = (int) (200-YData[i + 1] + 0.5);
             
            
             Ymax = YData[0];
             Ymin = YData[0];
              
            
                     if (YData[i] > Ymax) {
                     Ymax = YData[i];
                     }
                     if (YData[i] < Ymin) {
                     Ymin = YData[i];
                     }
                      
             
         
             
             
             g2.drawLine(x0, y0, x1, y1);
             
//             if (i == 0) {
//            	     g2.drawString(("premier  " + x0 + ", " + y0), x0, y0);
//
//             }
//             if (i == points - 2) {
//            	 
//            	     g2.drawString(("dernier" + x1 + ", " + y1), x1, y1);
//
//             }else if ( i == points -1) {
//				
			 
            if (i%3 ==0) {
            	
                g2.drawString((""+y1), x0, y0-20);
				
			}else {
                g2.drawString((""), x0, y0-20);

			}
            
            Font f2 = new Font("TimesRoman", Font.BOLD, 14);
            g.setFont(f2);
            g.drawString(xlabel, (XData[XData.length-1] - 40), (int) (220-YData[0]));
            g.drawString(ylabel, (XData[0]), (int) (YData[0]+22));
            
            
			

			//}
             
         }
     }

	public void update(Observable o, Object arg) {

		this.setDataArray(this.model.getTempList().toArray(new Double[this.model.getTempList().size()]));
	}
	
	
	
	
	
	
	
	
}
