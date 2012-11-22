package ar.uba.fi.celdas7568.ciudad;

import ar.uba.fi.celdas7568.ciudad.heuristicas.HeuristicaDeDecision;
import ar.uba.fi.celdas7568.ciudad.heuristicas.HeuristicaSoltero;

public class SimularAgentesMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Hola mundo");
		Agente soltero = new Agente();
		Personalidad solteria = new Personalidad();
		solteria.barrioExclusivo = 0;
		solteria.costo = 0.5;
		solteria.cultura = -0.75;
		solteria.diversion = 1;
		solteria.educacion = 0;
		solteria.familiar = -0.5;
		solteria.naturaleza = 0.5;
		solteria.populoso = 0.75;
		solteria.seguridad = -0.5;
		solteria.tranquilo = -1;
		solteria.transporte = 0.75;
		soltero.setPersonalidad(solteria);
		
		HeuristicaDeDecision heusoltero = new HeuristicaSoltero();
		soltero.setHeuristicaDeDesicion(heusoltero);
		
		Ciudad city = new Ciudad();
		city.generarZonas();
		
		Zona zonapreferidaSoltero = soltero.elegirZona(city);
		
		System.out.println("Valor elegido como el mejor:" +
		"Punto X:" + zonapreferidaSoltero.posicionx + 
		"Punto Y:" + zonapreferidaSoltero.posiciony );
		
	}

}



