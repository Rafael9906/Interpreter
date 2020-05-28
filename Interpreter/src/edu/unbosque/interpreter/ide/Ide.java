package edu.unbosque.interpreter.ide;
import java.awt.*;
import javax.swing.*;
import org.fife.ui.rtextarea.*;
import org.fife.ui.rsyntaxtextarea.*;

/**
 * A simple example showing how create an "Edit" menu from the same
 * actions used by RSyntaxTextArea.<p>
 *
 * This example uses RSyntaxTextArea 3.0.5.
 */
public class Ide extends JFrame {

    public Ide() {

        JPanel cp = new JPanel(new BorderLayout());

        RSyntaxTextArea textArea = new RSyntaxTextArea(20, 60);
	    textArea.setFont(new Font("Monospaced",Font.PLAIN,20));

        
        //textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        
        try {
	    	  AbstractTokenMakerFactory atmf = (AbstractTokenMakerFactory)TokenMakerFactory.getDefaultInstance();
	    	  atmf.putMapping("text/myLanguage", "Colores.Color");
	    	  textArea.setSyntaxEditingStyle("text/myLanguage");
	      }
	      catch(Exception e) {
	    	  
	      }
        textArea.setCodeFoldingEnabled(true);
        RTextScrollPane sp = new RTextScrollPane(textArea);
        cp.add(sp);

        setJMenuBar(createMenuBar(textArea));

        setContentPane(cp);
        setTitle("IDE");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

    }

    private static JMenuBar createMenuBar(RSyntaxTextArea textArea) {

        JMenuBar menuBar = new JMenuBar();
        
        JMenu fileMenu = new JMenu("File");
        fileMenu.add("New File...");
        fileMenu.add("Open File...");
        fileMenu.add("Save...");
        fileMenu.add("Save As...");

        JMenu editMenu = new JMenu("Edit");
        editMenu.add(createMenuItem(RTextArea.getAction(RTextArea.UNDO_ACTION)));
        editMenu.add(createMenuItem(RTextArea.getAction(RTextArea.REDO_ACTION)));
        editMenu.addSeparator();
        editMenu.add(createMenuItem(RTextArea.getAction(RTextArea.CUT_ACTION)));
        editMenu.add(createMenuItem(RTextArea.getAction(RTextArea.COPY_ACTION)));
        editMenu.add(createMenuItem(RTextArea.getAction(RTextArea.PASTE_ACTION)));
        editMenu.add(createMenuItem(RTextArea.getAction(RTextArea.DELETE_ACTION)));
        editMenu.addSeparator();
        editMenu.add(createMenuItem(RTextArea.getAction(RTextArea.SELECT_ALL_ACTION)));
        
        JMenu runMenu = new JMenu("Run");
        runMenu.add("Run...");
        
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(runMenu);

        return menuBar;
    }

    private static JMenuItem createMenuItem(Action action) {
        JMenuItem item = new JMenuItem(action);
        item.setToolTipText(null); // Swing annoyingly adds tool tip text to the menu item
        return item;
    }

    public static void main(String[] args) {
        // Start all Swing applications on the EDT.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Ide().setVisible(true);
            }
        });
    }

}