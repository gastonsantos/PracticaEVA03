package ar.edu.unlam.pb220202c.eva03;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAutoPista {
	
	@Test
	public void queSePuedaRegistrarTelepase () {
		
		Autopista ezeiza = new Autopista("Ezeiza");
		Vehiculo auto = new Automovil("JYO658", 100, 130);
		ezeiza.registrarTelepase(01, auto);
		Integer ve=1;
		Integer vo = ezeiza.getTelapase().size();
		assertEquals(ve,vo);
	}
@Test(expected = VehiculoNotFoundException.class)
public void queAlSalirDelAutopistaNoestaEncirculacionLanceUnaExcepcion() throws VehiculoNotFoundException {
	
	Autopista ezeiza = new Autopista("Ezeiza");
	Vehiculo auto = new Automovil("JYO658", 100, 130);
	ezeiza.registrarTelepase(01, auto);
	ezeiza.ingresarAutopista(01);
	ezeiza.salirAutpista(auto);	
	ezeiza.buscarVehiculoEnCirculacion(auto);
	
	}

	@Test
	public void queVerifiqueQueSeObtengaUnaListaDeAutosInsfractoresOrdenadaPorPatente() throws VehiculoNotFoundException{
		Autopista ezeiza = new Autopista("Ezeiza");
		Vehiculo auto = new Automovil("JYO658", 140, 130);
		Vehiculo mini = new Automovil("JYO8", 100, 130);
		Vehiculo camion = new Automovil("Jas658", 100, 80);
		ezeiza.registrarTelepase(01, auto);
		ezeiza.registrarTelepase(02, mini);
		ezeiza.registrarTelepase(03, camion);
		ezeiza.ingresarAutopista(01);
		ezeiza.ingresarAutopista(02);
		ezeiza.ingresarAutopista(03);
		Integer ve= 2;
		Integer vo = ezeiza.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente().size();
		assertEquals(ve,vo);
	}
@Test(expected = VehiculoNotFoundException.class)
	public void testeQueNoPuedaIngresarUnVehiculoSinTelepaseYlanceUnaExcepcion() throws VehiculoNotFoundException {
		
		Autopista ezeiza = new Autopista("Ezeiza");
		Vehiculo auto = new Automovil("JYO658", 140, 130);
		Vehiculo mini = new Automovil("JYO8", 100, 130);
		Vehiculo camion = new Automovil("Jas658", 100, 80);
		ezeiza.registrarTelepase(01, auto);
		ezeiza.registrarTelepase(02, mini);
		ezeiza.registrarTelepase(03, camion);
		ezeiza.ingresarAutopista(01);
		ezeiza.ingresarAutopista(02);
		ezeiza.ingresarAutopista(04);
		
		
	}
	@Test
	public void testeQuePuedaIngresarUnVehiculoConTelepase() throws VehiculoNotFoundException {
		Autopista ezeiza = new Autopista("Ezeiza");
		Vehiculo auto = new Automovil("JYO658", 140, 130);
		ezeiza.registrarTelepase(01, auto);
		ezeiza.ingresarAutopista(01);
		Integer ve = 1;
		Integer vo = ezeiza.cantidadDeVehiculosENCirculacion();
		assertEquals(ve, vo);
		
	}
	
}
