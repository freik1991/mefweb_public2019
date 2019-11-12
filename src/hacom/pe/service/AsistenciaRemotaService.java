package hacom.pe.service;

import java.io.Serializable;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hacom.pe.datos.entidades.AsistenciaRemota;
import hacom.pe.negocio.AsistenciaRemotNegocio;

@Service
public class AsistenciaRemotaService implements Serializable{

	final static Logger log = LogManager.getLogger(AsistenciaRemotaService.class.getName());

	private static final long serialVersionUID = 1L;
	@Autowired
	AsistenciaRemotNegocio asistenciaRemotNegocio;
	
	public List<AsistenciaRemota> listarAsistenciaRem() throws Exception {
		
		
		 List<AsistenciaRemota> lstAsi = asistenciaRemotNegocio.getAllAsistenciaRemota();
	        for(AsistenciaRemota asi : lstAsi) {
	        	System.out.println("descripcion:"+asi.getDescription());
	        }

	                    return lstAsi;
}
	
	public List<AsistenciaRemota> findAsistenciaRem(AsistenciaRemota asis) throws Exception {
		
		
		 List<AsistenciaRemota> lstAsi = asistenciaRemotNegocio.getFindAsistenciaRemota(asis);
	        for(AsistenciaRemota asi : lstAsi) {
	        	System.out.println("find descripcion:"+asi.getDescription());
	        }

	                    return lstAsi;
}
}
