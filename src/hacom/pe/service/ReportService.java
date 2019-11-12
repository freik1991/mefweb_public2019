package hacom.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hacom.pe.datos.entidades.Account;
import hacom.pe.datos.entidades.ChipStatus;
import hacom.pe.datos.entidades.ChipSupplier;
import hacom.pe.datos.entidades.GpsType;
import hacom.pe.datos.entidades.Vehicle;
import hacom.pe.negocio.ReportNegocio;

@Service
public class ReportService {

	@Autowired
	ReportNegocio reportNegocio;
	
	public List<Account> readListAccount()  throws Exception {
		return reportNegocio.readListAccount();
	}
	
	public List<ChipSupplier> readListChipSupplier()  throws Exception {
		return reportNegocio.readListChipSupplier();
	}
	
	public List<GpsType> readListGpsType()  throws Exception {
		return reportNegocio.readListGpsType();
	}
	
	public List<Vehicle> readListVehicle(int accountID)  throws Exception {
		return reportNegocio.readListVehicle(accountID);
	}
	
	public List<ChipStatus> readListChipStatus() throws Exception{
		return reportNegocio.readListChipStatus();
	}
}
