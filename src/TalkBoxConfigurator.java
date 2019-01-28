import javax.swing.*;
import java.awt.*;
import java.awt.dnd.DropTarget;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TalkBoxConfigurator extends JFrame {

   ArrayList<JButton> buttons = new ArrayList<JButton>();
   int counter = 0;
    JLabel iL = new JLabel();
    JLabel pL = new JLabel();

    public TalkBoxConfigurator() {

        setVisible(true);
        setSize(400,200);
        setLayout(new GridLayout(2,1,4,4));

        JButton button = new JButton("Add");
        add(button);
        button.addActionListener(new PlayListener());

/*      add(iL);
        iL.setSize(100,100);
        add(pL);
        pL.setSize(100,100);

        connectToDragDrop();*/

    }

    private void connectToDragDrop(){

        DragListener d = new DragListener(iL, pL);

        new DropTarget(this,d);

    }

    public class PlayListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            buttons.add(new JButton("button" + counter));
            add(buttons.get(counter));
            buttons.get(counter).addActionListener(new PlayListener1());
            counter++;
            revalidate();
        }
    }

    public class PlayListener1 implements ActionListener {

        public void actionPerformed(ActionEvent event){

            for(int k = 0; k < counter; k++){

                if(event.getSource().equals(buttons.get(k))){



                }
            }
        }

    }

}
