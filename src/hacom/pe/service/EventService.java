/* 
  =======================================================================================
    Copyright 2017, HACOM S.A.C.
    Proyecto: MATRIX - Sistema de Optimización de Transporte Urbano.
  =======================================================================================
	Change History:
  =======================================================================================
*/
package hacom.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hacom.pe.datos.entidades.Account;
import hacom.pe.datos.entidades.util.GpsControl;
import hacom.pe.datos.entidades.util.GpsControlEvent;
import hacom.pe.negocio.EventNegocio;

/**
 * Servicio de eventos del vehiculo.
 * @version 1.0
 * @since 2017/02/16
 */
@Service("EventService")
public class EventService {

	@Autowired
	EventNegocio eventNegocio;

	public List<Account> selectGpsControlAccountRead() throws Exception {
			return eventNegocio.selectGpsControlAccountRead();
	}

	public List<GpsControl> selectGpsControlRead(int cuentas) throws Exception {
			return eventNegocio.selectGpsControlRead(cuentas);
	}

	public List<GpsControlEvent> selectGpsControlEvent(int accountID, String esn) throws Exception {
			return eventNegocio.selectGpsControlEvent(accountID, esn);
	}
}
