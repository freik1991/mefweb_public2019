package hacom.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hacom.pe.datos.entidades.Chip;
import hacom.pe.negocio.ChipNegocio;

@Service
public class ChipService {

	@Autowired
	ChipNegocio chipNegocio;
	
	public List<Chip> selectAll() throws Exception {
		return chipNegocio.selectAll();
	}

	public void update(Chip chip) throws Exception {
		chipNegocio.update(chip);
	}

	public void insert(Chip chip) throws Exception {
		chipNegocio.insert(chip);
	}

	public void eliminarGPSDeChip(int chipID) throws Exception{
		chipNegocio.eliminarGPSDeChip(chipID);
	}

	public void insertHistory(Chip chip) throws Exception {
		chipNegocio.insertHistory(chip);
	}
	
	public List<Chip> selectHistoryChip(int chipID) throws Exception {
		return chipNegocio.selectHistoryChip(chipID);
	}
}
