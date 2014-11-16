package br.ufal.ic.sheetCreator.decorator;


import java.util.List;

public class TrebleClef extends Clefs{
	
	public TrebleClef(IComponent component, int position_x, int position_y, List<Flag> flag) {
		super(component, position_x, position_y,flag);
	}
	
	@Override
	public int getWidth() {
		return 100;
	}

	@Override
	public int getHeight() {
		return 100;
	}

	@Override
	public String getPathImage() {
		return "resource/G-Clef.svg.png";
	}

	@Override
	public int getPosisionCX() {
		return -13;
	}

	@Override
	public int getPositionCY() {
		return -25;
	}
}
