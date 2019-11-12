package hacom.pe.datos.mapper.iface;

import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import hacom.pe.datos.entidades.AsistenciaTecnica;
import hacom.pe.datos.entidades.Departamento;
import hacom.pe.datos.entidades.MsUser;


public interface AsistenciaTecMapper  {

	@Select(value = 
			  "SELECT * "
			+ "FROM MEFLocationDepartment")
	List<Departamento> select() throws Exception ;
	
	
	@Select(value = " {call dbo.usp_getAllAsistenciaTec()}")
	@Options(statementType = StatementType.CALLABLE)
	List<AsistenciaTecnica> getAllAsistenciaTec() throws Exception;
	
	@Select(value = 
			  "SELECT CONCAT(first_name,' ',last_name) as nameSec "
			+ "FROM auth_user "
			+ "WHERE id = #{id}")
	AsistenciaTecnica getSectorista(@Param("id") int userID) throws Exception ;

	@Select(value = 
			  "SELECT id  "
			+ "FROM auth_user "
			+ "WHERE CONCAT(first_name,' ',last_name)  = #{userName}")
	AsistenciaTecnica getSectoristaName(@Param("userName") String userName) throws Exception ;

	@Select(value = 
			  "{call dbo.usp_getFindAsistenciaTec("+
	          "#{fechaIni,jdbcType=BIGINT,mode=IN},"+
	          "#{fechaFin,jdbcType=BIGINT,mode=IN},"+
	           "#{secEjec,jdbcType=VARCHAR,mode=IN},"+
	           "#{department,jdbcType=INTEGER,mode=IN},"+
	           "#{unitName,jdbcType=VARCHAR ,mode=IN},"+
	           "#{sectorist_id,jdbcType=INTEGER,mode=IN},"+
	           "#{IMPLANTADOR,jdbcType=VARCHAR,mode=IN}," +
	           "#{isFunctional,jdbcType=INTEGER,mode=IN}," +
	           "#{isTechnical,jdbcType=INTEGER,mode=IN}," +
	           "#{isTraining,jdbcType=INTEGER,mode=IN}," +
	           "#{representantName,jdbcType=VARCHAR ,mode=IN}," +
	           "#{representantWorkingPosition,jdbcType=VARCHAR ,mode=IN}" 
	           + ")}")
	@Options(statementType = StatementType.CALLABLE)
	List<AsistenciaTecnica> getFindAsistenciaTecnica(AsistenciaTecnica asis) throws Exception ;
}