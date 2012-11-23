package ar.uba.fi.celdas7568.ciudad;

import java.util.Iterator;
import java.util.List;

import ar.uba.fi.celdas7568.ciudad.Opinion;
import ar.uba.fi.celdas7568.ciudad.heuristicas.HeuristicaAncianos;
import ar.uba.fi.celdas7568.ciudad.heuristicas.HeuristicaDeDecision;
import ar.uba.fi.celdas7568.ciudad.heuristicas.HeuristicaFamilia;
import ar.uba.fi.celdas7568.ciudad.heuristicas.HeuristicaPareja;

import ar.uba.fi.celdas7568.ciudad.heuristicas.HeuristicaSoltero;
import java.util.*;
public class SimularAgentes {

	/**
	 * @param args
	 */
	public static List<ElementoCiudad> simular() {
		
		
		int opcion = 1; //Extremadamente rustico
		
		//Descomentar si se quiere agregar input de usuario
		
		/*
		System.out.print( "Elija opcion: " );

	    Scanner scanner = new Scanner( System.in );

        // Read a line of text from the user.
        String input = scanner.nextLine();

        // Display the input back to the user.
        System.out.println( "input = " + input );

        int number = Integer.parseInt( input );  // converts a String into an int value

		opcion = number;
		*/
		
		
		List<ElementoCiudad> elementos = null;
		
		if (opcion == 1) {
			System.out.println("Simulacion para Soltero");
			Agente agente = new Agente();
			Personalidad personalidad = new Personalidad();
			personalidad.barrioExclusivo = 0;
			personalidad.costo = 0.5;
			personalidad.cultura = -0.75;
			personalidad.diversion = 1;
			personalidad.educacion = 0;
			personalidad.familiar = -0.5;
			personalidad.naturaleza = 0.5;
			personalidad.populoso = 0.75;
			personalidad.seguridad = -0.5;
			personalidad.tranquilo = -1;
			personalidad.transporte = 0.75;
			agente.setPersonalidad(personalidad);

			HeuristicaDeDecision heuristica = new HeuristicaSoltero();
			agente.setHeuristicaDeDecision(heuristica);

			Ciudad city = new Ciudad();
			city.generarZonas();

			List<Opinion> opinionZonas = agente.elegirZona(city);
			elementos = agente.getHeuristicaDeDecision().evaluarOpiniones(opinionZonas);
			elementos.add( new ElementoCiudad(-1,-1, agente.getHeuristicaDeDecision().max) );
			elementos.add( new ElementoCiudad(-1,-1, agente.getHeuristicaDeDecision().min) );
		}

		if (opcion == 2) {
			System.out.println("Simulacion para Pareja");
			Agente agente = new Agente();
			Personalidad personalidad = new Personalidad();
			personalidad.barrioExclusivo = 0.5;
			personalidad.costo = 0.25;
			personalidad.cultura = 0.5;
			personalidad.diversion = 0.5;
			personalidad.educacion = -0.5;
			personalidad.familiar = 0;
			personalidad.naturaleza = 0.75;
			personalidad.populoso = 1;
			personalidad.seguridad = 0.5;
			personalidad.tranquilo = -0.75;
			personalidad.transporte = 0;
			agente.setPersonalidad(personalidad);

			HeuristicaDeDecision heuristica = new HeuristicaPareja();
			agente.setHeuristicaDeDecision(heuristica);

			Ciudad city = new Ciudad();
			city.generarZonas();

			List<Opinion> opinionZonas = agente.elegirZona(city);
			elementos = agente.getHeuristicaDeDecision().evaluarOpiniones(opinionZonas);
			elementos.add( new ElementoCiudad(-1,-1, agente.getHeuristicaDeDecision().max) );
			elementos.add( new ElementoCiudad(-1,-1, agente.getHeuristicaDeDecision().min) );
		}
		if (opcion == 3) {
			System.out.println("Simulacion para Familia");
			Agente agente = new Agente();
			Personalidad personalidad = new Personalidad();
			personalidad.barrioExclusivo = 1;
			personalidad.costo = -0.5;
			personalidad.cultura = 0;
			personalidad.diversion = -0.25;
			personalidad.educacion = 1;
			personalidad.familiar = 1;
			personalidad.naturaleza = 0.25;
			personalidad.populoso = -0.5;
			personalidad.seguridad = 0.75;
			personalidad.tranquilo = 0.5;
			personalidad.transporte = -0.25;
			agente.setPersonalidad(personalidad);

			HeuristicaDeDecision heuristica = new HeuristicaFamilia();
			agente.setHeuristicaDeDecision(heuristica);

			Ciudad city = new Ciudad();
			city.generarZonas();

			List<Opinion> opinionZonas = agente.elegirZona(city);
			elementos = agente.getHeuristicaDeDecision().evaluarOpiniones(opinionZonas);
			elementos.add( new ElementoCiudad(-1,-1, agente.getHeuristicaDeDecision().max) );
			elementos.add( new ElementoCiudad(-1,-1, agente.getHeuristicaDeDecision().min) );
		}

		if (opcion == 4) {
			System.out.println("Simulacion para Ancianos");
			Agente agente = new Agente();
			Personalidad personalidad = new Personalidad();
			personalidad.barrioExclusivo = -0.5;
			personalidad.costo = -0.25;
			personalidad.cultura = 1;
			personalidad.diversion = -1;
			personalidad.educacion = -0.75;
			personalidad.familiar = -0.5;
			personalidad.naturaleza = 0.75;
			personalidad.populoso = -0.75;
			personalidad.seguridad = 0.5;
			personalidad.tranquilo = 1;
			personalidad.transporte = 0;
			agente.setPersonalidad(personalidad);

			HeuristicaDeDecision heuristica = new HeuristicaAncianos();
			agente.setHeuristicaDeDecision(heuristica);

			Ciudad city = new Ciudad();
			city.generarZonas();

			List<Opinion> opinionZonas = agente.elegirZona(city);
			elementos = agente.getHeuristicaDeDecision().evaluarOpiniones(opinionZonas);			
			elementos.add( new ElementoCiudad(-1,-1, agente.getHeuristicaDeDecision().max) );
			elementos.add( new ElementoCiudad(-1,-1, agente.getHeuristicaDeDecision().min) );
						
			//new Frame( elementos, agente.getHeuristicaDeDecision().max, agente.getHeuristicaDeDecision().min );
			
			//CreadorCiudad crea = new CreadorCiudad(elementos,
			//		agente.getHeuristicaDeDecision().max,
			//		agente.getHeuristicaDeDecision().min);
			//crea.crearCiudad();
		}
		
		return elementos;
	}

}



