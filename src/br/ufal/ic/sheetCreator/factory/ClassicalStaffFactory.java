package br.ufal.ic.sheetCreator.factory;

import java.util.ArrayList;

import br.ufal.ic.sheetCreator.decorator.*;

public class ClassicalStaffFactory extends StaffFactory {

	@Override
	public MusicalStaff createMusicalStaff(Flag ordemFlag) {
		Factory clef = new TrebleClefFactory();
		Factory keySignature = new NaturalKeySignatureFactory();
		Factory compass = new ClassicalCompassFactory();
		
		MusicalStaff classicalStaff = new MusicalStaff(ordemFlag);
		
		ArrayList<Flag> flags = new ArrayList<Flag>();
		flags.add(Flag.CLASSICAL_TREBLE_CLEF);
		
		classicalStaff.setClef(clef.createDecoratorItem(classicalStaff, classicalStaff.getMyPositionX(), classicalStaff.getMyPositionY(), flags));
		classicalStaff.setCompass(compass.createDecoratorItem(classicalStaff, classicalStaff.getMyPositionX(), classicalStaff.getMyPositionY(), flags));
		
		return classicalStaff;
	}

}
