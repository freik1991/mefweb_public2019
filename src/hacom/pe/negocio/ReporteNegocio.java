package hacom.pe.negocio;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
import hacom.pe.datos.mapper.iface.GenericMapper;
import hacom.pe.datos.mapper.iface.ReportMapper;
import hacom.pe.datos.mapper.iface.ReporteMapper;

@Component
public class ReporteNegocio implements ReporteMapper {

	static final Logger log = LogManager.getLogger(ReporteNegocio.class.getName());

	@Autowired
	ReporteMapper reportMapper;

	@Override
	public List<Reporte> getAllCalidadServicio() throws Exception {
		try {
			return reportMapper.getAllCalidadServicio();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Reporte> getAllEvaluacionAtencion() throws Exception {
		try {
			return reportMapper.getAllEvaluacionAtencion();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Reporte> getAllEvaluacionRemota() throws Exception {
		try {
			return reportMapper.getAllEvaluacionRemota();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Reporte> getAllResumenVisita() throws Exception {
		try {
			return reportMapper.getAllResumenVisita();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Reporte> getAllServicioPresencial() throws Exception {
		try {
			return reportMapper.getAllServicioPresencial();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

}
