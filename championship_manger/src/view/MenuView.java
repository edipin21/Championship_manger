package view;

import java.util.Vector;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import javafx.stage.Stage;
import listeners.TournamentViewEventsListener;
import model.DuplicateParticipanteExcepiton;
import model.InvalidResultExcepiton;

public class MenuView implements AbstractTournamentView {
	private Vector<TournamentViewEventsListener> allListeners = new Vector<TournamentViewEventsListener>();
	int typeOfGame;
	String Winner;
	Vector<TextField> ParticipantTfSecendV = new Vector<TextField>();
	Vector<Button> playGameBt = new Vector<Button>();
	Vector<TextField> ScoreTf = new Vector<TextField>();
	HBox hbRootWinnerWindow = new HBox();

	public final static String mainStyle = "Style.css";

	public void registerListener(TournamentViewEventsListener listener) {
		allListeners.add(listener);

	}

	public MenuView(Stage primaryStage) {
		Label lbParticipantName = new Label();
		lbParticipantName.setText("Participant name :");
		lbParticipantName.setTextFill(Color.WHITESMOKE);
		TextField tfParticipantName = new TextField();
		Button btAddParticipant = new Button();
		btAddParticipant.setText("Add participant");
		btAddParticipant.setDefaultButton(true);

		Button btStartChamp = new Button();
		btStartChamp.setText("Start championship");
		btStartChamp.setDisable(true);
		HBox hbRootAddParticipant = new HBox();
		hbRootAddParticipant.setSpacing(25);
		hbRootAddParticipant.getChildren().addAll(lbParticipantName, tfParticipantName, btAddParticipant, btStartChamp);
		hbRootAddParticipant.setAlignment(Pos.CENTER);

		HBox hbRootAddParBT = new HBox();
		hbRootAddParBT.setSpacing(25);
		hbRootAddParBT.getChildren().addAll(btAddParticipant, btStartChamp);
		hbRootAddParBT.setAlignment(Pos.CENTER);

		VBox vbRootAddpar = new VBox();
		vbRootAddpar.getChildren().addAll(hbRootAddParticipant, hbRootAddParBT);
		vbRootAddpar.setAlignment(Pos.CENTER);
		vbRootAddpar.setSpacing(20);

		VBox vbRootParticipantList = new VBox();
		vbRootParticipantList.setAlignment(Pos.CENTER_LEFT);
		vbRootParticipantList.setSpacing(20);

		Vector<TextField> ParticipantTf = new Vector<TextField>();
		for (int i = 0; i < 8; i++) {
			TextField tfParticipantNamei = new TextField();
			vbRootParticipantList.getChildren().addAll(tfParticipantNamei);
			tfParticipantNamei.setEditable(false);
			ParticipantTf.add(tfParticipantNamei);
		}

		ToggleGroup tgTypeOfChamp = new ToggleGroup();
		RadioButton rdTennis = new RadioButton("Tennis");
		RadioButton rdBasketball = new RadioButton("Basketball");
		RadioButton rdSoccer = new RadioButton("Soccer");
		rdTennis.setToggleGroup(tgTypeOfChamp);
		rdBasketball.setToggleGroup(tgTypeOfChamp);
		rdSoccer.setToggleGroup(tgTypeOfChamp);
		rdTennis.setTextFill(Color.WHITESMOKE);
		rdSoccer.setTextFill(Color.WHITESMOKE);
		rdBasketball.setTextFill(Color.WHITESMOKE);
		VBox vbRootTypeOfChamp = new VBox();
		vbRootTypeOfChamp.setSpacing(5);
		vbRootTypeOfChamp.setAlignment(Pos.CENTER_RIGHT);
		vbRootTypeOfChamp.getChildren().addAll(rdTennis, rdBasketball, rdSoccer);
		// #####################################################################################
		VBox VbRootQfinalParticipant = new VBox();
		VbRootQfinalParticipant.setSpacing(10);
		VbRootQfinalParticipant.setAlignment(Pos.CENTER);

		ParticipantTfSecendV = new Vector<TextField>();
		for (int i = 0; i < 16; i++) {
			TextField tfParticipantQFineali = new TextField();
			tfParticipantQFineali.setEditable(false);
			ParticipantTfSecendV.add(tfParticipantQFineali);
		}
		for (int i = 0; i < 8; i++) {
			VbRootQfinalParticipant.getChildren().addAll(ParticipantTfSecendV.get(i));
		}

		playGameBt = new Vector<Button>();
		for (int i = 0; i < 7; i++) {
			Button btplayGamei = new Button();
			btplayGamei.setText("play game");
			playGameBt.add(btplayGamei);
		}
		for (int i = 4; i < playGameBt.size(); i++) {
			playGameBt.get(i).setDisable(true);
		}
		VBox vbRootQFinalPlayBt = new VBox();
		vbRootQFinalPlayBt.setSpacing(60);
		vbRootQFinalPlayBt.setAlignment(Pos.CENTER);
		for (int i = 0; i < 4; i++) {
			vbRootQFinalPlayBt.getChildren().addAll(playGameBt.get(i));
		}

		VBox VbRootSfinalParticipant = new VBox();
		VbRootSfinalParticipant.setSpacing(45);
		VbRootSfinalParticipant.setAlignment(Pos.CENTER);
		for (int i = 8; i < 12; i++) {
			VbRootSfinalParticipant.getChildren().addAll(ParticipantTfSecendV.get(i));
		}

		VBox vbRootSFinalPlayBt = new VBox();
		vbRootSFinalPlayBt.setSpacing(110);
		vbRootSFinalPlayBt.setAlignment(Pos.CENTER);
		playGameBt.get(4).setDisable(true);
		playGameBt.get(5).setDisable(true);
		vbRootSFinalPlayBt.getChildren().addAll(playGameBt.get(4), playGameBt.get(5));

		VBox VbRootfinalParticipant = new VBox();
		VbRootfinalParticipant.setSpacing(110);
		VbRootfinalParticipant.setAlignment(Pos.CENTER);
		VbRootfinalParticipant.getChildren().addAll(ParticipantTfSecendV.get(13), ParticipantTfSecendV.get(14));

		VBox vbRootFinalPlayBt = new VBox();
		vbRootFinalPlayBt.setAlignment(Pos.CENTER);
		playGameBt.get(6).setDisable(true);
		vbRootFinalPlayBt.getChildren().addAll(playGameBt.get(6));

		VBox vbRootWinnerParticipan = new VBox();
		vbRootWinnerParticipan.setAlignment(Pos.CENTER);
		vbRootWinnerParticipan.getChildren().addAll(ParticipantTfSecendV.get(15));

		HBox hbRootPlayGameView = new HBox();
		hbRootPlayGameView.setSpacing(30);
		hbRootPlayGameView.getChildren().addAll(VbRootQfinalParticipant, vbRootQFinalPlayBt, VbRootSfinalParticipant,
				vbRootSFinalPlayBt, VbRootfinalParticipant, vbRootFinalPlayBt, vbRootWinnerParticipan);
		btAddParticipant.getStylesheets().add(mainStyle);
		btStartChamp.getStylesheets().add(mainStyle);
		primaryStage.setTitle("");
		HBox hbMain = new HBox();
		hbMain.getChildren().addAll(vbRootParticipantList, vbRootAddpar, vbRootTypeOfChamp);
		hbMain.setSpacing(30);
		StackPane stMain = new StackPane();
		stMain.getChildren().addAll(hbMain);
		Scene mainWindow = new Scene(stMain, 1100, 700);
		mainWindow.getStylesheets().add((mainStyle));
		primaryStage.setScene(mainWindow);
		primaryStage.show();

		// ####################################################################################################################
		btAddParticipant.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (tgTypeOfChamp.getSelectedToggle() == null) {
					allListeners.get(0).showMessage("Please choose the type of game before adding a participant");
					return;
				}

				if (tgTypeOfChamp.getSelectedToggle() == rdSoccer) {
					typeOfGame = 1;
				}
				if (tgTypeOfChamp.getSelectedToggle() == rdBasketball) {
					typeOfGame = 2;
				}
				if (tgTypeOfChamp.getSelectedToggle() == rdTennis) {
					typeOfGame = 3;
				}
				try {
					allListeners.get(0).addParticipantFromview(tfParticipantName.getText());
					for (int i = 0; i < ParticipantTf.size(); i++) {
						if (ParticipantTf.get(i).getText().equalsIgnoreCase("")) {
							ParticipantTf.get(i).setText(allListeners.get(0).getParticipantFromModel(i));
							break;
						}

					}
				} catch (DuplicateParticipanteExcepiton e) {

					allListeners.get(0).showMessage(e.getMessage());
				}

				if (allListeners.get(0).allParticipantAdd() && typeOfGame != 0) {
					btAddParticipant.setDisable(true);
					btStartChamp.setDisable(false);

				}

			}

		});
		// #################################################################################################################
		btStartChamp.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Scene gameScene = new Scene(hbRootPlayGameView, 1800, 700);
				gameScene.getStylesheets().add(mainStyle);
				primaryStage.setScene(gameScene);

				primaryStage.show();

				for (int i = 0; i < ParticipantTf.size(); i++) {
					ParticipantTfSecendV.get(i).setText(allListeners.get(0).getParticipantFromModel(i));
				}

			}
		});

		for (int i = 0; i < playGameBt.size(); i++) {
			int index = i;
			playGameBt.get(i).setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {

					if (index == 0) {

						ScoreWindow(typeOfGame, allListeners.get(0).getParticipantFromModel(0),
								allListeners.get(0).getParticipantFromModel(1), index, primaryStage);

					}
					if (index == 1) {
						ScoreWindow(typeOfGame, allListeners.get(0).getParticipantFromModel(2),
								allListeners.get(0).getParticipantFromModel(3), index, primaryStage);
					}
					if (index == 2) {
						ScoreWindow(typeOfGame, allListeners.get(0).getParticipantFromModel(4),
								allListeners.get(0).getParticipantFromModel(5), index, primaryStage);
					}
					if (index == 3) {
						ScoreWindow(typeOfGame, allListeners.get(0).getParticipantFromModel(6),
								allListeners.get(0).getParticipantFromModel(7), index, primaryStage);
					}
					if (index == 4) {
						ScoreWindow(typeOfGame, allListeners.get(0).getWinner(0), allListeners.get(0).getWinner(1),
								index + 1, primaryStage);

					}

					if (index == 5) {
						ScoreWindow(typeOfGame, allListeners.get(0).getWinner(2), allListeners.get(0).getWinner(3),
								index + 1, primaryStage);

					}
					if (index == 6) {
						ScoreWindow(typeOfGame, allListeners.get(0).getWinner(4), allListeners.get(0).getWinner(3),
								index + 1, primaryStage);
						playGameBt.get(6).setDisable(true);

					}
				}
			});
		}

	}

	@Override
	public void showMessage(String msg) {
		Label lbDuplicateParticipanteExcepiton = new Label();
	 lbDuplicateParticipanteExcepiton.setTextFill(Color.DARKGRAY);
		lbDuplicateParticipanteExcepiton.setText(msg);
		HBox hbRootDuplicateParticipanteExcepiton = new HBox();
		hbRootDuplicateParticipanteExcepiton.setAlignment(Pos.CENTER);
		hbRootDuplicateParticipanteExcepiton.getChildren().addAll(lbDuplicateParticipanteExcepiton);
		Scene seconderyScene = new Scene(hbRootDuplicateParticipanteExcepiton, 700, 200);
		seconderyScene.getStylesheets().add(mainStyle);
		Stage newWindow = new Stage();
		newWindow.setScene(seconderyScene);
		newWindow.show();

	}

	public void ScoreWindow(int TypeOFGame, String PlayerOneName, String PlayerTwoName, int index, Stage primaryStage) {
		HBox hbRootTypeOfGame = new HBox();
		hbRootTypeOfGame.setAlignment(Pos.TOP_CENTER);
		Label lbTypeOfGame = new Label();
		lbTypeOfGame.setTextFill(Color.WHITESMOKE);
		hbRootTypeOfGame.getChildren().addAll(lbTypeOfGame);
		HBox hbRootPlayerOneScore = new HBox();
		hbRootPlayerOneScore.setSpacing(20);
		HBox hbRootPlayerTwoScore = new HBox();
		hbRootPlayerTwoScore.setSpacing(20);
		HBox hbRootdDoneBt = new HBox();

		VBox vbRootTotalScore = new VBox();
		vbRootTotalScore.setSpacing(10);
		vbRootTotalScore.setAlignment(Pos.CENTER);
		ScoreTf = new Vector<TextField>();
		for (int i = 0; i < 10; i++) {
			TextField tfScorei = new TextField();
			ScoreTf.add(tfScorei);
			tfScorei.setPrefSize(40, 10);
		}
		Button BtDone = new Button("done");
		Label lbPlayerOneName = new Label();
		lbPlayerOneName.setTextFill(Color.WHITESMOKE);
		lbPlayerOneName.setText(PlayerOneName);
		Label lbPlayerTwoName = new Label();
		lbPlayerTwoName.setTextFill(Color.WHITESMOKE);
		lbPlayerTwoName.setText(PlayerTwoName);

		if (typeOfGame == 1) {
			lbTypeOfGame.setText("Soccer championship");
			hbRootPlayerOneScore.getChildren().addAll(lbPlayerOneName, ScoreTf.get(0), ScoreTf.get(1), ScoreTf.get(2),
					ScoreTf.get(3));

			hbRootPlayerTwoScore.getChildren().addAll(lbPlayerTwoName, ScoreTf.get(4), ScoreTf.get(5), ScoreTf.get(6),
					ScoreTf.get(7));

			hbRootdDoneBt.getChildren().addAll(BtDone);
			vbRootTotalScore.getChildren().addAll(hbRootTypeOfGame, hbRootPlayerOneScore, hbRootPlayerTwoScore,
					hbRootdDoneBt);
			int[] playerOneScore = new int[4];
			int[] playerTwoScore = new int[4];
			vbRootTotalScore.setSpacing(20);
			Scene scoreScene = new Scene(vbRootTotalScore, 500, 250);
			scoreScene.getStylesheets().add(mainStyle);
			Stage newWindow = new Stage();
			newWindow.setScene(scoreScene);
			newWindow.show();

			BtDone.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					StartNextRound();

					for (int i = 0; i < 4; i++) {

						if (ScoreTf.get(i).getText().isEmpty() && !ScoreTf.get(i + 4).getText().isEmpty()
								|| !ScoreTf.get(i).getText().isEmpty() && ScoreTf.get(i + 4).getText().isEmpty()) {
							allListeners.get(0)
									.showMessage("invalid score,plase enter a valid score for both participants");
							return;
						}
					}

					for (int i = 0; i < playerOneScore.length; i++) {
						if (!ScoreTf.get(i).getText().isEmpty()) {
							playerOneScore[i] = Integer.parseInt(ScoreTf.get(i).getText());
						} else
							playerOneScore[i] = -1;
					}
					for (int i = 4; i < 8; i++) {
						if (!ScoreTf.get(i).getText().isEmpty()) {
							playerTwoScore[i - 4] = Integer.parseInt(ScoreTf.get(i).getText());
						} else
							playerTwoScore[i - 4] = -1;
					}

					try {

						ParticipantTfSecendV.get(index + 8).setText(allListeners.get(0).PlayGame(PlayerOneName,
								PlayerTwoName, playerOneScore, playerTwoScore, typeOfGame));
						winnerWindow(primaryStage);

						newWindow.close();

					} catch (InvalidResultExcepiton e) {
						// TODO Auto-generated catch block
						allListeners.get(0).showMessage(e.getMessage());
					}

				}
			});

		}

		if (TypeOFGame == 2) {
			lbTypeOfGame.setText("basketball championship");
			hbRootPlayerOneScore.getChildren().addAll(lbPlayerOneName, ScoreTf.get(0), ScoreTf.get(1), ScoreTf.get(2),
					ScoreTf.get(3));
			hbRootPlayerTwoScore.getChildren().addAll(lbPlayerTwoName, ScoreTf.get(4), ScoreTf.get(5), ScoreTf.get(6),
					ScoreTf.get(7));
			hbRootdDoneBt.getChildren().addAll(BtDone);
			vbRootTotalScore.getChildren().addAll(hbRootTypeOfGame, hbRootPlayerOneScore, hbRootPlayerTwoScore,
					hbRootdDoneBt);
			int[] playerOneScoreB = new int[4];
			int[] playerTwoScoreB = new int[4];

			Scene scoreSceneBaketball = new Scene(vbRootTotalScore, 400, 200);
			scoreSceneBaketball.getStylesheets().add(mainStyle);
			Stage newWindowBasketballScore = new Stage();
			newWindowBasketballScore.setScene(scoreSceneBaketball);

			newWindowBasketballScore.show();
			BtDone.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					StartNextRound();

					for (int i = 0; i < 4; i++) {
						if (ScoreTf.get(i).getText().isEmpty() && !ScoreTf.get(i + 4).getText().isEmpty()
								|| !ScoreTf.get(i).getText().isEmpty() && ScoreTf.get(i + 4).getText().isEmpty()) {
							allListeners.get(0)
									.showMessage("invalid score,plase enter a valid score for both participants");
							return;
						}
					}
					for (int i = 0; i < playerOneScoreB.length; i++) {
						if (!ScoreTf.get(i).getText().isEmpty()) {
							playerOneScoreB[i] = Integer.parseInt(ScoreTf.get(i).getText());
						} else
							playerOneScoreB[i] = -1;
					}
					for (int i = 4; i < 8; i++) {
						if (!ScoreTf.get(i).getText().isEmpty()) {
							playerTwoScoreB[i - 4] = Integer.parseInt(ScoreTf.get(i).getText());
						} else
							playerTwoScoreB[i - 4] = -1;
					}
					try {

						ParticipantTfSecendV.get(index + 8).setText(allListeners.get(0).PlayGame(PlayerOneName,
								PlayerTwoName, playerOneScoreB, playerTwoScoreB, typeOfGame));
						newWindowBasketballScore.close();
						winnerWindow(primaryStage);
					} catch (InvalidResultExcepiton e) {
						// TODO Auto-generated catch block
						allListeners.get(0).showMessage(e.getMessage());
					}

				}

			});

		}
		if (TypeOFGame == 3) {
			lbTypeOfGame.setText("Tenis championship");
			hbRootPlayerOneScore.getChildren().addAll(lbPlayerOneName, ScoreTf.get(0), ScoreTf.get(1), ScoreTf.get(2),
					ScoreTf.get(3), ScoreTf.get(4));
			hbRootPlayerTwoScore.getChildren().addAll(lbPlayerTwoName, ScoreTf.get(5), ScoreTf.get(6), ScoreTf.get(7),
					ScoreTf.get(8), ScoreTf.get(9));
			hbRootdDoneBt.getChildren().addAll(BtDone);
			vbRootTotalScore.getChildren().addAll(hbRootTypeOfGame, hbRootPlayerOneScore, hbRootPlayerTwoScore,
					hbRootdDoneBt);
			int[] playerOneScoreT = new int[5];
			int[] playerTwoScoreT = new int[5];

			Scene scoreSceneTenis = new Scene(vbRootTotalScore, 400, 200);
			scoreSceneTenis.getStylesheets().add(mainStyle);
			Stage newWindowTenislScore = new Stage();
			newWindowTenislScore.setScene(scoreSceneTenis);
			newWindowTenislScore.show();
			BtDone.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					StartNextRound();
					for (int i = 0; i < 5; i++) {
						if (ScoreTf.get(i).getText().isEmpty() && !ScoreTf.get(i + 5).getText().isEmpty()
								|| !ScoreTf.get(i).getText().isEmpty() && ScoreTf.get(i + 5).getText().isEmpty()) {
							allListeners.get(0)
									.showMessage("invalid score,plase enter a valid score for both participants");
							return;
						}

					}
					for (int i = 0; i < 5; i++) {
						if (!ScoreTf.get(i).getText().isEmpty()) {
							playerOneScoreT[i] = Integer.parseInt(ScoreTf.get(i).getText());
						} else
							playerOneScoreT[i] = -1;
					}
					for (int i = 5; i < 10; i++) {
						if (!ScoreTf.get(i).getText().isEmpty()) {
							playerTwoScoreT[i - 5] = Integer.parseInt(ScoreTf.get(i).getText());
						} else
							playerTwoScoreT[i - 5] = -1;
					}

					try {

						ParticipantTfSecendV.get(index + 8).setText(allListeners.get(0).PlayGame(PlayerOneName,
								PlayerTwoName, playerOneScoreT, playerTwoScoreT, typeOfGame));
						newWindowTenislScore.close();
						winnerWindow(primaryStage);
					} catch (InvalidResultExcepiton e) {
						// TODO Auto-generated catch block
						allListeners.get(0).showMessage(e.getMessage());
					}

				}
			});

		}
	}

	public void StartNextRound() {
		int count = 0;

		for (int j = 8; j < 16; j++) {
			if (!ParticipantTfSecendV.get(j).getText().isEmpty()&&!ParticipantTfSecendV.get(j).getText().equalsIgnoreCase("")){
				count++;
			}
		}

		if (count == 5) {
			playGameBt.get(4).setDisable(true);
			playGameBt.get(5).setDisable(true);
			playGameBt.get(6).setDisable(false);

		}

		if (count == 3) {
			for (int i = 0; i < 4; i++) {
				playGameBt.get(i).setDisable(true);

			}

			playGameBt.get(4).setDisable(false);
			playGameBt.get(5).setDisable(false);
		}

	}
	public void winnerWindow(Stage primaryStage) {
		if (!ParticipantTfSecendV.get(15).getText().isEmpty()) {

			primaryStage.close();
			allListeners.get(0).showMessage("the winner is : " + allListeners.get(0).getWinner(6));
		}
	}
}
