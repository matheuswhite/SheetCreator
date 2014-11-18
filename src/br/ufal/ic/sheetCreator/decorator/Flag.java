package br.ufal.ic.sheetCreator.decorator;

public enum Flag {
	PRIMEIRA(1), SEGUNDA(2), TERCEIRA(3), QUARTA(4), QUINTA(5), SEXTA(6), SETIMA(7), OITAVA(8), 
	CLASSICAL_TREBLE_CLEF(9),
	WHOLE_NOTE(10), HALF_NOTE(11), QUARTER_NOTE(12), EIGHTH_NOTE(13),
	C(14) , D(15), E(16), F(17), G(18), A(19), B(20),
	SHARP(21), FLAT(22), NATURAL_SIGN(23),
	NONE(0),
	CLASSICAL_DOCUMENT(24);
	
	public int val;
	Flag(int val) {
		this.val = val;
	}
	
	public int getVal() {
		return this.val;
	}
}
