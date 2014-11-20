package br.ufal.ic.sheetCreator.decorator;

import java.util.Hashtable;
import java.util.List;

public class HalfNote extends Notes {

	public HalfNote(IComponent component, int position_x, int position_y,
			List<Flag> flag) {
		super(component, position_x, position_y, flag);
	}

	@Override
	protected void fillOrdemTable() {
		
		this.ordem = new Hashtable<Flag, Integer>();
		
		int initval = 130;
		int initvaly = 18;
		
		ordem.put(Flag.PRIMEIRA, initval);
		ordem.put(Flag.SEGUNDA, initval + 60);
		ordem.put(Flag.TERCEIRA, initval + 120);
		ordem.put(Flag.QUARTA, initval + 180);
		ordem.put(Flag.QUINTA, initval + 240);
		ordem.put(Flag.SEXTA, initval + 300);
		ordem.put(Flag.SETIMA, initval + 360);
		ordem.put(Flag.OITAVA, initval + 420);
		
		ordem.put(Flag.C, initvaly);
		ordem.put(Flag.D, initvaly - 3);
		ordem.put(Flag.E, initvaly - 12);
		ordem.put(Flag.F, initvaly - 18);
		ordem.put(Flag.G, initvaly - 25);
		ordem.put(Flag.A, initvaly - 30);
		ordem.put(Flag.B, initvaly - 37);
		
	}
	
	@Override
	public int getWidth() {
		return 50;
	}

	@Override
	public int getHeight() {
		return 60;
	}

	@Override
	public String getPathImage() {
		String exit = "resource/halfnote500.svg.png";
		if(this.flags.get(Notes.TONE_POSITION).equals(Flag.C)) {
			exit = "resource/halfnote500_do.svg.png";
		}
		
		if(this.flags.get(Notes.ACCIDENTAL_SYMBOL).equals(Flag.SHARP)){
			exit = "resource/halfnote500-sharp.png";
			if(this.flags.get(Notes.TONE_POSITION).equals(Flag.C)) {
				exit = "resource/halfnote500_do_sharp.png";
			}
		}
		else if(this.flags.get(Notes.ACCIDENTAL_SYMBOL).equals(Flag.FLAT)) {
			exit = "resource/halfnote500_flat.png";
			if(this.flags.get(Notes.TONE_POSITION).equals(Flag.C)) {
				exit = "resource/halfnote500_do_flat.png";
			}
		}
		return exit;
	}

	@Override
	public int getPosisionCX() {
		return this.ordem.get(this.flags.get(Notes.CURSOR_POSITION));
	}

	@Override
	public int getPositionCY() {
		return this.ordem.get(this.flags.get(Notes.TONE_POSITION));
	}
}
