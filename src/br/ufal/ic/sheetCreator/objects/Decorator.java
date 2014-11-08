package br.ufal.ic.sheetCreator.objects;


public abstract class Decorator extends IComponent {

	private IComponent component;
	private int[] position;
	
	public Decorator(IComponent component, int[] position) {
		this.component = component;
		this.position = position;
		this.draw();
	}
	
	protected int[] getPosition() {
		return this.position;
	}
	
	public abstract int getWidth();
	public abstract int getHeight();
}
