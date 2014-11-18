package br.ufal.ic.sheetCreator.factory;

import java.util.List;

import br.ufal.ic.sheetCreator.decorator.Decorator;
import br.ufal.ic.sheetCreator.decorator.Flag;
import br.ufal.ic.sheetCreator.decorator.HalfNote;
import br.ufal.ic.sheetCreator.decorator.IComponent;

public class HalfNoteFactory extends Factory {

	@Override
	public Decorator createDecoratorItem(IComponent comp, int pos_x, int pos_y,
			List<Flag> flag) {
		return new HalfNote(comp, pos_x, pos_y, flag);
	}

}
