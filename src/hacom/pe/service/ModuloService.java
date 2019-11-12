package hacom.pe.service;

import java.io.Serializable;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hacom.pe.datos.entidades.AsistenciaRemota;
import hacom.pe.datos.entidades.Encuesta;
import hacom.pe.datos.entidades.Modulo;
import hacom.pe.datos.entidades.Resumen;
import hacom.pe.negocio.AsistenciaTecNegocio;
import hacom.pe.negocio.EncuestaNegocio;
import hacom.pe.negocio.ModuloNegocio;
import hacom.pe.negocio.ResumenNegocio;

@Service
public class ModuloService implements Serializable{

	final static Logger log = LogManager.getLogger(ModuloService.class.getName());

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	ModuloNegocio moduloNegocio;


	public List<Modulo> getAllModulo() throws Exception {
		List<Modulo> lstAsi = moduloNegocio.getAllModulo();
     
                    return lstAsi;
	}


	public List<Modulo> getFindModulo(Modulo asis) throws Exception {
		List<Modulo> lstAsi = moduloNegocio.getFindModulo(asis);
                   return lstAsi;
	}

	public void getSaveModulo(Modulo ue) throws Exception {
		moduloNegocio.getSaveModulo(ue);
	}

	public void getUpdateModulo(Modulo ue) throws Exception {
		moduloNegocio.getUpdateModulo(ue);
	}

	
	public void getdeleteModulo(int id) throws Exception {
		moduloNegocio.getdeleteModulo(id);
	}

	public Modulo getFindIdModulo() throws Exception {
		return moduloNegocio.getFindIdModulo();
	}
	
	public List<Modulo> getAllModuloSele() throws Exception {
		try {
			return moduloNegocio.getAllModuloSele();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
}
