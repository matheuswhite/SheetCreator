package view.popUpMenus;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.ufal.ic.sheetCreator.FlagSongs;
import br.ufal.ic.sheetCreator.IDocument;
import br.ufal.ic.sheetCreator.PlayerSong;
import br.ufal.ic.sheetCreator.ProxyDocument;
import br.ufal.ic.sheetCreator.decorator.Flag;
import view.DocumentView;

public class NewNote extends JFrame {
	
	private IDocument doc;
	private PlayerSong player;
	
	private Hashtable<String, FlagSongs> typesTable, tonesTable, accidentTable, toneNumberTable;
	private Hashtable<String, Flag> tableFlags;
	
	private JPanel panelbtn, panel, panelAccidents;
	
	private JComboBox<String> types_notes, tones, accidents;
	
	private JButton btncreate, btnclose;
	
	private JLabel lbltype_notes, lbltones, lblaccidents;
	
	public NewNote(DocumentView view, PlayerSong player) {
		this.doc = view.getCurrenteEditDoc();
		this.player = player;
		
		this.fillTableFlagSong();
		this.fillTableFlags();
		
		this.initComponents(this);
		
		this.addComponents();
		
		this.initFrame();
	}
	
	private void fillTableFlags() {
		this.tableFlags = new Hashtable<String, Flag>();
		
		this.tableFlags.put("Semibreve", Flag.WHOLE_NOTE);
		this.tableFlags.put("Seminima", Flag.HALF_NOTE);
		this.tableFlags.put("Minima", Flag.QUARTER_NOTE);
		this.tableFlags.put("Colcheia", Flag.EIGHTH_NOTE);
		
		this.tableFlags.put("C", Flag.C);
		this.tableFlags.put("D", Flag.D);
		this.tableFlags.put("E", Flag.E);
		this.tableFlags.put("F", Flag.F);
		this.tableFlags.put("G", Flag.G);
		this.tableFlags.put("A", Flag.A);
		this.tableFlags.put("B", Flag.B);
		
		this.tableFlags.put("# - Sustenido", Flag.SHARP);
		this.tableFlags.put("b - Bemol", Flag.FLAT);
		this.tableFlags.put("Natural", Flag.NATURAL_SIGN);
	}
	
	private void fillTableFlagSong() {
		this.typesTable = new Hashtable<String, FlagSongs>();
		this.tonesTable = new Hashtable<String, FlagSongs>();
		this.toneNumberTable = new Hashtable<String, FlagSongs>();
		this.accidentTable = new Hashtable<String, FlagSongs>();
		
		this.typesTable.put("Semibreve", FlagSongs.WHOLE_NOTE);
		this.typesTable.put("Seminima", FlagSongs.HALF_NOTE);
		this.typesTable.put("Minima", FlagSongs.QUARTER_NOTE);
		this.typesTable.put("Colcheia", FlagSongs.EIGHTH_NOTE);
		
		this.tonesTable.put("C", FlagSongs.C);
		this.tonesTable.put("D", FlagSongs.D);
		this.tonesTable.put("E", FlagSongs.E);
		this.tonesTable.put("F", FlagSongs.F);
		this.tonesTable.put("G", FlagSongs.G);
		this.tonesTable.put("A", FlagSongs.A);
		this.tonesTable.put("B", FlagSongs.B);
		
		this.toneNumberTable.put("3", FlagSongs.TONE_5);
		this.toneNumberTable.put("4", FlagSongs.TONE_6);
		
		this.accidentTable.put("# - Sustenido", FlagSongs.SHARP);
		this.accidentTable.put("b - Bemol", FlagSongs.FLAT);
		this.accidentTable.put("Natural", FlagSongs.NATURAL);
	}
	
	private void initFrame() {
		this.setLayout(new BorderLayout());
		this.getContentPane().add(panel, BorderLayout.NORTH);
		this.getContentPane().add(panelAccidents, BorderLayout.CENTER);
		this.getContentPane().add(panelbtn, BorderLayout.SOUTH);
		
		this.setLocation(50, 50);
		this.setSize(400, 150);
		this.setResizable(false);
		this.setTitle("Nova Nota");
		this.setVisible(true);
	}
	
	private void initComponents(NewNote frame) {
		String[] listTypeNotes = {"Semibreve", "Seminima", "Minima", "Colcheia"};
		String[] listTons = {"C3", "D3", "E3", "F3", "G3", "A3", "B3", "C4", "D4", "E4", "F4", "G4"};
		String[] listAccidents = {"# - Sustenido", "b - Bemol", "Natural"};
		
		this.panel = new JPanel();
		this.panelAccidents = new JPanel();
		this.panelbtn = new JPanel();
		
		this.lbltype_notes = new JLabel("Tipos de notas");
		this.types_notes = new JComboBox<String>(listTypeNotes);
		
		this.lbltones = new JLabel("Tons");
		this.tones = new JComboBox<String>(listTons);
		
		this.lblaccidents = new JLabel("Acidentes");
		this.accidents = new JComboBox<String>(listAccidents);
		
		this.btnclose = new JButton("Fechar");
		this.btncreate = new JButton("Criar");
		
		this.btnclose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		
		this.btncreate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.createNote();
			}
		});
	}
	
	private void addComponents() {
		this.panel.add(this.lbltype_notes);
		this.panel.add(this.types_notes);
		this.panel.add(this.lbltones);
		this.panel.add(this.tones);
		
		this.panelAccidents.add(this.lblaccidents);
		this.panelAccidents.add(this.accidents);
		
		this.panelbtn.add(this.btnclose);
		this.panelbtn.add(this.btncreate);
	}
	
	public void createNote() {
		ArrayList<Flag> listFlags = new ArrayList<Flag>();
		String type = (String) this.types_notes.getSelectedItem();
		String tone = (String) this.tones.getSelectedItem();
		String accident = (String) this.accidents.getSelectedItem();
		
		this.player.addNote(this.tonesTable.get(tone.substring(0, 1)), this.accidentTable.get(accident), 
				this.toneNumberTable.get(tone.substring(1, 2)), this.typesTable.get(type));
		
		if(((ProxyDocument) this.doc).addBarCompass) {
			this.player.addBarCompass();
			((ProxyDocument) this.doc).addBarCompass = false;
		}
		
		
		listFlags.add(this.tableFlags.get(type));
		listFlags.add(Flag.NONE);
		listFlags.add(this.tableFlags.get(tone.substring(0, 1)));
		listFlags.add(this.tableFlags.get(accident));
		
		if(listFlags.get(0).equals(Flag.WHOLE_NOTE)) {
			System.out.println("101");
		}
		if(listFlags.get(1).equals(Flag.NONE)) {
			System.out.println("102");
		}
		if(listFlags.get(2).equals(Flag.C)) {
			System.out.println("103");
		}
		if(listFlags.get(3).equals(Flag.NATURAL_SIGN)) {
			System.out.println("104");
		}
		
		((ProxyDocument) this.doc).addNote(0, listFlags);
		
		this.dispose();
	}
}
