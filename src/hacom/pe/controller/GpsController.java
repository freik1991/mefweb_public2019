package hacom.pe.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import hacom.pe.datos.entidades.Account;
import hacom.pe.datos.entidades.Chip;
import hacom.pe.datos.entidades.Gps;
import hacom.pe.datos.entidades.GpsType;
import hacom.pe.datos.entidades.Vehicle;
import hacom.pe.service.ChipService;
import hacom.pe.service.GpsService;
import hacom.pe.service.ReportService;
import hacom.pe.util.GenerateExpressions;
import hacom.pe.util.SistConstants;
import lombok.Getter;
import lombok.Setter;

@Controller
@Scope(value = "session")
public class GpsController implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String TITULO_APLICACION = "ADMINISTRACION DE INGRESO";
	static final Logger log = LogManager.getLogger(LoginController.class.getName());
	
	@Getter @Setter private List<Gps> listGps;
	@Getter @Setter private List<Gps> filterListGps;
	@Getter @Setter private List<Chip> listChip;
	@Getter @Setter private List<Account> listAccount;
	@Getter @Setter private List<GpsType> listGpsType;
	@Getter @Setter private List<Vehicle> listVehicle;
	@Getter @Setter private List<Gps> listHistoryGps;
	
	@Getter @Setter private Gps selectGps;
	
	@Autowired
	GpsService gpsService;
	@Autowired
	ReportService reportService;
	@Autowired
	ChipService chipService;
	
	
	@PostConstruct
	public void init() {
		try {
			listGps = gpsService.selectAll();
			listAccount = reportService.readListAccount();
			selectGps = new Gps();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			GenerateExpressions.CrearMensaje("ERROR", TITULO_APLICACION, e.getMessage());
		}
		
	}

	@PreDestroy
    void release(){
		
	}

	public void voidReadListAll(int accountID, int type) {
		try {
			listAccount = reportService.readListAccount();
			listChip = chipService.selectAll();
			listGpsType = reportService.readListGpsType();
			listVehicle = new ArrayList<Vehicle>();
			
			if(type==2) { //editar
				voidReadListVehicle(accountID);
			}
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			GenerateExpressions.CrearMensaje("ERROR", TITULO_APLICACION, e.getMessage());
		}
	}
	
	public void onAccountChangeNew() {
        if(selectGps.getAccountID() !=0 || selectGps.getAccountID() != -1) {
        	selectGps.setVehicleID(-1);
        	voidReadListVehicle(selectGps.getAccountID());
		} else {
			selectGps.setVehicleID(-1);
			listVehicle = new ArrayList<>();
		}
    }
	
	public void voidReadListVehicle(int accountID) {
		try {
			listVehicle = reportService.readListVehicle(accountID);
			log.debug("listVehicle.size():"+listVehicle.size());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			GenerateExpressions.CrearMensaje("ERROR", TITULO_APLICACION, e.getMessage());
		}
	}	
	
	public void voidNewGps() {
		selectGps = new Gps();
		selectGps.setUserName(GenerateExpressions.ReadUserID());
		selectGps.setIsActive(1);
		selectGps.setDeliveryDateChange(new Date());
		voidReadListAll(0, 1);
		PrimeFaces.current().executeScript("PF('wgvNewGps').show();");
	}
	
	public void voidEditGps(int gpsID) {
		for(Gps g : listGps) {
			if(g.getGpsID()==gpsID) {
				selectGps = g.clone();
				break;
			}
		}
		
		selectGps.voidPrepararEdicion();
		selectGps.setUserName(GenerateExpressions.ReadUserID());
		voidReadListAll(selectGps.getAccountID(), 2);
		PrimeFaces.current().executeScript("PF('wgvEditGps').show();");
	}
	
	public void voidSaveNewGps() {
		try {
			//verificar si se eligio un vehiculo con gps
			if(selectGps.getVehicleID()>0) {
				int gpsID=-1;
				for(Vehicle v : listVehicle) {
					if(v.getVehicleID()==selectGps.getVehicleID()) {
						if(v.getGpsID()!=0 || v.getGpsID()!=-1) {
							gpsID = v.getGpsID();
							break;
						}
					}
				}
				if (gpsID > 0) {
					gpsService.eliminarGPSDeVehiculo(selectGps.getVehicleID());
					gpsService.eliminarVehicleDeGPS(gpsID);
					//crear un historyal para el gps afectado
					Gps g = new Gps();
					g.setGpsID(gpsID);
					g.setVehicleIDOld(selectGps.getVehicleID());
					g.setVehicleID(-1);
					g.setCreationTime(GenerateExpressions.TimeEpoch());
					g.setUserName(GenerateExpressions.ReadUserID());
					gpsService.insertHistory(g);					
				}
			}
			
			if(selectGps.getChipID()>0) {
				int gpsID=-1;
				for(Chip c : listChip) {
					if(c.getChipID()==selectGps.getChipID()) {
						if(c.getGpsID()!=0 || c.getGpsID()!=-1) {
							gpsID = c.getGpsID();
							break;
						}
					}
				}
				if (gpsID > 0) {
					chipService.eliminarGPSDeChip(selectGps.getChipID());
					//NO SE ELIMINARÁ HASTA QUE COMPLETEN EL LLENADO POR QUE TODOS LOS GPS TIENEN CHIPID=1
					//gpsService.eliminarChipDeGPS(gpsID); 
					//Gps g = new Gps();
					//g.setGpsID(gpsID);
					//g.setChipIDOld(selectGps.getVehicleID());
					//g.setChipID(-1);
					//g.setCreationTime(GenerateExpressions.TimeEpoch());
					//g.setUserName(GenerateExpressions.ReadUserID());
					//gpsService.insertHistory(selectGps);					
				}
			}
			
			selectGps.setCreationTime(GenerateExpressions.TimeEpoch());
			selectGps.setSessionIDCreation(0l);
			
			gpsService.insert(selectGps);
			
			if(selectGps.getVehicleID()>0) {
				gpsService.grabarGPSAVehiculo(selectGps.getGpsID(), selectGps.getVehicleID());
			}
			if(selectGps.getChipID()>0) {
				gpsService.grabarGPSAChip(selectGps.getGpsID(), selectGps.getChipID());
			}
			
			log.debug(selectGps);
			gpsService.insertHistory(selectGps);
			init();
			
			
			PrimeFaces.current().executeScript("PF('wgvNewGps').hide();");
			GenerateExpressions.CrearMensaje("INFO", TITULO_APLICACION, SistConstants.GRABADO_CORRECTAMENTE);
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			GenerateExpressions.CrearMensaje("ERROR", TITULO_APLICACION, e.getMessage());
		}
	}
	
	public void voidSaveEditGps() {
		try {
			//verificar si se eligio un vehiculo con gps
			log.debug("Editando GPS:"+selectGps.getGpsID());
			if(selectGps.getVehicleID()>0 && selectGps.getVehicleID()!=selectGps.getVehicleIDOld()) {
				int gpsID=-1;
				for(Vehicle v : listVehicle) {
					if(v.getVehicleID()==selectGps.getVehicleID()) {
						if(v.getGpsID()!=0 || v.getGpsID()!=-1) {
							gpsID = v.getGpsID();
							break;
						}
					}
				}
				log.debug("GPS Afectado:"+gpsID);
				if (gpsID > 0) {
					gpsService.eliminarGPSDeVehiculo(selectGps.getVehicleID());
					gpsService.eliminarVehicleDeGPS(gpsID);
					//crear un historyal para el gps afectado
					Gps g = new Gps();
					g.setGpsID(gpsID);
					g.setVehicleIDOld(selectGps.getVehicleID());
					g.setVehicleID(-1);
					g.setCreationTime(GenerateExpressions.TimeEpoch());
					g.setUserName(GenerateExpressions.ReadUserID());
					gpsService.insertHistory(g);
				}
				if(selectGps.getVehicleIDOld()>0) {
					gpsService.eliminarGPSDeVehiculo(selectGps.getVehicleIDOld());
				}
			} else if(selectGps.getVehicleID()!=selectGps.getVehicleIDOld() && selectGps.getVehicleIDOld()>0) {
				gpsService.eliminarGPSDeVehiculo(selectGps.getVehicleIDOld());
			}
			
			if(selectGps.getChipID()>0 && selectGps.getChipID()!=selectGps.getChipIDOld()) {
				int gpsID=-1;
				for(Chip c : listChip) {
					if(c.getChipID()==selectGps.getChipID()) {
						if(c.getGpsID()!=0 || c.getGpsID()!=-1) {
							gpsID = c.getGpsID();
							break;
						}
					}
				}
				if (gpsID > 0) {
					chipService.eliminarGPSDeChip(selectGps.getChipID());
					//NO SE ELIMINARÁ HASTA QUE COMPLETEN EL LLENADO POR QUE TODOS LOS GPS TIENEN CHIPID=1
					//gpsService.eliminarChipDeGPS(gpsID);
					//Gps g = new Gps();
					//g.setGpsID(gpsID);
					//g.setChipIDOld(selectGps.getVehicleID());
					//g.setChipID(-1);
					//g.setCreationTime(GenerateExpressions.TimeEpoch());
					//g.setUserName(GenerateExpressions.ReadUserID());
					//gpsService.insertHistory(selectGps);
				}
				if(selectGps.getChipIDOld()>0) {
					chipService.eliminarGPSDeChip(selectGps.getChipIDOld());
				}
			} else if (selectGps.getChipID()!=selectGps.getChipIDOld() && selectGps.getChipIDOld()>0) {
				chipService.eliminarGPSDeChip(selectGps.getChipIDOld());
			}
			
			selectGps.setLastUpdateTime(GenerateExpressions.TimeEpoch());
			selectGps.setSessionIDUpdate(0l);
			
			gpsService.update(selectGps);
			log.debug(selectGps);
			
			if(selectGps.getVehicleID()>0) {
				gpsService.grabarGPSAVehiculo(selectGps.getGpsID(), selectGps.getVehicleID());
			}
			if(selectGps.getChipID()>0) {
				gpsService.grabarGPSAChip(selectGps.getGpsID(), selectGps.getChipID());
			}

			selectGps.setCreationTime(GenerateExpressions.TimeEpoch());
			gpsService.insertHistory(selectGps);
			init();
			
			PrimeFaces.current().executeScript("PF('wgvEditGps').hide();");
			GenerateExpressions.CrearMensaje("INFO", TITULO_APLICACION, SistConstants.GRABADO_CORRECTAMENTE);
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			GenerateExpressions.CrearMensaje("ERROR", TITULO_APLICACION, e.getMessage());
		}
	}
	
	public void selectGpsID(int gpsID) {
		for(Gps g : listGps) {
			if(g.getGpsID()==gpsID) {
				selectGps = g.clone();
				break;
			}
		}
		
		try {
			listHistoryGps = gpsService.selectHistoryGps(gpsID);
			log.debug("listHistoryGps.size():"+listHistoryGps.size());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			GenerateExpressions.CrearMensaje("ERROR", TITULO_APLICACION, e.getMessage());
		}	}
}
