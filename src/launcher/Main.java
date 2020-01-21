package launcher;

import java.awt.EventQueue;

import businesslogic.MyServiceApplication;
import businesslogic.ServiceApplicationInterface;
import view.Controller;
import view.MainView;

public class Main {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServiceApplicationInterface serviceApp = new MyServiceApplication();
					Controller control = new Controller(serviceApp);
					@SuppressWarnings("unused")
					MainView view = new MainView(control);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
