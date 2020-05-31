package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JTabbedPane;

import edu.unbosque.interpreter.main.Main;
import model.Ejecutar;
import model.EscribirArchivo;
import model.LeerArchivo;
import view.Frame;
import view.Panel;

public class Controller implements ActionListener{
	
	Panel panel;
	LeerArchivo leer;
	EscribirArchivo escribir;
	String ruta;
	
	public Controller(Panel panel) {	
		this.panel = panel;	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==panel.nFile) {
			 panel.textArea.setText("");
			 ruta = null;
		}
		
		if(e.getSource()==panel.oFile) {
			JFileChooser jf = new JFileChooser();
			jf.showOpenDialog(null);
			
			leer = new LeerArchivo();
			ruta = jf.getSelectedFile().getAbsolutePath();
			
			String contenido = leer.leerTexto(ruta);
			panel.textArea.setText(contenido);	
		}
		
		if(e.getSource()==panel.save) {
			if(ruta!=null) {
				escribir = new EscribirArchivo();
				escribir.Escribir(panel.textArea.getText(),ruta);
			}
			else {
				JFileChooser jf = new JFileChooser();
				jf.showSaveDialog(null);
				
				leer = new LeerArchivo();
				ruta = jf.getSelectedFile().getAbsolutePath();
				
				escribir = new EscribirArchivo();
				escribir.Escribir(panel.textArea.getText(),ruta);
				
			}
			
		}
		
		if(e.getSource()==panel.saveA) {
			
			JFileChooser jf = new JFileChooser();
			jf.showSaveDialog(null);
			
			leer = new LeerArchivo();
			ruta = jf.getSelectedFile().getAbsolutePath();
			
			escribir = new EscribirArchivo();
			escribir.Escribir(panel.textArea.getText(),ruta);
			
		}
		
		if(e.getSource()==panel.exit) {
			System.exit(1);
		}
		
		if(e.getSource()==panel.run) {
			Main m = new Main();
			
			if(ruta == null) {
				JFileChooser jf = new JFileChooser();
				jf.showOpenDialog(null);
				
				leer = new LeerArchivo();
				ruta = jf.getSelectedFile().getAbsolutePath();
			}
			
				
			try {
				m.main(ruta);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}

}
