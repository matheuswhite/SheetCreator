package br.ufal.ic.sheetCreator.decorator;

import java.util.ArrayList;

public class WholeNote extends Notes{

	private final int width = 20;
	private final int height = 40;
	
	public WholeNote(IComponent component, int[] position, ArrayList<Flag> ordemFlag) {
		super(component, position, ordemFlag);
		this.pathImage = "resource/wholenote.svg.png";
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
