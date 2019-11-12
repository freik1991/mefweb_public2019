package hacom.pe.service;

import java.io.Serializable;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hacom.pe.datos.entidades.AsistenciaRemota;
import hacom.pe.datos.entidades.Encuesta;
import hacom.pe.datos.entidades.Entidad;
import hacom.pe.datos.entidades.TipoLocal;
import hacom.pe.negocio.AsistenciaTecNegocio;
import hacom.pe.negocio.EncuestaNegocio;
import hacom.pe.negocio.EntidadNegocio;

@Service
public class EntidadService implements Serializable{

	final static Logger log = LogManager.getLogger(EntidadService.class.getName());

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	EntidadNegocio entidadNegocio;


	
	public List<Entidad> getAllEntidad() throws Exception {
		List<Entidad> lstAsi = entidadNegocio.getAllEntidad();
                    return lstAsi;
	}


	public List<Entidad> getFindEntidad(Entidad asis) throws Exception {
		List<Entidad> lstAsi = entidadNegocio.getFindEntidad(asis);
    
                    return lstAsi;
	}


	public void getSaveEntidad(Entidad ent) throws Exception {
		entidadNegocio.getSaveEntidad(ent);
	}

	public void getUpdateEntidad(Entidad ue) throws Exception {
		entidadNegocio.getUpdateEntidad(ue);
	}

	public void getdeleteEntidad(int idTipoLocal) throws Exception {
		entidadNegocio.getdeleteEntidad(idTipoLocal);
	}
	
	public List<Entidad> getAllEntidadImplantador(Entidad ent) throws Exception {
		try {
			return entidadNegocio.getAllEntidadImplantador(ent);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Entidad> getAllEntidadSectorista(Entidad ent) throws Exception {
		try {
			return entidadNegocio.getAllEntidadSectorista(ent);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
}
