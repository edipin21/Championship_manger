package model;

public class DuplicateParticipanteExcepiton extends Exception {
	public DuplicateParticipanteExcepiton() {
		super("The participante allrady in the turnament");
	}
}
