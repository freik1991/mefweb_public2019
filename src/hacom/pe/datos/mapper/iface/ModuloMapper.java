package hacom.pe.datos.mapper.iface;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;
import hacom.pe.datos.entidades.Modulo;
import hacom.pe.datos.entidades.SubModulo;

public interface ModuloMapper {

	@Select(value = " {call dbo.usp_getAllModulos()}")
	@Options(statementType = StatementType.CALLABLE)
	List<Modulo> getAllModulo() throws Exception;

	@Select(value = "SELECT TOP 1 * FROM MEFModule ORDER BY ID DESC")
	Modulo getFindIdModulo() throws Exception;
	
	
	@Select(value = 
			  "{call dbo.usp_getFindModulo("+
	          "#{moduleName,jdbcType=VARCHAR,mode=IN},"+ 
	          "#{system_id,jdbcType=INTEGER,mode=IN}" +
	            ")}")
	@Options(statementType = StatementType.CALLABLE)
	List<Modulo> getFindModulo(Modulo asis) throws Exception ;
	
	
	@Insert(value = "insert into MEFModule(moduleName,system_id,status) values(#{moduleName},#{system_id},#{status})")
	void getSaveModulo(Modulo ue) throws Exception ;
	
	@Update(value = " update MEFModule set moduleName = #{moduleName},system_id = #{system_id} where id = #{id} ")
	void getUpdateModulo(Modulo ue) throws Exception ;
	
	@Update(value = " update MEFModule set status = '0' where id = #{id}")
	void getdeleteModulo(int id) throws Exception ;
	
	
	@Select(value = "SELECT  * FROM MEFModule")
	List<Modulo> getAllModuloSele() throws Exception;
	
}
