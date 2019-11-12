package hacom.pe.controller;

import java.io.Serializable;
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

import hacom.pe.datos.entidades.Chip;
import hacom.pe.datos.entidades.ChipStatus;
import hacom.pe.datos.entidades.ChipSupplier;
import hacom.pe.service.ChipService;
import hacom.pe.service.ReportService;
import hacom.pe.util.GenerateExpressions;
import hacom.pe.util.SistConstants;
import lombok.Getter;
import lombok.Setter;

@Controller
@Scope(value = "session")
public class ChipController implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String TITULO_APLICACION = "ADMINISTRACION DE INGRESO";
	static final Logger log = LogManager.getLogger(LoginController.class.getName());
	
	@Getter @Setter private List<Chip> listChip;
	@Getter @Setter private List<Chip> filterListChip;
	@Getter @Setter private List<ChipSupplier> listChipSupplier;
	@Getter @Setter private List<ChipStatus> listChipStatus;
	@Getter @Setter private List<Chip> listHistoryChip;
	
	@Getter @Setter private Chip selectChip;
	
	@Autowired
	ChipService chipService;
	@Autowired
	ReportService reportService;
	
	@PostConstruct
	public void init() {
		try {
			listChipStatus = reportService.readListChipStatus();
			listChipSupplier = reportService.readListChipSupplier();
			voidListChip();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			GenerateExpressions.CrearMensaje("ERROR", TITULO_APLICACION, e.getMessage());
		}
		
	}

	public void voidListChip() {
		try {
			selectChip = new Chip();
			listChip = chipService.selectAll();
			log.debug("listChip.size():"+listChip.size());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			GenerateExpressions.CrearMensaje("ERROR", TITULO_APLICACION, e.getMessage());
		}
	}
	
	@PreDestroy
    void release(){
		
	}
	
	public void voidNewChip() {
		selectChip = new Chip();
		selectChip.setUserName(GenerateExpressions.ReadUserID());
		selectChip.setChipStatusID(1);
		selectChip.setDeliveryDateChange(new Date());
		PrimeFaces.current().executeScript("PF('wgvNewChip').show();");
	}
	
	public void voidEditChip(int chipID) {
		selectChip = new Chip();
		log.debug("chipID: "+chipID);
		for(Chip c : listChip) {
			if(c.getChipID()==chipID) {
				log.debug("chipID: "+chipID);
				selectChip = c.clone();
				break;
			}
		}
		log.debug(selectChip);
		selectChip.voidPrepararEdicion();
		selectChip.setUserName(GenerateExpressions.ReadUserID());
		PrimeFaces.current().executeScript("PF('wgvEditChip').show();");
	}
	
	public void voidSaveNewChip() {
		try {
			selectChip.setCreationTime(GenerateExpressions.TimeEpoch());
			selectChip.setSessionIDCreation(0l);
			chipService.insert(selectChip);
			log.debug(selectChip);
			chipService.insertHistory(selectChip);
			voidListChip();
			PrimeFaces.current().executeScript("PF('wgvNewChip').hide();");
			GenerateExpressions.CrearMensaje("INFO", TITULO_APLICACION, SistConstants.GRABADO_CORRECTAMENTE);
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			GenerateExpressions.CrearMensaje("ERROR", TITULO_APLICACION, e.getMessage());
		}
	}
	
	public void voidSaveEditChip() {
		try {
			selectChip.setLastUpdateTime(GenerateExpressions.TimeEpoch());
			selectChip.setSessionIDUpdate(0l);
			
			chipService.update(selectChip);
			log.debug(selectChip);

			selectChip.setCreationTime(GenerateExpressions.TimeEpoch());
			chipService.insertHistory(selectChip);
			voidListChip();
			
			PrimeFaces.current().executeScript("PF('wgvEditChip').hide();");
			GenerateExpressions.CrearMensaje("INFO", TITULO_APLICACION, SistConstants.GRABADO_CORRECTAMENTE);
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			GenerateExpressions.CrearMensaje("ERROR", TITULO_APLICACION, e.getMessage());
		}
	}
	
	public void selectChipID(int chipID) {
		for(Chip c : listChip) {
			if(c.getChipID()==chipID) {
				selectChip = c.clone();
				break;
			}
		}
		
		try {
			listHistoryChip = chipService.selectHistoryChip(chipID);
			log.debug("listHistoryChip.size():"+listHistoryChip.size());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			GenerateExpressions.CrearMensaje("ERROR", TITULO_APLICACION, e.getMessage());
		}	}
}
