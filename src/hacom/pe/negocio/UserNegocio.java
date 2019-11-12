package hacom.pe.negocio;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hacom.pe.datos.entidades.MsUser;
import hacom.pe.datos.entidades.User;
import hacom.pe.datos.entidades.UsuarioMap;
import hacom.pe.datos.mapper.iface.UserMapper;

@Component
public class UserNegocio  implements UserMapper{

	static final Logger log = LogManager.getLogger(UserNegocio.class.getName());
	
	@Autowired
	UserMapper userMapper;

	public UsuarioMap select(String use,String pass) throws Exception {
		try {
			return userMapper.select(use,pass);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public MsUser getFindUsuario(int asis) throws Exception {
		try {
			return userMapper.getFindUsuario(asis);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<MsUser> getAllUsuario() throws Exception {
		try {
			return userMapper.getAllUsuario();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<MsUser> getFindUsuarioAdm(MsUser asis) throws Exception {
		try {
			return userMapper.getFindUsuarioAdm(asis);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	

	
}
