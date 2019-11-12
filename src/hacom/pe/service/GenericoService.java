package hacom.pe.service;

import java.io.Serializable;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hacom.pe.datos.entidades.Actividad;
import hacom.pe.datos.entidades.AsistenciaRemota;
import hacom.pe.datos.entidades.AsistenciaTecnica;
import hacom.pe.datos.entidades.Capacitador;
import hacom.pe.datos.entidades.Cronograma;
import hacom.pe.datos.entidades.Entidad;
import hacom.pe.datos.entidades.EntidadSectorista;
import hacom.pe.datos.entidades.Geozona;
import hacom.pe.datos.entidades.Implantador;
import hacom.pe.datos.entidades.Modalidad;
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
import hacom.pe.datos.mapper.iface.AsistenciaTecMapper;
import hacom.pe.negocio.EntidadNegocio;
import hacom.pe.negocio.GenericNegocio;

@Service
public class GenericoService implements Serializable {

	final static Logger log = LogManager.getLogger(GenericoService.class.getName());

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	GenericNegocio genericNegocio;

	public List<MsUser> getAllSectorista() throws Exception {
		List<MsUser> lstAsi = genericNegocio.getAllSectorista();
		return lstAsi;
	}

	public Entidad getAllDepartamento(int depa) throws Exception {
		Entidad en = genericNegocio.getAllDepa(depa);
		return en;
	}

	public Entidad getAllDistricto(int depa) throws Exception {
		Entidad en = genericNegocio.getAllDistrito(depa);
		return en;
	}

	public Entidad getAllProvincia(int depa) throws Exception {
		Entidad en = genericNegocio.getAllProvincia(depa);
		return en;
	}

	public List<Geozona> getAllGeozona() throws Exception {
		List<Geozona> en = genericNegocio.getAllGeozona();
		return en;
	}

	public List<MsUser> getAllUsuarioAdm() throws Exception {
		List<MsUser> en = genericNegocio.getAllUsuarioAdm();
		return en;
	}

	public void getSaveAdmin(MsUser user) throws Exception {
		genericNegocio.getSaveAdmin(user);

	}

	public void getUpdateAdmin(MsUser user) throws Exception {
		genericNegocio.getUpdateAdmin(user);

	}

	public void getDeleteAdmin(int use) throws Exception {
		genericNegocio.getdeleteAdmin(use);

	}

	public List<Sectorista> getAllSectoristaAdm() throws Exception {
		try {
			return genericNegocio.getAllSectoristaAdm();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void getSaveSectorista(Sectorista sec) throws Exception {
		genericNegocio.getSaveSectorista(sec);
	}

	public void getUpdateSectorista(Sectorista sec) throws Exception {
		genericNegocio.getUpdateSectorista(sec);

	}

	public void getdeleteSectorista(int sec) throws Exception {
		genericNegocio.getdeleteSectorista(sec);
	}

	public List<TipoUe> getAllTipoUe() throws Exception {
		try {
			return genericNegocio.getAllTipoUe();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void getSaveTipoUe(TipoUe ue) throws Exception {
		genericNegocio.getSaveTipoUe(ue);
	}

	public void getUpdateTipoUe(TipoUe ue) throws Exception {
		genericNegocio.getUpdateTipoUe(ue);
	}

	public void getdeleteTipoUe(int ue) throws Exception {
		genericNegocio.getdeleteTipoUe(ue);
	}

	public List<TipoVisita> getAllTipoVisita() throws Exception {
		try {
			return genericNegocio.getAllTipoVisita();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void getSaveTipoVisita(TipoVisita ue) throws Exception {
		genericNegocio.getSaveTipoVisita(ue);

	}

	public void getUpdateTipoVisita(TipoVisita ue) throws Exception {
		genericNegocio.getUpdateTipoVisita(ue);
	}

	public void getdeleteTipoVisita(int idTipoVis) throws Exception {
		genericNegocio.getdeleteTipoVisita(idTipoVis);
	}

	public List<TipoSistema> getAllTipoSistema() throws Exception {
		try {
			return genericNegocio.getAllTipoSistema();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void getSaveTipoSistema(TipoSistema ue) throws Exception {
		genericNegocio.getSaveTipoSistema(ue);
	}

	public void getUpdateTipoSistema(TipoSistema ue) throws Exception {
		genericNegocio.getUpdateTipoSistema(ue);
	}

	public void getdeleteTipoSitema(int tipoSistema) throws Exception {
		genericNegocio.getdeleteTipoSitema(tipoSistema);
	}

	public List<Modalidad> getAllTipoModalidad() throws Exception {
		try {
			return genericNegocio.getAllTipoModalidad();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void getSaveModalidad(Modalidad ue) throws Exception {
		genericNegocio.getSaveModalidad(ue);
	}

	public void getUpdateModalidad(Modalidad ue) throws Exception {
		genericNegocio.getUpdateModalidad(ue);
	}

	public void getdeleteModalidad(int idModalidad) throws Exception {
		genericNegocio.getdeleteModalidad(idModalidad);

	}

	public List<TipoLocal> getAllTipoLocal() throws Exception {
		try {
			return genericNegocio.getAllTipoLocal();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void getSaveTipoLocal(TipoLocal ue) throws Exception {
		genericNegocio.getSaveTipoLocal(ue);
	}

	public void getUpdateTipoLocal(TipoLocal ue) throws Exception {
		genericNegocio.getUpdateTipoLocal(ue);
	}

	public void getdeleteTipoLocal(int idTipoLocal) throws Exception {
		genericNegocio.getdeleteTipoLocal(idTipoLocal);
	}

	public List<Motivo> getAllTipoMotivo() throws Exception {
		try {
			return genericNegocio.getAllTipoMotivo();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void getSaveMotivo(Motivo ue) throws Exception {
		genericNegocio.getSaveMotivo(ue);
	}

	public void getUpdateMotivo(Motivo ue) throws Exception {
		genericNegocio.getUpdateMotivo(ue);
	}

	public void getdeleteMotivo(int idMotivo) throws Exception {
		genericNegocio.getdeleteMotivo(idMotivo);
	}

	public List<SubModulo> getAllSubModulo() throws Exception {
		try {
			return genericNegocio.getAllSubModulo();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void getSaveSubModulo(SubModulo ue) throws Exception {
		genericNegocio.getSaveSubModulo(ue);
	}

	public void getUpdateSubModulo(SubModulo ue) throws Exception {
		genericNegocio.getUpdateSubModulo(ue);
	}

	public void getdeleteSubModulo(int id) throws Exception {
		genericNegocio.getdeleteSubModulo(id);
	}

	public List<Implantador> getAllImplantador() throws Exception {
		try {
			return genericNegocio.getAllImplantador();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void getSaveImplantador(Implantador ue) throws Exception {
		genericNegocio.getSaveImplantador(ue);
	}

	public void getUpdateImplantador(Implantador ue) throws Exception {
		genericNegocio.getUpdateImplantador(ue);
	}

	public void getdeleteImplantador(int id) throws Exception {
		genericNegocio.getdeleteImplantador(id);
	}

	public List<EntidadSectorista> getAllEntidadSec(int sectoristaId) throws Exception {
		try {
			return genericNegocio.getAllEntidadSec(sectoristaId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public List<Entidad> getAllMfUnit() throws Exception {
		try {
			return genericNegocio.getAllMfUnit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void getUpdateEntidadI(int id) throws Exception {
		genericNegocio.getUpdateEntidadI(id);
	}

	public void getSaveEntidadImp(EntidadSectorista ue) throws Exception {
		genericNegocio.getSaveEntidadImp(ue);
	}

	public Implantador getFindIdImpl() throws Exception {
		return genericNegocio.getFindIdImpl();

	}

	public List<Entidad> getAllMfUnitId(int id) throws Exception {
		return genericNegocio.getAllMfUnitId(id);
	}

	public void getDeleteEntidadImp(int implantadorId) throws Exception {
		genericNegocio.getDeleteEntidadImp(implantadorId);
	}

	public void getUpdateEntidadIRese(int id) throws Exception {
		genericNegocio.getUpdateEntidadIRese(id);
	}

	public List<Capacitador> getAllCapacitador() throws Exception {
		try {
			return genericNegocio.getAllCapacitador();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void getSaveCapacitador(Capacitador ca) throws Exception {
		genericNegocio.getSaveCapacitador(ca);
	}

	public void getUpdateCapacitador(Capacitador ca) throws Exception {
		genericNegocio.getUpdateCapacitador(ca);
	}

	public void getUpdateEstadoCapa(int id) throws Exception {
		genericNegocio.getUpdateEstadoCapa(id);
	}

	public List<Ubigeo> getAllDepartamento() throws Exception {
		try {
			return genericNegocio.getAllDepartamento();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public List<Ubigeo> getAllProvinciaDepa(int deparment_id) throws Exception {
		try {
			return genericNegocio.getAllProvinciaDepa(deparment_id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public List<Ubigeo> getAllDistritoProvi(int province_id) throws Exception {
		try {
			return genericNegocio.getAllDistritoProvi(province_id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public List<Entidad> getAllEntidadSel() throws Exception {
		try {
			return genericNegocio.getAllEntidadSel();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public List<Implantador> getAllImplantadorSel() throws Exception {
		try {
			return genericNegocio.getAllImplantadorSel();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void getSaveCapacitacion(Capacitador cap) throws Exception {
		this.genericNegocio.getSaveCapacitacion(cap);
	}

	public void getUpdateCapacitadores(Capacitador cap) throws Exception {
		this.genericNegocio.getUpdateCapacitadores(cap);
	}

	public List<Capacitador> getAllCapacitacion() throws Exception {
		try {
			return genericNegocio.getAllCapacitacion();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public List<Cronograma> getAllCronograma() throws Exception {
		try {
			return genericNegocio.getAllCronograma();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void getSaveCronograma(Cronograma crono) throws Exception {
		this.genericNegocio.getSaveCronograma(crono);
	}

	public void getUpdateCronograma(Cronograma crono) throws Exception {
		this.genericNegocio.getUpdateCronograma(crono);
	}

	public void getdeleteCronograma(int idCrono) throws Exception {
		this.genericNegocio.getdeleteCronograma(idCrono);
	}

	public List<AsistenciaTecnica> getAllAsistenciaPres() throws Exception {
		try {
			return genericNegocio.getAllAsistenciaPres();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void getSaveAsistenciaPres(AsistenciaTecnica asist) throws Exception {
		this.genericNegocio.getSaveAsistenciaPres(asist);
	}

	public void getUpdateAsistenciPres(AsistenciaTecnica crono) throws Exception {
		this.genericNegocio.getUpdateAsistenciPres(crono);
	}

	public void getdeleteAsistenciaPres(int idAssip) throws Exception {
		this.genericNegocio.getdeleteAsistenciaPres(idAssip);
	}

	public List<AsistenciaRemota> getAllAsistenciaRem() throws Exception {
		try {
			return genericNegocio.getAllAsistenciaRem();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void getSaveAsistenciarRem(AsistenciaRemota asist) throws Exception {
		this.genericNegocio.getSaveAsistenciarRem(asist);
	}

	public void getUpdateAsistenciRem(AsistenciaRemota crono) throws Exception {
		this.genericNegocio.getUpdateAsistenciRem(crono);
	}

	public void getdeleteAsistenciaRem(int remoteAssistanceID) throws Exception {
		this.genericNegocio.getdeleteAsistenciaRem(remoteAssistanceID);
	}

	public List<Actividad> getAllActividad() throws Exception {
		try {
			return genericNegocio.getAllActividad();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void getSaveActividad(Actividad asist) throws Exception {
		this.genericNegocio.getSaveActividad(asist);
	}

	public void getUpdateActividad(Actividad crono) throws Exception {
		this.genericNegocio.getUpdateActividad(crono);
	}

	public void getdeleteActividad(int idAct) throws Exception {
		this.genericNegocio.getdeleteActividad(idAct);
	}

	public List<UsuarioMap> getAllUsuarioMap() throws Exception {
		try {
			return genericNegocio.getAllUsuarioMap();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void getSaveUsuarioMap(UsuarioMap ue) throws Exception {
		this.genericNegocio.getSaveUsuarioMap(ue);
	}

	public void getUpdateUsuarioMap(UsuarioMap ue) throws Exception {
		this.genericNegocio.getUpdateUsuarioMap(ue);
	}

	public void getDeleteUsuMap(UsuarioMap ue) throws Exception {
		this.genericNegocio.getDeleteUsuMap(ue);
	}

	public List<UsuarioMap> getAllIdUsuarioMap(UsuarioMap ue) throws Exception {
		try {
			return genericNegocio.getAllIdUsuarioMap(ue);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public Implantador getFindUsuImpl(Implantador im) throws Exception {
		return genericNegocio.getFindUsuImpl(im);
	}

	public List<AsistenciaRemota> getFindAsistenciaRemImp(AsistenciaRemota imp) throws Exception {
		try {
			return genericNegocio.getFindAsistenciaRemImp(imp);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public Sectorista getFindUsuImplSec(Sectorista usuaImpl) throws Exception {
		return this.genericNegocio.getFindUsuImplSec(usuaImpl);
	}

	public List<Implantador> getFindImplantadorSec(Implantador imp) throws Exception {
		try {
			return genericNegocio.getFindImplantadorSec(imp);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public List<AsistenciaTecnica> getFindAsistenciaPresSec(AsistenciaTecnica tec) throws Exception {
		try {
			return genericNegocio.getFindAsistenciaPresSec(tec);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public List<AsistenciaRemota> getFindAsistenciaRemSec(AsistenciaRemota rem) throws Exception {
		try {
			return genericNegocio.getFindAsistenciaRemSec(rem);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public Capacitador getFindCapacitadorId(Capacitador cap) throws Exception {
		try {
			return genericNegocio.getFindCapacitadorId(cap);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public List<Capacitador> getFindCapacitadorID(Capacitador cap) throws Exception {
		try {
			return genericNegocio.getFindCapacitadorID(cap);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public List<Actividad> getFindActividadID(Actividad cap) throws Exception {
		try {
			return genericNegocio.getFindActividadID(cap);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void getUpdateCoordenadas(Geozona geo) throws Exception {
		this.genericNegocio.getUpdateCoordenadas(geo);
	}

	public void getSaveAuthUser(MsUser user) throws Exception {
		this.genericNegocio.getSaveAuthUser(user);
	}

	public MsUser getUsuarioId() throws Exception {
		return this.genericNegocio.getUsuarioId();
	}

	public MsUser getSectoristaId() throws Exception {
		return this.genericNegocio.getSectoristaId();
	}

	public MsUser getImplantadoId() throws Exception {
		// TODO Auto-generated method stub
		return this.genericNegocio.getImplantadoId();
	}

	public MsUser getCapacitadorId() throws Exception {
		// TODO Auto-generated method stub
		return this.genericNegocio.getCapacitadorId();
	}
	
	

	public void getUpdateAuthUser(MsUser user) throws Exception {
		this.genericNegocio.getUpdateAuthUser(user);
	}

	public void getdeleteAuthUser(int use) throws Exception {
		this.genericNegocio.getdeleteAuthUser(use);
	}
}
