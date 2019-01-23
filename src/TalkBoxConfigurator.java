import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TalkBoxConfigurator extends JFrame {

   ArrayList<JButton> buttons = new ArrayList<JButton>();
   int counter = 0;

    public TalkBoxConfigurator() {

        setVisible(true);
        setSize(400,200);
        setLayout(new GridLayout());

        JButton button = new JButton("Add");
        add(button);
        button.addActionListener(new PlayListener());

    }

    public class PlayListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            buttons.add(new JButton("button" + counter));
            add(buttons.get(counter));
            counter++;
            revalidate();
        }
    }

}
