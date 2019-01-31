import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.GridBagLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class essentials2 extends JFrame{
	private JButton back, walk, more, washroom, noisy;
	private JFrame frame;
	private ImageIcon walk_ic, more_ic, washroom_ic, noisy_ic, back_ic;
	public essentials2() {
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//for fullscreen mode: frame.setUndecorated(true);
		frame.setState(Frame.NORMAL);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(2, 2, 1, 1));
		
		walk_ic = new ImageIcon("icon/essential2/walk.png");
		walk = new JButton("Go For A Walk",walk_ic);
		
		more_ic = new ImageIcon("icon/essential2/more.png");
		more = new JButton("Want More", more_ic);
		
		washroom_ic = new ImageIcon("icon/essential2/washroom.png");
		washroom = new JButton("Need Washroom",washroom_ic);
		
		noisy_ic = new ImageIcon("icon/essential2/noisy.png");
		noisy = new JButton("Too Noisy",noisy_ic);
		
		back_ic = new ImageIcon("icon/back.png");
		back = new JButton("Back", back_ic);
		
		back.setBounds(615, 216, 169, 93);
	
		//hello.setIcon(resizeIcon(hello_ic,hello.getWidth(),hello.getHeight()));
		//hello.setVerticalTextPosition(SwingConstants.BOTTOM);
		//hello.setHorizontalTextPosition(SwingConstants.CENTER);
		frame.getContentPane().add(walk);
		frame.getContentPane().add(more);
		frame.getContentPane().add(washroom);
		frame.getContentPane().add(noisy);
		frame.getContentPane().add(back);
		
		buttons();

		main(back);
	}
	
	private void buttons() {
		walk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {  
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds/essentials2_f/go_for_walk.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				} catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		more.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {  
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds/essentials2_f/like_more.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				} catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		washroom.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {  
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds/essentials2_f/need_washroom.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				} catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		noisy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {  
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds/essentials2_f/too_noisy.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				} catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	
	private void main(JButton back) {
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TalkBoxSimulator menu = new TalkBoxSimulator();
				frame.setVisible(false);
			}
		});
	}

}
