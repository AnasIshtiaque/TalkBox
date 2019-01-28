import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.io.File;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.TransferHandler;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Testpanel {

    public static void main(String[] args) {
        new Testpanel();
    }

    public Testpanel() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new GridLayout(5, 5));
            for (int index = 0; index < 5 * 5; index++) {
                JButton btn = new JButton("Drop here");
                btn.setVerticalTextPosition(JButton.BOTTOM);
                btn.setHorizontalTextPosition(JButton.CENTER);
                btn.setTransferHandler(new ImageTransferHandler());
                add(btn);
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
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
                            List files = (List) t.getTransferData(DataFlavor.javaFileListFlavor);
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