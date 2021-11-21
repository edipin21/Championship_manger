package listeners;




import model.DuplicateParticipanteExcepiton;
import model.InvalidResultExcepiton;

public interface TournamentViewEventsListener {

	void showMessage(String msg);

	void addParticipantFromview(String name) throws DuplicateParticipanteExcepiton;

	String getParticipantFromModel(int i);

	boolean allParticipantAdd();

	String PlayGame(String playerOneName, String playerTwoName, int[] playerOneScore, int[] playerTwoScore,
			int typeOfGame) throws InvalidResultExcepiton;

	String getWinner(int index);

	

}
