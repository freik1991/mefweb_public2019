package hacom.pe.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import hacom.pe.datos.entidades.AsistenciaTecnica;
import hacom.pe.datos.entidades.Departamento;
import hacom.pe.datos.entidades.Encuesta;
import hacom.pe.datos.entidades.MsUser;
import hacom.pe.datos.entidades.Visita;
import hacom.pe.service.AsistenciaTecService;
import hacom.pe.service.EncuestaService;
import hacom.pe.service.UserService;
import hacom.pe.service.VisitaService;
import hacom.pe.util.GenerateExpressions;

@ManagedBean(name = "usuarioController")
@SessionScoped
public class UsuarioController {

	@ManagedProperty(value = "#{userService}")
	private UserService userService;

	private List<MsUser> lstAsis;
	private MsUser usuarioBean;
	private List<Departamento> lstDepa;
	@ManagedProperty(value = "#{asistenciaTecService}")
	private AsistenciaTecService asistenciaTecService;

	@PostConstruct
	public void inicializarObjetos() {
		lstAsis = new ArrayList<MsUser>();
		lstDepa = new ArrayList<Departamento>();

		try {
			lstAsis = userService.getAllUsuarioAdm();
			lstDepa = asistenciaTecService.listarDepartamento();
			usuarioBean = new MsUser();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void buscarDepa() {

		try {
			lstDepa = asistenciaTecService.listarDepartamento();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void validarSeleccion() {
		if (!usuarioBean.isCheckRuc()) {
			usuarioBean.setUsername("");
		}
		if (!usuarioBean.isCheckUsu()) {
			usuarioBean.setName_usu("");
		}

		if (!usuarioBean.isCheckDisp()) {
			usuarioBean.setDevice_id("");
		}
		if (!usuarioBean.isCheckTipo()) {
			usuarioBean.setUserType("");
		}
		if (!usuarioBean.isCheckSecNam()) {
			usuarioBean.setSectorist("");
		}

	}

	public void filtroUsuario() throws Exception {
		try {

			this.validarSeleccion();

			lstAsis = userService.getFindUsuarioAdm(usuarioBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public AsistenciaTecService getAsistenciaTecService() {
		return asistenciaTecService;
	}

	public void setAsistenciaTecService(AsistenciaTecService asistenciaTecService) {
		this.asistenciaTecService = asistenciaTecService;
	}

	

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<MsUser> getLstAsis() {
		return lstAsis;
	}

	public void setLstAsis(List<MsUser> lstAsis) {
		this.lstAsis = lstAsis;
	}

	public MsUser getUsuarioBean() {
		return usuarioBean;
	}

	public void setUsuarioBean(MsUser usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

	public List<Departamento> getLstDepa() {
		return lstDepa;
	}

	public void setLstDepa(List<Departamento> lstDepa) {
		this.lstDepa = lstDepa;
	}

}
