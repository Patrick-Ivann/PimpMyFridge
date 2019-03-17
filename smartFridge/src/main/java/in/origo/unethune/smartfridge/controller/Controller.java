/**
 * 
 */
package in.origo.unethune.smartfridge.controller;

import in.origo.unethune.smartfridge.interfaces.IController;
import in.origo.unethune.smartfridge.interfaces.IView;

/**
 * @author ivann
 *
 */
public class Controller implements IController {

	private IView view;

	public Controller(IView view) {
		// TODO Auto-generated constructor stub
		
			this.view = view;
		
	}

	public void start() {
		this.view.build();
	}

}
