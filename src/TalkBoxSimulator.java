import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class TalkBoxSimulator extends JFrame {
	private JButton essential;

	public TalkBoxSimulator() {
		setVisible(true);
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		essential = new JButton("Essentials 1");
		getContentPane().add(essential);
		essential.setBounds(0, 0, 169, 93);
		buttons();
	}
	
	private void buttons() {
		essential.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				essentials1 ess = new essentials1();
				setVisible(false);
				try {  
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds/essentials1_f/essentials1_f.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				} catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}