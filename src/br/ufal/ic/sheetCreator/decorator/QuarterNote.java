package br.ufal.ic.sheetCreator.decorator;

import java.util.Hashtable;
import java.util.List;

public class QuarterNote extends Notes{

	public QuarterNote(IComponent component, int position_x, int position_y,
			List<Flag> flag) {
		super(component, position_x, position_y, flag);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void fillOrdemTable(Hashtable<Flag, Integer> table) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void drawAccidentalSymbol() {
		// TODO Auto-generated method stub
		
	}

}
