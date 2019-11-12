package hacom.pe.datos.mapper.iface;

import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import hacom.pe.datos.entidades.Encuesta;
import hacom.pe.datos.entidades.Incidencias;
import hacom.pe.datos.entidades.Visita;

public interface VisitaMapper {

	@Select(value = " {call dbo.usp_getAllVisita()}")
	@Options(statementType = StatementType.CALLABLE)
	List<Visita> getAllVisita() throws Exception;

	@Select(value = 
			  "{call dbo.usp_getFindVisitasEnt("+
	          "#{fechaVisCadI,jdbcType=VARCHAR,mode=IN},"+
	          "#{fechaVisCadF,jdbcType=VARCHAR,mode=IN},"+
	           "#{secEjec,jdbcType=VARCHAR,mode=IN},"+
	           "#{depa,jdbcType=INTEGER,mode=IN},"+
	           "#{sectorist_names,jdbcType=VARCHAR,mode=IN},"+
	           "#{implanter_names,jdbcType=VARCHAR,mode=IN}" +       
	            ")}")
	@Options(statementType = StatementType.CALLABLE)
	List<Visita> getFindVisita(Visita asis) throws Exception ;
}
