/**
 * 
 */
package in.origo.unethune.smartfridge.main;

import in.origo.unethune.smartfridge.controller.Controller;
import in.origo.unethune.smartfridge.interfaces.IController;
import in.origo.unethune.smartfridge.interfaces.IModel;
import in.origo.unethune.smartfridge.interfaces.IView;
import in.origo.unethune.smartfridge.model.Model;
import in.origo.unethune.smartfridge.view.Frame;

/**
 * @author ivann
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			IModel model = new Model();
			IView view = new Frame(model);
			IController controller = new Controller(view);
			controller.start();
		}

	

}
