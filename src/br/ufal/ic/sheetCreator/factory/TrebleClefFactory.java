package br.ufal.ic.sheetCreator.factory;

import java.util.ArrayList;

import br.ufal.ic.sheetCreator.decorator.*;

public class TrebleClefFactory extends Factory{

	@Override
	public Decorator createDecoratorItem(IComponent comp, int[] pos, ArrayList<Flag> flag) {
		return new TrebleClef(comp, pos, flag);
	}

}
