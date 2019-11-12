package hacom.pe.service;

import java.io.Serializable;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hacom.pe.datos.entidades.Actividad;
import hacom.pe.datos.entidades.AsistenciaRemota;
import hacom.pe.datos.entidades.AsistenciaTecnica;
import hacom.pe.datos.entidades.Capacitador;
import hacom.pe.datos.entidades.Cronograma;
import hacom.pe.datos.entidades.Entidad;
import hacom.pe.datos.entidades.EntidadSectorista;
import hacom.pe.datos.entidades.Geozona;
import hacom.pe.datos.entidades.Reporte;
import hacom.pe.datos.entidades.Modalidad;
import hacom.pe.datos.entidades.Motivo;
import hacom.pe.datos.entidades.MsUser;
import hacom.pe.datos.entidades.Sectorista;
import hacom.pe.datos.entidades.SubModulo;
import hacom.pe.datos.entidades.TipoLocal;
import hacom.pe.datos.entidades.TipoSistema;
import hacom.pe.datos.entidades.TipoUe;
import hacom.pe.datos.entidades.TipoVisita;
import hacom.pe.datos.entidades.Ubigeo;
import hacom.pe.datos.entidades.UsuarioMap;
import hacom.pe.datos.mapper.iface.AsistenciaTecMapper;
import hacom.pe.negocio.EntidadNegocio;
import hacom.pe.negocio.GenericNegocio;
import hacom.pe.negocio.ReporteNegocio;

@Service
public class ReporteService implements Serializable {

	final static Logger log = LogManager.getLogger(ReporteService.class.getName());

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	ReporteNegocio reportNegocio;

	
	public List<Reporte> getAllCalidadServicio() throws Exception {
		try {
			return reportNegocio.getAllCalidadServicio();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	
	public List<Reporte> getAllEvaluacionAtencion() throws Exception {
		try {
			return reportNegocio.getAllEvaluacionAtencion();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public List<Reporte> getAllEvaluacionRemota() throws Exception {
		try {
			return reportNegocio.getAllEvaluacionRemota();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public List<Reporte> getAllResumenVisita() throws Exception {
		try {
			return reportNegocio.getAllResumenVisita();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Reporte> getAllServicioPresencial() throws Exception {
		try {
			return reportNegocio.getAllServicioPresencial();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
}
