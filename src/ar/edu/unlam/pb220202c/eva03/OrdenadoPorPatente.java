package ar.edu.unlam.pb220202c.eva03;

import java.util.Comparator;

public class OrdenadoPorPatente implements Comparator<Vehiculo>  {

	@Override
	public int compare(Vehiculo vehi1, Vehiculo vehi2) {
		
		return vehi1.getPatente().compareTo(vehi2.getPatente());
	}

}
