package hacom.pe.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hacom.pe.datos.entidades.MsUser;
import hacom.pe.datos.entidades.Resumen;
import hacom.pe.datos.entidades.UsuarioMap;
import hacom.pe.negocio.UserNegocio;
import hacom.pe.util.SistConstants;

@Service
public class UserService {

	final static Logger log = LogManager.getLogger(UserService.class.getName());

	@Autowired
	UserNegocio userNegocio;

	public Map<String, Object> validar(String usuario, String clave) throws Exception {
		Map<String, Object> login = new HashMap<String, Object>();

		// vefiricar si existe la cuenta
		MsUser u = new MsUser();
		u.setUseriD(usuario);
		u.setPassword(clave);
        System.out.println("u:"+u.getUseriD()+ " "+ u.getPassword());
		// vefiricar si existe el usuario
        UsuarioMap user = userNegocio.select(u.getUseriD(),u.getPassword());
		System.out.println("user:" + user.getClave());
		log.debug(user);
		
		if (user == null ) {
			throw new Exception(SistConstants.LOGIN_USUARIO_NOEXISTE);
		}

		// Acceso a usuario
		if (user.getClave().compareTo(clave) == 0) {
			login.put("login", true);
			login.put("user", user);
			return login;
		} else {
			login.put("login", false);
			throw new Exception(SistConstants.LOGIN_USUARIO_NOPASS);
		}

	}
	
	public MsUser findUsuario(int sec) throws Exception {

		
        MsUser user = userNegocio.getFindUsuario(sec);
		System.out.println("useridd:" + user.getId());
		log.debug(user);
		
		return user;

	}
	
	public List<MsUser> getAllUsuarioAdm() throws Exception {
		List<MsUser> lstAsi = userNegocio.getAllUsuario();
     
                    return lstAsi;
	}


	public List<MsUser> getFindUsuarioAdm(MsUser asis) throws Exception {
		List<MsUser> lstAsi = userNegocio.getFindUsuarioAdm(asis);
                   return lstAsi;
	}
	
}
