import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.List;

public class TalkBoxConfigurator extends JFrame implements TalkBoxConfiguration {

	static ArrayList<JButton> sound_buttons = new ArrayList<JButton>();
	static ArrayList<JButton> img_buttons = new ArrayList<JButton>();
	List<String> filenames = new ArrayList<String>();
	List<String> images = new ArrayList<String>();
	Path RRfilenames;
	StringBuilder builder = new StringBuilder();
	int counter = 0;
	String filename = "";
	ArrayList<StringBuilder> builders = new ArrayList<StringBuilder>();
	int height = 300;
	int width = 600;
	CodeSource cs = TalkBoxConfigurator.class.getProtectionDomain().getCodeSource();
	File jF = new File(cs.getLocation().toURI().getPath());
	String jDirectory = jF.getParentFile().getPath()+"/config";

	public TalkBoxConfigurator() throws URISyntaxException, IOException {
		super ("Configuration Window");
		JPanel a = new JPanel();
		add(a);
		setVisible(true);
		setSize(width, height);
		setLayout(new GridLayout(1, 1));
		JButton button = new JButton("Add");
		a.add(button);
		button.addActionListener(new PlayListener());
		Files.createDirectories(Paths.get(jDirectory+"/audio"));
		Files.createDirectories(Paths.get(jDirectory+"/images"));
		Files.createDirectories(Paths.get(jDirectory+"/serialize"));

	}

	public class PlayListener implements ActionListener {

		public void actionPerformed(ActionEvent event){

			setSize(width+=80, height);

			builder = new StringBuilder();
			img_buttons.add(new JButton("Drag image file... "));
			add(img_buttons.get(counter));
			img_buttons.get(counter).addActionListener(new PlayListener1());
			sound_buttons.add(new JButton("Drag sound file... "));
			getContentPane().add(new javax.swing.JScrollPane(sound_buttons.get(counter)), java.awt.BorderLayout.CENTER);

			new FileDrop(System.out, sound_buttons.get(counter), /* dragBorder, */ new FileDrop.Listener() {

				public void filesDropped(java.io.File[] files) {

					for (int i = 0; i < files.length; i++) {

						try {
							builder.append(files[i].getCanonicalPath() + "\n");
							filename = "" + files[i].getCanonicalPath();
							RRfilenames = files[i].toPath().getParent();
							filenames.add(filename);
							builders.add(builder);
							File source = new File(filename);
							File dest = new File(jDirectory+"/audio/aud"+counter+"."+getFileExtension(source));
							Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
							
							sound_buttons.get(counter - 1).setText(files[i].getName());
							sound_buttons.get(counter - 1).setIcon(new ImageIcon("icon/sound.png"));
							sound_buttons.get(counter-1).setHorizontalTextPosition(JLabel.CENTER);
							sound_buttons.get(counter-1).setVerticalTextPosition(JLabel.BOTTOM);
							sound_buttons.get(counter-1).addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									try {
										AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(source);
										Clip clip = AudioSystem.getClip();
										clip.open(audioInputStream);
										clip.start();
									} catch(Exception e1) {
										e1.printStackTrace();
									}
								}
							});
						} // end try

						catch (java.io.IOException e) {

						}

					}
					// end for: through each dropped file
				} // end filesDropped

			}); // end FileDrop.Listener

			new FileDrop(System.out, img_buttons.get(counter), /* dragBorder, */ new FileDrop.Listener() {

				public void filesDropped(java.io.File[] files) {

					for (int i = 0; i < files.length; i++) {

						try {

							images.add(counter-1, files[i].getCanonicalPath());
							File source = new File(files[i].getCanonicalPath());
							File dest = new File(jDirectory+"/images/img"+counter+"."+getFileExtension(source));
							Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
							ImageIcon img = new ImageIcon(""+images.get(counter-1));
							img_buttons.get(counter-1).setIcon(img);
							img_buttons.get(counter-1).setText(files[i].getName());
							img_buttons.get(counter-1).setHorizontalTextPosition(JLabel.CENTER);
							img_buttons.get(counter-1).setVerticalTextPosition(JLabel.BOTTOM);

						} // end try

						catch (java.io.IOException e) {

						}
					}
					// end for: through each dropped file
				} // end filesDropped

			});

			counter++;

			revalidate();

		}
	}

	public class PlayListener1 implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			for (int k = 0; k < counter; k++) {

				if (e.getSource().equals(img_buttons.get(k)) && builders.get(k).toString().equals(sound_buttons.get(k).getText())) {

					try {

						File soundFile = new File(filenames.get(k)); // you could also get the sound file with an URL
						AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);

						// Get a sound clip resource.
						Clip clip = AudioSystem.getClip();

						// Open audio clip and load samples from the audio input stream.
						clip.open(audioIn);
						clip.start();

						getAudioFileNames();
						getRelativePathToAudioFiles();

					} catch (UnsupportedAudioFileException e1) {

						e1.printStackTrace();

					} catch (IOException e1) {

						e1.printStackTrace();

					} catch (LineUnavailableException e1) {

						e1.printStackTrace();

					}

				}

			}

		}

	}

	@Override
	public int getNumberOfAudioButtons() {

		// TODO Auto-generated method stub
		return counter;
	}

	@Override
	public int getNumberOfAudioSets() {

		// TODO Auto-generated method stub
		return counter;
	}

	@Override
	public int getTotalNumberOfButtons() {

		// TODO Auto-generated method stub
		return counter + 1;
	}

	@Override
	public Path getRelativePathToAudioFiles() {

		// TODO Auto-generated method stub
		return RRfilenames;
	}

	@Override
	public String[][] getAudioFileNames() {

		// TODO Auto-generated method stub
		String[][] a = new String[counter][1];

		for (int i = 0; i < counter; i++) {

			a[i][0] = filenames.get(i);

		}

		return a;
	}

	public static void main(String args[]) throws IOException, URISyntaxException{

		TalkBoxConfigurator talkBoxConf = new TalkBoxConfigurator();

	}

	private static String getFileExtension(File file) {

		String fileName = file.getName();

		if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {

			return fileName.substring(fileName.lastIndexOf(".") + 1);
		}

		else return "";

	}

}