package hacom.pe.service;

import java.io.Serializable;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hacom.pe.datos.entidades.AsistenciaRemota;
import hacom.pe.datos.entidades.Encuesta;
import hacom.pe.negocio.AsistenciaTecNegocio;
import hacom.pe.negocio.EncuestaNegocio;

@Service
public class EncuestaService implements Serializable{

	final static Logger log = LogManager.getLogger(EncuestaService.class.getName());

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	EncuestaNegocio encuestaNegocio;


	
	public List<Encuesta> getAllEncuesta() throws Exception {
		List<Encuesta> lstAsi = encuestaNegocio.getAllEncuesta();
        for(Encuesta asi : lstAsi) {
        	System.out.println("ejec:"+asi.getSecEjec());
        }

                    return lstAsi;
	}


	public List<Encuesta> getFindEncuesta(Encuesta asis) throws Exception {
		List<Encuesta> lstAsi = encuestaNegocio.getFindEncuesta(asis);
        for(Encuesta asi : lstAsi) {
        	System.out.println("find ej:"+asi.getSecEjec());
        }

                    return lstAsi;
	}


	
}
