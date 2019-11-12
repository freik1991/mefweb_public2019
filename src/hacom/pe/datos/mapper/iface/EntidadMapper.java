package hacom.pe.datos.mapper.iface;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

import hacom.pe.datos.entidades.Encuesta;
import hacom.pe.datos.entidades.EncuestaRemota;
import hacom.pe.datos.entidades.Entidad;
import hacom.pe.datos.entidades.Incidencias;
import hacom.pe.datos.entidades.TipoLocal;

public interface EntidadMapper {

	@Select(value = " {call dbo.usp_getAllEntidad()}")
	@Options(statementType = StatementType.CALLABLE)
	List<Entidad> getAllEntidad() throws Exception;

	@Select(value = 
			  "{call dbo.usp_getFindEntidad("+
	           "#{unit_secEjec,jdbcType=VARCHAR,mode=IN},"+
	           "#{depa,jdbcType=INTEGER,mode=IN},"+
	           "#{unit_unitname,jdbcType=VARCHAR ,mode=IN},"+
	           "#{username,jdbcType=VARCHAR ,mode=IN},"+
	           "#{sectorist_names,jdbcType=VARCHAR,mode=IN},"+
	           "#{implanter_names,jdbcType=VARCHAR,mode=IN}," +       
	           "#{address,jdbcType=VARCHAR ,mode=IN}," +
	           "#{geozoneName,jdbcType=VARCHAR,mode=IN}"+
	            ")}")
	@Options(statementType = StatementType.CALLABLE)
	List<Entidad> getFindEntidad(Entidad asis) throws Exception ;
	
	@Insert(value = "insert into MEFUnit(secEjec,auditCreationDate,unitName,address,unitType,sectorist_id,representativeName,representativeEmail,representativePosition,representativePhone,locality,status,department,district,province)"
			+ " values (#{unit_secEjec},#{auditCreationDate},#{unit_unitname},#{address},#{unitType},#{sectorist_id},#{representativeName},#{representativeEmail},#{representativePosition},#{representativePhone},#{locality},#{status},"
			+ "#{depa},#{district},#{province})")
	void getSaveEntidad(Entidad ent) throws Exception ;
	
	@Update(value = " update MEFUnit set secEjec = #{unit_secEjec},unitName = #{unit_unitname},address = #{address},unitType = #{unitType},sectorist_id = #{sectorist_id},representativeName = #{representativeName},representativeEmail = #{representativeEmail},representativePosition = #{representativePosition},"
			+ "representativePhone = #{representativePhone},locality = #{locality},department=#{depa},district=#{district},province=#{province},status=#{status} where id = #{id} ")
	void getUpdateEntidad(Entidad ue) throws Exception ;
	
	@Delete(value = " delete MEFUnit  where id = #{id}")
	void getdeleteEntidad(int idTipoLocal) throws Exception ;
	
	@Select(value = " {call dbo.usp_getAllEntidadImpl(" + 
			"#{implantadorId,jdbcType=INTEGER,mode=IN})}")
	@Options(statementType = StatementType.CALLABLE)
	List<Entidad> getAllEntidadImplantador(Entidad ent) throws Exception;
	
	@Select(value = " {call dbo.usp_getAllEntidadSec(" + 
			"#{sectoristaId,jdbcType=INTEGER,mode=IN})}")
	@Options(statementType = StatementType.CALLABLE)
	List<Entidad> getAllEntidadSectorista(Entidad ent) throws Exception;
}
