package hacom.pe.datos.mapper.iface;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

import hacom.pe.datos.entidades.Actividad;
import hacom.pe.datos.entidades.AsistenciaRemota;
import hacom.pe.datos.entidades.AsistenciaTecnica;
import hacom.pe.datos.entidades.Capacitador;
import hacom.pe.datos.entidades.Cronograma;
import hacom.pe.datos.entidades.Departamento;
import hacom.pe.datos.entidades.Entidad;
import hacom.pe.datos.entidades.EntidadSectorista;
import hacom.pe.datos.entidades.Geozona;
import hacom.pe.datos.entidades.Reporte;
import hacom.pe.datos.entidades.Modalidad;
import hacom.pe.datos.entidades.Modulo;
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


public interface ReporteMapper {

	@Select(value = " {call dbo.usp_getAllAsistenciaRem()}")
	@Options(statementType = StatementType.CALLABLE)
	List<Reporte> getAllCalidadServicio() throws Exception;
	
	@Select(value = " {call dbo.usp_getAllEvaluacionAtencion()}")
	@Options(statementType = StatementType.CALLABLE)
	List<Reporte> getAllEvaluacionAtencion() throws Exception;
	
	@Select(value = " {call dbo.usp_getAllEvaluacionRemota()}")
	@Options(statementType = StatementType.CALLABLE)
	List<Reporte> getAllEvaluacionRemota() throws Exception;
	
	@Select(value = " {call dbo.usp_getAllResumen()}")
	@Options(statementType = StatementType.CALLABLE)
	List<Reporte> getAllResumenVisita() throws Exception;
	
	@Select(value = " {call dbo.usp_getAllServicioPresencial()}")
	@Options(statementType = StatementType.CALLABLE)
	List<Reporte> getAllServicioPresencial() throws Exception;
	
}
