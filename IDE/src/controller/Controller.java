package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import model.EscribirArchivo;
import model.LeerArchivo;
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
		
		if(e.getSource()==panel.oFile) {
			JFileChooser jf = new JFileChooser();
			jf.showOpenDialog(null);
			
			leer = new LeerArchivo();
			ruta = jf.getSelectedFile().getAbsolutePath();
			
				String contenido = leer.leerTexto(ruta);
				panel.textArea.setText(contenido);
				
		}
		
		if(e.getSource()==panel.save) {
			escribir = new EscribirArchivo();
			escribir.Escribir(panel.textArea.getText(),ruta);
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
		
	}

}
