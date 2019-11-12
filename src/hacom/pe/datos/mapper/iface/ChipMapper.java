package hacom.pe.datos.mapper.iface;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

import hacom.pe.datos.entidades.Chip;

public interface ChipMapper {

	@Select(value = 
			  "SELECT " + 
			  "H.chipID, " + 
			  "H.gpsID, " + 
			  "H.sim, " + 
			  "H.iccid, " + 
			  "H.description, " + 
			  "H.chipSupplierID, " + 
			  "H.deliveryDate, " + 
			  "H.creationTime, " + 
			  "H.sessionIDCreation, " + 
			  "H.lastUpdateTime, " + 
			  "H.sessionIDUpdate, " + 
			  "H.chipStatusID, " + 
			  "C.name AS statusName, " + 
			  "S.name AS supplierName, " + 
			  "G.esn, " +
			  "D.displayID " + 
			  "FROM " + 
			  "dbo.MTXChip AS H " + 
			  "LEFT JOIN dbo.MTXChipStatus AS C ON H.chipStatusID= C.chipStatusID " + 
			  "LEFT JOIN dbo.MTXChipSupplier AS S ON H.chipSupplierID = S.chipSupplierID " + 
			  "LEFT JOIN dbo.MTXGps AS G ON H.gpsID = G.gpsID " +
			  "LEFT JOIN dbo.MTXDisplay AS D ON H.chipID = D.chipID " +
			  "ORDER BY H.sim ASC")
	@Options(statementType = StatementType.PREPARED)	
	List<Chip> selectAll() throws Exception;

	@Update(value = 
			 "UPDATE [dbo].[MTXChip] " + 
					  "   SET [gpsID] = #{gpsID,jdbcType=INTEGER,mode=IN} " + 
					  "      ,[iccid] = #{iccid,jdbcType=VARCHAR,mode=IN} " + 
					  "      ,[description] = #{description,jdbcType=VARCHAR,mode=IN} " + 
					  "      ,[chipSupplierID] = #{chipSupplierID,jdbcType=INTEGER,mode=IN} " + 
					  "      ,[deliveryDate] = #{deliveryDate,jdbcType=BIGINT,mode=IN} " + 
					  "      ,[lastUpdateTime] = #{lastUpdateTime,jdbcType=BIGINT,mode=IN} " + 
					  "      ,[sessionIDUpdate] = #{sessionIDUpdate,jdbcType=BIGINT,mode=IN} " + 
					  "      ,[chipStatusID] = #{chipStatusID,jdbcType=INTEGER,mode=IN} " + 
					  " WHERE chipID = #{chipID,jdbcType=INTEGER,mode=IN}")
	@Options(statementType = StatementType.PREPARED)	
	void update(Chip chip) throws Exception;
	
	@Insert(value = 
			" INSERT INTO [dbo].[MTXChip]" + 
					  "           ([gpsID]" + 
					  "           ,[sim]" + 
					  "           ,[iccid]" + 
					  "           ,[chipSupplierID]" + 
					  "           ,[description]" + 
					  "           ,[deliveryDate]" + 
					  "           ,[creationTime]" + 
					  "           ,[sessionIDCreation]" + 
					  "           ,[chipStatusID])" + 
					  "     VALUES " + 
					  "           (#{gpsID,jdbcType=INTEGER,mode=IN}" + 
					  "           ,#{sim,jdbcType=VARCHAR,mode=IN}" + 
					  "           ,#{iccid,jdbcType=VARCHAR,mode=IN}" + 
					  "           ,#{chipSupplierID,jdbcType=INTEGER,mode=IN}" + 
					  "           ,#{description,jdbcType=VARCHAR,mode=IN}" + 
					  "           ,#{deliveryDate,jdbcType=BIGINT,mode=IN}" + 
					  "           ,#{creationTime,jdbcType=BIGINT,mode=IN}" + 
					  "           ,#{sessionIDCreation,jdbcType=BIGINT,mode=IN}" + 
					  "           ,#{chipStatusID,jdbcType=INTEGER,mode=IN})")
	@Options(statementType = StatementType.PREPARED, useGeneratedKeys = true, keyProperty = "chipID")
	void insert(Chip chips) throws Exception;
	
	@Update(value = "UPDATE [dbo].[MTXChip] SET gpsID=-1 WHERE chipID=#{chipID,jdbcType=INTEGER,mode=IN}")
	@Options(statementType = StatementType.PREPARED)	
	void eliminarGPSDeChip(@Param("chipID") int chipID) throws Exception;
	
	@Insert(value = 
			  " INSERT INTO [dbo].[HOChipHistory]" + 
			  "           ([chipID]" + 
			  "           ,[iccid]" + 
			  "           ,[iccidOld]" + 
			  "           ,[chipSupplierID]" + 
			  "           ,[chipSupplierIDOld]" + 
			  "           ,[chipStatusID]" + 
			  "           ,[chipStatusIDOld]" + 
			  "           ,[creationTime]" + 
			  "           ,[userName])" + 
			  "     VALUES " + 
			  "           (#{chipID,jdbcType=INTEGER,mode=IN}" + 
			  "           ,#{iccid,jdbcType=VARCHAR,mode=IN}" + 
			  "           ,#{iccidOld,jdbcType=VARCHAR,mode=IN}" + 
			  "           ,#{chipSupplierID,jdbcType=INTEGER,mode=IN}" + 
			  "           ,#{chipSupplierIDOld,jdbcType=INTEGER,mode=IN}" + 
			  "           ,#{chipStatusID,jdbcType=INTEGER,mode=IN}" + 
			  "           ,#{chipStatusIDOld,jdbcType=INTEGER,mode=IN}" + 
			  "           ,#{creationTime,jdbcType=BIGINT,mode=IN}" + 
			  "           ,#{userName,jdbcType=VARCHAR,mode=IN})")
	@Options(statementType = StatementType.PREPARED, useGeneratedKeys = true, keyProperty = "chipHistoryID")
	void insertHistory(Chip chip) throws Exception;
	
	@Select(value = 
			  "SELECT " + 
			  "H.chipHistoryID, " + 
			  "H.chipID, " + 
			  "H.iccid, " + 
			  "H.iccidOld, " + 
			  "H.chipSupplierID, " + 
			  "H.chipSupplierIDOld, " + 
			  "H.chipStatusID, " + 
			  "H.chipStatusIDOld, " + 
			  "H.creationTime, " + 
			  "H.userName, " + 
			  "C.name as statusName, " + 
			  "Cold.name as statusNameOld, " + 
			  "S.name as supplierName, " + 
			  "Sold.name as supplierNameOld " + 
			  "FROM " + 
			  "dbo.HOChipHistory AS H " + 
			  "LEFT JOIN dbo.MTXChipStatus AS C ON H.chipStatusID = C.chipStatusID " + 
			  "LEFT JOIN dbo.MTXChipStatus AS Cold ON H.chipStatusIDOld = Cold.chipStatusID " + 
			  "LEFT JOIN dbo.MTXChipSupplier AS S ON H.chipSupplierID = S.chipSupplierID " + 
			  "LEFT JOIN dbo.MTXChipSupplier AS Sold ON H.chipSupplierIDOld = Sold.chipSupplierID " + 
			  "WHERE H.chipID = #{chipID,jdbcType=INTEGER,mode=IN} " +
			  "ORDER BY H.chipHistoryID DESC")
	@Options(statementType = StatementType.PREPARED)	
	List<Chip> selectHistoryChip(@Param("chipID") int chipID) throws Exception;
}
