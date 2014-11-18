package br.ufal.ic.sheetCreator.decorator;

import java.util.List;

public class HalfNote extends Notes {

	public HalfNote(IComponent component, int position_x, int position_y,
			List<Flag> flag) {
		super(component, position_x, position_y, flag);
	}

	@Override
	public int getWidth() {
		return 50;
	}

	@Override
	public int getHeight() {
		return 60;
	}

	@Override
	public String getPathImage() {
		String exit = "resource/halfnote500.svg.png";
		if(this.flags.get(Notes.TONE_POSITION).equals(Flag.C)) {
			exit = "resource/halfnote500_do.svg.png";
		}
		
		if(this.flags.get(Notes.ACCIDENTAL_SYMBOL).equals(Flag.SHARP)){
			exit = "resource/halfnote500_sharp.png";
			if(this.flags.get(Notes.TONE_POSITION).equals(Flag.C)) {
				exit = "resource/halfnote500_do_sharp.png";
			}
		}
		else if(this.flags.get(Notes.ACCIDENTAL_SYMBOL).equals(Flag.FLAT)) {
			exit = "resource/halfnote500_flat.png";
			if(this.flags.get(Notes.TONE_POSITION).equals(Flag.C)) {
				exit = "resource/halfnote500_do_flat.png";
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
