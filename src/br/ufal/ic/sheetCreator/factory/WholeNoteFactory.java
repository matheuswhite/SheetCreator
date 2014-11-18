package br.ufal.ic.sheetCreator.factory;

import java.util.List;

import br.ufal.ic.sheetCreator.decorator.*;

public class WholeNoteFactory extends Factory{

	@Override
	public Decorator createDecoratorItem(IComponent comp, int pos_x, int pos_y, List<Flag> flag) {
		if(flag.get(0).equals(Flag.WHOLE_NOTE)) {
			System.out.println("118");
		}
		if(flag.get(1).equals(Flag.PRIMEIRA)) {
			System.out.println("119");
		}
		if(flag.get(2).equals(Flag.C)) {
			System.out.println("120");
		}
		if(flag.get(3).equals(Flag.NATURAL_SIGN)) {
			System.out.println("121");
		}
		
		return new WholeNote(comp, pos_x, pos_y, flag);
	}

}
