package phone2013;

import java.awt.event.*;
import javax.swing.*;

class ControleSaisieNumero implements ActionListener {
	SaisieNumero sn;
	int i;

	public ControleSaisieNumero(SaisieNumero sn) {
		this.sn = sn;
		i = 0;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sn.raccrocher) {
			System.out.println("Action Dans ControleSaisieNumero false-  "+ i++);
			sn.etat.change(false, "");
		} else {// pour les "enter" recus dans la combo ou les clics sur
				// decrocher
			System.out.println("Action Dans ControleSaisieNumero true -  " + i++);
			sn.etat.change(true, (String) sn.comboBox.getEditor().getItem());
		}
	}
}

class CList extends MouseAdapter {
	Onglets o;
	int i;

	public CList(Onglets o) {
		this.o = o;
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			System.out.println("Double Clic dans Rep -  " + i++);
			ListModel model;
			int index = o.getList().locationToIndex(e.getPoint());
			String item;

			model = o.getListModel();
			item = (model.getElementAt(index)).toString();

			o.getList().ensureIndexIsVisible(index);

			o.change(true, item);
		}
	}
}
