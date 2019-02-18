import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.Image;

import java.awt.Frame;

import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class TalkBoxConfig extends JFrame{
	JPanel panel;
	JLabel title;
	GroupLayout layout; 
	
	
	public TalkBoxConfig(ActionListener a, ItemListener i) {
		initializaComponents(a,i);
		initializePanel();
		
	}
	
	public void initializaComponents(ActionListener a, ItemListener i) {
		title = new JLabel();
		
		panel = new JPanel();
		layout = new GroupLayout(panel);
		panel.setLayout(layout);
		
	}
	
	public void initializePanel() {
			JFrame.setDefaultLookAndFeelDecorated(true);
	}

}
