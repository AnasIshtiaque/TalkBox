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
import java.nio.file.Path;
import java.security.CodeSource;
import java.util.ArrayList;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TalkBoxConfigurator extends JFrame implements TalkBoxConfiguration {
	
	private JButton buttonRecord = new JButton("Record");
	public static SoundRecordingUtil recorder = new SoundRecordingUtil();
	private boolean isRecording = false;

	// Icons used for buttons
	private ImageIcon iconRecord = new ImageIcon(getClass().getResource("Record.gif"));
	private ImageIcon iconStop = new ImageIcon(getClass().getResource("Stop.gif"));
	static ArrayList<JButton> sound_buttons = new ArrayList<JButton>();
	static ArrayList<JButton> img_buttons = new ArrayList<JButton>();
	ConfiguratorController cc = new ConfiguratorController();
	static StringBuilder builder = new StringBuilder();
	
	public static int counter = 0;
	static int RecordCounter = 0;
	int height = 300;
	int width = 600;

	public TalkBoxConfigurator() throws URISyntaxException, IOException {

		super("Configuration Window");
		cc.createDirectories();
		JPanel a = new JPanel();
		a.setLayout(new BoxLayout(a, 1));
		add(a);
		setVisible(true);
		setSize(width, height);
		setLayout(new GridLayout(1, 1));
		JButton button = new JButton("Add Button");
		a.add(button);
		button.addActionListener(new PlayListener());
		JButton reset = new JButton("Reset");
		reset.addActionListener(new PlayListener4());
		a.add(buttonRecord);
		a.add(reset);
		buttonRecord.setIcon(iconRecord);

		// add(buttonRecord);
		buttonRecord.addActionListener(new PlayListener2());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public class PlayListener4 implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
			cc.resetDirectories();
			dispose();

		}
		
	}

	public class PlayListener2 implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
			JButton button = (JButton) event.getSource();
			
			if (button == buttonRecord) {
				
				if (!isRecording) {
					
					startRecording();
					setSize(width += 80, height);
					img_buttons.add(new JButton("Drag image file... "));
					add(img_buttons.get(counter));
					sound_buttons.add(new JButton("Press "));
					sound_buttons.get(counter).addActionListener(new PlayListener3());
					getContentPane().add(new javax.swing.JScrollPane(sound_buttons.get(counter)), java.awt.BorderLayout.CENTER);

					new FileDrop(System.out, img_buttons.get(counter), /* dragBorder, */ new FileDrop.Listener() {

						public void filesDropped(java.io.File[] files) {

							for (int i = 0; i < files.length; i++) {

								try {
									
									cc.imagesFileDrop(files, i);
									ImageIcon img = new ImageIcon("" + cc.images.get(counter - 1));
									img_buttons.get(counter - 1).setIcon(img);
									img_buttons.get(counter - 1).setText(files[i].getName());
									img_buttons.get(counter - 1).setHorizontalTextPosition(JLabel.CENTER);
									img_buttons.get(counter - 1).setVerticalTextPosition(JLabel.BOTTOM);

								} // end try

								catch (java.io.IOException e) {

								}
								
							}
							
							// end for: through each dropped file
						} // end filesDropped

					});

				} else {
					
					stopRecording();

				}
				
			}

		}

		private void startRecording() {
			
			Thread recordThread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					
					try {
						
						isRecording = true;
						buttonRecord.setText("Stop");
						buttonRecord.setIcon(iconStop);

						recorder.start();

					} catch (LineUnavailableException ex) {
						

						ex.printStackTrace();
						
					}
					
				}
				
			});
			
			recordThread.start();

		}

		/**
		 * Stop recording and save the sound into a WAV file
		 */
		private void stopRecording() {
			
			isRecording = false;
			
			try {
				
				buttonRecord.setText("Record");
				buttonRecord.setIcon(iconRecord);
				setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				recorder.stop();
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				saveFile();

			} catch (IOException ex) {

				ex.printStackTrace();
				
			}
			
		}

		/**
		 * Save the recorded sound into a WAV file.
		 */
		private void saveFile() {
		
			cc.save();
			RecordCounter++;
			counter++;
			
		}
		
	}

	public class PlayListener3 implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			System.out.println(ConfiguratorController.saveFilePaths.get(0));
			
			for (int k = 0; k < counter; k++) {
				
				for (int j = 0; j < RecordCounter; j++) {
					
					if (e.getSource().equals(sound_buttons.get(k)) && cc.filenames.get(k).equals(ConfiguratorController.saveFilePaths.get(j))) {

						try {

							File soundFile = new File(ConfiguratorController.saveFilePaths.get(j)); // you could also get the sound file with
																				// an URL
							AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
							System.out.println(ConfiguratorController.saveFilePaths.get(j));
							
							// Get a sound clip resource.
							Clip clip = AudioSystem.getClip();
							// Open audio clip and load samples from the audio input stream.
							clip.open(audioIn);
							clip.start();
							getAudioFileNames();
							
							// getRelativePathToAudioFiles();

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

	}

	public class PlayListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			
			// int NewCounter = counter+RecordCounter;
			setSize(width += 80, height);
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
							
							cc.audioFileDrop(files, i);
							File source = new File(files[i].getCanonicalPath());
							sound_buttons.get(counter - 1).setText(files[i].getName());
							sound_buttons.get(counter - 1).setIcon(new ImageIcon("icon/sound.png"));
							sound_buttons.get(counter - 1).setHorizontalTextPosition(JLabel.CENTER);
							sound_buttons.get(counter - 1).setVerticalTextPosition(JLabel.BOTTOM);
							sound_buttons.get(counter - 1).addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									
									try {
										
										AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(source);
										Clip clip = AudioSystem.getClip();
										clip.open(audioInputStream);
										clip.start();
										
									} catch (Exception e1) {
										
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
							
							cc.imageFileDrop(files, i);
							ImageIcon img = new ImageIcon("" + cc.images.get(counter - 1));
							img_buttons.get(counter - 1).setIcon(img);
							img_buttons.get(counter - 1).setText(files[i].getName());
							img_buttons.get(counter - 1).setHorizontalTextPosition(JLabel.CENTER);
							img_buttons.get(counter - 1).setVerticalTextPosition(JLabel.BOTTOM);

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

				if (e.getSource().equals(sound_buttons.get(k))
						&& cc.builders.get(k).toString().equals(sound_buttons.get(k).getText())) {

					try {

						File soundFile = new File(cc.filenames.get(k)); // you could also get the sound file with an URL
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

		return counter;
		
	}

	@Override
	public int getNumberOfAudioSets() {

		return counter;
	}

	@Override
	public int getTotalNumberOfButtons() {

		return counter + 1;
	}

	@Override
	public Path getRelativePathToAudioFiles() {

		return cc.RRfilenames;
	}

	public static void main(String args[]) throws IOException, URISyntaxException {

		TalkBoxConfigurator talkBoxConf = new TalkBoxConfigurator();

        // Add window listener by implementing WindowAdapter class to
        // the frame instance. To handle the close event we just need
        // to implement the windowClosing() method.
		talkBoxConf.addWindowListener(new WindowAdapter() {
			
            @Override
            public void windowClosing(WindowEvent e) {
            	
        		File dir = new File(ConfiguratorController.jDirectory);
        		
        		if(dir.isDirectory() == false) {
        			
        			System.out.println("Not a directory. Do nothing");
        			return;
        			
        		}
        		
        		File[] listFiles = dir.listFiles();
        		
        		for(File file : listFiles){
        			
        			System.out.println("Deleting "+file.getName());
        			file.delete();
        			
        		}
        		
        		//now directory is empty, so we can delete it
        		dir.delete();
        		
            	System.exit(0);
                
            }
            
        });

        // Show the frame
		talkBoxConf.setVisible(true);

	}


	@Override
	public String[][] getAudioFileNames() {
		
		return null;
		
	}

}