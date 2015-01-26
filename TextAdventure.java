import java.util.*;
import java.awt.*;
import javax.swing.*;

public class TextAdventure {

	public static String name;
	public static String partnerName;
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		name = "";
		partnerName = "";
		//not a pokemon intro I swear
		System.out.println(Text.openingLine);
		System.out.println(Text.line2);
		System.out.println(Text.nameLine);
		name = input.nextLine();
		System.out.println(Text.gotName + name);
		System.out.println(">" + name + Text.introClosing);
		System.out.println();

		//give first goal
		System.out.println(">" + name + Text.goTalkToSnow);



		Processor processor = new Processor();
		String command = "";
		//Game will run until command 'quit' is given
		while (!(command.equals("quit"))) {
			command = input.nextLine();
			if (command.equals("quit")) {
				break;
			}
			String printout = processor.processCommand(command);
			System.out.println(">"+printout);

			//"victory" screen
			JFrame frame = new JFrame();
			frame.setSize(508,600);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("HOORAY");
			frame.add(new VictoryImage());
			frame.setVisible(false);
			if (GameMod.youWon == true) {
				frame.setVisible(true);
			}
		}
	}
	
	//
	private static class VictoryImage extends JPanel {

	ImageIcon bobBaratheon;

		public VictoryImage() {
			super();
			bobBaratheon = new ImageIcon("kingbobbaratheon.png");
			setFocusable(true);		
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			g2.drawImage(bobBaratheon.getImage(),104,0,null);
			g2.setColor(Color.BLACK);
			g2.setFont(new Font("Seriff", Font.PLAIN,20));
			g2.drawString("Congratulations, you beat the game!", 5, 500);
		}
	}
}
