package br.ufal.ic.sheetCreator.decorator;

import java.util.ArrayList;

import javax.swing.JComponent;

public class TrebleClef extends Clefs{
	
	private final int width = 0;
	private final int height = 0;
	private final int position_x = 0;
	private final int position_y = 0;
	
	public TrebleClef(IComponent component, int[] position, ArrayList<Flag> flag) {
		super(component, position, flag);
		this.pathImage = "";
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
