package ar.uba.fi.celdas7568.ciudad;


import java.util.List;

import ar.uba.fi.celdas7568.ciudad.Opinion;
import ar.uba.fi.celdas7568.ciudad.agentes.*;

public class Simulador {

	Ciudad ciudad;
	Agente agente;
	int agenteActual;
	

	public String proximoAgente() {
		if (agenteActual==4)
			agenteActual=1;
		else
			agenteActual++;
		return cambiarAgente(agenteActual);
		
	}
	
	public String cambiarAgente(int opcion){
		switch(opcion){
		case 1: agente = new AgenteSoltero();
		return "Soltero";
		case 2: agente = new AgentePareja();
		return "Pareja";
		case 3: agente = new AgenteFamilia();
		return "Familia";
		case 4: agente = new AgenteAncianos();
		return "Ancianos";
		}
		return "";
		
	}
	
	public String nombreAgente(){
		switch(agenteActual){
		case 1: return "Soltero";
		case 2: return "Pareja";
		case 3: return "Familia";
		case 4: return "Ancianos";
		}
		return "";
	}
	
	public void cambiarCiudad(){
		ciudad.importarZonas();
	}
	
	public void escribirHistorial(String historial){
		java.io.PrintStream ps;
		try {
			ps = new java.io.PrintStream( new java.io.FileOutputStream("historial.csv", true));
			ps.println(historial);
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Simulador(){
		ciudad = new Ciudad();
		ciudad.importarZonas();
		agenteActual=0;
		proximoAgente();
	}

	public List<ElementoCiudad> simular() {
			
		
		List<ElementoCiudad> elementos = null;
		
		List<Opinion> opinionZonas = agente.elegirZona(ciudad);
		elementos = agente.evaluarOpiniones(opinionZonas);
		elementos.add( new ElementoCiudad(-1,-1, agente.max) );
		elementos.add( new ElementoCiudad(-1,-1, agente.min) );

		agente.aprender(ciudad);
		
		return elementos;
	}

	public Agente getAgente() {

		return agente;
	}
	

	
}



