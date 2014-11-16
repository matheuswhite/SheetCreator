package br.ufal.ic.sheetCreator;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import br.ufal.ic.sheetCreator.decorator.Decorator;
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
		
		this.setElements(staffs);
	}
	
	private void setElements(List<MusicalStaff> staff) {
		for (MusicalStaff musicalStaff : staff) {
			if(musicalStaff.getClef() != null) {
				this.add(musicalStaff.getClef().getLabel());
			}
			if(musicalStaff.getCompass() != null) {
				this.add(musicalStaff.getCompass().getLabel());
			}
			if(musicalStaff.getKsignature() != null) {
				this.add(musicalStaff.getKsignature().getLabel());
			}
		}
	}
}
