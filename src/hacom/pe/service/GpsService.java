package hacom.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hacom.pe.datos.entidades.Gps;
import hacom.pe.negocio.GpsNegocio;

@Service
public class GpsService {

	@Autowired
	GpsNegocio gpsNegocio;
	
	public List<Gps> selectAll() throws Exception {
		return gpsNegocio.selectAll();
	}

	public void update(Gps gps) throws Exception {
		gpsNegocio.update(gps);
	}

	public void insert(Gps gps) throws Exception {
		gpsNegocio.insert(gps);
	}
	
	public void eliminarGPSDeVehiculo(int VehicleID) throws Exception {
		gpsNegocio.eliminarGPSDeVehiculo(VehicleID);
	}

	public void eliminarVehicleDeGPS(int gpsID) throws Exception {
		gpsNegocio.eliminarVehicleDeGPS(gpsID);
	}

	public void eliminarChipDeGPS(int gpsID) throws Exception {
		gpsNegocio.eliminarChipDeGPS(gpsID);
	}

	public void grabarGPSAVehiculo(int gpsID, int VehicleID) throws Exception {
		gpsNegocio.grabarGPSAVehiculo(gpsID, VehicleID);
	}

	public void grabarGPSAChip(int gpsID, int chipID) throws Exception {
		gpsNegocio.grabarGPSAChip(gpsID, chipID);
	}

	public void insertHistory(Gps gps) throws Exception {
		gpsNegocio.insertHistory(gps);
	}

	public List<Gps> selectHistoryGps(int gpsID) throws Exception {
		return gpsNegocio.selectHistoryGps(gpsID);
	}
}
