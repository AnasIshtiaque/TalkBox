import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DropTarget;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TalkBoxConfigurator extends JFrame {

   ArrayList<JButton> buttons = new ArrayList<JButton>();
   int counter = 0;

    public TalkBoxConfigurator() {

        setVisible(true);
        setSize(300,200);
        setLayout(new GridLayout(2,1,4,4));

        JButton button = new JButton("Add");
        add(button);

        button.addActionListener(new PlayListener());

    }

    public class PlayListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            buttons.add(new JButton("button" + counter));
            buttons.get(counter).setTransferHandler(new TalkBoxConfigurator.ImageTransferHandler());
            add(buttons.get(counter));
            counter++;
            revalidate();
        }
    }

    public static class ImageTransferHandler extends TransferHandler {

        public static final DataFlavor[] SUPPORTED_DATA_FLAVORS = new DataFlavor[]{
                DataFlavor.javaFileListFlavor,
                DataFlavor.imageFlavor
        };

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

}
