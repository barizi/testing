package phone2013;

import java.awt.*;
import javax.swing.*;
import java.awt.datatransfer.*;

public class Onglets extends JTabbedPane  {
	EtatTelephone et;
	JList<String> list;
	DefaultListModel<String> data = new DefaultListModel<String>();
	Dimension bb = new Dimension(450, 200);

	public Onglets(EtatTelephone et) {
		this.et = et;
		JPanel panel;
		panel = new JPanel();
		panel.setLayout(new GridLayout(1, 0));
		
		data.addElement("0000000000 Pierre");
		data.addElement("1111111111 Jacques");
		data.addElement("2222222222 Paul");
		list = new JList<String>(data);
		list.setSelectedIndex(1);
		list.addMouseListener(new CList(this));

		addTab("Répertoire", new JScrollPane(list));

		panel = new JPanel();
		panel.add(new JLabel("MEVO"));
		addTab("Messagerie Vocale", panel);

		panel = new JPanel();
		panel.add(new JLabel("Configuration"));
		addTab("Configuration", panel);
		setPreferredSize(bb);
		setSelectedIndex(0);
	}

	// Deux petites methodes pour implementer l'interface copiableCollable
	public StringSelection donneACopier() {
		String st;
		int index = list.getSelectedIndex();
		st = (String) (data.elementAt(index));

		return new StringSelection(st);
	}

	// on ajoute dans la liste au début
	public void coller(String aColler) {
		data.addElement(aColler);
	}

	public JList<String> getList() {
		return list;
	}

	public ListModel<String> getListModel() {
		return data;
	}

	public void change(boolean b, String item) {
		et.change(b, item);
	}
}
