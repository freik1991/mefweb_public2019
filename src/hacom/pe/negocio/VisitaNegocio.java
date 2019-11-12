package hacom.pe.negocio;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import hacom.pe.datos.entidades.Encuesta;
import hacom.pe.datos.entidades.Visita;
import hacom.pe.datos.mapper.iface.EncuestaMapper;
import hacom.pe.datos.mapper.iface.VisitaMapper;

@Component
public class VisitaNegocio implements VisitaMapper{
	
static final Logger log = LogManager.getLogger(VisitaNegocio.class.getName());
	
	@Autowired
	VisitaMapper visitaMapper;



	@Override
	public List<Visita> getAllVisita() throws Exception {
		try {
			return visitaMapper.getAllVisita();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}


	@Override
	public List<Visita> getFindVisita(Visita asis) throws Exception {
		try {
			return visitaMapper.getFindVisita(asis);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}


	
}
