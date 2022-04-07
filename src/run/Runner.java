package run;
import controller.Controller;
import view.MainWindow;

public class Runner {

	
	public static void main(String[] args) {
		Controller controller = Controller.get();
		controller.setView(new MainWindow());
		controller.play();
	}
}
