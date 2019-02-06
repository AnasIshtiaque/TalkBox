import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class TalkBoxSimulator extends JFrame {
	private JButton essential1, essential2;
	private JFrame frame;

	public TalkBoxSimulator() {
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		// for fullscreen mode:frame.setUndecorated(true);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(3, 4, 1, 1));

		essential1 = new JButton("Essentials 1");
		essential2 = new JButton("Essentials 2");
		
		frame.getContentPane().add(essential1);
		frame.getContentPane().add(essential2);
		buttons();
	}

	private void buttons() {
		essential1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				essentials1 ess = new essentials1();
				frame.setVisible(false);
				try {  
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds/pop.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				} catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		essential2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				essentials2 ess = new essentials2();
				frame.setVisible(false);
				try {  
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds/pop.wav"));
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