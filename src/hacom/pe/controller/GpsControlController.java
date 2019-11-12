package hacom.pe.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import hacom.pe.datos.entidades.Account;
import hacom.pe.datos.entidades.util.GpsControl;
import hacom.pe.datos.entidades.util.GpsControlEvent;
import hacom.pe.service.EventService;
import hacom.pe.util.GenerateExpressions;
import hacom.pe.util.SistConstants;
import lombok.Getter;
import lombok.Setter;

@Controller
@Scope(value = "session")
public class GpsControlController {

	final static Logger log = LogManager.getLogger(GpsControlController.class.getName());


	@Getter
	@Setter
	private List<GpsControl> listGps;
	@Getter
	@Setter
	private List<GpsControlEvent> listGpsEvent;
	@Getter
	@Setter
	private List<Account> listAccount;
	@Getter
	@Setter
	private int accountID = 9;
	@Getter
	private GpsControl selectEvent;

	@Autowired
	EventService eventService;

	@PostConstruct
	public void init() {
		listGpsEvent = new ArrayList<>();
		listGps = new ArrayList<>();
		try {
			listAccount = eventService.selectGpsControlAccountRead();
			log.debug("listAccount.size():" + listAccount.size());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			GenerateExpressions.CrearMensaje("ERROR", "CONTROL DE GPS", SistConstants.ERROR_ACCESO_BASE_DE_DATOS);
		}

	}

	/**
	 * finaliza el bean controller de session.
	 */
	@PreDestroy
	void release() {

	}

	public void selectAccount() {
		try {
				log.debug("Select AccountID:" + accountID);
				listGps = eventService.selectGpsControlRead(accountID);
				for (int i = 0; i < listGps.size(); i++) {
					if (listGps.get(i).getStatusName()!=null) {
						if (listGps.get(i).getStatusName().compareTo("Apagado y sin movimiento") == 0
								|| listGps.get(i).getStatusName().compareTo("Motor Apagado") == 0
								|| listGps.get(i).getStatusName().compareTo("Bateria Desconectada") == 0) {
							listGps.get(i).setApagado(true);
							listGps.get(i).setProblema(false);
						} else {
							if (((System.currentTimeMillis() / 1000) - listGps.get(i).getTimeIngreso()) > 20) {
								listGps.get(i).setApagado(false);
								listGps.get(i).setProblema(true);
							} else {
								listGps.get(i).setApagado(false);
								listGps.get(i).setProblema(false);
							}
						}
					} else {
						listGps.get(i).setApagado(true);
					}
				}
				log.debug("listGps.size():" + listGps.size());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			GenerateExpressions.CrearMensaje("ERROR", "CONTROL DE GPS", SistConstants.ERROR_ACCESO_BASE_DE_DATOS);
		}
	}

	public void setSelectEvent(GpsControl gpsControl) {
		this.selectEvent = gpsControl;
		try {
				log.debug("Select gpsControl.getAccountID():" + gpsControl.getAccountID()
						+ " select gpsControl.getEsn():" + gpsControl.getEsn());
				
				listGpsEvent = eventService.selectGpsControlEvent(gpsControl.getAccountID(), gpsControl.getEsn());
				
				log.debug("listGpsEvent.size():" + listGpsEvent.size());
				for (int i = 1; i < listGpsEvent.size(); i++) {
					listGpsEvent.get(i).setSaltos(listGpsEvent.get(i - 1).getTimestamp() - listGpsEvent.get(i).getTimestamp());
					if (listGpsEvent.get(i).getMotor()!=null && (listGpsEvent.get(i).getMotor().compareTo("Apagado y sin movimiento") == 0
							|| listGpsEvent.get(i).getMotor().compareTo("Motor Apagado") == 0
							|| listGpsEvent.get(i).getMotor().compareTo("Bateria Desconectada") == 0)) {

						listGpsEvent.get(i).setApagado(true);
						listGpsEvent.get(i).setProblema(false);
					} else {
						if (listGpsEvent.get(i).getDiffTime_CreationMin() > 30
								|| listGpsEvent.get(i).getSaltos() > 20) {
							listGpsEvent.get(i).setApagado(false);
							listGpsEvent.get(i).setProblema(true);
						} else {
							listGpsEvent.get(i).setApagado(false);
							listGpsEvent.get(i).setProblema(false);
						}
					}
				}

		} catch (Exception e) {
			GenerateExpressions.CrearMensaje("ERROR", "CONTROL DE GPS", e.getMessage());
			listGpsEvent = new ArrayList<>();
		}
	}
}
