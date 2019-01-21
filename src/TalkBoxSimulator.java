import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TalkBoxSimulator extends JFrame {

    public static int i;
    int ab = 0;
    ArrayList<JButton> buttons = new ArrayList<JButton>();

    public TalkBoxSimulator() {

        setVisible(true);
        setSize(400,200);
        setLayout(new GridLayout());




        for(i = 0; i < 10; i++) {
            buttons.add(new JButton("Button: " + (i + 1)));
            add(buttons.get(i));
            buttons.get(i).addActionListener(new PlayListener());
        }
    buttons.get(0).setText("PLAY"); 
    String path = "GWgwHBK.jpg";
    ImageIcon icon = new ImageIcon(TalkBoxSimulator.class.getResource(path));
    buttons.get(0).setIcon(icon);

    }
public class PlayListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            ClassLoader classLoader=this.getClass().getClassLoader();
            java.applet.AudioClip audio=JApplet.newAudioClip(classLoader.getResource("1.wav"));
            audio.play();
        }
     }

}