package hacom.pe.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hacom.pe.datos.entidades.AsistenciaRemota;
import hacom.pe.datos.entidades.Incidencias;
import hacom.pe.negocio.IncidenciaNegocio;

@Service
public class IncidenciaService {

	final static Logger log = LogManager.getLogger(IncidenciaService.class.getName());

	private static final long serialVersionUID = 1L;
	@Autowired
	IncidenciaNegocio incidenciaNegocio;

	public List<Incidencias> listarIncidencias() throws Exception {

		List<Incidencias> lstAsi = incidenciaNegocio.getAllincidencias();
		for (Incidencias asi : lstAsi) {
			System.out.println("descripcionInc:" + asi.getDescription());
		}

		return lstAsi;
	}
	
	public List<Incidencias> findIncidencias(Incidencias asis) throws Exception {
		
		
		 List<Incidencias> lstAsi = incidenciaNegocio.getFindIncidencias(asis);
	        for(Incidencias asi : lstAsi) {
	        	System.out.println("find descripcion inc:"+asi.getDescription());
	        }

	                    return lstAsi;
}
}
