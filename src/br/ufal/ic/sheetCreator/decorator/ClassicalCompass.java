package br.ufal.ic.sheetCreator.decorator;

import java.util.List;

public class ClassicalCompass extends Compass{

	public ClassicalCompass(IComponent component, int position_x,
			int position_y, List<Flag> flag) {
		super(component, position_x, position_y, flag);
	}
	
	@Override
	public int getWidth() {
		return 40;
	}

	@Override
	public int getHeight() {
		return 80;
	}

	@Override
	public String getPathImage() {
		return "resource/commontime.svg.png";
	}

	@Override
	public int getPosisionCX() {
		return 75;
	}

	@Override
	public int getPositionCY() {
		return 8;
	}
}
