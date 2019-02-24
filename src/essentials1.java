import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Image;

import java.awt.Frame;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class essentials1 extends JFrame{

	private JButton hello, gbye, feel_sick, back, mouth_dry,need_break,need_help, yes, no, thank, youre_welcome, upset;
	private JFrame frame;
	private ImageIcon hello_ic, gbye_ic, sick_ic, mouth_dry_ic,break_ic,help_ic,yes_ic,no_ic,thank_ic,welcome_ic,upset_ic,back_ic;

	public essentials1() {

		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setState(Frame.NORMAL);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(3, 4, 1, 1));
		
		hello_ic = new ImageIcon("icon/essential1/hello.png");
		hello = new JButton("Hello",hello_ic);
		
		gbye_ic = new ImageIcon("icon/essential1/goodbye.png");
		gbye = new JButton("Goodbye", gbye_ic);
		
		sick_ic = new ImageIcon("icon/essential1/feel_sick.gif");
		feel_sick = new JButton("Feel Sick",sick_ic);
		
		mouth_dry_ic = new ImageIcon("icon/essential1/mouth_dry.png");
		mouth_dry = new JButton("Mouth Dry",mouth_dry_ic);
		
		break_ic = new ImageIcon("icon/essential1/break.png");
		need_break = new JButton("Need A Break",break_ic);
		
		help_ic = new ImageIcon("icon/essential1/help.png");
		need_help = new JButton("Need Help",help_ic);
		
		yes_ic = new ImageIcon("icon/essential1/yes.png");
		yes = new JButton("YES",yes_ic);
		
		no_ic = new ImageIcon("icon/essential1/no.png");
		no = new JButton("NO",no_ic);
		
		thank_ic = new ImageIcon("icon/essential1/thanks.png");
		thank = new JButton("Thank you",thank_ic);
		
		welcome_ic = new ImageIcon("icon/essential1/yourewelcome.png");
		youre_welcome = new JButton("You're Welcome",welcome_ic);
		
		upset_ic = new ImageIcon("icon/essential1/upset.png");
		upset = new JButton("Upset",upset_ic);
		
		back_ic = new ImageIcon("icon/essential1/back.png");
		back = new JButton("Back", back_ic);
		back.setBounds(615, 216, 169, 93);

		frame.getContentPane().add(hello);
		frame.getContentPane().add(gbye);
		frame.getContentPane().add(feel_sick);
		frame.getContentPane().add(mouth_dry);
		frame.getContentPane().add(need_break);
		frame.getContentPane().add(need_help);
		frame.getContentPane().add(yes);
		frame.getContentPane().add(no);
		frame.getContentPane().add(thank);
		frame.getContentPane().add(youre_welcome);
		frame.getContentPane().add(upset);
		frame.getContentPane().add(back);
		
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

		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

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
