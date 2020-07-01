package com.redsocial.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.redsocial.entidad.Entrenador;
import com.redsocial.servicio.EntrenadorServicio;

@Controller
public class EntrenadorCrudController {

	@Autowired
	private EntrenadorServicio servicio;
	
	@RequestMapping("/verCrudEntrenador")
	public String ver() {
		return "crudEntrenador";
	}
	
	@RequestMapping("/consultaCrudEntrenador")
	public String lista(String filtro, Model m) {
		List<Entrenador> lista =  servicio.listaEntrenadorPorNombre(filtro+"%");
		m.addAttribute("entrenadores", lista);
		return "crudEntrenador";
	}
	
	@RequestMapping("/registraActualizaCrudEntrenador")
	public String registraActualiza(Entrenador obj, Model m) {
		servicio.insertaActualizaEntrenador(obj);
		List<Entrenador> lista =  servicio.listaEntrenador();
		m.addAttribute("entrenadores", lista);
		return "crudEntrenador";
	}
	
	@RequestMapping("/eliminaCrudEntrenador")
	public String elimina(int id, Model m) {
		servicio.eliminaEntrenador(id);
		List<Entrenador> lista =  servicio.listaEntrenador();
		m.addAttribute("entrenadores", lista);
		return "crudEntrenador";
	}
}
