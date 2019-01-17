import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TalkBoxSimulator extends JFrame {

    public TalkBoxSimulator() {

        setVisible(true);
        setSize(400,200);
        setLayout(new GridLayout());

        ArrayList<JButton> buttons = new ArrayList<JButton>();

        for(int i = 0; i < 5; i++){
            buttons.add(new JButton("Button: " + (i+1)));
            add(buttons.get(i));
        }


    }
}