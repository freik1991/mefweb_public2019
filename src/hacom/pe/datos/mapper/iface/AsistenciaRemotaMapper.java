package hacom.pe.datos.mapper.iface;

import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import hacom.pe.datos.entidades.AsistenciaRemota;
import hacom.pe.datos.entidades.AsistenciaTecnica;

public interface AsistenciaRemotaMapper {
	
	@Select(value = " {call dbo.usp_getAllAsistenciaRem()}")
	@Options(statementType = StatementType.CALLABLE)
	List<AsistenciaRemota> getAllAsistenciaRemota() throws Exception;
	
	@Select(value = 
			  "{call dbo.usp_getFindAsistenciaRem("+
	          "#{fechaAsisIni,jdbcType=VARCHAR,mode=IN},"+
	          "#{FechaAsisHas,jdbcType=VARCHAR,mode=IN},"+
	          "#{FechaRegIni,jdbcType=VARCHAR,mode=IN},"+
	          "#{FechaRegHas,jdbcType=VARCHAR,mode=IN},"+
	           "#{secEjec,jdbcType=VARCHAR,mode=IN},"+
	           "#{department,jdbcType=INTEGER,mode=IN},"+
	           "#{unitName,jdbcType=INTEGER ,mode=IN},"+
	           "#{sectorist_id,jdbcType=INTEGER,mode=IN},"+
	           "#{IMPLANTADOR,jdbcType=INTEGER,mode=IN}," +
	           "#{modalidad,jdbcType=INTEGER ,mode=IN}," +
	           "#{sistema,jdbcType=INTEGER ,mode=IN}," +
	           "#{tipoAsi,jdbcType=VARCHAR ,mode=IN}"
	           + ")}")
	@Options(statementType = StatementType.CALLABLE)
	List<AsistenciaRemota> getFindAsistenciaRemota(AsistenciaRemota asis) throws Exception ;
}
