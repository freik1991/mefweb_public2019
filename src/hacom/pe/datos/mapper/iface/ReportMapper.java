package hacom.pe.datos.mapper.iface;

import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import hacom.pe.datos.entidades.Account;
import hacom.pe.datos.entidades.ChipStatus;
import hacom.pe.datos.entidades.ChipSupplier;
import hacom.pe.datos.entidades.GpsType;
import hacom.pe.datos.entidades.Vehicle;

public interface ReportMapper {

	@Select(value = 
			  "SELECT " + 
			  "a.accountID, " + 
			  "a.uniqueID, " + 
			  "a.bussinessName " + 
			  "FROM " + 
			  "dbo.MTXAccount AS a " + 
			  "WHERE " + 
			  "a.isActive = 1 " + 
			  "ORDER BY " + 
			  "a.bussinessName ")
	@Options(statementType = StatementType.PREPARED)	
	List<Account> readListAccount() throws Exception;
	
	@Select(value = 
			  "SELECT " + 
			  "c.chipSupplierID, " + 
			  "c.name, " + 
			  "c.description " + 
			  "FROM " + 
			  "dbo.MTXChipSupplier AS c " + 
			  "ORDER BY " + 
			  "c.name ")
	@Options(statementType = StatementType.PREPARED)	
	List<ChipSupplier> readListChipSupplier()  throws Exception;
	
	@Select(value = 
			  "SELECT " + 
			  "g.gpsTypeID, " + 
			  "g.name " + 
			  "FROM " + 
			  "dbo.MTXGpsType AS g " + 
			  "ORDER BY " + 
			  "g.name")
	@Options(statementType = StatementType.PREPARED)
	List<GpsType> readListGpsType()  throws Exception;
	
	@Select(value = 
			  "SELECT " + 
			  "v.vehicleID, " + 
			  "v.accountID, " + 
			  "v.routeID, " + 
			  "v.gpsID, " + 
			  "'('+v.code+') '+v.licensePlate AS vehicleName, " + 
			  "v.isActive " + 
			  "FROM " + 
			  "dbo.MTXVehicle AS v " + 
			  "WHERE " + 
			  "v.accountID = #{accountID,jdbcType=INTEGER,mode=IN} AND " + 
			  "(v.isActive = 1 OR v.isActive = 3) " + 
			  "ORDER BY " + 
			  "v.code ASC ")
	@Options(statementType = StatementType.PREPARED)
	List<Vehicle> readListVehicle(@Param("accountID") int accountID)  throws Exception;
	
	@Select(value = 
			  "SELECT " + 
			  "s.chipStatusID, " + 
			  "s.name " + 
			  "FROM " + 
			  "dbo.MTXChipStatus AS s " + 
			  "ORDER BY " + 
			  "s.name")
	@Options(statementType = StatementType.PREPARED)
	List<ChipStatus> readListChipStatus()  throws Exception;
	
}
