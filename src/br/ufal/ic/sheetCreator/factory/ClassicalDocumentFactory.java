package br.ufal.ic.sheetCreator.factory;

import java.util.ArrayList;

import br.ufal.ic.sheetCreator.ClassicalDocument;
import br.ufal.ic.sheetCreator.Document;
import br.ufal.ic.sheetCreator.decorator.Flag;
import br.ufal.ic.sheetCreator.decorator.MusicalStaff;

public class ClassicalDocumentFactory extends DocumentFactory{

	@Override
	public Document createDocument(String name, String author, int[] docPos) {
		ArrayList<MusicalStaff> staffs = new ArrayList<MusicalStaff>();
		StaffFactory factory = new ClassicalStaffFactory();
		
		staffs.add(factory.createMusicalStaff(docPos, Flag.PRIMEIRA));
		staffs.add(factory.createMusicalStaff(docPos, Flag.SEGUNDA));
		staffs.add(factory.createMusicalStaff(docPos, Flag.TERCEIRA));
		staffs.add(factory.createMusicalStaff(docPos, Flag.QUARTA));
		
		return new ClassicalDocument(name, author, staffs);
	}

}
