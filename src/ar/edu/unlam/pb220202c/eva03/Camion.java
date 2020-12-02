package ar.edu.unlam.pb220202c.eva03;

public class Camion extends Vehiculo implements Imultable {
	
	private Integer cantidadDeEjes;
	public Camion(String patente, Integer velocidadActual, Integer limiteVelocidad, Integer cantidadDeEjes) {
		super(patente, velocidadActual, limiteVelocidad);
		this.cantidadDeEjes = cantidadDeEjes;
	}
	@Override
	public Boolean enInfraccion() {
		Boolean infraccion = false;
		if(limiteVelocidad >80){
			infraccion=true;
		}
		return infraccion;
	}

	//Si es necesario Utilice herencia o implemente de Interfaces
	//Se debe crear contructeres getters y Setters y los que crean conveniente
	
	//el Limite de velociadad para autos es de 80km
	//en caso que supere dicho limite el este sera multado

	
}
