package hacom.pe.negocio;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import hacom.pe.datos.entidades.Encuesta;
import hacom.pe.datos.entidades.EncuestaRemota;
import hacom.pe.datos.entidades.Entidad;
import hacom.pe.datos.entidades.Resumen;
import hacom.pe.datos.mapper.iface.EncuestaMapper;
import hacom.pe.datos.mapper.iface.EncuestaRemMapper;
import hacom.pe.datos.mapper.iface.EntidadMapper;
import hacom.pe.datos.mapper.iface.ResumenMapper;

@Component
public class ResumenNegocio implements ResumenMapper{
	
static final Logger log = LogManager.getLogger(ResumenNegocio.class.getName());
	
	@Autowired
	ResumenMapper resumenMapper;

	@Override
	public List<Resumen> getAllResumen() throws Exception {
		try {
			return resumenMapper.getAllResumen();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}


	@Override
	public List<Resumen> getFindResumen(Resumen asis) throws Exception {
		try {
			return resumenMapper.getFindResumen(asis);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
}
