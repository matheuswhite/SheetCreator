package br.ufal.ic.sheetCreator.decorator;

import java.util.ArrayList;
import java.util.List;

public class Compass extends Decorator{

	public Compass(IComponent component, int position_x, int position_y, List<Flag> flag) {
		super(component, position_x, position_y, flag);
	}

	@Override
	public int getWidth() {
		return 0;
	}

	@Override
	public int getHeight() {
		return 0;
	}

	@Override
	protected void draw() {
		
	}
}
