package hacom.pe.negocio;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hacom.pe.datos.entidades.Modulo;
import hacom.pe.datos.entidades.MsUser;
import hacom.pe.datos.entidades.User;
import hacom.pe.datos.mapper.iface.ModuloMapper;
import hacom.pe.datos.mapper.iface.UserMapper;

@Component
public class ModuloNegocio  implements ModuloMapper{

	static final Logger log = LogManager.getLogger(ModuloNegocio.class.getName());
	
	@Autowired
	ModuloMapper moduloMapper;



	@Override
	public List<Modulo> getAllModulo() throws Exception {
		try {
			return moduloMapper.getAllModulo();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Modulo> getFindModulo(Modulo asis) throws Exception {
		try {
			return moduloMapper.getFindModulo(asis);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void getSaveModulo(Modulo ue) throws Exception {
		moduloMapper.getSaveModulo(ue);
	}

	@Override
	public void getUpdateModulo(Modulo ue) throws Exception {
		moduloMapper.getUpdateModulo(ue);
	}

	@Override
	public void getdeleteModulo(int id) throws Exception {
		moduloMapper.getdeleteModulo(id);
	}

	@Override
	public Modulo getFindIdModulo() throws Exception {
		return moduloMapper.getFindIdModulo();
	}

	@Override
	public List<Modulo> getAllModuloSele() throws Exception {
		try {
			return moduloMapper.getAllModuloSele();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	
}
