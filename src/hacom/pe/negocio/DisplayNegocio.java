package hacom.pe.negocio;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hacom.pe.datos.entidades.Display;
import hacom.pe.datos.mapper.iface.DisplayMapper;

@Component
public class DisplayNegocio implements DisplayMapper {

	static final Logger log = LogManager.getLogger(DisplayNegocio.class.getName());
	
	@Autowired
	DisplayMapper displayMapper;
	
	public List<Display> selectAll() throws Exception {
		try {
			return displayMapper.selectAll();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(e.getMessage());
		}
	}

	public void update(Display display) throws Exception {
		try {
			displayMapper.update(display);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(e.getMessage());
		}
	}

	public void insert(Display display) throws Exception {
		try {
			displayMapper.insert(display);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(e.getMessage());
		}
	}

	public void eliminarVehiculoDeDisplay(int displayID) throws Exception {
		try {
			displayMapper.eliminarVehiculoDeDisplay(displayID);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(e.getMessage());
		}
	}
	
	public void eliminarChipDeDisplay(int displayID) throws Exception {
		try {
			displayMapper.eliminarChipDeDisplay(displayID);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(e.getMessage());
		}
	}

	public void insertHistory(Display display) throws Exception {
		try {
			log.debug("Grabando:"+display);
			displayMapper.insertHistory(display);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(e.getMessage());
		}		
	}

	public List<Display> selectHistoryDisplay(int displayID) throws Exception {
		try {
			return displayMapper.selectHistoryDisplay(displayID);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(e.getMessage());
		}
	}
}
