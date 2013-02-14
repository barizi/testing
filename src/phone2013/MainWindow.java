package phone2013;

import javax.swing.*;

import Utils.Usip;

import java.awt.event.*;
import java.awt.*;

import javax.swing.*;
import Utils.Usip;
import java.awt.event.*;
import java.awt.*;



public class MainWindow extends JFrame{
	ActionAide aide;

	public MainWindow(String nomFenetre) {
		super(nomFenetre);
		setSize(new Dimension(400, 300));
		setTitle("Telephone");
		addCenter(new Contenu(this));
		addMenus();
		addToolbar();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void addCenter(Component c) {
		getContentPane().add(c, "Center");
	}

	public void addToolbar() {
		JButton jButton3 = new JButton();
		JToolBar jToolBar = new JToolBar();
		jButton3.setAction(aide);
		jButton3.setText("");
		jToolBar.add(jButton3);
		getContentPane().add(jToolBar, BorderLayout.NORTH);
	}

	public void addMenus() {
		JMenuBar jmb = new JMenuBar();

		JMenu jMenuFile = new JMenu();
		JMenuItem jMenuFileExit = new JMenuItem();
		jMenuFile.setText(Usip.getTitle("f"));
		jMenuFileExit.setText(Usip.getTitle("q"));
		jMenuFileExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				System.exit(0);
			}
		});
		
		JMenu jMenuHelp = new JMenu(Usip.getTitle("hlp"));
		JMenuItem jMenuHelpAbout = new JMenuItem();
		aide = new ActionAide(Usip.getTitle("hlp"), Usip.getIcon("hlp"));
		jMenuHelpAbout.setAction(aide);
		
		jMenuFile.add(jMenuFileExit);
		jMenuHelp.add(jMenuHelpAbout);
		jmb.add(jMenuFile);
		jmb.add(jMenuHelp);
		this.setJMenuBar(jmb);
	}


 public static void main(String s[]){
    MainWindow fp = new MainWindow("Phone2013");
    fp.pack();
    fp.setVisible(true);
  }
}

//On aurait pu le faire avec un actionListener mais
//on peut aussi le faire en utilisant une action
class ActionAide extends AbstractAction {
	ActionAide(String titre, Icon icon) {
		super(titre, icon);
	}

	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null,
				Usip.getTitle("s"), Usip.getTitle("ap"),
				JOptionPane.INFORMATION_MESSAGE);
	}
}
