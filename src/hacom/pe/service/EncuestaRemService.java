package hacom.pe.service;

import java.io.Serializable;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hacom.pe.datos.entidades.AsistenciaRemota;
import hacom.pe.datos.entidades.Encuesta;
import hacom.pe.datos.entidades.EncuestaRemota;
import hacom.pe.negocio.AsistenciaTecNegocio;
import hacom.pe.negocio.EncuestaNegocio;
import hacom.pe.negocio.EncuestaRemNegocio;

@Service
public class EncuestaRemService implements Serializable{

	final static Logger log = LogManager.getLogger(EncuestaRemService.class.getName());

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	EncuestaRemNegocio encuestaRemNegocio;


	
	public List<EncuestaRemota> getAllEncuestaRemota() throws Exception {
		List<EncuestaRemota> lstAsi = encuestaRemNegocio.getAllEncuestaRemota();
        

                    return lstAsi;
	}


	public List<EncuestaRemota> getFindEncuestaRemota(EncuestaRemota asis) throws Exception {
		List<EncuestaRemota> lstAsi = encuestaRemNegocio.getFindEncuestaRemota(asis);
       
                    return lstAsi;
	}


	
}
