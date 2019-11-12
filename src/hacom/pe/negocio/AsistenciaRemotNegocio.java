package hacom.pe.negocio;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hacom.pe.datos.entidades.AsistenciaRemota;
import hacom.pe.datos.mapper.iface.AsistenciaRemotaMapper;
import hacom.pe.datos.mapper.iface.AsistenciaTecMapper;

@Component
public class AsistenciaRemotNegocio implements AsistenciaRemotaMapper{

static final Logger log = LogManager.getLogger(AsistenciaRemotNegocio.class.getName());
	
	@Autowired
	AsistenciaRemotaMapper asistenciaRemotaMapper;
	
	@Override
	public List<AsistenciaRemota> getAllAsistenciaRemota() throws Exception {
		try {
			return asistenciaRemotaMapper.getAllAsistenciaRemota();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<AsistenciaRemota> getFindAsistenciaRemota(AsistenciaRemota asis) throws Exception {
		try {
			return asistenciaRemotaMapper.getFindAsistenciaRemota(asis);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

}
