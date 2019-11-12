package hacom.pe.negocio;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import hacom.pe.datos.entidades.Encuesta;
import hacom.pe.datos.entidades.EncuestaRemota;
import hacom.pe.datos.mapper.iface.EncuestaMapper;
import hacom.pe.datos.mapper.iface.EncuestaRemMapper;

@Component
public class EncuestaRemNegocio implements EncuestaRemMapper{
	
static final Logger log = LogManager.getLogger(EncuestaRemNegocio.class.getName());
	
	@Autowired
	EncuestaRemMapper encuestaRemMapper;


	@Override
	public List<EncuestaRemota> getAllEncuestaRemota() throws Exception {
		try {
			return encuestaRemMapper.getAllEncuestaRemota();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}


	@Override
	public List<EncuestaRemota> getFindEncuestaRemota(EncuestaRemota asis) throws Exception {
		try {
			return encuestaRemMapper.getFindEncuestaRemota(asis);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
}
