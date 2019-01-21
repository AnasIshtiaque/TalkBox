import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TalkBoxSimulator extends JFrame {

    public static int i;

    ArrayList<JButton> buttons = new ArrayList<JButton>();
    ArrayList<PlayListener> listeners = new ArrayList<PlayListener>();

    public TalkBoxSimulator() {

        setVisible(true);
        setSize(400,200);
        setLayout(new GridLayout());

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
}