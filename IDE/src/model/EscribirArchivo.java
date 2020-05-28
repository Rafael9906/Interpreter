package model;

import java.io.FileWriter;

public class EscribirArchivo {
	
		public void Escribir(String content, String path) {
			
			FileWriter fichero = null;
			try {

				fichero = new FileWriter(path);

				// Escribimos linea a linea en el fichero
					fichero.write(content);
				

				fichero.close();

			} catch (Exception ex) {
				System.out.println("Mensaje de la excepción: " + ex.getMessage());
			}
		}

}
