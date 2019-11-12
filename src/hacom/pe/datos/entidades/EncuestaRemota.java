package hacom.pe.datos.entidades;

import java.util.Date;

public class EncuestaRemota {

	private String unit_sec_ejec;
	private String sectorist_names;
	private String department;
	private int depa;
	private String unitName;
	private String name;
	private String implanter_names;
	private String fechaEnvioCadI;
	private String fechaEnvioCadF;
	private String fechaRespCadI;
	private String fechaRespCadF
	;
	private Date fechaEnvCalI = new Date();
	private Date fechaEnvCalF = new Date();
	private Date fechaRespCalI = new Date();
	private Date fechaRespCalF = new Date();
	
	private String systemName;
	private String answer1;
	private String answer2;
	private String answer3;
	private String recommendation;
	private String assistance_representant;
	private String assistance_repr_work;

	private boolean checkSecEje;
	private boolean checkDepa;
	private boolean checkEntidad;
	private boolean checkSectorista;
	private boolean checkImpl;
	private boolean checkAns;
	private boolean checkRep;
	private boolean checkCarR;
	private boolean checkSis;
	private boolean disEnvio;
	private boolean disResp;
	private boolean checkFechaEnv;
	private boolean checkFechaResp;
	private String surveyDateDT;
	private String surveyCompletitionDateDT;
	private String rbFechaSelec;
	
	
	
	
	public EncuestaRemota() {
		super();
	}
	public String getUnit_sec_ejec() {
		return unit_sec_ejec;
	}
	public void setUnit_sec_ejec(String unit_sec_ejec) {
		this.unit_sec_ejec = unit_sec_ejec;
	}
	public String getSectorist_names() {
		return sectorist_names;
	}
	public void setSectorist_names(String sectorist_names) {
		this.sectorist_names = sectorist_names;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getDepa() {
		return depa;
	}
	public void setDepa(int depa) {
		this.depa = depa;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImplanter_names() {
		return implanter_names;
	}
	public void setImplanter_names(String implanter_names) {
		this.implanter_names = implanter_names;
	}
	public String getFechaEnvioCadI() {
		return fechaEnvioCadI;
	}
	public void setFechaEnvioCadI(String fechaEnvioCadI) {
		this.fechaEnvioCadI = fechaEnvioCadI;
	}
	public String getFechaEnvioCadF() {
		return fechaEnvioCadF;
	}
	public void setFechaEnvioCadF(String fechaEnvioCadF) {
		this.fechaEnvioCadF = fechaEnvioCadF;
	}
	public String getFechaRespCadI() {
		return fechaRespCadI;
	}
	public void setFechaRespCadI(String fechaRespCadI) {
		this.fechaRespCadI = fechaRespCadI;
	}
	public String getFechaRespCadF() {
		return fechaRespCadF;
	}
	public void setFechaRespCadF(String fechaRespCadF) {
		this.fechaRespCadF = fechaRespCadF;
	}
	public Date getFechaEnvCalI() {
		return fechaEnvCalI;
	}
	public void setFechaEnvCalI(Date fechaEnvCalI) {
		this.fechaEnvCalI = fechaEnvCalI;
	}
	public Date getFechaEnvCalF() {
		return fechaEnvCalF;
	}
	public void setFechaEnvCalF(Date fechaEnvCalF) {
		this.fechaEnvCalF = fechaEnvCalF;
	}
	public Date getFechaRespCalI() {
		return fechaRespCalI;
	}
	public void setFechaRespCalI(Date fechaRespCalI) {
		this.fechaRespCalI = fechaRespCalI;
	}
	public Date getFechaRespCalF() {
		return fechaRespCalF;
	}
	public void setFechaRespCalF(Date fechaRespCalF) {
		this.fechaRespCalF = fechaRespCalF;
	}
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	public String getAnswer3() {
		return answer3;
	}
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	public String getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}
	public String getAssistance_representant() {
		return assistance_representant;
	}
	public void setAssistance_representant(String assistance_representant) {
		this.assistance_representant = assistance_representant;
	}
	public String getAssistance_repr_work() {
		return assistance_repr_work;
	}
	public void setAssistance_repr_work(String assistance_repr_work) {
		this.assistance_repr_work = assistance_repr_work;
	}
	public boolean isCheckSecEje() {
		return checkSecEje;
	}
	public void setCheckSecEje(boolean checkSecEje) {
		this.checkSecEje = checkSecEje;
	}
	public boolean isCheckDepa() {
		return checkDepa;
	}
	public void setCheckDepa(boolean checkDepa) {
		this.checkDepa = checkDepa;
	}
	public boolean isCheckEntidad() {
		return checkEntidad;
	}
	public void setCheckEntidad(boolean checkEntidad) {
		this.checkEntidad = checkEntidad;
	}
	public boolean isCheckSectorista() {
		return checkSectorista;
	}
	public void setCheckSectorista(boolean checkSectorista) {
		this.checkSectorista = checkSectorista;
	}
	public boolean isCheckImpl() {
		return checkImpl;
	}
	public void setCheckImpl(boolean checkImpl) {
		this.checkImpl = checkImpl;
	}
	public boolean isCheckAns() {
		return checkAns;
	}
	public void setCheckAns(boolean checkAns) {
		this.checkAns = checkAns;
	}
	public boolean isCheckRep() {
		return checkRep;
	}
	public void setCheckRep(boolean checkRep) {
		this.checkRep = checkRep;
	}
	public boolean isCheckCarR() {
		return checkCarR;
	}
	public void setCheckCarR(boolean checkCarR) {
		this.checkCarR = checkCarR;
	}
	public boolean isCheckSis() {
		return checkSis;
	}
	public void setCheckSis(boolean checkSis) {
		this.checkSis = checkSis;
	}
	public boolean isDisEnvio() {
		return disEnvio;
	}
	public void setDisEnvio(boolean disEnvio) {
		this.disEnvio = disEnvio;
	}
	public boolean isDisResp() {
		return disResp;
	}
	public void setDisResp(boolean disResp) {
		this.disResp = disResp;
	}
	public boolean isCheckFechaEnv() {
		return checkFechaEnv;
	}
	public void setCheckFechaEnv(boolean checkFechaEnv) {
		this.checkFechaEnv = checkFechaEnv;
	}
	public boolean isCheckFechaResp() {
		return checkFechaResp;
	}
	public void setCheckFechaResp(boolean checkFechaResp) {
		this.checkFechaResp = checkFechaResp;
	}
	public String getSurveyDateDT() {
		return surveyDateDT;
	}
	public void setSurveyDateDT(String surveyDateDT) {
		this.surveyDateDT = surveyDateDT;
	}
	public String getSurveyCompletitionDateDT() {
		return surveyCompletitionDateDT;
	}
	public void setSurveyCompletitionDateDT(String surveyCompletitionDateDT) {
		this.surveyCompletitionDateDT = surveyCompletitionDateDT;
	}
	public String getRbFechaSelec() {
		return rbFechaSelec;
	}
	public void setRbFechaSelec(String rbFechaSelec) {
		this.rbFechaSelec = rbFechaSelec;
	}
	
	
	
	
	
}
