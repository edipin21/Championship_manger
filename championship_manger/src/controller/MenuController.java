package controller;



import listeners.TournamentViewEventsListener;
import listeners.tournamentEventsListener;
import model.DuplicateParticipanteExcepiton;
import model.InvalidResultExcepiton;
import model.Tournament;
import view.AbstractTournamentView;

public class MenuController  implements tournamentEventsListener,TournamentViewEventsListener {
	
	private Tournament theModel;
	private AbstractTournamentView theView;
	
	public MenuController( Tournament model,AbstractTournamentView view) {
		this.theModel=model;
		this.theView=view;
		model.registerListener(this);
		view.registerListener(this);
	}

	
	

	

	@Override
	public void showMessage(String msg) {
		theView.showMessage(msg);
		
	}

	



	@Override
	public void addParticipantFromview(String name) throws DuplicateParticipanteExcepiton {
		theModel.addParticipant(name);
		
	}




	@Override
	public String getParticipantFromModel(int index) {
		
		return theModel.getParticipant(index);
	}






	@Override
	public boolean allParticipantAdd() {
		
		return theModel.allParticipantAdd();
	}






	@Override
	public String PlayGame(String playerOneName, String playerTwoName, int[] playerOneScore, int[] playerTwoScore,
			int typeOfGame) throws  InvalidResultExcepiton {
		return theModel.playGame(playerOneName, playerTwoName, playerOneScore, playerTwoScore, typeOfGame);
		
	}






	@Override
	public String getWinner(int index) {
		
		return theModel.getWinner(index);
	}










	
	




}
