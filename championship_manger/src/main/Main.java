package main;
//eddie abramov-307947655


import controller.MenuController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Tournament;
import view.AbstractTournamentView;
import view.MenuView;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		AbstractTournamentView menuView = new MenuView(primaryStage);
		Tournament theModel = new Tournament();
		MenuController menuController = new MenuController(theModel, menuView);

	}

}
