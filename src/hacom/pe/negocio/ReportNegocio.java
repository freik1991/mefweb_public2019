package hacom.pe.negocio;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hacom.pe.datos.entidades.Account;
import hacom.pe.datos.entidades.ChipStatus;
import hacom.pe.datos.entidades.ChipSupplier;
import hacom.pe.datos.entidades.GpsType;
import hacom.pe.datos.entidades.Vehicle;
import hacom.pe.datos.mapper.iface.ReportMapper;

@Component
public class ReportNegocio implements ReportMapper {

	static final Logger log = LogManager.getLogger(ReportNegocio.class.getName());
	
	@Autowired
	ReportMapper reportMapper;
	
	public List<Account> readListAccount() throws Exception {
		try {
			return reportMapper.readListAccount();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(e.getMessage());
		}
	}

	public List<ChipSupplier> readListChipSupplier() throws Exception {
		try {
			return reportMapper.readListChipSupplier();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(e.getMessage());
		}
	}

	public List<GpsType> readListGpsType() throws Exception {
		try {
			return reportMapper.readListGpsType();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(e.getMessage());
		}
	}

	public List<Vehicle> readListVehicle(int accountID) throws Exception {
		try {
			return reportMapper.readListVehicle(accountID);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(e.getMessage());
		}
	}

	public List<ChipStatus> readListChipStatus() throws Exception{
		try {
			return reportMapper.readListChipStatus();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(e.getMessage());
		}
	}
}
