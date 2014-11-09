package br.ufal.ic.sheetCreator.decorator;

import java.util.ArrayList;

public abstract class Decorator extends IComponent {

	private IComponent component;
	protected ArrayList<Flag> flags;
	
	public Decorator(IComponent component, int[] position, ArrayList<Flag> flags) {
		this.component = component;
		this.position = position;
		this.flags = flags;
		this.draw();
	}
	
	public abstract int getWidth();
	public abstract int getHeight();
}
