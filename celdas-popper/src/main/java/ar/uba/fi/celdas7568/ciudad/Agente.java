package ar.uba.fi.celdas7568.ciudad;

import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;

public class Agente {
	
	
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
	
	public double importanciaCultura;
	public double importanciaDiversion;
	public double importanciaSeguridad;
	public double importanciaEducacion;
	public double importanciaNaturaleza;
	public double importanciaPopuloso;
	public double importanciaFamiliar;
	public double importanciaTranquilo;
	public double importanciaTransporte;
	public double importanciaBarrioExclusivo;
	public double importanciaCosto;
	
	public double max;
	public double min;
	
		
	public List<Opinion> elegirZona(Ciudad ciudad){

			List<Opinion> opiniones = Lists.newArrayList();
			
			for(Zona zona : ciudad){
				Opinion opinionSobreZona = evaluarZona(zona);
				opiniones.add(opinionSobreZona);
			}
			
		return opiniones;		
	}
	
	public Opinion evaluarZona(Zona zona){
		Opinion opinion = new Opinion();
		opinion.respuesta = 0;
		opinion.setZona(zona);
		
		//int cantidad_caracteristicas = 11;
		double dif = Math.pow((barrioExclusivo - zona.barrioExclusivo) * this.barrioExclusivo,2);
		dif += Math.pow((costo - zona.costo) * importanciaCosto,2);
		dif += Math.pow((cultura - zona.cultura) * importanciaCultura,2);
		dif += Math.pow((diversion - zona.diversion) * importanciaDiversion,2);
		dif += Math.pow((educacion - zona.educacion) * importanciaEducacion,2);
		dif += Math.pow((familiar - zona.familiar) * importanciaFamiliar,2);
		dif += Math.pow((naturaleza - zona.naturaleza) * importanciaNaturaleza,2);
		dif += Math.pow((populoso - zona.populoso) * importanciaPopuloso,2);
		dif += Math.pow((seguridad - zona.seguridad) * importanciaSeguridad,2);
		dif += Math.pow((tranquilo - zona.tranquilo) * importanciaTranquilo,2);
		dif += Math.pow((transporte - zona.transporte) * importanciaTransporte,2);
		
		opinion.respuesta = 300-dif; 
		return opinion;
	}

	
	public List<ElementoCiudad> evaluarOpiniones(List<Opinion> opiniones){
		
		Iterator<Opinion> iter = opiniones.iterator();
		max = -99999999;
		min = 99999999;
		Zona mejor = null;
		List<ElementoCiudad> elementos = Lists.newArrayList();
		
		while(iter.hasNext()){
			
			Opinion op = iter.next();
			if(op.respuesta > max){
				max = op.respuesta;
				mejor = op.getZona();
			}
			if(op.respuesta < min){
				min = op.respuesta;
				
			}
			elementos.add(new ElementoCiudad(op.getZona().posicionx,op.getZona().posiciony,op.respuesta));
			//Aca en vez de los prints tendria que estar la llamada a un metodo de la clase
			//Colorear ciudad que se ocupe de ir pintando segun alguna logica
			System.out.println("Zona en X: " + op.getZona().posicionx + " Y: " + op.getZona().posiciony);
			System.out.println("Tiene un puntaje de: " + op.respuesta);
			
		}
		System.out.println("\n"+"La mejor zona tiene un puntaje de: " + max);
		System.out.println("Esta ubicada en el punto X: " + mejor.posicionx + " Y: " + mejor.posiciony);
		
		return elementos;
	}

}
