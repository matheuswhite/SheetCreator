package br.ufal.ic.sheetCreator.factory;

import java.util.List;

import br.ufal.ic.sheetCreator.decorator.Decorator;
import br.ufal.ic.sheetCreator.decorator.Flag;
import br.ufal.ic.sheetCreator.decorator.IComponent;
import br.ufal.ic.sheetCreator.decorator.QuarterNote;

public class QuarterNoteFactory extends Factory {

	@Override
	public Decorator createDecoratorItem(IComponent comp, int pos_x, int pos_y,
			List<Flag> flag) {
		return new QuarterNote(comp, pos_x, pos_y, flag);
	}

}
