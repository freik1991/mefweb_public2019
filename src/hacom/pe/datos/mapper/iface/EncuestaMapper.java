package hacom.pe.datos.mapper.iface;

import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import hacom.pe.datos.entidades.Encuesta;
import hacom.pe.datos.entidades.Incidencias;

public interface EncuestaMapper {

	@Select(value = " {call dbo.usp_getAllEncuesta()}")
	@Options(statementType = StatementType.CALLABLE)
	List<Encuesta> getAllEncuesta() throws Exception;

	@Select(value = 
			  "{call dbo.usp_getFindEncuesta("+
	          "#{fechaEnvioCadI,jdbcType=VARCHAR,mode=IN},"+
	          "#{fechaEnvioCadF,jdbcType=VARCHAR,mode=IN},"+
	          "#{fechaRespCadI,jdbcType=VARCHAR,mode=IN},"+
	          "#{fechaRespCadF,jdbcType=VARCHAR,mode=IN},"+
	           "#{secEjec,jdbcType=VARCHAR,mode=IN},"+
	           "#{depa,jdbcType=INTEGER,mode=IN},"+
	           "#{unitName,jdbcType=VARCHAR ,mode=IN},"+
	           "#{sectorist_names,jdbcType=VARCHAR,mode=IN},"+
	           "#{implanter_names,jdbcType=VARCHAR,mode=IN}," +       
	           "#{systemName,jdbcType=VARCHAR ,mode=IN}," +
	           "#{ans1,jdbcType=VARCHAR,mode=IN},"+
	           "#{ans2,jdbcType=VARCHAR,mode=IN},"+
	           "#{ans3,jdbcType=VARCHAR,mode=IN},"+
	           "#{assistance_representant,jdbcType=VARCHAR,mode=IN},"+
	           "#{assistance_repr_work,jdbcType=VARCHAR,mode=IN}"+
	            ")}")
	@Options(statementType = StatementType.CALLABLE)
	List<Encuesta> getFindEncuesta(Encuesta asis) throws Exception ;
}
