package ar.uba.fi.celdas7568.ciudad;

import java.util.List;

import ar.uba.fi.celdas7568.ciudad.Opinion;
import ar.uba.fi.celdas7568.ciudad.agentes.*;

public class Simulador {

	Ciudad ciudad;
	
	public void cambiarCiudad(){
		ciudad.generarZonas();
	}
	
	public Simulador(){
		ciudad = new Ciudad();
		ciudad.generarZonas();
		
	}

	public List<ElementoCiudad> simular() {
		
		
		int opcion = 1; 		
		
		List<ElementoCiudad> elementos = null;
		
		Agente agente = null;
		
		switch(opcion){
		case 1: agente = new AgenteSoltero();
		break;
		case 2: agente = new AgentePareja();
		break;
		case 3: agente = new AgenteFamilia();
		break;
		case 4: agente = new AgenteAncianos();
		}
		
		List<Opinion> opinionZonas = agente.elegirZona(ciudad);
		elementos = agente.evaluarOpiniones(opinionZonas);
		elementos.add( new ElementoCiudad(-1,-1, agente.max) );
		elementos.add( new ElementoCiudad(-1,-1, agente.min) );

		return elementos;
	}

}



