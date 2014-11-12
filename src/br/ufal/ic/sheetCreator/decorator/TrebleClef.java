package br.ufal.ic.sheetCreator.decorator;

import java.util.ArrayList;

import javax.swing.JComponent;

public class TrebleClef extends Clefs{
	
	private final int width = 20;
	private final int height = 50;
	private final int position_x = 20;
	private final int position_y = 40;
	
	public TrebleClef(IComponent component, int[] position, ArrayList<Flag> flag) {
		super(component, position, flag);
		this.pathImage = "resource/trebleclef.png";
	}

	@Override
	public int getWidth() {
		return this.width;
	}

	@Override
	public int getHeight() {
		return this.height;
	}

	@Override
	public int getPosition_X(){
		return this.position_x;
	}

	@Override
	public int getPosition_Y() {
		return this.position_y;
	}
}
