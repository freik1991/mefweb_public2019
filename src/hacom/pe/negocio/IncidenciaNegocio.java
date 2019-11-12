package hacom.pe.negocio;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hacom.pe.datos.entidades.AsistenciaRemota;
import hacom.pe.datos.entidades.Incidencias;
import hacom.pe.datos.mapper.iface.AsistenciaRemotaMapper;
import hacom.pe.datos.mapper.iface.IncidenciaMapper;

@Component
public class IncidenciaNegocio implements IncidenciaMapper{

	static final Logger log = LogManager.getLogger(IncidenciaNegocio.class.getName());

	@Autowired
	IncidenciaMapper incidenciaMapper;
	
	@Override
	public List<Incidencias> getAllincidencias() throws Exception {
		try {
			return incidenciaMapper.getAllincidencias();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Incidencias> getFindIncidencias(Incidencias asis) throws Exception {
		try {
			return incidenciaMapper.getFindIncidencias(asis);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

}
