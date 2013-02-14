package Utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.ImageIcon;


public class Usip {
	static 	HashMap<String,String> title = new HashMap<String,String>(){{
		put("hlp", "Aide");
		put("q", "Quitter");
		put("f", "Fichier");
		put("s","TP Téléphone\nMountaz Hascoët");
		put("ap","A propos");
	}};
	
	static 	HashMap<String,String> icons = new HashMap<String,String>(){{
		put("hlp", "Icons/help.gif");
		put("cp", "Icons/copier.gif");
		put("cl", "Icons/coller.gif");
	}};
	
	public static String getTitle(String code){
		return title.get(code);
	}
	
	public static String gwd(){
		String current="";
		try {
			current = new File( "." ).getCanonicalPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Current dir:"+current);
		return current;
	}
	public static ImageIcon getIcon(String code){
		System.out.println(gwd());
		
		return new ImageIcon(icons.get(code));
	}
}
