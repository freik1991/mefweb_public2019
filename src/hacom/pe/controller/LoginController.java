/* 
 * =======================================================================================
 *   Copyright 2016, HACOM S.A.C.
 *   Proyecto: MATRIX - Sistema de Optimización de Transporte Urbano.
 * =======================================================================================
 *    Change History:
 * 
 * =======================================================================================
 * 
*/
package hacom.pe.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import hacom.pe.datos.entidades.MsUser;
import hacom.pe.datos.entidades.User;
import hacom.pe.datos.entidades.UsuarioMap;
import hacom.pe.datos.entidades.util.Theme;
import hacom.pe.service.UserService;
import hacom.pe.util.GenerateExpressions;
import hacom.pe.util.SistConstants;
import lombok.Getter;
import lombok.Setter;

/**
 * Controlador de la página de login
 * @version 1.0
 * @since 2016/09/05
 * @see hacom.pe.datos.entidades.Account
 * @see hacom.pe.datos.entidades.SessionHistory
 * @see hacom.pe.datos.entidades.User
 * @see hacom.pe.datos.entidades.report.UserACLAdmin
 * @see hacom.pe.datos.service.LoginService
 * @see hacom.pe.datos.service.SessionHistoryService
 * @see hacom.pe.datos.service.UserACLService
 * @see hacom.pe.util.GenerateExpressions
 * @see hacom.pe.util.SistConstants
 */
@Controller("loginController")
@Scope(value = "session")
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String TITULO_APLICACION = "ADMINISTRACION DE INGRESO";
	static final Logger log = LogManager.getLogger(LoginController.class.getName());

	@Getter @Setter private boolean isAdm;
	@Getter @Setter private String varUsuario;
	@Getter @Setter private String varClave;
	@Getter @Setter private String nombre;
	@Getter @Setter private boolean login;
	@Getter @Setter private String tipo;

	@Getter @Setter private UsuarioMap user;
	@Getter @Setter List<Theme> themes;
	@Getter @Setter String selectThemes="nova-colored";
	@Getter @Setter private boolean menuAdm;
	@Getter @Setter private boolean menuRepo;
	@Getter @Setter private boolean menuCap;
	@Getter @Setter private boolean menuCrono;
	@Getter @Setter private boolean menuAsis;
	@Getter @Setter private boolean menuActi;
	@Getter @Setter private boolean menuConf;
	@Getter @Setter private String smenuImp;
	@Getter @Setter private String smenuAsisP;
	@Getter @Setter private String smenuAdm;
	@Getter @Setter private String smenuEnt;
	@Getter @Setter private String smenuAsisRe;

	@Autowired
	UserService userService;
	
	/**
	 * Constructor del controlador.
	 */
	public LoginController() {
		varUsuario = "";
		varClave = "";
		user = new UsuarioMap();
		login = false;
		themes = new ArrayList<>();
        themes.add(new Theme(0, "Blanco-Liviano", "nova-light"));
        themes.add(new Theme(1, "Blanco-Oscura", "nova-dark"));
        themes.add(new Theme(2, "Blanco-De Colores", "nova-colored"));
        themes.add(new Theme(3, "Negro-Azul", "luna-blue"));
        themes.add(new Theme(4, "Negro-Ambar", "luna-amber"));
        themes.add(new Theme(5, "Negro-Verde", "luna-green"));
        themes.add(new Theme(6, "Negro-Rosa", "luna-pink"));
	}

	/**
	 * Valida el acceso a Matrix.
	 * @return Indicador de autorizacion. 
	 */
	public String validar() {
		System.out.println("varUsuario:"+varUsuario);
		System.out.println("varClave:"+varClave);
//		String varUsuario = "klm";
//		String varClave = "flight";
		if(varUsuario.isEmpty() ||  varClave.isEmpty()){
			GenerateExpressions.CrearMensaje("INFO", TITULO_APLICACION, SistConstants.LOGIN_USUARIO_REG_BLANCK);
			return "";
		}
		
		
		try {
			login = false;
			Map<String, Object> respuesta = null;
			try {
				System.out.println("respuesta:" + userService.validar(varUsuario, varClave));
				respuesta = userService.validar(varUsuario, varClave);
				if (!(boolean) respuesta.get("login")) {
					GenerateExpressions.CrearMensaje("INFO", TITULO_APLICACION, SistConstants.ACCEDO_DENEGADO);
					return "";
				}
			} catch (Exception e) {
				GenerateExpressions.CrearMensaje("INFO", TITULO_APLICACION, e.getMessage());
				return "";
//				e.printStackTrace();
			}
			user = (UsuarioMap) respuesta.get("user");
			log.debug(user);
			nombre = user.getUsuario();
			tipo =user.getTipo();
			System.out.println("tipo:"+tipo);
           // MsUser user = userService.findUsuario(6);
            this.menuEvento(tipo);
			// Grabar sessión en HttpSession
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			session.setAttribute(SistConstants.SESSION_INFO, session.getId());
//			session.setAttribute(SistConstants.SESSION_USUARIO_PERFIL, user.getPerfil());
//			session.setAttribute(SistConstants.SESSION_USUARIO_ID, user.getUserName());
//
//			selectThemes = user.getPerfil();
			log.debug("selectThemes:" + selectThemes);
			if(selectThemes.isEmpty()) {
				selectThemes="luna-green";
			}
			log.debug("selectThemes:" + selectThemes);

			log.info("------ Login ------");
			log.info("Usuario: " + ((varUsuario.isEmpty()) ? "" : (varUsuario + " - ")) + nombre);
			log.info("Session: " + session.getId());
			log.info("------ Login ------");
			//GenerateExpressions.CrearMensaje("INFO", "Bienvenid@ "+nombre, user.getUseriD());
			
			
	        try {
	        	FacesContext contex = FacesContext.getCurrentInstance();
				contex.getExternalContext().redirect( "calidadServicioRemoto.jsf" );
			} catch (IOException e) {
				log.error(e);
			}
			
			
			return "autorizado";

		} catch (Exception e) {
			//e.printStackTrace();
			return "";
		}
	}

	/**
	 * Metodo para cerrar la sesion
	 * @return Indicar de exito.
	 */
	public String cerrarSession() {
		varClave = "";
		login = false;
		log.debug("----------------Saliste del Sistema------------------------");
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.invalidate();

		GenerateExpressions.CrearMensaje("INFO", TITULO_APLICACION, SistConstants.SESSION_FINALIZADA);
        try {
        	FacesContext contex = FacesContext.getCurrentInstance();
			contex.getExternalContext().redirect( "login.jsf" );
		} catch (IOException e) {
			log.error(e);
		}
		
		
		return "cerrarsession";

	}

	/**
	 * Metodo para cerrar la sesion
	 * @param prueba Valor de inicio
	 * @return Indicar de exito.
	 */
	public int cerrarSession(String prueba) {
		log.debug("----------------Saliste del Sistema / prueba------------------------");
		return 0;
	}
	
//	public void changePerfil() {
//		try {
//			log.debug("selectThemes:" + selectThemes);
//			userService.updatePerfilColor(new User(GenerateExpressions.ReadUserID(), "", selectThemes));
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//		}
//	}
	
	public void menuEvento(String tipo) {
		if(tipo.equals("A")) {
			menuAdm = true;
			menuCap = false;
			menuCrono = false;
			menuAsis = false;
			menuActi = false;
			menuConf = true;
			menuRepo = true;
			smenuAdm = "block";
			smenuImp = "block";
			smenuEnt = "block";
		}else if(tipo.equals("C")) {
			menuAdm = false;
			menuConf = false;
			menuCrono = false;
			menuAsis = false;
			menuRepo = true;
			menuCap = true;
			menuActi = true;
			

		}else if(tipo.equals("S")) {
			menuAdm = true;
			menuCrono = true;
			menuAsis = true;
			menuRepo = true;
			menuCap = true;
			menuActi = true;
			menuConf = false;	
			smenuAdm = "none";
			smenuImp = "block";
			smenuEnt = "block";
			smenuAsisP = "block";
			smenuAsisRe = "block";

		}else if(tipo.equals("I")) {
			menuAdm = true;
			menuCrono = true;
			menuAsis = true;
			menuRepo = true;
			menuCap = true;
			menuActi = true;
			menuConf = false;	
			smenuAdm = "none";
			smenuImp = "none";
			smenuEnt = "block";
			smenuAsisP = "none";
			smenuAsisRe = "block";
		}
	}
}
