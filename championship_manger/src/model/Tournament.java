package model;

import java.util.Vector;




import listeners.tournamentEventsListener;

public class Tournament {
	public enum eTypesOfsport {
		soceer, basketball, tennis
	};

	private Vector<tournamentEventsListener> listeners;
	private eTypesOfsport eType;
	private Vector<String> Participant;
	private Vector<String> winners = new Vector<String>();

	public Tournament(eTypesOfsport eType) {
		this.eType = eType;
		this.Participant = new Vector<String>();
		listeners = new Vector<tournamentEventsListener>();
	}

	public Tournament() {
		this.Participant = new Vector<String>();
		listeners = new Vector<tournamentEventsListener>();

	}

	public String playGame(String plyerOneName, String plyerTwoName, int[] pleyrtOneScore, int[] pleyrtTwoScore,
			int typeOfSport) throws InvalidResultExcepiton {

		if (typeOfSport == 1) {
			this.eType = eTypesOfsport.soceer;
			return playSoceer(plyerOneName, plyerTwoName, pleyrtOneScore, pleyrtTwoScore);

		}

		else if (typeOfSport == 2) {
			this.eType = eTypesOfsport.basketball;
			return playBasketball(plyerOneName, plyerTwoName, pleyrtOneScore, pleyrtTwoScore);

		} else if (typeOfSport == 3) {
			this.eType = eTypesOfsport.tennis;
			return playTennis(plyerOneName, plyerTwoName, pleyrtOneScore, pleyrtTwoScore);

		}

		return null;
	}

	public String playSoceer(String plyerOneName, String plyerTwoName, int[] pleyrtOneScore, int[] pleyrtTwoScore)
			throws InvalidResultExcepiton {
		int totalScoreP1 = 0;
		int totalScoreP2 = 0;
		if(pleyrtOneScore[0]==-1||pleyrtOneScore[1]==-1||pleyrtTwoScore[0]==-1||pleyrtTwoScore[1]==-1) {
			throw new InvalidResultExcepiton();
		}
		totalScoreP1 = pleyrtOneScore[0] + pleyrtOneScore[1];
		totalScoreP2 = pleyrtTwoScore[0] + pleyrtTwoScore[1];
		
		if (totalScoreP1 == totalScoreP2) {
			totalScoreP1 = pleyrtOneScore[2];
			totalScoreP2 = pleyrtTwoScore[2];

			if (totalScoreP1 == totalScoreP2) {
				totalScoreP1 = pleyrtOneScore[3];
				totalScoreP2 = pleyrtTwoScore[3];

				if (totalScoreP1 == totalScoreP2) {
					throw new InvalidResultExcepiton();

				}
			}
		} else if (totalScoreP1 > totalScoreP2) {
			if (pleyrtOneScore[2] != -1 || pleyrtOneScore[3] != -1 || pleyrtTwoScore[2] != -1 || pleyrtTwoScore[3] != -1) {
				throw new InvalidResultExcepiton();
			}
			winners.add(plyerOneName);
			return plyerOneName;

		} else if (totalScoreP1 < totalScoreP2) {
			if (pleyrtOneScore[2] != -1 || pleyrtOneScore[3] != -1 || pleyrtTwoScore[2] != -1 || pleyrtTwoScore[3] != -1) {
				throw new InvalidResultExcepiton();
			}

		}
		winners.add(plyerTwoName);
		return plyerTwoName;
	}

	public String playBasketball(String plyerOneName, String plyerTwoName, int[] pleyrtOneScore, int[] pleyrtTwoScore)
			throws InvalidResultExcepiton {

		int TotalScoreP1 = 0;
		int TotalScoreP2 = 0;
		for (int i = 0; i < 4; i++) {
			if (pleyrtOneScore[i] == -1 || pleyrtTwoScore[i] == -1) {
				throw new InvalidResultExcepiton();
			}
			TotalScoreP1 = TotalScoreP1 + pleyrtOneScore[i];
			TotalScoreP2 = TotalScoreP2 + pleyrtTwoScore[i];

		}

		if (TotalScoreP1 == TotalScoreP2) {
			throw new InvalidResultExcepiton();
		}

		if (TotalScoreP1 > TotalScoreP2) {
			winners.add(plyerOneName);
			return plyerOneName;
		}
		winners.add(plyerTwoName);
		return plyerTwoName;

	}

	public String playTennis(String plyerOneName, String plyerTwoName, int[] pleyrtOneScore, int[] pleyrtTwoScore)
			throws InvalidResultExcepiton {
		int TotalScoreP1 = 0;
		int TotalScoreP2 = 0;
		for (int i = 0; i < 3; i++) {
			if (pleyrtOneScore[i] == pleyrtTwoScore[i] || pleyrtOneScore[i] != -1 && pleyrtTwoScore[i] == -1||pleyrtOneScore[i] == -1 && pleyrtTwoScore[i]!=-1) {
				throw new InvalidResultExcepiton();
			}
		}
		
		for (int i = 0; i < 3; i++) {
			if (pleyrtOneScore[i] > pleyrtTwoScore[i]) {
				TotalScoreP1 = TotalScoreP1 + 1;
			} else if (pleyrtOneScore[i] < pleyrtTwoScore[i]) {
				TotalScoreP2 = TotalScoreP2 + 1;
			}

		}
		
		if (TotalScoreP1 - 2 > TotalScoreP2) {
			if (pleyrtOneScore[3] != -1 || pleyrtOneScore[3] != -1||pleyrtOneScore[4] != -1 || pleyrtOneScore[4] != -1) {
				throw new InvalidResultExcepiton();
			}
			winners.add(plyerOneName);
			return plyerOneName;
		} else if (TotalScoreP2 - 2 > TotalScoreP1) {
			if (pleyrtOneScore[3] != -1 || pleyrtOneScore[3] != -1||pleyrtOneScore[4] != -1 || pleyrtOneScore[4] != -1) {
				throw new InvalidResultExcepiton();
			}
			winners.add(plyerTwoName);
			return plyerTwoName;
		} else if (pleyrtOneScore[3] > pleyrtTwoScore[3]) {
			TotalScoreP1 = TotalScoreP1 + 1;
		} else if (pleyrtTwoScore[3] > pleyrtOneScore[3]) {
			TotalScoreP2 = TotalScoreP2 + 1;

		}
		if (TotalScoreP1 - 2 > TotalScoreP2) {
			winners.add(plyerOneName);
			return plyerOneName;
		} else if (TotalScoreP2 - 2 > TotalScoreP1) {
			winners.add(plyerTwoName);
			return plyerTwoName;
		} else if (pleyrtOneScore[4] > pleyrtTwoScore[4]) {
			return plyerOneName;
		} else if (pleyrtTwoScore[4] > pleyrtOneScore[4]) {
			return plyerTwoName;
		}
		else {throw new InvalidResultExcepiton();}

	}

	public void addParticipant(String name) throws DuplicateParticipanteExcepiton {
		if (Participant.contains(name)) {
			throw new DuplicateParticipanteExcepiton();
		}

		else
			Participant.add(name);

	}

	public void registerListener(tournamentEventsListener listener) {
		listeners.add(listener);
	}

	public String getParticipant(int index) {
		if (index > Participant.size()) {
			return null;
		}

		else
			return Participant.get(index);
	}

	public boolean allParticipantAdd() {
		if (Participant.size() == 8) {
			return true;
		} else
			return false;
	}

	public String getWinner(int index) {

		return winners.get(index);
	}

}