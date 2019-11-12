/* 
  =======================================================================================
    Copyright 2017, HACOM S.A.C.
    Proyecto: MATRIX - Sistema de Optimización de Transporte Urbano.
  =======================================================================================
	Change History:
  =======================================================================================
*/
package hacom.pe.datos.mapper.iface;

import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import hacom.pe.datos.entidades.Account;
import hacom.pe.datos.entidades.util.GpsControl;
import hacom.pe.datos.entidades.util.GpsControlEvent;

/**
 * Se emplea para realizar los llamados a procedimientos almacenados.
 * @version 1.0
 * @since 2017/02/16
 */
public interface EventMapper {

	@Select(value = " {call MTX_sp_GpsControlAccountRead()} ")
	@Options(statementType = StatementType.CALLABLE)
	List<Account> selectGpsControlAccountRead() throws Exception;
	
	@Select(value = " {call MTX_sp_GpsControlRead(#{cuentas,jdbcType=INTEGER,mode=IN})} ")
	@Options(statementType = StatementType.CALLABLE)
	List<GpsControl> selectGpsControlRead(@Param("cuentas") int cuentas) throws Exception;
	
	@Select(value = " {call MTX_sp_GpsControlEvent(#{accountID,jdbcType=INTEGER,mode=IN},#{esn,jdbcType=VARCHAR,mode=IN})} ")
	@Options(statementType = StatementType.CALLABLE, timeout=30)
	List<GpsControlEvent> selectGpsControlEvent(@Param("accountID") int accountID, @Param("esn") String esn) throws Exception;
	
	
}
