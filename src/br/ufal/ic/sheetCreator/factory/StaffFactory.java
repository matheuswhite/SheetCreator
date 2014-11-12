package br.ufal.ic.sheetCreator.factory;

import br.ufal.ic.sheetCreator.decorator.*;

public abstract class StaffFactory {
	
	public abstract MusicalStaff createMusicalStaff(Flag ordemFlag);

}
