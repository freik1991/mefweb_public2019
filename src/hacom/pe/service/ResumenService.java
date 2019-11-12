package hacom.pe.service;

import java.io.Serializable;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hacom.pe.datos.entidades.AsistenciaRemota;
import hacom.pe.datos.entidades.Encuesta;
import hacom.pe.datos.entidades.Resumen;
import hacom.pe.negocio.AsistenciaTecNegocio;
import hacom.pe.negocio.EncuestaNegocio;
import hacom.pe.negocio.ResumenNegocio;

@Service
public class ResumenService implements Serializable{

	final static Logger log = LogManager.getLogger(ResumenService.class.getName());

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	ResumenNegocio resumenNegocio;


	
	public List<Resumen> getAllResumen() throws Exception {
		List<Resumen> lstAsi = resumenNegocio.getAllResumen();
     
                    return lstAsi;
	}


	public List<Resumen> getFindResumen(Resumen asis) throws Exception {
		List<Resumen> lstAsi = resumenNegocio.getFindResumen(asis);
                   return lstAsi;
	}


	
}
