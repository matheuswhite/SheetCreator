package br.ufal.ic.sheetCreator.decorator;

import java.util.ArrayList;

public abstract class Decorator extends IComponent {

	private IComponent component;
	protected ArrayList<Flag> flags;
	
	public Decorator(IComponent component, int position_x, int position_y, ArrayList<Flag> flags) {
		this.component = component;
		this.position_x = position_x;
		this.position_y = position_y;
		this.flags = flags;
		this.draw();
	}
	
	public abstract int getWidth();
	public abstract int getHeight();
}
