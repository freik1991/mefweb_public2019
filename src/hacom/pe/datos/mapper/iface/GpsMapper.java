package hacom.pe.datos.mapper.iface;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

import hacom.pe.datos.entidades.Gps;

public interface GpsMapper {

	@Select(value = 
			  "SELECT " + 
			  "G.gpsID, " + 
			  "G.accountID, " + 
			  "G.vehicleID, " + 
			  "G.chipID, " + 
			  "G.esn, " + 
			  "G.gpsTypeID, " + 
			  "G.lastValidLatitude, " + 
			  "G.lastValidLongitude, " + 
			  "G.lastGpsTimestamp, " + 
			  "G.lastOdometer, " + 
			  "G.transmitFrecuency, " + 
			  "G.isActive, " + 
			  "G.displayName, " + 
			  "G.description, " + 
			  "G.notes, " + 
			  "G.deliveryDate, " + 
			  "G.creationTime, " + 
			  "G.sessionIDCreation, " + 
			  "G.lastUpdateTime, " + 
			  "G.sessionIDUpdate, " + 
			  "A.bussinessName, " + 
			  "'('+V.code +') '+V.licensePlate  as vehicleName, " + 
			  "C.sim, " + 
			  "T.name " + 
			  "FROM dbo.MTXGps AS G " + 
			  "LEFT JOIN dbo.MTXAccount AS A ON G.accountID = A.accountID " + 
			  "LEFT JOIN dbo.MTXVehicle AS V ON G.vehicleID = V.vehicleID " + 
			  "LEFT JOIN dbo.MTXChip AS C ON G.chipID = C.chipID " + 
			  "LEFT JOIN dbo.MTXGpsType AS T ON G.gpsTypeID = T.gpsTypeID " +
			  "ORDER BY G.esn")
	@Options(statementType = StatementType.PREPARED)	
	List<Gps> selectAll() throws Exception;

	@Update(value = 
			  "UPDATE [dbo].[MTXGps] " + 
			  "   SET [accountID] = #{accountID,jdbcType=INTEGER,mode=IN} " + 
			  "      ,[vehicleID] = #{vehicleID,jdbcType=INTEGER,mode=IN} " + 
			  "      ,[chipID] = #{chipID,jdbcType=INTEGER,mode=IN} " + 
			  "      ,[gpsTypeID] = #{gpsTypeID,jdbcType=INTEGER,mode=IN} " + 
			  "      ,[isActive] = #{isActive,jdbcType=INTEGER,mode=IN} " + 
			  "      ,[displayName] = #{displayName,jdbcType=VARCHAR,mode=IN} " + 
			  "      ,[description] = #{description,jdbcType=VARCHAR,mode=IN} " + 
			  "      ,[notes] = #{notes,jdbcType=VARCHAR,mode=IN} " + 
			  "      ,[deliveryDate] = #{deliveryDate,jdbcType=BIGINT,mode=IN} " + 
			  "      ,[lastUpdateTime] = #{lastUpdateTime,jdbcType=BIGINT,mode=IN} " + 
			  "      ,[sessionIDUpdate] = #{sessionIDUpdate,jdbcType=BIGINT,mode=IN} " + 
			  " WHERE gpsID = #{gpsID,jdbcType=INTEGER,mode=IN}")
	@Options(statementType = StatementType.PREPARED)	
	void update(Gps gps) throws Exception;
	
	@Insert(value = 
			  " INSERT INTO [dbo].[MTXGps]" + 
			  "           ([accountID]" + 
			  "           ,[vehicleID]" + 
			  "           ,[chipID]" + 
			  "           ,[esn]" + 
			  "           ,[gpsTypeID]" + 
			  "           ,[isActive]" + 
			  "           ,[displayName]" + 
			  "           ,[description]" + 
			  "           ,[notes]" + 
			  "           ,[deliveryDate]" + 
			  "           ,[creationTime]" + 
			  "           ,[sessionIDCreation])" + 
			  "     VALUES " + 
			  "           (#{accountID,jdbcType=INTEGER,mode=IN}" + 
			  "           ,#{vehicleID,jdbcType=INTEGER,mode=IN}" + 
			  "           ,#{chipID,jdbcType=INTEGER,mode=IN}" + 
			  "           ,#{esn,jdbcType=VARCHAR,mode=IN}" + 
			  "           ,#{gpsTypeID,jdbcType=INTEGER,mode=IN}" + 
			  "           ,#{isActive,jdbcType=INTEGER,mode=IN}" + 
			  "           ,#{displayName,jdbcType=VARCHAR,mode=IN}" + 
			  "           ,#{description,jdbcType=VARCHAR,mode=IN}" + 
			  "           ,#{notes,jdbcType=VARCHAR,mode=IN}" + 
			  "           ,#{deliveryDate,jdbcType=BIGINT,mode=IN}" + 
			  "           ,#{creationTime,jdbcType=BIGINT,mode=IN}" + 
			  "           ,#{sessionIDCreation,jdbcType=BIGINT,mode=IN})")
	@Options(statementType = StatementType.PREPARED, useGeneratedKeys = true, keyProperty = "gpsID")
	void insert(Gps gps) throws Exception;
	
	@Update(value =  "UPDATE [dbo].[MTXVehicle] SET gpsID=-1 WHERE vehicleID=#{VehicleID,jdbcType=INTEGER,mode=IN}")
	@Options(statementType = StatementType.PREPARED)	
	void eliminarGPSDeVehiculo(@Param("VehicleID") int VehicleID) throws Exception;
	
	@Update(value =  "UPDATE [dbo].[MTXGps] SET VehicleID=-1 WHERE gpsID=#{gpsID,jdbcType=INTEGER,mode=IN}")
	@Options(statementType = StatementType.PREPARED)	
	void eliminarVehicleDeGPS(@Param("gpsID") int gpsID) throws Exception;
	
	@Update(value =  "UPDATE [dbo].[MTXGps] SET chipID=-1 WHERE gpsID=#{gpsID,jdbcType=INTEGER,mode=IN}")
	@Options(statementType = StatementType.PREPARED)	
	void eliminarChipDeGPS(@Param("gpsID") int gpsID) throws Exception;

	@Update(value =  "UPDATE [dbo].[MTXVehicle] SET gpsID=#{gpsID,jdbcType=INTEGER,mode=IN} WHERE vehicleID=#{VehicleID,jdbcType=INTEGER,mode=IN}")
	@Options(statementType = StatementType.PREPARED)	
	void grabarGPSAVehiculo(@Param("gpsID") int gpsID, @Param("VehicleID") int VehicleID) throws Exception;
	
	@Update(value =  "UPDATE [dbo].[MTXChip] SET gpsID=#{gpsID,jdbcType=INTEGER,mode=IN} WHERE chipID=#{chipID,jdbcType=INTEGER,mode=IN}")
	@Options(statementType = StatementType.PREPARED)	
	void grabarGPSAChip(@Param("gpsID") int gpsID, @Param("chipID") int chipID) throws Exception;
	
	@Insert(value = 
			  " INSERT INTO [dbo].[HOGpsHistory]" + 
			  "           ([gpsID]" + 
			  "           ,[accountIDOld]" + 
			  "           ,[accountID]" + 
			  "           ,[vehicleIDOld]" + 
			  "           ,[vehicleID]" + 
			  "           ,[chipIDOld]" + 
			  "           ,[chipID]" + 
			  "           ,[gpsTypeIDOld]" + 
			  "           ,[gpsTypeID]" + 
			  "           ,[isActiveOld]" + 
			  "           ,[isActive]" + 
			  "           ,[creationTime]" + 
			  "           ,[userName])" + 
			  "     VALUES " + 
			  "           (#{gpsID,jdbcType=INTEGER,mode=IN}" + 
			  "           ,#{accountIDOld,jdbcType=INTEGER,mode=IN}" + 
			  "           ,#{accountID,jdbcType=INTEGER,mode=IN}" + 
			  "           ,#{vehicleIDOld,jdbcType=INTEGER,mode=IN}" + 
			  "           ,#{vehicleID,jdbcType=INTEGER,mode=IN}" + 
			  "           ,#{chipIDOld,jdbcType=INTEGER,mode=IN}" + 
			  "           ,#{chipID,jdbcType=INTEGER,mode=IN}" + 
			  "           ,#{gpsTypeIDOld,jdbcType=INTEGER,mode=IN}" + 
			  "           ,#{gpsTypeID,jdbcType=INTEGER,mode=IN}" + 
			  "           ,#{isActiveOld,jdbcType=INTEGER,mode=IN}" + 
			  "           ,#{isActive,jdbcType=INTEGER,mode=IN}" + 
			  "           ,#{creationTime,jdbcType=BIGINT,mode=IN}" + 
			  "           ,#{userName,jdbcType=VARCHAR,mode=IN})")
	@Options(statementType = StatementType.PREPARED, useGeneratedKeys = true, keyProperty = "gpsHistoryID")
	void insertHistory(Gps gps) throws Exception;
	
	@Select(value = 
			  "SELECT TOP 10 " + 
			  "G.gpsHistoryID, " + 
			  "A.bussinessName, " + 
			  "'('+V.code +') '+V.licensePlate  as vehicleName, " + 
			  "C.sim, " + 
			  "Told.name, " + 
			  "Aold.bussinessName as bussinessNameOld, " + 
			  "'('+Vold.code +') '+Vold.licensePlate  as vehicleNameOld, " + 
			  "Cold.sim as simOld, " + 
			  "Told.name as nameOld, " + 
			  "G.isActive, " + 
			  "G.isActiveOld, " + 
			  "G.creationTime, " + 
			  "G.userName " + 
			  "FROM dbo.HOGpsHistory AS G " + 
			  "LEFT JOIN dbo.MTXAccount AS A ON G.accountID = A.accountID " + 
			  "LEFT JOIN dbo.MTXVehicle AS V ON G.vehicleID = V.vehicleID " + 
			  "LEFT JOIN dbo.MTXChip AS C ON G.chipID = C.chipID " + 
			  "LEFT JOIN dbo.MTXGpsType AS T ON G.gpsTypeID = T.gpsTypeID " + 
			  "LEFT JOIN dbo.MTXAccount AS Aold ON G.accountIDOld = Aold.accountID " + 
			  "LEFT JOIN dbo.MTXVehicle AS Vold ON G.vehicleIDOld = Vold.vehicleID " + 
			  "LEFT JOIN dbo.MTXChip AS Cold ON G.chipIDOld = Cold.chipID " + 
			  "LEFT JOIN dbo.MTXGpsType AS Told ON G.gpsTypeIDOld = Told.gpsTypeID " + 
			  "WHERE G.gpsID = #{gpsID,jdbcType=INTEGER,mode=IN} " + 
			  "ORDER BY " + 
			  "g.gpsHistoryID DESC")
	@Options(statementType = StatementType.PREPARED)	
	List<Gps> selectHistoryGps(@Param("gpsID") int gpsID) throws Exception;
}
