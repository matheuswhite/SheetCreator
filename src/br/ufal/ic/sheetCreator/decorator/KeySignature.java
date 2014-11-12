package br.ufal.ic.sheetCreator.decorator;

import java.util.ArrayList;
import java.util.List;

public class KeySignature extends Decorator{

	public KeySignature(IComponent component, int position_x, int position_y,
			List<Flag> flags) {
		super(component, position_x, position_y, flags);
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
