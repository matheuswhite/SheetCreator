package br.ufal.ic.sheetCreator;

import br.ufal.ic.sheetCreator.decorator.*;

public class StaffState {
	private final int maxNotePerStaff = 8;
	private int noteInStaff;
	
	private final int maxStaffPerDoc = 4;
	private int currentStaff;
	
	private Flag currentState;
	private boolean block;
	
	public StaffState(MusicalStaff staff){
		this.noteInStaff = 0;
		this.currentStaff = 1;
		this.currentState = Flag.NO_FULL;
	}
	
	private boolean isFullStaff() {
		if(this.noteInStaff >= this.maxNotePerStaff) {
			return true;
		}
		
		return false;
	}
	
	private boolean isFullDoc() {
		if(this.currentStaff > this.maxStaffPerDoc) {
			return true;
		}
		
		return false;
	}
	
	private void setCurrentState() {
		if(this.isFullDoc()) {
			this.currentState = Flag.FULL_DOC;
		}
		if(this.isFullStaff()) {
			this.currentState = Flag.FULL_STAFF;
		}
	}
	
	public void zeroState(Flag flag) {
		if(flag.equals(Flag.FULL_STAFF)) {
			this.currentStaff++;
			this.noteInStaff = 0;
		}
		if(flag.equals(Flag.FULL_DOC)) {
			this.currentStaff = 0;
			this.block = true;
		}
	}
	
	public Flag incrementState(Flag typeNote) {
		Flag exit = Flag.NO_FULL;
		this.setCurrentState();
		this.zeroState(currentState);
		
		if(this.currentState.equals(Flag.FULL_DOC)) {
			exit = Flag.NOT_CREATED;
		}
		else if(this.currentState.equals(Flag.FULL_STAFF)) {
			exit = Flag.CHANGE_STAFF;
		}
		else {
			this.noteInStaff++;
		}
		
		return exit;
	}
	
	public Flag getCurrentState() {
		return this.currentState;
	}
	
	public int getCurrentStaff() {
		return this.currentStaff;
	}
	
	public int getNoteInStaff() {
		return this.noteInStaff;
	}
}
