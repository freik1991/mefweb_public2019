package hacom.pe.negocio;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
import hacom.pe.datos.mapper.iface.GenericMapper;

@Component
public class GenericNegocio implements GenericMapper {

	static final Logger log = LogManager.getLogger(GenericNegocio.class.getName());

	@Autowired
	GenericMapper genericMapper;

	@Override
	public List<MsUser> getAllSectorista() throws Exception {
		try {
			return genericMapper.getAllSectorista();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Entidad getAllDepa(int depa) throws Exception {
		try {
			return genericMapper.getAllDepa(depa);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Entidad getAllDistrito(int dis) throws Exception {
		try {
			return genericMapper.getAllDistrito(dis);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Entidad getAllProvincia(int prov) throws Exception {
		try {
			return genericMapper.getAllProvincia(prov);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Geozona> getAllGeozona() throws Exception {
		try {
			return genericMapper.getAllGeozona();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<MsUser> getAllUsuarioAdm() throws Exception {
		try {
			return genericMapper.getAllUsuarioAdm();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void getSaveAdmin(MsUser user) throws Exception {
		genericMapper.getSaveAdmin(user);

	}

	@Override
	public void getUpdateAdmin(MsUser user) throws Exception {
		genericMapper.getUpdateAdmin(user);
	}

	@Override
	public void getdeleteAdmin(int use) throws Exception {
		genericMapper.getdeleteAdmin(use);
	}

	@Override
	public List<Sectorista> getAllSectoristaAdm() throws Exception {
		try {
			return genericMapper.getAllSectoristaAdm();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void getSaveSectorista(Sectorista sec) throws Exception {
		genericMapper.getSaveSectorista(sec);
	}

	@Override
	public void getUpdateSectorista(Sectorista sec) throws Exception {
		genericMapper.getUpdateSectorista(sec);

	}

	@Override
	public void getdeleteSectorista(int sec) throws Exception {
		genericMapper.getdeleteSectorista(sec);
	}

	@Override
	public List<TipoUe> getAllTipoUe() throws Exception {
		try {
			return genericMapper.getAllTipoUe();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void getSaveTipoUe(TipoUe ue) throws Exception {
		genericMapper.getSaveTipoUe(ue);
	}

	@Override
	public void getUpdateTipoUe(TipoUe ue) throws Exception {
		genericMapper.getUpdateTipoUe(ue);
	}

	@Override
	public void getdeleteTipoUe(int ue) throws Exception {
		genericMapper.getdeleteTipoUe(ue);
	}

	@Override
	public List<TipoVisita> getAllTipoVisita() throws Exception {
		try {
			return genericMapper.getAllTipoVisita();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void getSaveTipoVisita(TipoVisita ue) throws Exception {
		genericMapper.getSaveTipoVisita(ue);

	}

	@Override
	public void getUpdateTipoVisita(TipoVisita ue) throws Exception {
		genericMapper.getUpdateTipoVisita(ue);
	}

	@Override
	public void getdeleteTipoVisita(int idTipoVis) throws Exception {
		genericMapper.getdeleteTipoVisita(idTipoVis);
	}

	@Override
	public List<TipoSistema> getAllTipoSistema() throws Exception {
		try {
			return genericMapper.getAllTipoSistema();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void getSaveTipoSistema(TipoSistema ue) throws Exception {
		genericMapper.getSaveTipoSistema(ue);
	}

	@Override
	public void getUpdateTipoSistema(TipoSistema ue) throws Exception {
		genericMapper.getUpdateTipoSistema(ue);
	}

	@Override
	public void getdeleteTipoSitema(int tipoSistema) throws Exception {
		genericMapper.getdeleteTipoSitema(tipoSistema);
	}

	@Override
	public List<Modalidad> getAllTipoModalidad() throws Exception {
		try {
			return genericMapper.getAllTipoModalidad();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void getSaveModalidad(Modalidad ue) throws Exception {
		genericMapper.getSaveModalidad(ue);
	}

	@Override
	public void getUpdateModalidad(Modalidad ue) throws Exception {
		genericMapper.getUpdateModalidad(ue);
	}

	@Override
	public void getdeleteModalidad(int idModalidad) throws Exception {
		genericMapper.getdeleteModalidad(idModalidad);

	}

	@Override
	public List<TipoLocal> getAllTipoLocal() throws Exception {
		try {
			return genericMapper.getAllTipoLocal();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void getSaveTipoLocal(TipoLocal ue) throws Exception {
		genericMapper.getSaveTipoLocal(ue);
	}

	@Override
	public void getUpdateTipoLocal(TipoLocal ue) throws Exception {
		genericMapper.getUpdateTipoLocal(ue);
	}

	@Override
	public void getdeleteTipoLocal(int idTipoLocal) throws Exception {
		genericMapper.getdeleteTipoLocal(idTipoLocal);
	}

	@Override
	public List<Motivo> getAllTipoMotivo() throws Exception {
		try {
			return genericMapper.getAllTipoMotivo();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void getSaveMotivo(Motivo ue) throws Exception {
		genericMapper.getSaveMotivo(ue);
	}

	@Override
	public void getUpdateMotivo(Motivo ue) throws Exception {
		genericMapper.getUpdateMotivo(ue);
	}

	@Override
	public void getdeleteMotivo(int idMotivo) throws Exception {
		genericMapper.getdeleteMotivo(idMotivo);
	}

	@Override
	public List<SubModulo> getAllSubModulo() throws Exception {
		try {
			return genericMapper.getAllSubModulo();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void getSaveSubModulo(SubModulo ue) throws Exception {
		genericMapper.getSaveSubModulo(ue);
	}

	@Override
	public void getUpdateSubModulo(SubModulo ue) throws Exception {
		genericMapper.getUpdateSubModulo(ue);
	}

	@Override
	public void getdeleteSubModulo(int id) throws Exception {
		genericMapper.getdeleteSubModulo(id);
	}

	@Override
	public List<Implantador> getAllImplantador() throws Exception {
		try {
			return genericMapper.getAllImplantador();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void getSaveImplantador(Implantador ue) throws Exception {
		genericMapper.getSaveImplantador(ue);
	}

	@Override
	public void getUpdateImplantador(Implantador ue) throws Exception {
		genericMapper.getUpdateImplantador(ue);
	}

	@Override
	public void getdeleteImplantador(int id) throws Exception {
		genericMapper.getdeleteImplantador(id);
	}

	@Override
	public List<EntidadSectorista> getAllEntidadSec(int sectoristaId) throws Exception {
		try {
			return genericMapper.getAllEntidadSec(sectoristaId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Entidad> getAllMfUnit() throws Exception {
		try {
			return genericMapper.getAllMfUnit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void getUpdateEntidadI(int id) throws Exception {
		genericMapper.getUpdateEntidadI(id);
	}

	@Override
	public void getSaveEntidadImp(EntidadSectorista ue) throws Exception {
		genericMapper.getSaveEntidadImp(ue);
	}

	@Override
	public Implantador getFindIdImpl() throws Exception {
		// TODO Auto-generated method stub
		return genericMapper.getFindIdImpl();

	}

	@Override
	public List<Entidad> getAllMfUnitId(int id) throws Exception {
		return genericMapper.getAllMfUnitId(id);
	}

	@Override
	public void getDeleteEntidadImp(int implantadorId) throws Exception {
		genericMapper.getDeleteEntidadImp(implantadorId);
	}

	@Override
	public void getUpdateEntidadIRese(int id) throws Exception {
		genericMapper.getUpdateEntidadIRese(id);
	}

	@Override
	public List<Capacitador> getAllCapacitador() throws Exception {
		try {
			return genericMapper.getAllCapacitador();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void getSaveCapacitador(Capacitador ca) throws Exception {
		genericMapper.getSaveCapacitador(ca);
	}

	@Override
	public void getUpdateCapacitador(Capacitador ca) throws Exception {
		genericMapper.getUpdateCapacitador(ca);
	}

	@Override
	public void getUpdateEstadoCapa(int id) throws Exception {
		genericMapper.getUpdateEstadoCapa(id);
	}

	@Override
	public List<Ubigeo> getAllDepartamento() throws Exception {
		try {
			return genericMapper.getAllDepartamento();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Ubigeo> getAllProvinciaDepa(int deparment_id) throws Exception {
		try {
			return genericMapper.getAllProvinciaDepa(deparment_id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Ubigeo> getAllDistritoProvi(int province_id) throws Exception {
		try {
			return genericMapper.getAllDistritoProvi(province_id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Entidad> getAllEntidadSel() throws Exception {
		try {
			return genericMapper.getAllEntidadSel();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Implantador> getAllImplantadorSel() throws Exception {
		try {
			return genericMapper.getAllImplantadorSel();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void getSaveCapacitacion(Capacitador cap) throws Exception {
		try {
			this.genericMapper.getSaveCapacitacion(cap);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void getUpdateCapacitadores(Capacitador cap) throws Exception {
		this.genericMapper.getUpdateCapacitadores(cap);
	}

	@Override
	public List<Capacitador> getAllCapacitacion() throws Exception {
		try {
			return genericMapper.getAllCapacitacion();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Cronograma> getAllCronograma() throws Exception {
		try {
			return genericMapper.getAllCronograma();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void getSaveCronograma(Cronograma crono) throws Exception {
		this.genericMapper.getSaveCronograma(crono);
	}

	@Override
	public void getUpdateCronograma(Cronograma crono) throws Exception {
		this.genericMapper.getUpdateCronograma(crono);
	}

	@Override
	public void getdeleteCronograma(int idCrono) throws Exception {
		this.genericMapper.getdeleteCronograma(idCrono);
	}

	@Override
	public List<AsistenciaTecnica> getAllAsistenciaPres() throws Exception {
		try {
			return genericMapper.getAllAsistenciaPres();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void getSaveAsistenciaPres(AsistenciaTecnica asist) throws Exception {
		this.genericMapper.getSaveAsistenciaPres(asist);
	}

	@Override
	public void getUpdateAsistenciPres(AsistenciaTecnica crono) throws Exception {
		this.genericMapper.getUpdateAsistenciPres(crono);
	}

	@Override
	public void getdeleteAsistenciaPres(int idAssip) throws Exception {
		this.genericMapper.getdeleteAsistenciaPres(idAssip);
	}

	@Override
	public List<AsistenciaRemota> getAllAsistenciaRem() throws Exception {
		try {
			return genericMapper.getAllAsistenciaRem();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void getSaveAsistenciarRem(AsistenciaRemota asist) throws Exception {
		this.genericMapper.getSaveAsistenciarRem(asist);
	}

	@Override
	public void getUpdateAsistenciRem(AsistenciaRemota crono) throws Exception {
		this.genericMapper.getUpdateAsistenciRem(crono);
	}

	@Override
	public void getdeleteAsistenciaRem(int remoteAssistanceID) throws Exception {
		this.genericMapper.getdeleteAsistenciaRem(remoteAssistanceID);
	}

	@Override
	public List<Actividad> getAllActividad() throws Exception {
		try {
			return genericMapper.getAllActividad();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void getSaveActividad(Actividad asist) throws Exception {
		this.genericMapper.getSaveActividad(asist);
	}

	@Override
	public void getUpdateActividad(Actividad crono) throws Exception {
		this.genericMapper.getUpdateActividad(crono);
	}

	@Override
	public void getdeleteActividad(int idAct) throws Exception {
		this.genericMapper.getdeleteActividad(idAct);
	}

	@Override
	public List<UsuarioMap> getAllUsuarioMap() throws Exception {
		try {
			return genericMapper.getAllUsuarioMap();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void getSaveUsuarioMap(UsuarioMap ue) throws Exception {
		this.genericMapper.getSaveUsuarioMap(ue);
	}

	@Override
	public void getUpdateUsuarioMap(UsuarioMap ue) throws Exception {
		this.genericMapper.getUpdateUsuarioMap(ue);
	}

	@Override
	public void getDeleteUsuMap(UsuarioMap ue) throws Exception {
		this.genericMapper.getDeleteUsuMap(ue);
	}

	@Override
	public List<UsuarioMap> getAllIdUsuarioMap(UsuarioMap ue) throws Exception {
		try {
			return genericMapper.getAllIdUsuarioMap(ue);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Implantador getFindUsuImpl(Implantador im) throws Exception {
		// TODO Auto-generated method stub
		return genericMapper.getFindUsuImpl(im);
	}

	@Override
	public List<AsistenciaRemota> getFindAsistenciaRemImp(AsistenciaRemota imp) throws Exception {
		try {
			return genericMapper.getFindAsistenciaRemImp(imp);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Sectorista getFindUsuImplSec(Sectorista usuaImpl) throws Exception {
		return this.genericMapper.getFindUsuImplSec(usuaImpl);
	}

	@Override
	public List<Implantador> getFindImplantadorSec(Implantador imp) throws Exception {
		try {
			return genericMapper.getFindImplantadorSec(imp);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<AsistenciaTecnica> getFindAsistenciaPresSec(AsistenciaTecnica tec) throws Exception {
		try {
			return genericMapper.getFindAsistenciaPresSec(tec);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<AsistenciaRemota> getFindAsistenciaRemSec(AsistenciaRemota rem) throws Exception {
		try {
			return genericMapper.getFindAsistenciaRemSec(rem);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Capacitador getFindCapacitadorId(Capacitador cap) throws Exception {
		try {
			return genericMapper.getFindCapacitadorId(cap);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Capacitador> getFindCapacitadorID(Capacitador cap) throws Exception {
		try {
			return genericMapper.getFindCapacitadorID(cap);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Actividad> getFindActividadID(Actividad cap) throws Exception {
		try {
			return genericMapper.getFindActividadID(cap);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	@Override
	public void getUpdateCoordenadas(Geozona geo) throws Exception {
		this.genericMapper.getUpdateCoordenadas(geo);
	}

	@Override
	public void getSaveAuthUser(MsUser user) throws Exception {
		this.genericMapper.getSaveAuthUser(user);
	}

	@Override
	public MsUser getUsuarioId() throws Exception {
		return this.genericMapper.getUsuarioId();
	}

	@Override
	public MsUser getSectoristaId() throws Exception {
		return this.genericMapper.getSectoristaId();
	}

	@Override
	public MsUser getImplantadoId() throws Exception {
		// TODO Auto-generated method stub
		return this.genericMapper.getImplantadoId();
	}

	@Override
	public MsUser getCapacitadorId() throws Exception {
		// TODO Auto-generated method stub
		return this.genericMapper.getCapacitadorId();
	}

	@Override
	public void getUpdateAuthUser(MsUser user) throws Exception {
		this.genericMapper.getUpdateAuthUser(user);
	}

	@Override
	public void getdeleteAuthUser(int use) throws Exception {
		this.genericMapper.getdeleteAuthUser(use);
	}

}
