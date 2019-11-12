package hacom.pe.datos.mapper.iface;

import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import hacom.pe.datos.entidades.Encuesta;
import hacom.pe.datos.entidades.EncuestaRemota;
import hacom.pe.datos.entidades.Incidencias;

public interface EncuestaRemMapper {

	@Select(value = " {call dbo.usp_getAllEncuestaRem()}")
	@Options(statementType = StatementType.CALLABLE)
	List<EncuestaRemota> getAllEncuestaRemota() throws Exception;

	@Select(value = 
			  "{call dbo.usp_getFindEncuestaRem("+
	          "#{fechaEnvioCadI,jdbcType=VARCHAR,mode=IN},"+
	          "#{fechaEnvioCadF,jdbcType=VARCHAR,mode=IN},"+
	          "#{fechaRespCadI,jdbcType=VARCHAR,mode=IN},"+
	          "#{fechaRespCadF,jdbcType=VARCHAR,mode=IN},"+
	           "#{unit_sec_ejec,jdbcType=VARCHAR,mode=IN},"+
	           "#{depa,jdbcType=INTEGER,mode=IN},"+
	           "#{unitName,jdbcType=VARCHAR ,mode=IN},"+
	           "#{sectorist_names,jdbcType=VARCHAR,mode=IN},"+
	           "#{implanter_names,jdbcType=VARCHAR,mode=IN}," +       
	           "#{systemName,jdbcType=VARCHAR ,mode=IN}," +
	           "#{answer1,jdbcType=VARCHAR,mode=IN},"+
	           "#{assistance_representant,jdbcType=VARCHAR,mode=IN},"+
	           "#{assistance_repr_work,jdbcType=VARCHAR,mode=IN}"+
	            ")}")
	@Options(statementType = StatementType.CALLABLE)
	List<EncuestaRemota> getFindEncuestaRemota(EncuestaRemota asis) throws Exception ;
}
