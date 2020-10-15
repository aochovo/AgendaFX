/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg001proyectohilos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author FP Mañana A
 */
class AccesoFichero {

    static void ingresarContacto(Contacto c, String ruta) {
        String separador=",";
        try {
			FileWriter fw=new FileWriter(ruta, true);
			String linea=c.getNombre()+separador+c.getApellido()+separador+c.getTelefono()+"\n";
			fw.write(linea);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    static ArrayList<Contacto> leerContactos(String ruta)
    {
        ArrayList<Contacto> lista=new ArrayList<>();
        FileReader fr=null;
		try {
			fr=new FileReader(ruta);
			BufferedReader br=new BufferedReader(fr);
			String linea=br.readLine();
			while(linea!=null)
			{
				String[] datos=linea.split(",");
				Contacto c=new Contacto(datos[0], datos[1], datos[2]);
				lista.add(c);
				linea=br.readLine();
				
			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       return lista; 
    }
    }
    

