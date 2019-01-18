import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TalkBoxSimulator extends JFrame {

    public static int i;

    public TalkBoxSimulator() {

        setVisible(true);
        setSize(400,200);
        setLayout(new GridLayout());


        ArrayList<JButton> buttons = new ArrayList<JButton>();

        for(i = 0; i < 10; i++) {
            buttons.add(new JButton("Button: " + (i + 1)));
            add(buttons.get(i));
        }
    buttons.get(0).setText("PLAY"); 
    String path = "GWgwHBK.jpg";
    ImageIcon icon = new ImageIcon(TalkBoxSimulator.class.getResource(path));
    buttons.get(0).setIcon(icon);
    buttons.get(0).addActionListener(new PlayListener());
    }
public class PlayListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            ClassLoader classLoader=this.getClass().getClassLoader();
            java.applet.AudioClip audio=JApplet.newAudioClip(classLoader.getResource("yes-5.wav"));
            audio.play();
        }
     }
    
}