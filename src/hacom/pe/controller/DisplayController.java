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
import hacom.pe.datos.entidades.Display;
import hacom.pe.datos.entidades.Vehicle;
import hacom.pe.service.ChipService;
import hacom.pe.service.DisplayService;
import hacom.pe.service.ReportService;
import hacom.pe.util.GenerateExpressions;
import hacom.pe.util.SistConstants;
import lombok.Getter;
import lombok.Setter;

@Controller
@Scope(value = "session")
public class DisplayController implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String TITULO_APLICACION = "ADMINISTRACION DE INGRESO";
	static final Logger log = LogManager.getLogger(LoginController.class.getName());
	
	@Getter @Setter private List<Display> listDisplay;
	@Getter @Setter private List<Display> filterListDisplay;
	@Getter @Setter private List<Chip> listChip;
	@Getter @Setter private List<Account> listAccount;
	@Getter @Setter private List<Vehicle> listVehicle;
	@Getter @Setter private List<Display> listHistoryDisplay;
	
	@Getter @Setter private Display selectDisplay;
	
	@Autowired
	DisplayService displayService;
	@Autowired
	ReportService reportService;
	@Autowired
	ChipService chipService;
	
	
	@PostConstruct
	public void init() {
		try {
			listDisplay = displayService.selectAll();
			listAccount = reportService.readListAccount();
			selectDisplay = new Display();
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
        if(selectDisplay.getAccountID() !=0 || selectDisplay.getAccountID() != -1) {
        	selectDisplay.setVehicleID(-1);
        	voidReadListVehicle(selectDisplay.getAccountID());
		} else {
			selectDisplay.setVehicleID(-1);
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
	
	public void voidNewDisplay() {
		selectDisplay = new Display();
		selectDisplay.setUserName(GenerateExpressions.ReadUserID());
		selectDisplay.setDeliveryDateChange(new Date());
		voidReadListAll(0, 1);
		PrimeFaces.current().executeScript("PF('wgvNewDisplay').show();");
	}
	
	public void voidEditDisplay(int displayID) {
		for(Display d : listDisplay) {
			if(d.getDisplayID()==displayID) {
				selectDisplay = d.clone();
				break;
			}
		}
		
		selectDisplay.voidPrepararEdicion();
		selectDisplay.setUserName(GenerateExpressions.ReadUserID());
		voidReadListAll(selectDisplay.getAccountID(), 2);
		PrimeFaces.current().executeScript("PF('wgvEditDisplay').show();");
	}
	
	public void voidSaveNewDisplay() {
		try {
			
			int routeID=0;
			if(selectDisplay.getVehicleID()>0) {
				for(Vehicle v : listVehicle) {
					if(v.getVehicleID()==selectDisplay.getVehicleID()) {
						routeID = v.getRouteID();
						break;
					}
				}
			}
			
			//verificar si se eligio un vehiculo con display
			log.debug("Grabando nuevo Display:");
			if(selectDisplay.getVehicleID()>0) {
				int displayID=-1;
				for(Display d : listDisplay) {
					if(d.getVehicleID()!=0 && d.getVehicleID()==selectDisplay.getVehicleID()) {
						displayID = d.getDisplayID();
						break;
					}
				}
				log.debug("Display Afectado:"+displayID);
				if (displayID > 0) {
					displayService.eliminarVehiculoDeDisplay(displayID);
					//crear un historyal para el display afectado
					Display g = new Display();
					g.setDisplayID(displayID);
					g.setVehicleIDOld(selectDisplay.getVehicleID());
					g.setVehicleID(-1);
					g.setCreationTime(GenerateExpressions.TimeEpoch());
					g.setUserName(GenerateExpressions.ReadUserID());
					displayService.insertHistory(g);
				}
			}
			
			/*
			 * NO SE ELIMINARÁ HASTA QUE COMPLETEN EL LLENADO POR QUE TODOS LOS DISPLAY TIENEN CHIPID=1
			 * 
			   if(selectDisplay.getChipID()>0) {
				int displayID=-1;
				for(Display d : listDisplay) {
					if(d.getChipID()==selectDisplay.getChipID()) {
						if(d.getChipID()!=0 && d.getChipID()==selectDisplay.getChipID()) {
							displayID = d.getDisplayID();
							break;
						}
					}
				}
				if (displayID > 0) {
					displayService.eliminarChipDeDisplay(displayID);
				}
			}*/
			
			selectDisplay.setCreationTime(GenerateExpressions.TimeEpoch());
			selectDisplay.setSessionIDCreation(0l);
			selectDisplay.setRouteID(routeID);
			displayService.insert(selectDisplay);
			
			log.debug(selectDisplay);
			displayService.insertHistory(selectDisplay);
			init();
			
			PrimeFaces.current().executeScript("PF('wgvNewDisplay').hide();");
			GenerateExpressions.CrearMensaje("INFO", TITULO_APLICACION, SistConstants.GRABADO_CORRECTAMENTE);
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			GenerateExpressions.CrearMensaje("ERROR", TITULO_APLICACION, e.getMessage());
		}
	}
	
	public void voidSaveEditDisplay() {
		try {
			
			int routeID=0;
			if(selectDisplay.getVehicleID()>0) {
				for(Vehicle v : listVehicle) {
					if(v.getVehicleID()==selectDisplay.getVehicleID()) {
						routeID = v.getRouteID();
						break;
					}
				}
			}
			
			//verificar si se eligio un vehiculo con display
			log.debug("Actualizando Display:");
			if(selectDisplay.getVehicleID()>0 && selectDisplay.getVehicleID()!=selectDisplay.getVehicleIDOld()) {
				int displayID=-1;
				for(Display d : listDisplay) {
					if(d.getVehicleID()!=0 && d.getVehicleID()==selectDisplay.getVehicleID()) {
						displayID = d.getDisplayID();
						break;
					}
				}
				log.debug("Display Afectado:"+displayID);
				if (displayID > 0) {
					displayService.eliminarVehiculoDeDisplay(displayID);
					//crear un historyal para el display afectado
					Display g = new Display();
					g.setDisplayID(displayID);
					g.setVehicleIDOld(selectDisplay.getVehicleID());
					g.setVehicleID(-1);
					g.setCreationTime(GenerateExpressions.TimeEpoch());
					g.setUserName(GenerateExpressions.ReadUserID());
					displayService.insertHistory(g);
				}
			}
			/*
			 * NO SE ELIMINARÁ HASTA QUE COMPLETEN EL LLENADO POR QUE TODOS LOS GPS TIENEN CHIPID=1
			 * 
			if(selectDisplay.getChipID()>0 && selectDisplay.getChipID()!=selectDisplay.getChipIDOld()) {
				int displayID=-1;
				for(Display d : listDisplay) {
					if(d.getChipID()==selectDisplay.getChipID()) {
						if(d.getChipID()!=0 && d.getChipID()==selectDisplay.getChipID()) {
							displayID = d.getDisplayID();
							break;
						}
					}
				}
				if (displayID > 0) {
					displayService.eliminarChipDeGPS(displayID);
					Display g = new Display();
					g.setDisplayID(displayID);
					g.setChipIDOld(selectDisplay.getVehicleID());
					g.setChipID(-1);
					g.setCreationTime(GenerateExpressions.TimeEpoch());
					g.setUserName(GenerateExpressions.ReadUserID());
					displayService.insertHistory(selectDisplay);
				}
			}
			*/
			
			selectDisplay.setLastUpdateTime(GenerateExpressions.TimeEpoch());
			selectDisplay.setSessionIDUpdate(0l);
			selectDisplay.setRouteID(routeID);
			displayService.update(selectDisplay);
			log.debug(selectDisplay);
			
			selectDisplay.setCreationTime(GenerateExpressions.TimeEpoch());
			displayService.insertHistory(selectDisplay);
			init();
			
			PrimeFaces.current().executeScript("PF('wgvEditDisplay').hide();");
			GenerateExpressions.CrearMensaje("INFO", TITULO_APLICACION, SistConstants.GRABADO_CORRECTAMENTE);
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			GenerateExpressions.CrearMensaje("ERROR", TITULO_APLICACION, e.getMessage());
		}
	}
	
	public void selectDisplayID(int displayID) {
		for(Display g : listDisplay) {
			if(g.getDisplayID()==displayID) {
				selectDisplay = g.clone();
				break;
			}
		}
		
		try {
			listHistoryDisplay = displayService.selectHistoryDisplay(displayID);
			log.debug("listHistoryDisplay.size():"+listHistoryDisplay.size());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			GenerateExpressions.CrearMensaje("ERROR", TITULO_APLICACION, e.getMessage());
		}	}
}
