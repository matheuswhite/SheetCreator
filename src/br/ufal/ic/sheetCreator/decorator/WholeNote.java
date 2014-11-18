package br.ufal.ic.sheetCreator.decorator;

import java.util.Hashtable;
import java.util.List;

public class WholeNote extends Notes{
	
	public WholeNote(IComponent component, int position_x, int position_y, List<Flag> flag) {
		super(component, position_x, position_y, flag);
	}

	@Override
	public int getWidth() {
		return 20;
	}

	@Override
	public int getHeight() {
		return 40;
	}

	@Override
	protected void fillOrdemTable(Hashtable<Flag, Integer> table) {
		table.put(Flag.PRIMEIRA, 50);
		table.put(Flag.SEGUNDA, 60);
		table.put(Flag.TERCEIRA, 70);
		table.put(Flag.QUARTA, 80);
		table.put(Flag.QUINTA, 90);
		table.put(Flag.SEXTA, 100);
		table.put(Flag.SETIMA, 110);
		table.put(Flag.OITAVA, 120);
		
		table.put(Flag.C, 20);
		table.put(Flag.D, 40);
		table.put(Flag.E, 60);
		table.put(Flag.F, 80);
		table.put(Flag.G, 100);
		table.put(Flag.A, 120);
		table.put(Flag.B, 140);
	}

	@Override
	public String getPathImage() {
		return "resource/wholenote500.svg.png";
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
