package com.redsocial.servicio;

import java.util.List;

import com.redsocial.entidad.Entrenador;

public interface EntrenadorServicio {

	public Entrenador insertaActualizaEntrenador(Entrenador obj);
	public void eliminaEntrenador(int idJugador);
	public List<Entrenador> listaEntrenador();
	public List<Entrenador> listaEntrenadorPorNombre(String nom);

}
