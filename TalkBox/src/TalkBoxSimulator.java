import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class TalkBoxSimulator extends JFrame {

	private JButton essential1, essential2, simulator;
	private JFrame frame;

	public TalkBoxSimulator() {

		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(4, 4, 1, 1));
		setLayout(new GridLayout());
		//essential1 = new JButton("Essentials 1");
		//essential2 = new JButton("Essentials 2");
		simulator = new JButton("Simulator");
		//frame.getContentPane().add(essential1);
		//frame.getContentPane().add(essential2);
		frame.getContentPane().add(simulator);

		buttons();

	}

	private void buttons() {

		/*
		 * essential1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			essentials1 ess = new essentials1();
			frame.setVisible(false);

			try {
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds/pop.wav"));
				Clip clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.start();
			} catch (Exception e1) {
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
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	});
	*
	*/

		simulator.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					simulator sim = new simulator();
				} catch (URISyntaxException use) {
					
				}
				
				frame.setVisible(false);
			
				try {

					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds/pop.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

	}

	public static void main(String args[]) {

		TalkBoxSimulator talkBoxSim = new TalkBoxSimulator();

        // Add window listener by implementing WindowAdapter class to
        // the frame instance. To handle the close event we just need
        // to implement the windowClosing() method.
		talkBoxSim.addWindowListener(new WindowAdapter() {
			
            @Override
            public void windowClosing(WindowEvent e) {
            	
                System.exit(0);
                
            }
            
        });

        // Show the frame
		talkBoxSim.setVisible(true);

	}

}