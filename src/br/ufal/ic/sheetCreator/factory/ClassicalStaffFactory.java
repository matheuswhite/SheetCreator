package br.ufal.ic.sheetCreator.factory;

import java.util.ArrayList;

import br.ufal.ic.sheetCreator.decorator.*;

public class ClassicalStaffFactory extends StaffFactory {

	@Override
	public MusicalStaff createMusicalStaff(Flag ordemFlag) {
		Factory clef = new TrebleClefFactory();
		MusicalStaff classicalStaff = new MusicalStaff(ordemFlag);
		
		ArrayList<Flag> flags = new ArrayList<Flag>();
		flags.add(Flag.CLASSICAL_TREBLE_CLEF);
		
		classicalStaff.add(clef.createDecoratorItem(classicalStaff, classicalStaff.getMyPosition(), 
				flags));
		
		return classicalStaff;
	}

}
