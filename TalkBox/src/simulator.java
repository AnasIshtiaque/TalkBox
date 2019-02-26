import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.io.File;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.*;
import java.util.List;
import java.util.stream.*;

public class simulator extends JFrame {

    private JFrame frame;
    ArrayList<JButton> buttons = new ArrayList<JButton>();

    CodeSource cs = TalkBoxConfigurator.class.getProtectionDomain().getCodeSource();
    File jF = new File(cs.getLocation().toURI().getPath());
    String jDirectoryAud = jF.getParentFile().getPath()+"/config/audio";
    String jDirectoryImg = jF.getParentFile().getPath()+"/config/images";
    List<String> resultAud;
    List<String> resultImg;

    int aLen = new File(jDirectoryAud).listFiles().length;

    public simulator() throws URISyntaxException {

        frame = new JFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setState(Frame.NORMAL);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(2, 2, 1, 1));

        try (Stream<Path> walk = Files.walk(Paths.get(jDirectoryAud))) {

            resultAud = walk.map(x -> x.toString())
                    .filter(f -> f.endsWith(".wav")).collect(Collectors.toList());

            Collections.sort(resultAud);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Stream<Path> walk = Files.walk(Paths.get(jDirectoryImg))) {

            resultImg = walk.map(x -> x.toString())
                    .filter(f -> f.endsWith(".png")).collect(Collectors.toList());

            Collections.sort(resultImg);

        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < aLen; i++){

            buttons.add(new JButton(new ImageIcon(resultImg.get(i))));
            add(buttons.get(i));
            frame.getContentPane().add(buttons.get(i));
            buttons.get(i).addActionListener(new PlayListener());

        }

    }

    public class PlayListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            for(int k = 0; k < aLen; k++){

                if(event.getSource().equals(buttons.get(k))){

                    try {

                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(resultAud.get(k)));
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();

                    }

                    catch (Exception e){

                        e.printStackTrace();

                    }

                }

            }

        }

    }

}