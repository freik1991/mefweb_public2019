/* 
  =======================================================================================
    Copyright 2017, HACOM S.A.C.
    Proyecto: MATRIX - Sistema de Optimización de Transporte Urbano.
  =======================================================================================
	Change History:
  =======================================================================================
*/
package hacom.pe.negocio;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hacom.pe.datos.entidades.Account;
import hacom.pe.datos.entidades.util.GpsControl;
import hacom.pe.datos.entidades.util.GpsControlEvent;
import hacom.pe.datos.mapper.iface.EventMapper;
import hacom.pe.util.SistConstants;

/**
 * Modelo de la entidad Event.
 * @version 1.0
 * @since 2017/02/16
 */
@Component
public class EventNegocio  implements EventMapper{

	final static Logger log = LogManager.getLogger(EventNegocio.class.getName());

	@Autowired
	EventMapper eventMapper;

	public List<Account> selectGpsControlAccountRead() throws Exception {
		try {
			return eventMapper.selectGpsControlAccountRead();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(SistConstants.ERROR_ACCESO_BASE_DE_DATOS);
		}
	}

	public List<GpsControl> selectGpsControlRead(int cuentas) throws Exception {
		try {
			return eventMapper.selectGpsControlRead(cuentas);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new Exception(SistConstants.ERROR_ACCESO_BASE_DE_DATOS);
		}
	}

	public List<GpsControlEvent> selectGpsControlEvent(int accountID, String esn) throws Exception {
		try {
			return eventMapper.selectGpsControlEvent(accountID, esn);
		} catch (Exception e) {
			throw new Exception("Tiempo de espera de informacion de la BD, excedido...!!!");
		} 
	}

}
