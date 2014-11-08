package br.ufal.ic.sheetCreator.objects;

import javax.swing.JComponent;

public class TrebleClef extends Clefs{
	
	private int width = 0;
	private int height = 0;
	private int position_x = 0;
	private int position_y = 0;
	
	public TrebleClef(IComponent component, int[] position) {
		super(component, position);
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
