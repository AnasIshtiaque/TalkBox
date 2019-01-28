import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.*;
import java.awt.image.BufferedImage;
import java.util.List;
import java.io.*;

public class DragListener implements DropTargetListener {
	
	JLabel imageLabel = new JLabel();
	JLabel pathLabel = new JLabel();

	public DragListener(JLabel image, JLabel path){

	    imageLabel = image;

	    pathLabel = path;

    }

    public void dragEnter(DropTargetDragEvent dtde){


    }

    public void dragOver(DropTargetDragEvent dtde){



    }

    public void dropActionChanged(DropTargetDragEvent dtde){



    }

    public void dragExit(DropTargetEvent dte){



    }

    public void drop(DropTargetDropEvent ev){

	    ev.acceptDrop(DnDConstants.ACTION_COPY);

        Transferable t = ev.getTransferable();

        DataFlavor[] df = t.getTransferDataFlavors();

        for(DataFlavor f:df){

            try{

                if(f.isFlavorJavaFileListType()){

                    List<File> files = (List<File>)t.getTransferData(f);

                    for(File file:files){

                        displayImage(file.getPath());

                    }

                }

            } catch(Exception ex){

                JOptionPane.showMessageDialog(null, ex);

            }
        }
    }

    public void displayImage(String path){

        BufferedImage img = null;
        try{

            img = ImageIO.read(new File(path));

        }catch(Exception e){

        }

        ImageIcon icon = new ImageIcon(img);
        imageLabel.setIcon(icon);
        pathLabel.setText(path);

    }

}
