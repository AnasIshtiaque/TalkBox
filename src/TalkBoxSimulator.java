import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TalkBoxSimulator extends JFrame {
    private JPanel panel1;
    private JButton button1;
    private JButton button2;

    public TalkBoxSimulator() {

        add(panel1);
        setTitle("Talk Box Simulator");
        setSize(400,400);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hello World");
            }
        });
    }
}