package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

import org.fife.ui.rsyntaxtextarea.AbstractTokenMakerFactory;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.TokenMakerFactory;
import org.fife.ui.rtextarea.RTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;

import controller.Controller;

public class Panel extends JPanel{
	
	public Frame frame;
	public JMenu fileMenu,runMenu;
	public JMenuItem nFile,oFile,save,saveA,run,exit;
	public RSyntaxTextArea textArea;
	
	public Panel(Frame frame) {
		this.frame = frame;
		initComponents(frame);
	}
		
	public void initComponents(Frame frame) {
		 	JPanel cp = new JPanel(new BorderLayout());

	        textArea = new RSyntaxTextArea(20, 60);
		    textArea.setFont(new Font("Monospaced",Font.PLAIN,20));

	        //textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
	        
	        try {
		    	  AbstractTokenMakerFactory atmf = (AbstractTokenMakerFactory)TokenMakerFactory.getDefaultInstance();
		    	  atmf.putMapping("text/myLanguage", "model.Color");
		    	  textArea.setSyntaxEditingStyle("text/myLanguage");
		      }catch(Exception e) {}
	        
	        textArea.setCodeFoldingEnabled(true);
	        RTextScrollPane sp = new RTextScrollPane(textArea);
	        cp.add(sp);

	        frame.setJMenuBar(createMenuBar(textArea));

	        frame.setContentPane(cp);
	        frame.setTitle("IDE");
	        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	        frame.pack();
	        frame.setLocationRelativeTo(null);
	       
	}
	
	public JMenuBar createMenuBar(RSyntaxTextArea textArea) {

        JMenuBar menuBar = new JMenuBar();
        
        fileMenu = new JMenu("File");
        
        nFile = new JMenuItem("New File...");

        oFile = new JMenuItem("Open File...");
        save = new JMenuItem("Save..");
        saveA = new JMenuItem("Save As...");
        exit = new JMenuItem("Exit");
        
        fileMenu.add(nFile);
        fileMenu.add(oFile);
        fileMenu.add(save);
        fileMenu.add(saveA);
        fileMenu.addSeparator();
        fileMenu.add(exit);
        
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
        
        runMenu = new JMenu("Run");
        run = new JMenuItem("Run...");
        runMenu.add(run);
        
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(runMenu);	
        
        //addFont(fileMenu);
        addShortCut();
        addAction();

        return menuBar;
    }
	
	public void addAction() {
		Controller c = new Controller(this);
		
		nFile.addActionListener(c);
		oFile.addActionListener(c);
		save.addActionListener(c);
		saveA.addActionListener(c);
		run.addActionListener(c);
		exit.addActionListener(c);
	}
	
	public void addShortCut() {
        nFile.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.Event.CTRL_MASK));
        oFile.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.Event.CTRL_MASK));
        save.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.Event.CTRL_MASK));
        saveA.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.Event.CTRL_MASK));
        exit.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.Event.CTRL_MASK));
        run.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_SPACE, java.awt.Event.CTRL_MASK));
	}
	
	public void addFont(JMenu fileMenu) {
		Font f = new Font(fileMenu.getFont().getFontName(), fileMenu.getFont().getStyle(), 15);
	    nFile.setFont(f);
	}

    private static JMenuItem createMenuItem(Action action) {
        JMenuItem item = new JMenuItem(action);
        item.setToolTipText(null);
        return item;
    }
	
}