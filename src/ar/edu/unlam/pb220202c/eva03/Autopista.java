package ar.edu.unlam.pb220202c.eva03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.TreeSet;



public class Autopista {
	//Si es necesario Utilice herencia o implemente de Interfaces
	//Se debe crear contructeres getters y Setters y los atributos o metodos que crean convenientes
	private String nombre;
	private HashMap <Integer,Vehiculo> telapase;
	private HashSet <Vehiculo> vehiculosEnCirculacion;
	
	
	
	
	
	public Autopista(String nombre) {
		
		this.nombre = nombre;
		this.telapase = new HashMap <Integer,Vehiculo>();
		this.vehiculosEnCirculacion = new HashSet <Vehiculo>();
		
	}
	public void registrarTelepase (Integer numeroTelpase, Vehiculo vehiculo) {
		
		telapase.put(numeroTelpase, vehiculo);
		
	}
	
	
	public Boolean buscarVehiculoEnCirculacion(Vehiculo vehi) throws VehiculoNotFoundException{
		Boolean encontro = false;
		
			if(vehiculosEnCirculacion.contains(vehi)){
				encontro = true;
			
		}else{
			throw new VehiculoNotFoundException();
		}
		
		return encontro;
	}
	
	
	
	public Boolean ingresarAutopista (Integer numeroTelepase) throws VehiculoNotFoundException {
		//si el telepase no esta registrado lanza una Exceptios del tipo VehiculoNotFoundException
	   // y no permite ingresar al autopista	
		Boolean ingreso = false;
		if(telapase.containsKey(numeroTelepase)){
			 for(HashMap.Entry<Integer, Vehiculo> entry: telapase.entrySet()){
				 if(entry.getKey().equals(numeroTelepase)){
					 vehiculosEnCirculacion.add(entry.getValue());
					 ingreso = true;
				 }
		}
		}else{
			throw new VehiculoNotFoundException();
		
		
				 
			 	 
		 }
		
		
		return ingreso;
	}
	
	public void salirAutpista (Vehiculo vehiculo) throws VehiculoNotFoundException {	
		for(Vehiculo e: vehiculosEnCirculacion){
			if(e.Patente.equals(vehiculo.getPatente())){
				vehiculosEnCirculacion.remove(vehiculo);
			}else{
				throw new VehiculoNotFoundException();
			}
		}
		
		
	}
	
	
	
	
	public TreeSet<Vehiculo> obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente(){
		TreeSet<Vehiculo> ordenadoPorPatente= new TreeSet<Vehiculo>(new OrdenadoPorPatente());
		for(Vehiculo e: vehiculosEnCirculacion){
			if(e.getLimiteVelocidad()<=e.getVelocidadActual()){
				ordenadoPorPatente.add(e);
			}
		}

		return ordenadoPorPatente;	
		
	
    }

	public Integer cantidadDeVehiculosENCirculacion() {
	 
		return vehiculosEnCirculacion.size();
}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public HashMap<Integer, Vehiculo> getTelapase() {
		return telapase;
	}
	public void setTelapase(HashMap<Integer, Vehiculo> telapase) {
		this.telapase = telapase;
	}
	public HashSet<Vehiculo> getVehiculosEnCirculacion() {
		return vehiculosEnCirculacion;
	}
	public void setVehiculosEnCirculacion(HashSet<Vehiculo> vehiculosEnCirculacion) {
		this.vehiculosEnCirculacion = vehiculosEnCirculacion;
	}
	
	

	
	
}
