package hacom.pe.negocio;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hacom.pe.datos.entidades.Gps;
import hacom.pe.datos.mapper.iface.GpsMapper;

@Component
public class GpsNegocio implements GpsMapper {

	static final Logger log = LogManager.getLogger(GpsNegocio.class.getName());
	
	@Autowired
	GpsMapper gpsMapper;
	
	public List<Gps> selectAll() throws Exception {
		try {
			return gpsMapper.selectAll();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(e.getMessage());
		}
	}

	public void update(Gps gps) throws Exception {
		try {
			gpsMapper.update(gps);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(e.getMessage());
		}
	}

	public void insert(Gps gps) throws Exception {
		try {
			gpsMapper.insert(gps);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(e.getMessage());
		}
	}

	public void eliminarGPSDeVehiculo(int VehicleID) throws Exception {
		try {
			gpsMapper.eliminarGPSDeVehiculo(VehicleID);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(e.getMessage());
		}
	}

	public void eliminarVehicleDeGPS(int gpsID) throws Exception {
		try {
			gpsMapper.eliminarVehicleDeGPS(gpsID);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(e.getMessage());
		}
	}

	public void eliminarChipDeGPS(int gpsID) throws Exception {
		try {
			gpsMapper.eliminarChipDeGPS(gpsID);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(e.getMessage());
		}
	}

	public void grabarGPSAVehiculo(int gpsID, int VehicleID) throws Exception {
		try {
			gpsMapper.grabarGPSAVehiculo(gpsID, VehicleID);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(e.getMessage());
		}		
	}

	public void grabarGPSAChip(int gpsID, int chipID) throws Exception {
		try {
			gpsMapper.grabarGPSAChip(gpsID, chipID);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(e.getMessage());
		}		
	}

	public void insertHistory(Gps gps) throws Exception {
		try {
			log.debug("Grabando:"+gps);
			gpsMapper.insertHistory(gps);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(e.getMessage());
		}		
	}

	public List<Gps> selectHistoryGps(int gpsID) throws Exception {
		try {
			return gpsMapper.selectHistoryGps(gpsID);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(e.getMessage());
		}
	}
}
