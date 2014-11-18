package br.ufal.ic.sheetCreator.decorator;

import java.util.List;

public class WholeNote extends Notes{
	
	public WholeNote(IComponent component, int position_x, int position_y, List<Flag> flag) {
		super(component, position_x, position_y, flag);
	}

	@Override
	public int getWidth() {
		return 60;
	}

	@Override
	public int getHeight() {
		return 30;
	}

	@Override
	public String getPathImage() {
		return "resource/wholenote500.svg.png";
	}

	@Override
	public int getPosisionCX() {
		if(flags.get(0).equals(Flag.WHOLE_NOTE)) {
			System.out.println("130");
		}
		if(flags.get(1).equals(Flag.PRIMEIRA)) {
			System.out.println("131");
		}
		if(flags.get(2).equals(Flag.C)) {
			System.out.println("132");
		}
		if(flags.get(3).equals(Flag.NATURAL_SIGN)) {
			System.out.println("133");
		}
		
		if(this.ordem.get(this.flags.get(1)) == Integer.valueOf(50)) {
			System.out.println("100x");
		}
		
		return this.ordem.get(this.flags.get(Notes.CURSOR_POSITION));
	}

	@Override
	public int getPositionCY() {
		return this.ordem.get(this.flags.get(Notes.TONE_POSITION));
	}

}
