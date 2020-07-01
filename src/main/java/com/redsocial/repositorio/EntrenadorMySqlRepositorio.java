package com.redsocial.repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.redsocial.entidad.Equipo;
import com.redsocial.entidad.Entrenador;

@Repository
public class EntrenadorMySqlRepositorio implements EntrenadorRepositorio{

	@Autowired
    private JdbcTemplate jdbcTemplate ;
	
	RowMapper<Entrenador> mapperEntrenador = new RowMapper<Entrenador>() {
		@Override
		public Entrenador mapRow(ResultSet rs, int rowNum) throws SQLException {
			Entrenador obj = new Entrenador();
			obj.setIdEntrenador(rs.getInt(1));
			obj.setNombre(rs.getString(2));
			obj.setFechaNacimiento(rs.getString(3));
			obj.setSueldo(rs.getDouble(4));
			obj.setTelefono(rs.getString(5));
			obj.setEmail(rs.getString(6));
			
			Equipo objEquip = new Equipo();
			objEquip.setIdEquipo(rs.getInt(7));
			objEquip.setNombre(rs.getString(8));
		
			obj.setEquipo(objEquip);
			
			return obj;
		}
	};
	
	@Override
	public Entrenador insertaActualizaEntrenador(Entrenador obj) {
		Entrenador salida = null;
		if (obj.getIdEntrenador() == 0) {
			jdbcTemplate.update("insert into entrenador values(null,?,?,?,?,?,?)",
			new Object[] {obj.getNombre(), obj.getFechaNacimiento(), obj.getSueldo(), obj.getTelefono(), obj.getEmail(),obj.getEquipo().getIdEquipo()});	
			List<Entrenador> lista = jdbcTemplate.query("select m.*,d.nombre from entrenador m inner join equipo d on m.idEquipo = d.idEquipo order by m.idEntrenador desc limit 0, 1",new Object[] {} ,mapperEntrenador);
			salida = lista.get(0);
		}else {
			jdbcTemplate.update("update entrenador set nombre=?,fechaNacimiento=?,sueldo=?,telefono=?,email =?, idEquipo = ? where idEntrenador=?", new Object[] {obj.getNombre(), obj.getFechaNacimiento(), obj.getSueldo(), obj.getTelefono(), obj.getEmail(), obj.getEquipo().getIdEquipo(), obj.getIdEntrenador()});
			List<Entrenador> lista = jdbcTemplate.query("select m.*,d.nombre from entrenador m inner join equipo d on m.idEquipo = d.idEquipo where m.idEntrenador =?",new Object[] {obj.getIdEntrenador()} ,mapperEntrenador);
			salida = lista.get(0);
		}
		return salida;
	}

	@Override
	public void eliminaEntrenador(int idEntrenador) {
		jdbcTemplate.update("delete from entrenador where idEntrenador = ?",new Object[] {idEntrenador});		
	}

	@Override
	public List<Entrenador> listaEntrenador() {
		List<Entrenador> lista = jdbcTemplate.query("select m.*,d.nombre from entrenador m inner join equipo d on m.idEquipo = d.idEquipo", new Object[] {} ,mapperEntrenador);
		return lista;
	}

	@Override
	public List<Entrenador> listaEntrenadorPorNombre(String nom) {
		List<Entrenador> lista = jdbcTemplate.query("select m.*,d.nombre from entrenador m inner join equipo d on m.idEquipo = d.idEquipo where m.nombre like ?", new Object[] {nom} ,mapperEntrenador);
		return lista;
	}

	
}
