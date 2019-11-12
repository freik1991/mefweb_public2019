/* 
 * =======================================================================================
 *   Copyright 2016, HACOM S.A.C.
 *   Proyecto: MATRIX - Sistema de Optimización de Transporte Urbano.
 * =======================================================================================
*/
package hacom.pe.datos.mapper.iface;

import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

import hacom.pe.datos.entidades.AsistenciaRemota;
import hacom.pe.datos.entidades.MsUser;
import hacom.pe.datos.entidades.Resumen;
import hacom.pe.datos.entidades.User;
import hacom.pe.datos.entidades.UsuarioMap;

public interface UserMapper {

	@Select(value = 
			  "SELECT * "
			+ "FROM MEFUsuMap "
			+ "WHERE usuario = #{usuario} and clave = #{clave}")
	UsuarioMap select(@Param("usuario") String usuario,@Param("clave") String clave) throws Exception ;

	@Select(value = 
			  "{call dbo.usp_getFindUsuario("+
	          "#{sectorist_id,jdbcType=INTEGER,mode=IN}"
	           + ")}")
	@Options(statementType = StatementType.CALLABLE)
	MsUser getFindUsuario(int asis) throws Exception ;
	
	@Select(value = " {call dbo.usp_getAllUsuario()}")
	@Options(statementType = StatementType.CALLABLE)
	List<MsUser> getAllUsuario() throws Exception;

	@Select(value = 
			  "{call dbo.usp_getFindUsuarioAdm("+
	          "#{username,jdbcType=VARCHAR,mode=IN},"+ 
	          "#{name_usu,jdbcType=VARCHAR,mode=IN}," +
	          "#{device_id,jdbcType=VARCHAR,mode=IN}," +
	          "#{userType,jdbcType=VARCHAR,mode=IN}," +
	          "#{sectorist,jdbcType=VARCHAR,mode=IN}" +
	            ")}")
	@Options(statementType = StatementType.CALLABLE)
	List<MsUser> getFindUsuarioAdm(MsUser asis) throws Exception ;
	
	
	
}