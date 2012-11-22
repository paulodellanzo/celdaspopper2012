package ar.uba.fi.celdas7568.ciudad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

public class Ciudad implements Iterable<Zona>{
	
	Multimap<Zona, Agente> agentes = LinkedListMultimap.create();
	//Set<Zona> zonas = Sets.newHashSet();
	List<Zona> zonas;
	
	
	public void agregarAgente(Agente agente){
		//Zona zonaElegida = agente.elegirZona(this);
		//agentes.put(zonaElegida, agente);
		
	}
	
	public void generarZonas(){
		zonas = new ArrayList<Zona>();
		Random r = new Random();
		for(int i = 0; i < 10; i++){
			for(int j = 0; j <10; j++){
			
				Zona unaZona = new Zona();
				unaZona.posicionx = i;
				unaZona.posiciony = j;
				//Generamos valores randoms para los valores de las zonas 
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
				
				//System.out.println("unaZona.barrioExclusivo"+unaZona.barrioExclusivo);
				this.addZona(unaZona);
			}
		}
		
	}

	public double aleatorio(Random r){
		boolean pos = r.nextBoolean();
		if(pos){
			return r.nextDouble();
		}
		else
			return (-1)*r.nextDouble();
	}
	public Iterator<Zona> iterator() {
		return zonas.iterator();
	}
	
	public void addZona(Zona zona){
		this.zonas.add(zona);
	}
	
	public Collection<Agente> getAgentesEnZona(Zona zona){
		return agentes.get(zona);
	}

}
