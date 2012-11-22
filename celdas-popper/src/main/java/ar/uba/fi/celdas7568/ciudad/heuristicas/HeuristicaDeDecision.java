package ar.uba.fi.celdas7568.ciudad.heuristicas;

import java.net.ResponseCache;
import java.util.Iterator;
import java.util.List;

import ar.uba.fi.celdas7568.ciudad.Opinion;
import ar.uba.fi.celdas7568.ciudad.Personalidad;
import ar.uba.fi.celdas7568.ciudad.Zona;

public abstract class HeuristicaDeDecision {

	public double cultura;
	public double diversion;
	public double seguridad;
	public double educacion;
	public double naturaleza;
	public double populoso;
	public double familiar;
	public double tranquilo;
	public double transporte;
	public double barrioExclusivo;
	public double costo;
	
	/**
	 * En base al estado actual de la heuristica y la personalidad pasada como par�metro, genera una opini�n 
	 * sobre la zona pasada como par�metro. Este m�todo no puede modificar el estado de la heuristica
	 * 
	 * @param zona Zona a evaluar
	 * @param personalidad Personalidad del agente
	 * @return Opinion sobre la zona
	 */
	public Opinion evaluarZona(Zona zona, Personalidad personalidad){
		// TODO Auto-generated method stub
		Opinion opinion = new Opinion();
		opinion.respuesta = 0;
		opinion.setZona(zona);
		
		//int cantidad_caracteristicas = 11;
		double dif = Math.pow((personalidad.barrioExclusivo - zona.barrioExclusivo) * this.barrioExclusivo,2);
		dif += Math.pow((personalidad.costo - zona.costo) * this.costo,2);
		dif += Math.pow((personalidad.cultura - zona.cultura) * this.cultura,2);
		dif += Math.pow((personalidad.diversion - zona.diversion) * this.diversion,2);
		dif += Math.pow((personalidad.educacion - zona.educacion) * this.educacion,2);
		dif += Math.pow((personalidad.familiar - zona.familiar) * this.familiar,2);
		dif += Math.pow((personalidad.naturaleza - zona.naturaleza) * this.naturaleza,2);
		dif += Math.pow((personalidad.populoso - zona.populoso) * this.populoso,2);
		dif += Math.pow((personalidad.seguridad - zona.seguridad) * this.seguridad,2);
		dif += Math.pow((personalidad.tranquilo - zona.tranquilo) * this.tranquilo,2);
		dif += Math.pow((personalidad.transporte - zona.transporte) * this.transporte,2);
		
		opinion.respuesta = dif; 
		return opinion;
	}
	/**
	 * Eval�a todas las opiniones obtenidas pasadas como par�metro y selecciona la zona de una de ellas o ninguna
	 * si ninguna es adecuada. Este m�todo no puede modificar el estado de la heuristica
	 * 
	 * @param opiniones opiniones generadas previamente
	 * @param personalidad la personalidad del agente que realiza la evaluaci�n
	 * @return
	 */
	public Zona evaluarOpiniones(List<Opinion> opiniones, Personalidad personalidad){
		
		Iterator<Opinion> o = opiniones.iterator();
		double maximo = 0;
		double resp;
		while(o.hasNext()){
			resp = o.next().respuesta;
			if(resp > maximo){
				maximo = resp;
			}
		}
		
		Iterator<Opinion> iter = opiniones.iterator();
		while(iter.hasNext()){
			Opinion op = iter.next();
			if(op.respuesta == maximo)
				return op.getZona();
		}
		return null;
	}

	/**
	 * En base al estado actual de la heur�stica, y una personalidad de agente, toma una lista de opiniones y modifica
	 * su estado interno con el fin de poder decidir en una evaluaci�n posterior una zona.
	 * 
	 * @param opiniones
	 * @param personalidad
	 */
	public void reconsiderarOpiniones(List<Opinion> opiniones, Personalidad personalidad){

	}
}
