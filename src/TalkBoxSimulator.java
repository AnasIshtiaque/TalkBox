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
    public static int i;

    ArrayList<JButton> buttons = new ArrayList<JButton>();
    ArrayList<PlayListener> listeners = new ArrayList<PlayListener>();
	private JButton essential1, essential2;
	private JFrame frame;

	public TalkBoxSimulator() {
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(3, 4, 1, 1));

        setVisible(true);
        setSize(200,200);
        setLayout(new GridLayout());
		essential1 = new JButton("Essentials 1");
		essential2 = new JButton("Essentials 2");
		
		frame.getContentPane().add(essential1);
		frame.getContentPane().add(essential2);
		//buttons();
	

        for(i = 0; i < 5; i++) {
            buttons.add(new JButton(i+"button"));
            add(buttons.get(i));
            buttons.get(i).addActionListener(new PlayListener());
        }
        
    String path = "GWgwHBK.jpg";
    ImageIcon icon = new ImageIcon(TalkBoxSimulator.class.getResource(path));
    }

public class PlayListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            for(int k = 0; k < 5; k++){
                if(event.getSource().equals(buttons.get(k))){
                    ClassLoader classLoader=this.getClass().getClassLoader();
                    java.applet.AudioClip audio=JApplet.newAudioClip(classLoader.getResource((k+1)+".wav"));
                    audio.play();
                }
            }
        }
     }

/*private void buttons() {
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
	}*/
}