package br.ufal.ic.sheetCreator.decorator;

import java.util.List;

public class QuarterNote extends Notes{

	public QuarterNote(IComponent component, int position_x, int position_y,
			List<Flag> flag) {
		super(component, position_x, position_y, flag);
	}

	@Override
	public int getWidth() {
		return 60;
	}

	@Override
	public int getHeight() {
		return 60;
	}

	@Override
	public String getPathImage() {
		String exit = "resource/quarternote500.svg.png";
		if(this.flags.get(Notes.TONE_POSITION).equals(Flag.C)) {
			exit = "resource/quarternote500_do.svg.png";
		}
		
		if(this.flags.get(Notes.ACCIDENTAL_SYMBOL).equals(Flag.SHARP)){
			exit = "resource/quarternote500_sharp.png";
			if(this.flags.get(Notes.TONE_POSITION).equals(Flag.C)) {
				exit = "resource/quarternote500_do_sharp.png";
			}
		}
		else if(this.flags.get(Notes.ACCIDENTAL_SYMBOL).equals(Flag.FLAT)) {
			exit = "resource/quarternote500_flat.png";
			if(this.flags.get(Notes.TONE_POSITION).equals(Flag.C)) {
				exit = "resource/quarternote500_do_flat.png";
			}
		}
		return exit;
	}

	@Override
	public int getPosisionCX() {
		return this.ordem.get(this.flags.get(Notes.CURSOR_POSITION));
	}

	@Override
	public int getPositionCY() {
		return this.ordem.get(this.flags.get(Notes.TONE_POSITION));
	}
}
