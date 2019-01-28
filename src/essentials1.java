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
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;


public class essentials1 extends JFrame{
	private JButton hello, gbye, feel_sick, back, mouth_dry,need_break,need_suction,need_help, yes, no, thank, youre_welcome, upset;
	
	public essentials1() {
		setVisible(true);
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(3, 4, 1, 1));
		
		hello = new JButton("Hello");
		gbye = new JButton("Goodbye");
		feel_sick = new JButton("Feel Sick");
		mouth_dry = new JButton("Mouth Dry");
		need_break = new JButton("Need A Break");
		need_help = new JButton("Need Help");
		need_suction = new JButton("Need Suction");
		yes = new JButton("YES");
		no = new JButton("NO");
		thank = new JButton("Thank you");
		youre_welcome = new JButton("You're Welcome");
		upset = new JButton("Upset");
		back = new JButton("Back");
		back.setBounds(615, 216, 169, 93);
		
		getContentPane().add(hello);
		getContentPane().add(gbye);
		getContentPane().add(feel_sick);
		getContentPane().add(mouth_dry);
		getContentPane().add(need_break);
		getContentPane().add(need_suction);
		getContentPane().add(need_help);
		getContentPane().add(yes);
		getContentPane().add(no);
		getContentPane().add(thank);
		getContentPane().add(youre_welcome);
		getContentPane().add(upset);
		getContentPane().add(back);
		
		buttons();

		main(back);
	}
	
	private void buttons() {
		hello.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {  
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds/essentials1_f/hello.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				} catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		gbye.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {  
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds/essentials1_f/goodbye.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				} catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		feel_sick.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {  
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds/essentials1_f/feel_sick.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				} catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		mouth_dry.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {  
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds/essentials1_f/mouth_dry.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				} catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		need_break.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {  
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds/essentials1_f/need_break.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				} catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		need_suction.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {  
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds/essentials1_f/need_suction.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				} catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		need_help.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {  
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds/essentials1_f/need_help.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				} catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		no.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {  
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds/essentials1_f/no.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				} catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		yes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {  
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds/essentials1_f/yes.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				} catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		thank.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {  
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds/essentials1_f/thank_you.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				} catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		youre_welcome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {  
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds/essentials1_f/youre_welcome.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				} catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		upset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {  
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds/essentials1_f/upset.wav"));
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
			}
		});
	}
}
