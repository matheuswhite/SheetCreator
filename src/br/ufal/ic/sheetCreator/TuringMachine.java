package br.ufal.ic.sheetCreator;

import java.util.ArrayList;

import br.ufal.ic.sheetCreator.decorator.Flag;

public class TuringMachine{
	
	private ArrayList<Flag> fita;
	private ArrayList<Flag> states;
	private int indexFita;
	private int indexStates;
	
	public TuringMachine() {
		this.fita = new ArrayList<Flag>();
		this.fita.add(Flag.FIM_DE_FITA);
		
		this.states = new ArrayList<Flag>();
		this.fillStates();
		
		this.indexFita = 0;
		this.indexStates = 0;
	}
	
	private void fillStates() {
		this.states.add(Flag.STATE_0);
		this.states.add(Flag.STATE_1);
		this.states.add(Flag.STATE_2);
		this.states.add(Flag.STATE_3);
		this.states.add(Flag.STATE_4);
	}
	
	private boolean programState0() {
		if(this.fita.get(indexFita).equals(Flag.WHOLE_NOTE)) {
			this.fita.remove(indexFita);
			this.fita.add(indexFita, Flag.FORWARD);
			
			this.indexStates++;
			
			this.drawCompass();
		}
		else if(this.fita.get(indexFita).equals(Flag.HALF_NOTE)) {
			this.indexFita++;
			
			this.indexStates += 2;
		}
		else if(this.fita.get(indexFita).equals(Flag.QUARTER_NOTE)) {
			this.fita.remove(indexFita);
			this.fita.add(indexFita, Flag.EMPTY);
			
			this.indexFita++;
			
			this.indexStates += 3;
		}
		else if(this.fita.get(indexFita).equals(Flag.EIGHTH_NOTE)) {
			this.fita.remove(indexFita);
			this.fita.add(indexFita, Flag.EMPTY);
			
			this.indexFita++;
			
			this.indexStates += 4;
		}
		else if(this.fita.get(indexFita).equals(Flag.FORWARD)) {
			this.indexFita++;
		}
		else if(this.fita.get(indexFita).equals(Flag.EMPTY)) {
			this.fita.remove(indexFita);
			this.fita.add(indexFita, Flag.FORWARD);
			
			this.indexFita--;
		}
		else {
			return false;
		}
		
		return true;
	}
	
	private boolean programState1() {
		if(this.fita.get(indexFita).equals(Flag.FORWARD)) {
			this.indexStates++;
			
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean programState2() {
		if(this.fita.get(indexFita).equals(Flag.HALF_NOTE)) {
			this.fita.remove(indexFita);
			this.fita.add(indexFita, Flag.WHOLE_NOTE);
			
			this.indexFita++;
			
			this.indexStates = 0;
		}
		else if(this.fita.get(indexFita).equals(Flag.QUARTER_NOTE)) {
			this.fita.remove(indexFita);
			this.fita.add(indexFita, Flag.EMPTY);
			
			this.indexFita++;
			
			this.indexStates += 3;
		}
		else if(this.fita.get(indexFita).equals(Flag.EIGHTH_NOTE)) {
			this.fita.remove(indexFita);
			this.fita.add(indexFita, Flag.EMPTY);
			
			this.indexFita++;
			
			this.indexStates += 4;
		}
		else if(this.fita.get(indexFita).equals(Flag.FORWARD)) {
			this.indexFita++;
		}
		else {
			return false;
		}
		return true;
	}
	
	private boolean programState3() {
		if(this.fita.get(indexFita).equals(Flag.QUARTER_NOTE)) {
			this.fita.remove(indexFita);
			this.fita.add(indexFita, Flag.HALF_NOTE);
			
			this.indexFita--;
			
			this.indexStates = 0;
		}
		else if(this.fita.get(indexFita).equals(Flag.EIGHTH_NOTE)) {
			this.fita.remove(indexFita);
			this.fita.add(indexFita, Flag.EMPTY);
			
			this.indexFita++;
			
			this.indexStates += 4;
		}
		else {
			return false;
		}
		return true;
	}
	
	private boolean programState4() {
		if(this.fita.get(indexFita).equals(Flag.EIGHTH_NOTE)) {
			this.fita.remove(indexFita);
			this.fita.add(indexFita, Flag.QUARTER_NOTE);
			
			this.indexFita--;
			
			this.indexStates = 0;
		}
		else {
			return false;
		}
		return true;
	}
	
	public boolean programFunction() {
		
		boolean exit = true;
		
		while(! this.fita.get(indexFita).equals(Flag.FIM_DE_FITA)) {
			if(this.states.get(indexStates).equals(Flag.STATE_0)) {
				exit = this.programState0();	
			}
			else if(this.states.get(indexStates).equals(Flag.STATE_1)) {
				exit = this.programState1();
			}
			else if(this.states.get(indexStates).equals(Flag.STATE_2)) {
				exit = this.programState2();
			}
			else if(this.states.get(indexStates).equals(Flag.STATE_3)) {
				exit = this.programState3();
			}
			else if(this.states.get(indexStates).equals(Flag.STATE_4)) {
				exit = this.programState4();
			}
			else {
				exit = false;
			}
			if(!exit) {
				return exit;
			}
		}
		
		return exit;
	}
	
	public boolean addInput(Flag Note) {
		boolean exit = true;
		
		this.states.remove(Flag.FIM_DE_FITA);
		this.states.add(Note);
		this.states.add(Flag.FIM_DE_FITA);
		
		exit = this.programFunction();
		
		return exit;
	}
	
	public void drawCompass() {
		
	}
}
