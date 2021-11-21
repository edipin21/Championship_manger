package view;

import listeners.TournamentViewEventsListener;


public abstract interface AbstractTournamentView {
	void registerListener(TournamentViewEventsListener listener);

	void showMessage(String msg);
}
