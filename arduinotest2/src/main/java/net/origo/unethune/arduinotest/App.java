	package net.origo.unethune.arduinotest;

import controlleur.Controller;
import interfaces.IController;
import interfaces.IModel;
import interfaces.IView;
import modele.Model;
import vue.Frame;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "KILLER FROST2" );
    	IModel model = new Model();
		IView view = new Frame(model);
		IController controller = new Controller(view, model);
		controller.start();
		
    }
}
