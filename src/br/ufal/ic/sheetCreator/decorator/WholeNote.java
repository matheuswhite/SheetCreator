package br.ufal.ic.sheetCreator.decorator;

import java.util.ArrayList;

public class WholeNote extends Notes{

	private final int width = 0;
	private final int height = 0;
	
	public WholeNote(IComponent component, int[] position, ArrayList<Flag> ordemFlag) {
		super(component, position, ordemFlag);
	}

	@Override
	public int getWidth() {
		return this.width;
	}

	@Override
	public int getHeight() {
		return this.height;
	}

}
