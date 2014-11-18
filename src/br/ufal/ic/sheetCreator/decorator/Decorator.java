package br.ufal.ic.sheetCreator.decorator;

import java.util.List;

public abstract class Decorator extends IComponent {

	private IComponent component;
	protected List<Flag> flags;
	
	public Decorator(IComponent component, int position_x, int position_y, List<Flag> flags) {
		this.component = component;
		this.position_x = position_x;
		this.position_y = position_y;
		this.flags = flags;
		this.draw();
	}
}
