package hacom.pe.util;

import java.io.Serializable;

public class SistConstants implements Serializable {

	private static final long serialVersionUID = 7079108011359999775L;

	public static final String DIRECTORIOFILE = "";

	public static final String ERROR_REGISTRO_BASE_DE_DATOS = "No se pudo grabar la información...";
	public static final String ERROR_ACCESO_BASE_DE_DATOS = "No se puede acceder a la información de la Base de Datos...";
	public static final String ERROR_GEOZONAS = "La categoría aún tiene geocercas asignadas...";
	public static final String ERROR_EN_REPORTE_FECHAS_PARA_CONSULTA = "Intervalo de fechas Erradas...";
	public static final String REPORTE_SIN_DATOS = "No se encontraron resultados para la Consulta...";
	public static final String GRABADO_CORRECTAMENTE = "Grabado correctamente...!!!";
	public static final String ELIMINADO_CORRECTAMENTE = "Eliminado correctamente...!!!";
	public static final String ERROR_TIPO_GEOZONA = "Elija un tipo de geozona...";
	public static final String ERROR_RADIO_GEOZONA = "El radio no puede ser menor a 100 metros...";
	public static final String ERROR_CENTRO_GEOZONA = "Elija un punto en el mapa...";

	public static final String ACCEDO_DENEGADO = "No tiene acceso al sistema";
	public static final String SESSION_INFO = "session";
	public static final String SESSION_USUARIO_PERFIL = "Perfil";
	public static final String SESSION_USUARIO_ID = "usuarioID";
	public static final String SESSION_USUARIO_ADMIN = "isAdm";	
	public static final String SESSION_FINALIZADA = "Sessión finalizada...";	
	public static final String LOGIN_USUARIO_REG_BLANCK = "Debe ingresar los campos usuario y clave.";
	public static final String LOGIN_USUARIO_NOEXISTE = "Usuario ingresado no existe";
	public static final String LOGIN_USUARIO_NOPASS = "Usuario ingresado no existe";
	public static final String LOGIN_USUARIO_DESACTIVADO = "El usuario se encuentra desactivado...";

	public static final int ACCESO_SOLO_LECTURA = 1;
	public static final int ACCESO_EDICION = 2;
	
}
