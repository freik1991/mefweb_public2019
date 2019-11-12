package hacom.pe.datos.mapper.iface;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

import hacom.pe.datos.entidades.Actividad;
import hacom.pe.datos.entidades.AsistenciaRemota;
import hacom.pe.datos.entidades.AsistenciaTecnica;
import hacom.pe.datos.entidades.Capacitador;
import hacom.pe.datos.entidades.Cronograma;
import hacom.pe.datos.entidades.Departamento;
import hacom.pe.datos.entidades.Entidad;
import hacom.pe.datos.entidades.EntidadSectorista;
import hacom.pe.datos.entidades.Geozona;
import hacom.pe.datos.entidades.Implantador;
import hacom.pe.datos.entidades.Modalidad;
import hacom.pe.datos.entidades.Modulo;
import hacom.pe.datos.entidades.Motivo;
import hacom.pe.datos.entidades.MsUser;
import hacom.pe.datos.entidades.Sectorista;
import hacom.pe.datos.entidades.SubModulo;
import hacom.pe.datos.entidades.TipoLocal;
import hacom.pe.datos.entidades.TipoSistema;
import hacom.pe.datos.entidades.TipoUe;
import hacom.pe.datos.entidades.TipoVisita;
import hacom.pe.datos.entidades.Ubigeo;
import hacom.pe.datos.entidades.UsuarioMap;


public interface GenericMapper {

	@Select(value = 
			  "SELECT * "
			+ "FROM MEFUserProfile p inner join auth_user a "
			+ " on p.sectorist_id = a.id")
	List<MsUser> getAllSectorista() throws Exception ;
	
	
	@Select(value = 
			  "select name depaname from dbo.MEFLocationDepartment  where mefid= #{department}")
	Entidad getAllDepa(int depa) throws Exception ;
	
	@Select(value = 
			  "select name disname from dbo.MEFLocationDistrict where id= #{district}")
	Entidad getAllDistrito(int dis) throws Exception ;
	
	@Select(value = 
			  "select name provname from dbo.MEFLocationProvince where id= #{province}")
	Entidad getAllProvincia(int prov) throws Exception ;
	
	@Select(value = 
			  "select * from MEFGeozone g inner join auth_user a on g.user_id = a.id")
	List<Geozona> getAllGeozona() throws Exception ;
	
	@Select(value = 
			  "select * from MEFSectorista")
	List<Sectorista> getAllSectoristaAdm() throws Exception ;
	
	
	@Insert(value = "  {call dbo.usp_SaveSectorista("
			+ "#{dni,jdbcType=VARCHAR,mode=IN},"
			+ "#{nombreSec,jdbcType=VARCHAR,mode=IN},"
			+ "#{apellidoSec,jdbcType=VARCHAR,mode=IN},"
			+ "#{usuSec,jdbcType=VARCHAR,mode=IN},"
			+ "#{contSec,jdbcType=VARCHAR,mode=IN},"
			+ "#{estado,jdbcType=VARCHAR,mode=IN},"
			+ "#{tipo,jdbcType=VARCHAR,mode=IN}"
			+ ")} ")
	void getSaveSectorista(Sectorista sec) throws Exception ;
	
	@Update(value = "  {call usp_updateSectorista("
			+ "#{idSec,jdbcType=INTEGER,mode=IN},"
			+ "#{dni,jdbcType=VARCHAR,mode=IN},"
			+ "#{nombreSec,jdbcType=VARCHAR,mode=IN},"
			+ "#{apellidoSec,jdbcType=VARCHAR,mode=IN},"
			+ "#{usuSec,jdbcType=VARCHAR,mode=IN},"
			+ "#{contSec,jdbcType=VARCHAR,mode=IN},"
			+ "#{estado,jdbcType=VARCHAR,mode=IN}"
			+ ")} ")
	void getUpdateSectorista(Sectorista sec) throws Exception ;
	
	@Delete(value = " delete MEFSectorista  where idSec=#{sec}")
	void getdeleteSectorista(int sec) throws Exception ;
	
	@Select(value = 
			  "select * from mefusuario where tipo='A'")
	List<MsUser> getAllUsuarioAdm() throws Exception ;
	
	
	@Insert(value = "  {call dbo.usp_SaveAdmin("
			+ "#{is_superuser,jdbcType=INTEGER,mode=IN},"
			+ "#{username,jdbcType=VARCHAR,mode=IN},"
			+ "#{contrasena,jdbcType=VARCHAR,mode=IN},"
			+ "#{nombre_use,jdbcType=VARCHAR,mode=IN},"
			+ "#{apellido_use,jdbcType=VARCHAR,mode=IN},"
			+ "#{estado,jdbcType=VARCHAR,mode=IN},"
			+ "#{tipo,jdbcType=VARCHAR,mode=IN},"
			+ "#{dni,jdbcType=VARCHAR,mode=IN},"
			+ "#{email,jdbcType=VARCHAR,mode=IN}"
			+ ")} ")
	void getSaveAdmin(MsUser user) throws Exception ;
	
	@Insert(value = "" + 
			"insert into auth_user(password,username,first_name,last_name,email,idIdentif)"
			+ " values(#{password},#{username},#{first_name},#{last_name},#{email},#{idIdentif}) ")
	void getSaveAuthUser(MsUser user) throws Exception ;
	
	@Update(value = " update auth_user set password=#{password},username=#{username},first_name=#{first_name},"
			+ "last_name=#{last_name},email=#{email} where idIdentif=#{idIdentif}")
	void getUpdateAuthUser(MsUser user) throws Exception ;
	
	@Delete(value = " delete auth_user where idIdentif=#{use}")
	void getdeleteAuthUser(int use) throws Exception ;
	
	
	@Update(value = "  {call usp_UpdateAdmin("
			+ "#{iduser,jdbcType=INTEGER,mode=IN},"
			+ "#{username,jdbcType=VARCHAR,mode=IN},"
			+ "#{contrasena,jdbcType=VARCHAR,mode=IN},"
			+ "#{nombre_use,jdbcType=VARCHAR,mode=IN},"
			+ "#{apellido_use,jdbcType=VARCHAR,mode=IN},"
			+ "#{estado,jdbcType=VARCHAR,mode=IN},"
			+ "#{tipo,jdbcType=VARCHAR,mode=IN},"
			+ "#{dni,jdbcType=VARCHAR,mode=IN}"
			+ ")} ")
	void getUpdateAdmin(MsUser user) throws Exception ;
	
	@Delete(value = " delete mefusuario where iduser=#{use}")
	void getdeleteAdmin(int use) throws Exception ;
	
	@Select(value = 
			  "select * from MEFTipoUe")
	List<TipoUe> getAllTipoUe() throws Exception ;
	
	
	@Insert(value = "insert into MEFTipoUe(descripcion) values(#{descripcion})")
	void getSaveTipoUe(TipoUe ue) throws Exception ;
	
	@Update(value = " update MEFTipoUe set descripcion = #{descripcion} where idTipoUe = #{idTipoUe} ")
	void getUpdateTipoUe(TipoUe ue) throws Exception ;
	
	@Update(value = " delete MEFTipoUe where idTipoUe=#{sec}")
	void getdeleteTipoUe(int ue) throws Exception ;
	
	@Select(value = 
			  "select * from MEFTipoVisita")
	List<TipoVisita> getAllTipoVisita() throws Exception ;
	
	
	@Insert(value = "insert into MEFTipoVisita(descripcion) values(#{descripcion})")
	void getSaveTipoVisita(TipoVisita ue) throws Exception ;
	
	@Update(value = " update MEFTipoVisita set descripcion = #{descripcion} where idTipoVis = #{idTipoVis} ")
	void getUpdateTipoVisita(TipoVisita ue) throws Exception ;
	
	@Delete(value = " delete MEFTipoVisita where idTipoVis=#{idTipoVis}")
	void getdeleteTipoVisita(int idTipoVis) throws Exception ;
	
	@Select(value = 
			  "select * from MEFTipoSistema")
	List<TipoSistema> getAllTipoSistema() throws Exception ;
	
	@Insert(value = "insert into MEFTipoSistema(tipoSistema,tipoElemento) values(#{tipoSistema},#{tipoElemento})")
	void getSaveTipoSistema(TipoSistema ue) throws Exception ;
	
	@Update(value = " update MEFTipoSistema set tipoSistema = #{tipoSistema},tipoElemento = #{tipoElemento} where idTiposis = #{idTiposis} ")
	void getUpdateTipoSistema(TipoSistema ue) throws Exception ;
	
	@Delete(value = " delete MEFTipoSistema where idTiposis = #{idTiposis}")
	void getdeleteTipoSitema(int tipoSistema) throws Exception ;
	
	@Select(value = 
			  "select * from MEFModalidad")
	List<Modalidad> getAllTipoModalidad() throws Exception ;
	
	@Insert(value = "insert into MEFModalidad(titulo) values(#{titulo})")
	void getSaveModalidad(Modalidad ue) throws Exception ;
	
	@Update(value = " update MEFModalidad set titulo = #{titulo} where idModalidad = #{idModalidad} ")
	void getUpdateModalidad(Modalidad ue) throws Exception ;
	
	@Delete(value = " delete MEFModalidad where idModalidad = #{idModalidad}")
	void getdeleteModalidad(int idModalidad) throws Exception ;
	
	@Select(value = 
			  "select * from MEFTipoLocal")
	List<TipoLocal> getAllTipoLocal() throws Exception ;
	
	@Insert(value = "insert into MEFTipoLocal(tipoLocal) values(#{tipoLocal})")
	void getSaveTipoLocal(TipoLocal ue) throws Exception ;
	
	@Update(value = " update MEFTipoLocal set tipoLocal = #{tipoLocal} where idTipoLocal = #{idTipoLocal} ")
	void getUpdateTipoLocal(TipoLocal ue) throws Exception ;
	
	@Delete(value = " delete MEFTipoLocal where idTipoLocal = #{idTipoLocal}")
	void getdeleteTipoLocal(int idTipoLocal) throws Exception ;
	
	@Select(value = 
			  "select * from MEFMotive")
	List<Motivo> getAllTipoMotivo() throws Exception ;
	
	@Insert(value = "insert into MEFMotive(title) values(#{title})")
	void getSaveMotivo(Motivo ue) throws Exception ;
	
	@Update(value = " update MEFMotive set titulo = #{title} where idMotive = #{idMotive} ")
	void getUpdateMotivo(Motivo ue) throws Exception ;
	
	@Delete(value = " delete MEFMotive where idMotive = #{idMotive}")
	void getdeleteMotivo(int idMotivo) throws Exception ;
	
	@Select(value = " {call dbo.usp_getAllSubModulos()}")
	@Options(statementType = StatementType.CALLABLE)
	List<SubModulo> getAllSubModulo() throws Exception;
	
	@Insert(value = "insert into MEFSubModule(moduleID,subModuleName,status) values(#{moduleID},#{subModuleName},#{status})")
	void getSaveSubModulo(SubModulo ue) throws Exception ;
	
	@Update(value = " update MEFSubModule set moduleID = #{moduleID},subModuleName = #{subModuleName} where subModuleID = #{subModuleID} ")
	void getUpdateSubModulo(SubModulo ue) throws Exception ;
	
	@Update(value = " update MEFSubModule set status = '0' where subModuleID = #{subModuleID}")
	void getdeleteSubModulo(int id) throws Exception ;
	
	@Select(value = " {call dbo.usp_getAllImplantador()}")
	@Options(statementType = StatementType.CALLABLE)
	List<Implantador> getAllImplantador() throws Exception;
	
	@Insert(value = " insert into MEFImplantador(dni,imei,nombreImpl,apellidoImpl,celular,ruc,cas,usuaImpl,contImpl,correo,sectoristaId,fotoAdjunto,tipo)"
			+ " values (#{dni},#{imei},#{nombreImpl},#{apellidoImpl},#{celular},#{ruc},#{cas},#{usuaImpl},#{contImpl},#{correo},#{sectoristaId},#{fotoAdjunto},#{tipo})")
	void getSaveImplantador(Implantador ue) throws Exception ;
	
	@Update(value ="update MEFImplantador set dni=#{dni},imei=#{imei},nombreImpl=#{nombreImpl},apellidoImpl=#{apellidoImpl},celular=#{celular},ruc=#{ruc},cas=#{cas},usuaImpl=#{usuaImpl},"
			+ "contImpl=#{contImpl},correo=#{correo},sectoristaId=#{sectoristaId},fotoAdjunto=#{fotoAdjunto} where idImpl=#{idImpl}")
	void getUpdateImplantador(Implantador ue) throws Exception ;
	
	@Delete(value = " delete MEFImplantador where idImpl = #{idImpl}")
	void getdeleteImplantador(int id) throws Exception ;
	
	@Select(value = 
			  "select * from MEFUnit_users where user_id =#{implantadorId} ")
	List<EntidadSectorista> getAllEntidadSec(int implantadorId) throws Exception ;
	
	@Select(value = 
			  "select id,unitName from MEFUnit where  implantadorAsignado != 1")
	List<Entidad> getAllMfUnit() throws Exception ;
	
	@Update(value = " update MEFUnit set implantadorAsignado = 1 where id = #{id}")
	void getUpdateEntidadI(int id) throws Exception ;
	
//	@Insert(value = " insert into MEFEntidad_Implantador(entidadId,implantadorId) values  (#{entidadId},#{implantadorId})")
//	void getSaveEntidadImp(EntidadSectorista ue) throws Exception ;
	
	@Select(value = "SELECT TOP 1 * FROM MEFImplantador ORDER BY idImpl DESC")
	Implantador getFindIdImpl() throws Exception;
	
	
	
	@Select(value = 
			  "select * from MEFUnit where  id = #{id}")
	List<Entidad> getAllMfUnitId(int id) throws Exception ;
	
	@Delete(value = "delete  from MEFUnit_users where user_id =#{implantadorId}")
	void getDeleteEntidadImp(int implantadorId) throws Exception ;
	
	@Update(value = " update MEFUnit set implantadorAsignado = 0 where id = #{id}")
	void getUpdateEntidadIRese(int id) throws Exception ;
	
	
	@Select(value = 
			  "select * from MEFCapacitador where estado = 'A'")
	List<Capacitador> getAllCapacitador() throws Exception ;
	
	@Insert(value = " insert into MEFCapacitador(nombreCap,apeCap,dni,correo,usuario,clave,foto,estado,tipo) "
			+ "values  (#{nombreCap},#{apeCap},#{dni},#{correo},#{usuario},#{clave},#{fotoAdjunto},#{estado},#{tipo})")
	void getSaveCapacitador(Capacitador ca) throws Exception ;
	
	@Update(value = " update MEFCapacitador set nombreCap = #{nombreCap},apeCap = #{apeCap},dni = #{dni},correo = #{correo},"
			+ "usuario = #{usuario},clave = #{clave},foto = #{fotoAdjunto},estado = #{estado} where idCap = #{idCap}")
	void getUpdateCapacitador(Capacitador ca) throws Exception ;
	
	@Delete(value = " delete MEFCapacitador  where idCap = #{idCap}")
	void getUpdateEstadoCapa(int id) throws Exception ;
	
	@Select(value = 
			  "SELECT * FROM MEFLocationDepartment WHERE mefid != 0")
	List<Ubigeo> getAllDepartamento() throws Exception ;
	
	
	@Select(value = 
			  "SELECT name as nameprov,mefid as mefprov FROM MEFLocationProvince WHERE mefid != 0 and deparment_id =#{deparment_id} ")
	List<Ubigeo> getAllProvinciaDepa(int deparment_id) throws Exception ;
	
	@Select(value = 
			  "SELECT * FROM MEFLocationDistrict WHERE mefid != 0 and province_id = #{province_id}")
	List<Ubigeo> getAllDistritoProvi(int province_id) throws Exception ;
	
	@Select(value = 
			  "select id,unitName from MEFUnit")
	List<Entidad> getAllEntidadSel() throws Exception ;
	
	@Select(value = 
			  "select m.idImpl,concat(m.nombreImpl,' ',m.apellidoImpl) as nameImp from MEFImplantador m")
	List<Implantador> getAllImplantadorSel() throws Exception ;
	
	@Insert(value = " insert into MEFTrainig(dateTraining,themeTraining,level,localTraining,department,typeAttention,groupLeader,exhibitor,typeSystem,moduleId,observation,nroEntGN,nroUsuGN," + 
			"nroEntGR,nroUsuGR,nroEntGL,nroUsuGL,nroEntUO,nroUsuUO,nroEntMC,nroUsuMC,nroEntIP,nroUsuIP,nroEntTE,nroUsuTE,status,idCap) values (#{fechaCadena},#{themeTraining},#{level},#{localTraining},"
			+ "#{department},#{typeAttention},#{groupLeader},#{exhibitor},#{typeSystem},#{moduleId},#{observation},#{nroEntGN},#{nroUsuGN}," + 
			"#{nroEntGR},#{nroUsuGR},#{nroEntGL},#{nroUsuGL},#{nroEntUO},#{nroUsuUO},#{nroEntMC},#{nroUsuMC},#{nroEntIP},#{nroUsuIP},#{nroEntTE},#{nroUsuTE},#{status},#{idCapa})")
	void getSaveCapacitacion(Capacitador cap) throws Exception ;
	
	@Update(value = "  update MEFTrainig set dateTraining=#{fechaCadena},themeTraining=#{themeTraining},level=#{level},localTraining=#{localTraining},department=#{department},typeAttention=#{typeAttention},groupLeader=#{groupLeader},exhibitor=#{exhibitor},typeSystem=#{typeSystem},moduleId=#{moduleId},observation=#{observation}," + 
			"nroEntGN=#{nroEntGN},nroUsuGN=#{nroUsuGN},nroEntGR=#{nroEntGR},nroUsuGR=#{nroUsuGR},nroEntGL=#{nroEntGL},nroUsuGL=#{nroUsuGL},nroEntUO=#{nroEntUO},nroUsuUO=#{nroUsuUO},nroEntMC=#{nroEntMC},nroUsuMC=#{nroUsuMC},nroEntIP=#{nroEntIP},nroUsuIP=#{nroUsuIP},nroEntTE=#{nroEntTE},nroUsuTE=#{nroUsuTE},status=#{status} where id=#{id}")
	void getUpdateCapacitadores(Capacitador cap) throws Exception ;
	
	@Select(value = " {call dbo.usp_getAllTraining()}")
	@Options(statementType = StatementType.CALLABLE)
	List<Capacitador> getAllCapacitacion() throws Exception;
	
	@Select(value = " {call dbo.usp_getAllCronograma()}")
	@Options(statementType = StatementType.CALLABLE)
	List<Cronograma> getAllCronograma() throws Exception;
	
	@Insert(value = "  {call dbo.usp_SaveCronograma("
			+ "#{visitDate,jdbcType=VARCHAR,mode=IN},"
			+ "#{visitHour,jdbcType=VARCHAR,mode=IN},"
			+ "#{visitType,jdbcType=INTEGER,mode=IN},"
			+ "#{userItineraryDescription,jdbcType=VARCHAR,mode=IN},"
			+ "#{status,jdbcType=VARCHAR,mode=IN},"
			+ "#{auditCreationDate,jdbcType=VARCHAR,mode=IN},"
			+ "#{isPlanned,jdbcType=VARCHAR,mode=IN},"
			+ "#{implanter_id,jdbcType=INTEGER,mode=IN},"
			+ "#{unit_id,jdbcType=INTEGER,mode=IN},"
			+ "#{systemId,jdbcType=INTEGER,mode=IN},"
			+ "#{comments,jdbcType=VARCHAR,mode=IN}"
			+ ")} ")
	void getSaveCronograma(Cronograma crono) throws Exception ;
	
	@Update(value = "  {call dbo.usp_UpdateCronograma("
			+ "#{idCrono,jdbcType=INTEGER,mode=IN},"
			+ "#{visitDate,jdbcType=VARCHAR,mode=IN},"
			+ "#{visitHour,jdbcType=VARCHAR,mode=IN},"
			+ "#{visitType,jdbcType=INTEGER,mode=IN},"
			+ "#{userItineraryDescription,jdbcType=VARCHAR,mode=IN},"
			+ "#{status,jdbcType=VARCHAR,mode=IN},"
			+ "#{isPlanned,jdbcType=VARCHAR,mode=IN},"
			+ "#{implanter_id,jdbcType=INTEGER,mode=IN},"
			+ "#{unit_id,jdbcType=INTEGER,mode=IN},"
			+ "#{systemId,jdbcType=INTEGER,mode=IN},"
			+ "#{comments,jdbcType=VARCHAR,mode=IN}"
			+ ")} ")
	void getUpdateCronograma(Cronograma crono) throws Exception ;
	
	@Delete(value = " delete MEFSchedule where idCrono=#{idCrono}")
	void getdeleteCronograma(int idCrono) throws Exception ;
	
	@Select(value = " {call dbo.usp_getAllAsisPre()}")
	@Options(statementType = StatementType.CALLABLE)
	List<AsistenciaTecnica> getAllAsistenciaPres() throws Exception;
	
	@Insert(value = "  {call dbo.usp_SaveAsistenciaPres("
			+ "#{representantName,jdbcType=VARCHAR,mode=IN},"
			+ "#{representantEmail,jdbcType=VARCHAR,mode=IN},"
			+ "#{representantWorkingPosition,jdbcType=VARCHAR,mode=IN},"
			+ "#{phoneNumber,jdbcType=VARCHAR,mode=IN},"
			+ "#{localType,jdbcType=VARCHAR,mode=IN},"
			+ "#{assistanceStartTime,jdbcType=VARCHAR,mode=IN},"
			+ "#{assistanceEndTime,jdbcType=VARCHAR,mode=IN},"
			+ "#{assistanceDescription,jdbcType=VARCHAR,mode=IN},"
			+ "#{recomendacion,jdbcType=VARCHAR,mode=IN},"
			+ "#{assistanceType,jdbcType=INTEGER,mode=IN},"
			+ "#{arrivalDate,jdbcType=VARCHAR,mode=IN},"
			+ "#{departureDate,jdbcType=VARCHAR,mode=IN},"
			+ "#{system_id,jdbcType=INTEGER,mode=IN},"
			+ "#{itinerary_id,jdbcType=INTEGER,mode=IN},"
			+ "#{coordinateX,jdbcType=FLOAT,mode=IN},"
			+ "#{coordinateY,jdbcType=FLOAT,mode=IN},"
			+ "#{typeAttention,jdbcType=VARCHAR,mode=IN},"
			+ "#{unitid,jdbcType=INTEGER,mode=IN},"
			+ "#{status,jdbcType=VARCHAR,mode=IN}"
			+ ")} ")
	void getSaveAsistenciaPres(AsistenciaTecnica asist) throws Exception ;
	
	@Update(value = "  {call dbo.usp_UpdateAsistenciaPres("
			+ "#{idAssip,jdbcType=INTEGER,mode=IN},"
			+ "#{representantName,jdbcType=VARCHAR,mode=IN},"
			+ "#{representantEmail,jdbcType=VARCHAR,mode=IN},"
			+ "#{representantWorkingPosition,jdbcType=VARCHAR,mode=IN},"
			+ "#{phoneNumber,jdbcType=VARCHAR,mode=IN},"
			+ "#{localType,jdbcType=VARCHAR,mode=IN},"
			+ "#{assistanceStartTime,jdbcType=VARCHAR,mode=IN},"
			+ "#{assistanceEndTime,jdbcType=VARCHAR,mode=IN},"
			+ "#{assistanceDescription,jdbcType=VARCHAR,mode=IN},"
			+ "#{recomendacion,jdbcType=VARCHAR,mode=IN},"
			+ "#{assistanceType,jdbcType=INTEGER,mode=IN},"
			+ "#{arrivalDate,jdbcType=VARCHAR,mode=IN},"
			+ "#{departureDate,jdbcType=VARCHAR,mode=IN},"
			+ "#{system_id,jdbcType=INTEGER,mode=IN},"
			+ "#{itinerary_id,jdbcType=INTEGER,mode=IN},"
			+ "#{coordinateX,jdbcType=FLOAT,mode=IN},"
			+ "#{coordinateY,jdbcType=FLOAT,mode=IN},"
			+ "#{typeAttention,jdbcType=VARCHAR,mode=IN},"
			+ "#{unitid,jdbcType=INTEGER,mode=IN},"
			+ "#{status,jdbcType=VARCHAR,mode=IN}"
			+ ")} ")
	void getUpdateAsistenciPres(AsistenciaTecnica crono) throws Exception ;
	
	@Delete(value = " delete MEFAssistancePre where idAssip=#{idAssip}")
	void getdeleteAsistenciaPres(int idAssip) throws Exception ;
		
	@Select(value = " {call dbo.usp_getAllAsisRemota()}")
	@Options(statementType = StatementType.CALLABLE)
	List<AsistenciaRemota> getAllAsistenciaRem() throws Exception;
	
	@Insert(value = "  {call dbo.usp_SaveAsistenciaRemota("
			+ "#{unitID,jdbcType=INTEGER,mode=IN},"
			+ "#{email,jdbcType=VARCHAR,mode=IN},"
			+ "#{modality,jdbcType=VARCHAR,mode=IN},"
			+ "#{systemID,jdbcType=INTEGER,mode=IN},"
			+ "#{moduleID,jdbcType=INTEGER,mode=IN},"
			+ "#{subModuleID,jdbcType=INTEGER,mode=IN},"
			+ "#{implanterID,jdbcType=INTEGER,mode=IN},"
			+ "#{description,jdbcType=VARCHAR,mode=IN},"
			+ "#{timestamp,jdbcType=VARCHAR,mode=IN},"
			+ "#{creationTime,jdbcType=INTEGER,mode=IN},"
			+ "#{assistanceDate,jdbcType=VARCHAR,mode=IN},"
			+ "#{registerType,jdbcType=INTEGER,mode=IN},"
			+ "#{assistanceStartTime,jdbcType=VARCHAR,mode=IN},"
			+ "#{assistanceEndTime,jdbcType=VARCHAR,mode=IN},"
			+ "#{assistanceType,jdbcType=VARCHAR,mode=IN},"
			+ "#{status,jdbcType=VARCHAR,mode=IN}"
			+ ")} ")
	void getSaveAsistenciarRem(AsistenciaRemota asist) throws Exception ;
	
	@Update(value = "  {call dbo.usp_UpdateAsistenciaRemota("
			+ "#{remoteAssistanceID,jdbcType=INTEGER,mode=IN},"
			+ "#{unitID,jdbcType=INTEGER,mode=IN},"
			+ "#{email,jdbcType=VARCHAR,mode=IN},"
			+ "#{modality,jdbcType=VARCHAR,mode=IN},"
			+ "#{systemID,jdbcType=INTEGER,mode=IN},"
			+ "#{moduleID,jdbcType=INTEGER,mode=IN},"
			+ "#{subModuleID,jdbcType=INTEGER,mode=IN},"
			+ "#{implanterID,jdbcType=INTEGER,mode=IN},"
			+ "#{description,jdbcType=VARCHAR,mode=IN},"
			+ "#{timestamp,jdbcType=VARCHAR,mode=IN},"
			+ "#{assistanceDate,jdbcType=VARCHAR,mode=IN},"
			+ "#{registerType,jdbcType=INTEGER,mode=IN},"
			+ "#{assistanceStartTime,jdbcType=VARCHAR,mode=IN},"
			+ "#{assistanceEndTime,jdbcType=VARCHAR,mode=IN},"
			+ "#{assistanceType,jdbcType=VARCHAR,mode=IN},"
			+ "#{status,jdbcType=VARCHAR,mode=IN}"
			+ ")} ")
	void getUpdateAsistenciRem(AsistenciaRemota crono) throws Exception ;
	
	@Delete(value = " delete AssistanceRemote where remoteAssistanceID=#{remoteAssistanceID}")
	void getdeleteAsistenciaRem(int remoteAssistanceID) throws Exception ;
	
	
	
	@Select(value = " {call dbo.usp_getAllActividad()}")
	@Options(statementType = StatementType.CALLABLE)
	List<Actividad> getAllActividad() throws Exception;
	
	@Insert(value = "  {call dbo.usp_SaveActividad("
			+ "#{implId,jdbcType=INTEGER,mode=IN},"
			+ "#{systemId,jdbcType=INTEGER,mode=IN},"
			+ "#{idMot,jdbcType=INTEGER,mode=IN},"
			+ "#{activitieDate,jdbcType=VARCHAR,mode=IN},"
			+ "#{comment,jdbcType=VARCHAR,mode=IN},"
			+ "#{state,jdbcType=VARCHAR,mode=IN},"
			+ "#{idCap,jdbcType=INTEGER,mode=IN}"
			+ ")} ")
	void getSaveActividad(Actividad asist) throws Exception ;
	
	@Update(value = "  {call dbo.usp_UpdateActividad("
			+ "#{idAct,jdbcType=INTEGER,mode=IN},"
			+ "#{implId,jdbcType=INTEGER,mode=IN},"
			+ "#{systemId,jdbcType=INTEGER,mode=IN},"
			+ "#{idMot,jdbcType=INTEGER,mode=IN},"
			+ "#{activitieDate,jdbcType=VARCHAR,mode=IN},"
			+ "#{comment,jdbcType=VARCHAR,mode=IN},"
			+ "#{state,jdbcType=VARCHAR,mode=IN}"
			+ ")} ")
	void getUpdateActividad(Actividad crono) throws Exception ;
	
	@Delete(value = " delete MEFActivities where idAct=#{idAct}")
	void getdeleteActividad(int idAct) throws Exception ;
	
	@Select(value = 
			  "select * from MEFUsuMap")
	List<UsuarioMap> getAllUsuarioMap() throws Exception ;
	

	@Insert(value = "insert into MEFUsuMap(usuario,clave,tipo) values(#{usuario},#{clave},#{tipo})")
	void getSaveUsuarioMap(UsuarioMap ue) throws Exception ;
	
	@Update(value = " update MEFUsuMap set usuario = #{usuario},clave = #{clave} where idUsumap = #{idUsumap}")
	void getUpdateUsuarioMap(UsuarioMap ue) throws Exception ;
	
	@Delete(value = " delete MEFUsuMap   where idUsumap = #{idUsumap}")
	void getDeleteUsuMap(UsuarioMap ue) throws Exception ;
	
	@Select(value = 
			  "select * from MEFUsuMap where usuario = #{usuario} and  clave = #{clave} and  tipo = #{tipo}")
	List<UsuarioMap> getAllIdUsuarioMap(UsuarioMap ue) throws Exception ;
	
	@Select(value = "SELECT * FROM MEFImplantador WHERE usuaImpl=#{usuaImpl}")
	Implantador getFindUsuImpl(Implantador usuaImpl) throws Exception;
	
	@Select(value = " {call dbo.usp_getFindAsisRemotaImp("
			+ "#{implanterID,jdbcType=INTEGER,mode=IN}"
			+ ")}")
	@Options(statementType = StatementType.CALLABLE)
	List<AsistenciaRemota> getFindAsistenciaRemImp(AsistenciaRemota imp) throws Exception;
	
	@Select(value = "SELECT * FROM MEFSectorista WHERE usuSec=#{usuSec}")
	Sectorista getFindUsuImplSec(Sectorista usuaImpl) throws Exception;
	
	@Select(value = " {call dbo.usp_getFindImplantadorSec("
			+ "#{sectoristaId,jdbcType=INTEGER,mode=IN}"
			+ ")}")
	@Options(statementType = StatementType.CALLABLE)
	List<Implantador> getFindImplantadorSec(Implantador imp) throws Exception;
	
	@Select(value = " {call dbo.usp_getAllAsisPresSec("
			+ "#{sectorist_id,jdbcType=INTEGER,mode=IN}"
			+ ")}")
	@Options(statementType = StatementType.CALLABLE)
	List<AsistenciaTecnica> getFindAsistenciaPresSec(AsistenciaTecnica tec) throws Exception;
	
	@Select(value = " {call dbo.usp_getAllAsisRemotaSec("
			+ "#{sectorist_id,jdbcType=INTEGER,mode=IN}"
			+ ")}")
	@Options(statementType = StatementType.CALLABLE)
	List<AsistenciaRemota> getFindAsistenciaRemSec(AsistenciaRemota rem) throws Exception;
	
	@Select(value = "select * from MEFCapacitador where usuario=#{usuario}")
	Capacitador getFindCapacitadorId(Capacitador cap) throws Exception;
	
	@Select(value = " {call dbo.usp_getFindTrainingId("
			+ "#{capacitadorId,jdbcType=INTEGER,mode=IN}"
			+ ")}")
	@Options(statementType = StatementType.CALLABLE)
	List<Capacitador> getFindCapacitadorID(Capacitador cap) throws Exception;
	
	@Select(value = " {call dbo.usp_getFindActividadId("
			+ "#{capacitadorId,jdbcType=INTEGER,mode=IN}"
			+ ")}")
	@Options(statementType = StatementType.CALLABLE)
	List<Actividad> getFindActividadID(Actividad cap) throws Exception;
	
	@Update(value = "update MEFGeozone set latitude=#{latitude},longitude=#{longitude},radius=#{radius} where id=#{id}")
	void getUpdateCoordenadas(Geozona geo) throws Exception ;
	
	
	@Select(value = 
			  "select top 1 * from MEFUsuario  where tipo='A' order by iduser desc")
	MsUser getUsuarioId() throws Exception ;
	
	@Select(value = 
			  "select top 1 * from MEFSectorista order by idSec desc")
	MsUser getSectoristaId() throws Exception ;
	
	@Select(value = 
			  "select top 1 * from MEFImplantador order by idImpl desc")
	MsUser getImplantadoId() throws Exception ;
	
	@Select(value = 
			  "select top 1 * from MEFCapacitador order by idCap desc")
	MsUser getCapacitadorId() throws Exception ;
	
	@Insert(value = " insert into MEFUnit_users(mefunit_id,user_id) values  (#{entidadId},#{implantadorId})")
	void getSaveEntidadImp(EntidadSectorista ue) throws Exception ;
}
