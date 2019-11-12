package hacom.pe.datos.mapper.iface;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

import hacom.pe.datos.entidades.Display;

public interface DisplayMapper {

	@Select(value = 
			  "SELECT " + 
			  "D.displayID, " + 
			  "D.accountID, " + 
			  "D.routeID, " + 
			  "D.vehicleID, " + 
			  "D.chipID, " + 
			  "D.series, " + 
			  "D.brand, " + 
			  "D.creationTime, " + 
			  "D.sessionIDCreation, " + 
			  "D.lastUpdateTime, " + 
			  "D.sessionIDUpdate, " + 
			  "D.unlockPassword, " + 
			  "D.appVersion, " + 
			  "D.unlockPasswordSetting, " + 
			  "D.gift, " + 
			  "D.deliveryDate, " + 
			  "C.sim, " + 
			  "A.bussinessName, " + 
			  "'('+V.code+') '+V.licensePlate as vehicleName, " + 
			  "R.name as routerName " + 
			  "FROM " + 
			  "dbo.MTXDisplay AS D " + 
			  "LEFT JOIN dbo.MTXChip AS C ON D.chipID = C.chipID " + 
			  "LEFT JOIN dbo.MTXAccount AS A ON D.accountID = A.accountID " + 
			  "LEFT JOIN dbo.MTXVehicle AS V ON D.vehicleID = V.vehicleID " + 
			  "LEFT JOIN dbo.MTXRoute AS R ON D.routeID = R.routeID " +
			  "ORDER BY D.displayID ASC")
	@Options(statementType = StatementType.PREPARED)	
	List<Display> selectAll() throws Exception;

	@Update(value = 
			 "UPDATE [dbo].[MTXDisplay] " + 
					  "   SET [accountID] = #{accountID,jdbcType=INTEGER,mode=IN} " + 
					  "      ,[routeID] = #{routeID,jdbcType=INTEGER,mode=IN} " + 
					  "      ,[vehicleID] = #{vehicleID,jdbcType=INTEGER,mode=IN} " + 
					  "      ,[chipID] = #{chipID,jdbcType=INTEGER,mode=IN} " + 
					  "      ,[series] = #{series,jdbcType=VARCHAR,mode=IN} " + 
					  "      ,[brand] = #{brand,jdbcType=VARCHAR,mode=IN} " + 
					  "      ,[unlockPassword] = #{unlockPassword,jdbcType=INTEGER,mode=IN} " + 
					  "      ,[unlockPasswordSetting] = #{unlockPasswordSetting,jdbcType=INTEGER,mode=IN} " + 
					  "      ,[gift] = #{gift,jdbcType=INTEGER,mode=IN} " + 
					  "      ,[lastUpdateTime] = #{lastUpdateTime,jdbcType=BIGINT,mode=IN} " + 
					  "      ,[sessionIDUpdate] = #{sessionIDUpdate,jdbcType=BIGINT,mode=IN} " + 
					  "      ,[deliveryDate] = #{deliveryDate,jdbcType=BIGINT,mode=IN} " + 
					  " WHERE displayID = #{displayID,jdbcType=INTEGER,mode=IN}")
	@Options(statementType = StatementType.PREPARED)	
	void update(Display display) throws Exception;
	
	@Update(value = 
			 "UPDATE [dbo].[MTXDisplay] " + 
					  "   SET [routeID] = 0 " + 
					  "      ,[vehicleID] = -1 " + 
					  " WHERE displayID = #{displayID,jdbcType=INTEGER,mode=IN}")
	@Options(statementType = StatementType.PREPARED)	
	void eliminarVehiculoDeDisplay(@Param("displayID") int displayID) throws Exception;

	@Update(value = 
			 "UPDATE [dbo].[MTXDisplay] " + 
					  "   SET [chipID] = -1 " + 
					  " WHERE displayID = #{displayID,jdbcType=INTEGER,mode=IN}")
	@Options(statementType = StatementType.PREPARED)	
	void eliminarChipDeDisplay(@Param("displayID") int displayID) throws Exception;

	
	@Insert(value = 
			" INSERT INTO [dbo].[MTXDisplay]" + 
					  "           ([accountID] " + 
					  "           ,[routeID] " + 
					  "           ,[vehicleID] " + 
					  "           ,[chipID] " + 
					  "           ,[series] " + 
					  "           ,[brand] " + 
					  "           ,[creationTime] " + 
					  "           ,[sessionIDCreation] " + 
					  "           ,[unlockPassword] " + 
					  "           ,[appVersion] " + 
					  "           ,[unlockPasswordSetting] " + 
					  "           ,[gift] " + 
					  "           ,[deliveryDate] " + 
					  "           ,[token] " + 
					  "           ,[isTrackable] " + 
					  "           ,[notificationType])" + 
					  "     VALUES " + 
					  "           (#{accountID,jdbcType=INTEGER,mode=IN}" + 
					  "           ,#{routeID,jdbcType=INTEGER,mode=IN}" + 
					  "           ,#{vehicleID,jdbcType=INTEGER,mode=IN}" + 
					  "           ,#{chipID,jdbcType=INTEGER,mode=IN}" + 
					  "           ,#{series,jdbcType=VARCHAR,mode=IN}" + 
					  "           ,#{brand,jdbcType=VARCHAR,mode=IN}" + 
					  "           ,#{creationTime,jdbcType=BIGINT,mode=IN}" + 
					  "           ,#{sessionIDCreation,jdbcType=BIGINT,mode=IN}" + 
					  "           ,#{unlockPassword,jdbcType=INTEGER,mode=IN}" + 
					  "           ,#{appVersion,jdbcType=VARCHAR,mode=IN}" + 
					  "           ,#{unlockPasswordSetting,jdbcType=INTEGER,mode=IN}" + 
					  "           ,#{gift,jdbcType=INTEGER,mode=IN}" + 
					  "           ,#{deliveryDate,jdbcType=BIGINT,mode=IN}" + 
					  "           ,''" + 
					  "           ,1" + 
					  "           ,1)")
	@Options(statementType = StatementType.PREPARED, useGeneratedKeys = true, keyProperty = "displayID")
	void insert(Display displays) throws Exception;
	
	@Insert(value = 
			  " INSERT INTO [dbo].[HODisplayHistory]" + 
			  "           ([displayID] " + 
			  "           ,[accountIDOld] " + 
			  "           ,[accountID] " + 
			  "           ,[vehicleIDOld] " + 
			  "           ,[vehicleID] " + 
			  "           ,[chipIDOld] " + 
			  "           ,[chipID] " + 
			  "           ,[series] " + 
			  "           ,[seriesOld] " + 
			  "           ,[brand] " + 
			  "           ,[brandOld] " + 
			  "           ,[creationTime] " + 
			  "           ,[userName])" + 
			  "     VALUES " + 
			  "           (#{displayID,jdbcType=INTEGER,mode=IN}" + 
			  "           ,#{accountIDOld,jdbcType=INTEGER,mode=IN}" + 
			  "           ,#{accountID,jdbcType=INTEGER,mode=IN}" + 
			  "           ,#{vehicleIDOld,jdbcType=INTEGER,mode=IN}" + 
			  "           ,#{vehicleID,jdbcType=INTEGER,mode=IN}" + 
			  "           ,#{chipIDOld,jdbcType=INTEGER,mode=IN}" + 
			  "           ,#{chipID,jdbcType=INTEGER,mode=IN}" + 
			  "           ,#{series,jdbcType=VARCHAR,mode=IN}" + 
			  "           ,#{seriesOld,jdbcType=VARCHAR,mode=IN}" + 
			  "           ,#{brand,jdbcType=VARCHAR,mode=IN}" + 
			  "           ,#{brandOld,jdbcType=VARCHAR,mode=IN}" + 
			  "           ,#{creationTime,jdbcType=BIGINT,mode=IN}" + 
			  "           ,#{userName,jdbcType=VARCHAR,mode=IN})")
	@Options(statementType = StatementType.PREPARED, useGeneratedKeys = true, keyProperty = "displayHistoryID")
	void insertHistory(Display display) throws Exception;
	
	@Select(value = 
			  "SELECT " + 
			  "H.displayHistoryID, " + 
			  "H.displayID, " + 
			  "H.accountIDOld, " + 
			  "H.accountID, " + 
			  "H.vehicleIDOld, " + 
			  "H.vehicleID, " + 
			  "H.chipIDOld, " + 
			  "H.chipID, " + 
			  "H.series, " + 
			  "H.seriesOld, " + 
			  "H.brand, " + 
			  "H.brandOld, " + 
			  "H.creationTime, " + 
			  "H.userName, " + 
			  "A.bussinessName, " + 
			  "AOld.bussinessName as bussinessNameOld, " + 
			  "'('+V.code+') '+V.licensePlate as vehicleName, " + 
			  "'('+VOld.code+') '+VOld.licensePlate as vehicleNameOld, " + 
			  "C.sim, " + 
			  "COld.sim as simOld " + 
			  "FROM " + 
			  "dbo.HODisplayHistory AS H " + 
			  "LEFT JOIN dbo.MTXAccount AS A ON H.accountID = A.accountID " + 
			  "LEFT JOIN dbo.MTXAccount AS AOld ON H.accountIDOld = AOld.accountID " + 
			  "LEFT JOIN dbo.MTXVehicle AS V ON H.vehicleID = V.vehicleID " + 
			  "LEFT JOIN dbo.MTXVehicle AS VOld ON H.vehicleIDOld = VOld.vehicleID " + 
			  "LEFT JOIN dbo.MTXChip AS C ON H.chipID = C.chipID " + 
			  "LEFT JOIN dbo.MTXChip AS COld ON H.chipIDOld = COld.chipID " + 
			  "WHERE H.displayID = #{displayID,jdbcType=INTEGER,mode=IN} " +
			  "ORDER BY H.displayHistoryID DESC")
	@Options(statementType = StatementType.PREPARED)	
	List<Display> selectHistoryDisplay(@Param("displayID") int displayID) throws Exception;
}
