import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
public class fenetre extends JFrame {

	public fenetre() {
		this.setTitle("P&C DATA ");
		this.setSize(1440, 1024);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel pan = new JPanel();
		pan.setBackground(Color.BLACK);
		this.setContentPane(pan);
		this.setVisible(true);
		this.setContentPane(new panneau());
		
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		fenetre fen  = new fenetre();
		
		
		// TODO Auto-generated method stub

	}

}
