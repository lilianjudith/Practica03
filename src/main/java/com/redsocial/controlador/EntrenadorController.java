package com.redsocial.controlador;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.redsocial.entidad.Equipo;
import com.redsocial.entidad.Entrenador;
import com.redsocial.servicio.EquipoServicio;
import com.redsocial.servicio.EntrenadorServicio;

@Controller
public class EntrenadorController {

	@Autowired
	private EntrenadorServicio entrenadorServicio;
	
	@Autowired
	private EquipoServicio equipoServicio;

	@RequestMapping("/verEntrenador")
	public String ver() {
		return "crudEntrenador";
	}
	
	@RequestMapping("/cargaEquipo")
	@ResponseBody
	public List<Equipo> listaEquipo() {
		return equipoServicio.listaEquipo();
	}
	
	@RequestMapping("/registraEntrenador")
	public String metRegistra(Entrenador obj,HttpSession session) {
		Entrenador aux = entrenadorServicio.insertaActualizaEntrenador(obj);
		if(aux == null) {
			session.setAttribute("MENSAJE", "Registro erróneo");
		}else {
			session.setAttribute("MENSAJE", "Registro exitos");
		}
		return "redirect:verEntrenador";
	}
}
