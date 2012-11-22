package ar.uba.fi.celdas7568.ciudad;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreadorCiudad {
	
	private List<ElementoCiudad> elementos;
	private double max;
	private double min;
	
	public CreadorCiudad(List<ElementoCiudad> e, double maximo, double minimo){
		max = maximo;
		min = minimo;
		elementos = e;
	}
	
	public void crearCiudad(){
		
		Iterator<ElementoCiudad> iter = elementos.iterator();
		while(iter.hasNext()){
			
			ElementoCiudad e = iter.next();
			//hacer lo que hay q hacer 
			
			
			
			
			
		}
		
	}
	
}
