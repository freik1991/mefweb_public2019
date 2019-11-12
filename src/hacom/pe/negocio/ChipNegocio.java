package hacom.pe.negocio;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hacom.pe.datos.entidades.Chip;
import hacom.pe.datos.mapper.iface.ChipMapper;

@Component
public class ChipNegocio implements ChipMapper {

	static final Logger log = LogManager.getLogger(ChipNegocio.class.getName());
	
	@Autowired
	ChipMapper chipMapper;
	
	public List<Chip> selectAll() throws Exception {
		try {
			return chipMapper.selectAll();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(e.getMessage());
		}
	}

	public void update(Chip chip) throws Exception {
		try {
			chipMapper.update(chip);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(e.getMessage());
		}
	}

	public void insert(Chip chip) throws Exception {
		try {
			chipMapper.insert(chip);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(e.getMessage());
		}
	}

	public void eliminarGPSDeChip(int chipID) throws Exception{
		try {
			chipMapper.eliminarGPSDeChip(chipID);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(e.getMessage());
		}
	}

	public void insertHistory(Chip chip) throws Exception {
		try {
			chipMapper.insertHistory(chip);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(e.getMessage());
		}		
	}

	public List<Chip> selectHistoryChip(int chipID) throws Exception {
		try {
			return chipMapper.selectHistoryChip(chipID);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(e.getMessage());
		}
	}


}
