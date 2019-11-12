package hacom.pe.datos.mapper.iface;

import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import hacom.pe.datos.entidades.Encuesta;
import hacom.pe.datos.entidades.Incidencias;
import hacom.pe.datos.entidades.Resumen;
import hacom.pe.datos.entidades.Visita;

public interface ResumenMapper {

	@Select(value = " {call dbo.usp_getAllResumen()}")
	@Options(statementType = StatementType.CALLABLE)
	List<Resumen> getAllResumen() throws Exception;

	@Select(value = 
			  "{call dbo.usp_getFindResumenGeneral("+
	          "#{fechaVisCadI,jdbcType=VARCHAR,mode=IN},"+ 
	          "#{fechaVisCadF,jdbcType=VARCHAR,mode=IN}" +
	            ")}")
	@Options(statementType = StatementType.CALLABLE)
	List<Resumen> getFindResumen(Resumen asis) throws Exception ;
	
	
}
