package hacom.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hacom.pe.datos.entidades.Display;
import hacom.pe.negocio.DisplayNegocio;

@Service
public class DisplayService {

	@Autowired
	DisplayNegocio displayNegocio;
	
	public List<Display> selectAll() throws Exception {
		return displayNegocio.selectAll();
	}

	public void update(Display display) throws Exception {
		displayNegocio.update(display);
	}

	public void insert(Display display) throws Exception {
		displayNegocio.insert(display);
	}

	public void eliminarVehiculoDeDisplay(int displayID) throws Exception {
		displayNegocio.eliminarVehiculoDeDisplay(displayID);
	}
	
	public void eliminarChipDeDisplay(int displayID) throws Exception {
		displayNegocio.eliminarChipDeDisplay(displayID);
	}
	
	public void insertHistory(Display display) throws Exception {
		displayNegocio.insertHistory(display);
	}

	public List<Display> selectHistoryDisplay(int displayID) throws Exception {
		return displayNegocio.selectHistoryDisplay(displayID);
	}
}
