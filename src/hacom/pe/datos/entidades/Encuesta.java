package hacom.pe.datos.entidades;

import java.math.BigInteger;
import java.util.Date;

public class Encuesta {



	private String secEjec;
	private String sectorist_names;
	private String depaname;
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
	private String ans1;
	private String ans2;
	private String ans3;
	private String recommendation;
	private String assistance_representant;
	private String assistance_repr_work;

	private boolean checkSecEje;
	private boolean checkDepa;
	private boolean checkEntidad;
	private boolean checkSectorista;
	private boolean checkImpl;
	private boolean checkFunc;
	private boolean checkTec;
	private boolean checkCap;
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
	public String getRbFechaSelec() {
		return rbFechaSelec;
	}
	public void setRbFechaSelec(String rbFechaSelec) {
		this.rbFechaSelec = rbFechaSelec;
	}
	public Encuesta() {
		super();
	}
	public String getSecEjec() {
		return secEjec;
	}
	public void setSecEjec(String secEjec) {
		this.secEjec = secEjec;
	}
	public String getSectorist_names() {
		return sectorist_names;
	}
	public void setSectorist_names(String sectorist_names) {
		this.sectorist_names = sectorist_names;
	}
	
	public String getDepaname() {
		return depaname;
	}
	public void setDepaname(String depaname) {
		this.depaname = depaname;
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
	public String getAns1() {
		return ans1;
	}
	public void setAns1(String ans1) {
		this.ans1 = ans1;
	}
	public String getAns2() {
		return ans2;
	}
	public void setAns2(String ans2) {
		this.ans2 = ans2;
	}
	public String getAns3() {
		return ans3;
	}
	public void setAns3(String ans3) {
		this.ans3 = ans3;
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
	public boolean isCheckFunc() {
		return checkFunc;
	}
	public void setCheckFunc(boolean checkFunc) {
		this.checkFunc = checkFunc;
	}
	public boolean isCheckTec() {
		return checkTec;
	}
	public void setCheckTec(boolean checkTec) {
		this.checkTec = checkTec;
	}
	public boolean isCheckCap() {
		return checkCap;
	}
	public void setCheckCap(boolean checkCap) {
		this.checkCap = checkCap;
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
	
	
	
}
