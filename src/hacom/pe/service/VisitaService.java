package hacom.pe.service;

import java.io.Serializable;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hacom.pe.datos.entidades.AsistenciaRemota;
import hacom.pe.datos.entidades.Encuesta;
import hacom.pe.datos.entidades.Visita;
import hacom.pe.negocio.AsistenciaTecNegocio;
import hacom.pe.negocio.EncuestaNegocio;
import hacom.pe.negocio.VisitaNegocio;

@Service
public class VisitaService implements Serializable{

	final static Logger log = LogManager.getLogger(VisitaService.class.getName());

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	VisitaNegocio visitaNegocio;


	
	public List<Visita> getAllVisita() throws Exception {
		List<Visita> lstAsi = visitaNegocio.getAllVisita();
       
                    return lstAsi;
	}


	public List<Visita> getFindEncuesta(Visita asis) throws Exception {
		List<Visita> lstAsi = visitaNegocio.getFindVisita(asis);
      
                    return lstAsi;
	}


	
}
