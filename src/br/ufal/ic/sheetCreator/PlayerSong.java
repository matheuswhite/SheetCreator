package br.ufal.ic.sheetCreator;

import java.util.Hashtable;

import org.jfugue.Player;

public class PlayerSong{
	
	private String song;
	private Player player;
	private Hashtable<FlagSongs, String> notes;
	
	public PlayerSong() {
		this.song = "";
		this.player = new Player();
		
		this.fillHashTable();
	}
	
	private void fillHashTable() {
		this.notes = new Hashtable<FlagSongs, String>();
		
		this.notes.put(FlagSongs.WHOLE_NOTE, "w");
		this.notes.put(FlagSongs.HALF_NOTE, "h");
		this.notes.put(FlagSongs.QUARTER_NOTE, "q");
		this.notes.put(FlagSongs.EIGHTH_NOTE, "i");
		
		this.notes.put(FlagSongs.TONE_5, "5");
		this.notes.put(FlagSongs.TONE_6, "6");
		
		this.notes.put(FlagSongs.SHARP, "#");
		this.notes.put(FlagSongs.FLAT, "b"); // ?
		this.notes.put(FlagSongs.NATURAL, "");
		
		this.notes.put(FlagSongs.C, "C");
		this.notes.put(FlagSongs.D, "D");
		this.notes.put(FlagSongs.E, "E");
		this.notes.put(FlagSongs.F, "F");
		this.notes.put(FlagSongs.G, "G");
		this.notes.put(FlagSongs.A, "A");
		this.notes.put(FlagSongs.B, "B");
	}
	
	public void addNote(FlagSongs note, FlagSongs accident, FlagSongs toneNumber, FlagSongs time) {
		this.song += " " + this.notes.get(note) + this.notes.get(accident) + this.notes.get(toneNumber) + this.notes.get(time);
	}
	
	public void addBarCompass() {
		this.song += " |";
	}

	public void playSong() {
		this.player.play(song);
	}
	
	public void clearSongString() {
		this.song = "";
	}
	
	public void pauseSong() {
		this.player.pause();
	}
}
