package com.redsocial.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redsocial.entidad.Entrenador;
import com.redsocial.repositorio.EntrenadorRepositorio;

@Service
public class EntrenadorServicioImpl implements EntrenadorServicio{

	@Autowired
	private EntrenadorRepositorio repositorio;

	@Override
	public Entrenador insertaActualizaEntrenador(Entrenador obj) {
		return repositorio.insertaActualizaEntrenador(obj);
	}

	@Override
	public void eliminaEntrenador(int idEntrenador) {
		repositorio.eliminaEntrenador(idEntrenador);
	}

	@Override
	public List<Entrenador> listaEntrenador() {
		return repositorio.listaEntrenador();
	}

	@Override
	public List<Entrenador> listaEntrenadorPorNombre(String nom) {
		return repositorio.listaEntrenadorPorNombre(nom);
	}
	


}


