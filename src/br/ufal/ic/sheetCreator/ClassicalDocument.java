package br.ufal.ic.sheetCreator;

import java.util.ArrayList;

import br.ufal.ic.sheetCreator.decorator.MusicalStaff;

public class ClassicalDocument extends Document {

	public ClassicalDocument(String title, String author, ArrayList<MusicalStaff> staffs) {
		super(title, author, staffs);
	}

	@Override
	public void setStaffs(ArrayList<MusicalStaff> staffs) {
		this.add(staffs.get(0).getLabel());
		this.add(staffs.get(1).getLabel());
		this.add(staffs.get(2).getLabel());
		this.add(staffs.get(3).getLabel());
	}
}
