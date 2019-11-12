package hacom.pe.negocio;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import hacom.pe.datos.entidades.Encuesta;
import hacom.pe.datos.entidades.EncuestaRemota;
import hacom.pe.datos.entidades.Entidad;
import hacom.pe.datos.entidades.TipoLocal;
import hacom.pe.datos.mapper.iface.EncuestaMapper;
import hacom.pe.datos.mapper.iface.EncuestaRemMapper;
import hacom.pe.datos.mapper.iface.EntidadMapper;

@Component
public class EntidadNegocio implements EntidadMapper{
	
static final Logger log = LogManager.getLogger(EntidadNegocio.class.getName());
	
	@Autowired
	EntidadMapper entidadMapper;

	@Override
	public List<Entidad> getAllEntidad() throws Exception {
		try {
			return entidadMapper.getAllEntidad();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}


	@Override
	public List<Entidad> getFindEntidad(Entidad asis) throws Exception {
		try {
			return entidadMapper.getFindEntidad(asis);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}


	@Override
	public void getSaveEntidad(Entidad ent) throws Exception {
		entidadMapper.getSaveEntidad(ent);
	}


	@Override
	public void getUpdateEntidad(Entidad ue) throws Exception {
		entidadMapper.getUpdateEntidad(ue);
	}


	@Override
	public void getdeleteEntidad(int idTipoLocal) throws Exception {
		entidadMapper.getdeleteEntidad(idTipoLocal);
	}


	@Override
	public List<Entidad> getAllEntidadImplantador(Entidad ent) throws Exception {
		try {
			return entidadMapper.getAllEntidadImplantador(ent);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}


	@Override
	public List<Entidad> getAllEntidadSectorista(Entidad ent) throws Exception {
		try {
			return entidadMapper.getAllEntidadSectorista(ent);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
}
