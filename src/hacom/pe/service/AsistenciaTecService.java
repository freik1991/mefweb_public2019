package hacom.pe.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hacom.pe.datos.entidades.AsistenciaTecnica;
import hacom.pe.datos.entidades.Departamento;
import hacom.pe.datos.entidades.MsUser;
import hacom.pe.negocio.AsistenciaTecNegocio;
import hacom.pe.negocio.UserNegocio;
import hacom.pe.util.SistConstants;

@Service
public class AsistenciaTecService  implements Serializable{

	final static Logger log = LogManager.getLogger(AsistenciaTecService.class.getName());

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	AsistenciaTecNegocio asistenciaTecNegocio;

	 
	public List<Departamento> listarDepartamento() throws Exception {
	
		
			 List<Departamento> lstDepa = asistenciaTecNegocio.select();
		        for(Departamento depa : lstDepa) {
		        	System.out.println("depa:"+depa.getName());
		        }

		                    return lstDepa;
	}
	
	public List<AsistenciaTecnica> listarAsistenciaTec() throws Exception {
		
		
		 List<AsistenciaTecnica> lstAsi = asistenciaTecNegocio.getAllAsistenciaTec();
	        for(AsistenciaTecnica asi : lstAsi) {
	        	System.out.println("depa:"+asi.getRepresentantName());
	        }

	                    return lstAsi;
}
	
	public AsistenciaTecnica getSectorista(int userID) throws Exception {
		
		
		 AsistenciaTecnica asis = asistenciaTecNegocio.getSectorista(userID);
	        

	                    return asis;
}
	
	public List<AsistenciaTecnica> getFindAsistencia(AsistenciaTecnica asis) throws Exception {
		
		
		 List<AsistenciaTecnica> lista = asistenciaTecNegocio.getFindAsistenciaTecnica(asis);
		 for(AsistenciaTecnica asi : lista) {
	        	System.out.println("repre:"+asi.getRepresentantName());
	        }

	                    return lista;
}
	
	public AsistenciaTecnica getSectoristaName(String userName) throws Exception {
		
		
		 AsistenciaTecnica asis = asistenciaTecNegocio.getSectoristaName(userName);
	        

	                    return asis;
}
}

