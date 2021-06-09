import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Main {

	public static void main(String[] args) throws Exception {
		//Apply Look'n Feel
				UIManager.setLookAndFeel(new NimbusLookAndFeel()); //C'est une mise en forme 
						
				//Start my window
				MyKeyboard mykeyboard = new MyKeyboard(); //Instancier une fenetre
				mykeyboard.setVisible(true); //Afficher la fenetre
	}

}
