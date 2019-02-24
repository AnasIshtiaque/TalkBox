import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TalkBoxConfigurator extends JFrame implements TalkBoxConfiguration{
	static ArrayList<JTextArea> c = new ArrayList<JTextArea>();
	ArrayList<JButton> buttons = new ArrayList<JButton>();
	List<String> filenames = new ArrayList<String>();
	String RRfilename = new String();
	Path RRfilenames;
	StringBuilder builder = new StringBuilder();
	int filecounter;
	int counter = 0;
	String filename = "";
	ArrayList<StringBuilder> builders = new ArrayList<StringBuilder>();

	public TalkBoxConfigurator() {
		JPanel a = new JPanel();
		a.setVisible(true);
		a.setSize(300, 200);
		add(a);
		setVisible(true);
		setSize(300, 200);
		setLayout(new GridLayout(1, 1, 1, 1));

		JButton button = new JButton("Add");
		a.add(button);

		button.addActionListener(new PlayListener());

	}

	public class PlayListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			builder = new StringBuilder();
			buttons.add(new JButton("Drag image file... "));
			buttons.get(counter).setTransferHandler(new TalkBoxConfigurator.ImageTransferHandler());
			add(buttons.get(counter));
			buttons.get(counter).addActionListener(new PlayListener1());
			c.add(new JTextArea());

			getContentPane().add(new javax.swing.JScrollPane(c.get(counter)), java.awt.BorderLayout.CENTER);

			new FileDrop(System.out, c.get(counter), /* dragBorder, */ new FileDrop.Listener() {
				public void filesDropped(java.io.File[] files) {
					for (int i = 0; i < files.length; i++) {
						try {
							c.get(counter - 1).append(files[i].getCanonicalPath() + "\n");
							// filecounter = files.length;
							// a.append(files[i].getCanonicalPath()+"\n");
							builder.append(files[i].getCanonicalPath() + "\n");
							filename = "" + files[i].getCanonicalPath();
							RRfilenames = files[i].toPath().getParent();
							filenames.add(filename);
							builders.add(builder);
								
						} // end try
						catch (java.io.IOException e) {
						}
					}
					// end for: through each dropped file
				} // end filesDropped
			}); // end FileDrop.Listener
			// filename = builder.toString();
			System.out.println(RRfilenames);

			counter++;

			revalidate();

		}
	}

	public class PlayListener1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// System.out.println(filename);
			for (int k = 0; k < counter; k++) {
				if (e.getSource().equals(buttons.get(k)) && builders.get(k).toString().equals(c.get(k).getText())) {
					try {
						File soundFile = new File(filenames.get(k)); // you could also get the sound file with an URL
						AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
						// Get a sound clip resource.
						Clip clip = AudioSystem.getClip();
						// Open audio clip and load samples from the audio input stream.
						clip.open(audioIn);
						clip.start();
						// System.out.println(c.get(k).getText());
						System.out.println(builder.toString().equals(c.get(k).getText()));

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

	public static class ImageTransferHandler extends TransferHandler {

		public static final DataFlavor[] SUPPORTED_DATA_FLAVORS = new DataFlavor[] { DataFlavor.javaFileListFlavor,
				DataFlavor.imageFlavor };

		@Override
		public boolean canImport(TransferHandler.TransferSupport support) {
			boolean canImport = false;
			for (DataFlavor flavor : SUPPORTED_DATA_FLAVORS) {
				if (support.isDataFlavorSupported(flavor)) {
					canImport = true;
					break;
				}
			}
			return canImport;
		}

		@Override
		public boolean importData(TransferHandler.TransferSupport support) {
			boolean accept = false;
			if (canImport(support)) {
				try {
					Transferable t = support.getTransferable();
					Component component = support.getComponent();
					if (component instanceof JButton) {
						Image image = null;
						if (support.isDataFlavorSupported(DataFlavor.imageFlavor)) {
							image = (Image) t.getTransferData(DataFlavor.imageFlavor);
						} else if (support.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
							java.util.List files = (List) t.getTransferData(DataFlavor.javaFileListFlavor);
							if (files.size() > 0) {
								image = ImageIO.read((File) files.get(0));
							}
						}
						ImageIcon icon = null;
						if (image != null) {
							icon = new ImageIcon(image);
						}
						((JButton) component).setIcon(icon);
						accept = true;
					}
				} catch (Exception exp) {
					exp.printStackTrace();
				}
			}
			return accept;
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
		String[][] a =new String[counter][];
		for (int i = 0; i<counter; i++) {
			
			a[i][0]=filenames.get(i);
			
		}
		return a;
	}

}
