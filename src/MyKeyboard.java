import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

// Utilisation de l'API Swing

public class MyKeyboard extends JFrame /* JFrame est une classe qui se trouve dans le package javax.swing */ {
	
	
	private static final long serialVersionUID = -8810322889718622240L;
//	Cr�ation du tableau de caract�res
	
	static final String[] caractere = {
			"a", "z", "e", "r", "t", "u", "i", "o",
			"p", "q", "s", "d", "f", "g", "h", "j", 
			"k", "l", "m", "w", "x", "c", "v", "b",
			"n", "�", "�", "�", "�", "�", "�", "�", "�"," "
	};
	
	static final int nbCaractere = caractere.length; // Taille du tableau
	JButton[] b; //Tableau de bouttons
	JTextArea zoneTexte;  //Cr�ation de la zone de texte
	JButton bEffacer; //Effacer tout le text
	JButton effacerC; //Effacer un caract�re
	
	
	public MyKeyboard() {
//		Mise en forme de ma fenetre 
		
		super("Clavier fran�ais"); // Titre de la fenetre
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //	Arreter le processus en fermant la fenetre
		this.setSize(new Dimension (600,600)); //	Dimension de la fenetre
		this.setLocationRelativeTo(null); //	Positionner la fenetre au centre
		
//		Cr�ation et organisation du contentPane
		
		JPanel contentPane = (JPanel) this.getContentPane();  
		contentPane.setLayout(new GridLayout(2,1)); //  GridLayout: mettre en ligne et colonnes les �l�ments
		contentPane.setLayout (new BorderLayout()); //Mettre les �l�ments les uns apr�s les autres et qu'on ait des zones bien pr�cises
		contentPane.setBackground(Color.pink);
		
//		Le panel p1 compte 35 objets: nbCaractes + effacerC		
		
		JPanel p1 = new JPanel (new GridLayout (0, 9)); //Mettre les �l�ments en grille (l� 9 caract�res par ligne au maximum)
		b = new JButton [nbCaractere]; 
		for (int i=0; i < nbCaractere; i++) {
			b[i] = new JButton (caractere[i]); // Cr�ation et affectation de chaque caract�re � un boutton
			b[i].setBackground (Color.white);
			p1.add (b[i]);  
		}
		effacerC = new JButton ("Effacer");
		effacerC.setBackground (Color.white);
		p1.add(effacerC); //Ajouter le boutton effacerC � cot� du tableau de caract�res
		add (p1, "North"); //Mettre p1 au nord
		
//		Cr�ation de la zone de texte
		
		zoneTexte = new JTextArea ("\"  Zone de saisie  \" Effacez pour �crire");
		add (zoneTexte, "Center");
		bEffacer = new JButton ("Effacer tout");
		bEffacer.setBackground (Color.white);
				
		JPanel p2 = new JPanel();
		p2.add (bEffacer);
		add (p2,"South"); //Mettre au sud p2
		setVisible (true);
		traitement();
		p1.setBackground(Color.pink);
		p2.setBackground(Color.pink);			

	}
	
	void traitement() {
		
		ActionListener ecouteClick = new CaractereClick(); // ActionListenner est une interface auditrice (ici clic de la souris)
		//														Caractereclick est la classe qui impl�mente l'interface de type EventListene: ICI ActionListenner
		for (int i=0; i < nbCaractere; i++) {
			b[i].addActionListener (ecouteClick); // (addActionListenner est une m�thode qui permet de pr�ciser la classe qui va g�rer 
												  //l'�v�nement utilisateur de type ActionListener du bouton. (ici ecouteClick)
												
		}
		bEffacer.addActionListener (new ActionEffacer());
		effacerC.addActionListener (new ActionEffacerC());
	}
		
	class CaractereClick implements ActionListener   { 
		
		public void actionPerformed (ActionEvent evt)  { //ActionListenner envoie des �v�nements � la m�thode actionPerformed
			String etiquette = evt.getActionCommand(); //Renvoie le composant qui a g�n�r� l'�venement
			zoneTexte.append (etiquette);  //Ajouter l'�v�nement g�n�r� � la zone de texte
		}
	}
	
	class ActionEffacer implements ActionListener {
		public void actionPerformed (ActionEvent evt) {
			zoneTexte.setText ("");
		}
	}
	
	class ActionEffacerC implements ActionListener {
		public void actionPerformed (ActionEvent evt) {
			String txt = zoneTexte.getText(); // R�cup�rer le texte
			int size = txt.length(); // R�cup�rer la taille du texte
			zoneTexte.replaceRange("",size-1,size); 
			
		}
	}

}
