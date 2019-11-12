package hacom.pe.negocio;

import java.io.Serializable;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hacom.pe.datos.entidades.AsistenciaTecnica;
import hacom.pe.datos.entidades.Departamento;
import hacom.pe.datos.entidades.MsUser;
import hacom.pe.datos.mapper.iface.AsistenciaTecMapper;
import hacom.pe.datos.mapper.iface.UserMapper;

@Component
public class AsistenciaTecNegocio  implements AsistenciaTecMapper,Serializable{

	static final Logger log = LogManager.getLogger(AsistenciaTecNegocio.class.getName());
	
	@Autowired
	AsistenciaTecMapper asistenciaTecMapper;


	@Override
	public List<Departamento> select() throws Exception {
		try {
			return asistenciaTecMapper.select();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}


	@Override
	public List<AsistenciaTecnica> getAllAsistenciaTec() throws Exception {
		try {
			return asistenciaTecMapper.getAllAsistenciaTec();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}


	@Override
	public AsistenciaTecnica getSectorista(int userID) throws Exception {
		try {
			return asistenciaTecMapper.getSectorista(userID);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}


	@Override
	public List<AsistenciaTecnica> getFindAsistenciaTecnica(AsistenciaTecnica asis) throws Exception {
		try {
			return asistenciaTecMapper.getFindAsistenciaTecnica(asis);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}


	@Override
	public AsistenciaTecnica getSectoristaName(String userName) throws Exception {
		try {
			return asistenciaTecMapper.getSectoristaName(userName);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	

	
}

