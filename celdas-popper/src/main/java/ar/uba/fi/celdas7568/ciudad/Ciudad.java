package ar.uba.fi.celdas7568.ciudad;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Ciudad implements Iterable<Zona>{
	
	List<Zona> zonas;

	public void importarZonas(){
		
		File file = new File("src/main/java/ar/uba/fi/celdas7568/ciudad/ciudad.csv");
        BufferedReader reader = null;
        zonas = new ArrayList<Zona>();
 
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = null;
 
            line=reader.readLine();
            while ((line = reader.readLine()) != null) {
            	String[] fields = line.replace(",", ".").split(";"); 
            	Zona unaZona = new Zona();
    			unaZona.posicionx = Integer.parseInt(fields[0]);
    			unaZona.posiciony = Integer.parseInt(fields[1]);
    			unaZona.barrioExclusivo = Double.parseDouble(fields[2]);
    			unaZona.costo  = Double.parseDouble(fields[3]);
    			unaZona.cultura  = Double.parseDouble(fields[4]);
    			unaZona.diversion  = Double.parseDouble(fields[5]);
    			unaZona.educacion = Double.parseDouble(fields[6]);
    			unaZona.familiar  = Double.parseDouble(fields[7]);
    			unaZona.naturaleza  = Double.parseDouble(fields[8]);
    			unaZona.populoso  = Double.parseDouble(fields[9]);
    			unaZona.seguridad   = Double.parseDouble(fields[10]);
    			unaZona.tranquilo  = Double.parseDouble(fields[11]);
    			unaZona.transporte  = Double.parseDouble(fields[12]);
            	this.addZona(unaZona);	
            }	
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
		
		
	}
	
	public void generarZonas(){
		zonas = new ArrayList<Zona>();
		Random r = new Random();
		for(int i = 0; i < 10; i++){
			for(int j = 0; j <10; j++){
			
				Zona unaZona = new Zona();
				unaZona.posicionx = i;
				unaZona.posiciony = j;
				unaZona.barrioExclusivo = aleatorio(r);
				unaZona.costo = aleatorio(r);
				unaZona.cultura = aleatorio(r);
				unaZona.diversion = aleatorio(r);
				unaZona.educacion = aleatorio(r);
				unaZona.familiar = aleatorio(r);
				unaZona.naturaleza = aleatorio(r);
				unaZona.populoso = aleatorio(r);
				unaZona.seguridad = aleatorio(r);
				unaZona.tranquilo = aleatorio(r);
				unaZona.transporte = aleatorio(r);
				
				this.addZona(unaZona);
			}
		}
		
	}

	public double aleatorio(Random r){
		Double aleatorio= r.nextDouble()*5;
		return aleatorio;

	}
	public Iterator<Zona> iterator() {
		return zonas.iterator();
	}
	
	public void addZona(Zona zona){
		this.zonas.add(zona);
	}
	
}
