package hacom.pe.negocio;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import hacom.pe.datos.entidades.Encuesta;
import hacom.pe.datos.mapper.iface.EncuestaMapper;

@Component
public class EncuestaNegocio implements EncuestaMapper{
	
static final Logger log = LogManager.getLogger(EncuestaNegocio.class.getName());
	
	@Autowired
	EncuestaMapper encuestaMapper;



	@Override
	public List<Encuesta> getAllEncuesta() throws Exception {
		try {
			return encuestaMapper.getAllEncuesta();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}


	@Override
	public List<Encuesta> getFindEncuesta(Encuesta asis) throws Exception {
		try {
			return encuestaMapper.getFindEncuesta(asis);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
}
