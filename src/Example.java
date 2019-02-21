import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A simple example showing how to use {@link FileDrop}
 * @author Robert Harder, rob@iharder.net
 */
public class Example {
	static ArrayList<JButton> buttons = new ArrayList<JButton>();
	static ArrayList<JTextArea> c = new ArrayList<JTextArea>();

    /** Runs a sample program that shows dropped files */
    public static void main( String[] args )
    {
    	 final javax.swing.JTextArea text = new javax.swing.JTextArea();
        javax.swing.JFrame frame = new javax.swing.JFrame( "FileDrop" );
       // StringBuilder a = new StringBuilder();
        for(int i = 0; i < 10; i++) {
            buttons.add(new JButton(i+"button"));
            frame.add(buttons.get(i));
            c.add(new JTextArea());
            
            frame.getContentPane().add( 
                new javax.swing.JScrollPane( c.get(i)), 
                java.awt.BorderLayout.CENTER);
        //    buttons.get(i).addActionListener(new PlayListener());
        }
      
        //javax.swing.border.TitledBorder dragBorder = new javax.swing.border.TitledBorder( "Drop 'em" );
       
     for (int i = 0; i<10;i++) {
        new FileDrop( System.out, c.get(i), /*dragBorder,*/ new FileDrop.Listener()
        {   public void filesDropped( java.io.File[] files )
            {   for( int i = 0; i < files.length; i++ )
                {   try
                    {   //text.append( files[i].getCanonicalPath() + "\n" );
                  //  a.append(files[i].getCanonicalPath()+"\n");
                    System.out.println(files[i].getCanonicalPath()+"\n");
                    }   // end try
                    catch( java.io.IOException e ) {}
                }   // end for: through each dropped file
            }   // end filesDropped
        }); // end FileDrop.Listener
     }
        frame.setBounds( 100, 100, 300, 400 );
        frame.setLayout(new GridLayout(5,1,2,2));
      //  frame.setDefaultCloseOperation( frame.EXIT_ON_CLOSE );
        frame.setVisible(true);
    }   // end main



}