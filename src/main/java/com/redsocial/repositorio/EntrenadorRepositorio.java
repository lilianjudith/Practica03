package com.redsocial.repositorio;

import java.util.List;

import com.redsocial.entidad.Entrenador;

public interface EntrenadorRepositorio  {
	
	public Entrenador insertaActualizaEntrenador(Entrenador obj);
	public void eliminaEntrenador(int idEntrenador);
	public List<Entrenador> listaEntrenador();
	public List<Entrenador> listaEntrenadorPorNombre(String nom);
	
}
