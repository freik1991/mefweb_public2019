package hacom.pe.datos.mapper.iface;

import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import hacom.pe.datos.entidades.AsistenciaRemota;
import hacom.pe.datos.entidades.Incidencias;

public interface IncidenciaMapper {
	
	@Select(value = " {call dbo.usp_getAllIncidencias()}")
	@Options(statementType = StatementType.CALLABLE)
	List<Incidencias> getAllincidencias() throws Exception;

	@Select(value = 
			  "{call dbo.usp_getFindIncidencias("+
	          "#{fechaIncIni,jdbcType=VARCHAR,mode=IN},"+
	          "#{fechaIncHas,jdbcType=VARCHAR,mode=IN},"+
	           "#{secEjec,jdbcType=VARCHAR,mode=IN},"+
	           "#{unitName,jdbcType=VARCHAR ,mode=IN},"+
	           "#{sectorist_names,jdbcType=VARCHAR,mode=IN},"+
	           "#{implanterName,jdbcType=VARCHAR,mode=IN}," +       
	           "#{systemName,jdbcType=VARCHAR ,mode=IN}" 
	           + ")}")
	@Options(statementType = StatementType.CALLABLE)
	List<Incidencias> getFindIncidencias(Incidencias asis) throws Exception ;
}
