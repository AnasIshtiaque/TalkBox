import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TalkBoxSimulator extends JFrame {
	ArrayList<JButton> buttons = new ArrayList<JButton>();
	ArrayList<PlayListener> listeners = new ArrayList<PlayListener>();

	public TalkBoxSimulator() {
		setVisible(true);
		setSize(400, 200);
		getContentPane().setLayout(null);
		
		JButton greetbtn = new JButton("Greetings");
		
		greetbtn.setIcon(new ImageIcon("0-1289024.png"));
		greetbtn.setBounds(0, 0, 75, 50);
		greetbtn.setHorizontalTextPosition(JButton.CENTER);
		greetbtn.setVerticalTextPosition(JButton.CENTER);
		getContentPane().add(greetbtn);
		
	}

	public class PlayListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			for (int k = 0; k < 5; k++) {
				if (event.getSource().equals(buttons.get(k))) {
					ClassLoader classLoader = this.getClass().getClassLoader();
					java.applet.AudioClip audio = JApplet.newAudioClip(classLoader.getResource((k + 1) + ".wav"));
					audio.play();
				}
			}
		}
	}
}