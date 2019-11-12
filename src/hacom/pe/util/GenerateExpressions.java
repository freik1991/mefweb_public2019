package hacom.pe.util;

import java.io.File;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;
import org.primefaces.json.JSONTokener;

public class GenerateExpressions implements Serializable {

	private static final long serialVersionUID = 152188123670074094L;
	static final Logger log = LogManager.getLogger(GenerateExpressions.class.getName());
    private static final String Algoritmo = "AES"; //Algoritmo
    private static final String KEYENCRYPT = "v9y$B&E)H+MbQeTh";

	// en GMT
	public static Timestamp TimeNow() {
		Date d = new Date();
		Timestamp t = new Timestamp(d.getTime());
		return t;
	}

	// en GMT
	public static Long TimeEpoch() {
		long epoch = System.currentTimeMillis() / 1000;
		return epoch;
	}

	// en GMT
	public static Long ConvertDateToEpoch(Date date) {
		if (date == null) {
			return null;
		}
		long epoch = date.getTime() / 1000;
		return epoch;
	}

	// en GMT
	public static Date ConvertEpochToDate(Long epoch) {
		if (epoch == null) {
			return null;
		}
		return new Date(epoch * 1000);

	}

	// en GMT-5
	public static String ConvertDateToString(Date fecha) {
		if (fecha == null) {
			return "";
		}
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return df.format(fecha);
	}
	
	// en GMT-5 HH
		public static String ConvertHoraToString(Date fecha) {
			if (fecha == null) {
				return "";
			}
			DateFormat df = new SimpleDateFormat("HH:mm");
			return df.format(fecha);
		}
		

	public static String ConvertDateOneToString(Date fecha) {
		if (fecha == null) {
			return "";
		}
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return df.format(fecha);
	}
	
	public static String ConvertDateOneToStringIn(Date fecha) {
		if (fecha == null) {
			return "";
		}
		DateFormat df = new SimpleDateFormat("dd-mm-yyyy");
		return df.format(fecha);
	}
	
	
	public static int countDiffDay(Date date1, Date date2) {
		return (int) ((date1.getTime()-date2.getTime())/86400000);
	}
	
	public static Date prevOrNextDay(Date date,int direction) {
		Calendar c = Calendar.getInstance(); 
		c.setTime(date); 
		c.add(Calendar.DATE, direction);
		return c.getTime();
	}

	// en GMT-5
	public static String ConvertDateToString(Date fecha, String format) {
		if (fecha == null) {
			return "";
		}
		DateFormat df = new SimpleDateFormat(format);
		return df.format(fecha);
	}
	
	// en GMT-5
	public static String ConvertEpochToDateFormat(Long epoch, String format) {
		if (epoch == null) {
			return "";
		}
		return new SimpleDateFormat(format).format(new Date(epoch * 1000));
	}

	// cambiar la fecha enviada a la misma fecha pero con hora 00:00:00
	public static Long dateIni(Date d) {
		return dateIni(d, null);
	}

	public static Long dateIni(Date d, String strTimeZone) {
		Locale localidad = new Locale("es", "PE");
		Calendar objCalendar = Calendar.getInstance(TimeZone.getTimeZone("America/Lima"), localidad);
		objCalendar.setTime(d);
		Calendar objCalendarInicial = Calendar.getInstance();
		if (strTimeZone != null) {
			objCalendarInicial.setTimeZone(TimeZone.getTimeZone(strTimeZone));
		}
		objCalendarInicial.set(Calendar.YEAR, objCalendar.get(Calendar.YEAR));
		objCalendarInicial.set(Calendar.MONTH, objCalendar.get(Calendar.MONTH));
		objCalendarInicial.set(Calendar.DAY_OF_MONTH, objCalendar.get(Calendar.DAY_OF_MONTH));
		objCalendarInicial.set(Calendar.HOUR_OF_DAY, 0);
		objCalendarInicial.set(Calendar.MINUTE, 0);
		objCalendarInicial.set(Calendar.SECOND, 0);
		return objCalendarInicial.getTimeInMillis() / 1000;
	}

	// cambiar la fecha enviada a la misma fecha pero con hora 23:59:59
	public static Long dateTer(Date d) {
		return dateTer(d, null);
	}

	public static Long dateTer(Date d, String strTimeZone) {
		Locale localidad = new Locale("es", "PE");
		Calendar objCalendar = Calendar.getInstance(TimeZone.getTimeZone("America/Lima"), localidad);
		objCalendar.setTime(d);
		Calendar objCalendarFinal = Calendar.getInstance();
		if (strTimeZone != null) {
			objCalendarFinal.setTimeZone(TimeZone.getTimeZone(strTimeZone));
		}
		objCalendarFinal.set(Calendar.YEAR, objCalendar.get(Calendar.YEAR));
		objCalendarFinal.set(Calendar.MONTH, objCalendar.get(Calendar.MONTH));
		objCalendarFinal.set(Calendar.DAY_OF_MONTH, objCalendar.get(Calendar.DAY_OF_MONTH));
		objCalendarFinal.set(Calendar.HOUR_OF_DAY, 23);
		objCalendarFinal.set(Calendar.MINUTE, 59);
		objCalendarFinal.set(Calendar.SECOND, 59);
		return (objCalendarFinal.getTimeInMillis() / 1000);
	}

	public static Long dateIniMonth(Date d) {
		Locale localidad = new Locale("es", "PE");
		Calendar objCalendar = Calendar.getInstance(TimeZone.getTimeZone("America/Lima"), localidad);
		objCalendar.setTime(d);
		Calendar objCalendarFinal = Calendar.getInstance();
		objCalendarFinal.set(Calendar.YEAR, objCalendar.get(Calendar.YEAR));
		objCalendarFinal.set(Calendar.MONTH, objCalendar.get(Calendar.MONTH));
		objCalendarFinal.set(Calendar.DAY_OF_MONTH, 1);
		objCalendarFinal.set(Calendar.HOUR_OF_DAY, 0);
		objCalendarFinal.set(Calendar.MINUTE, 0);
		objCalendarFinal.set(Calendar.SECOND, 0);
		log.debug("dateIniMonth():"+objCalendarFinal.getTime());
		return (objCalendarFinal.getTimeInMillis() / 1000);
	}
	
	public static Long dateTerMonth(Date d) {
		Locale localidad = new Locale("es", "PE");
		Calendar objCalendar = Calendar.getInstance(TimeZone.getTimeZone("America/Lima"), localidad);
		objCalendar.setTime(d);
		Calendar objCalendarFinal = Calendar.getInstance();
		
		switch (objCalendar.get(Calendar.MONTH)) {
		case 12:
			objCalendarFinal.set(Calendar.YEAR, objCalendar.get(Calendar.YEAR)+1);
			objCalendarFinal.set(Calendar.MONTH, 1);
			break;
		default:
			objCalendarFinal.set(Calendar.YEAR, objCalendar.get(Calendar.YEAR));
			objCalendarFinal.set(Calendar.MONTH, objCalendar.get(Calendar.MONTH)+1);
			break;
		}

		objCalendarFinal.set(Calendar.DAY_OF_MONTH, 1);
		objCalendarFinal.set(Calendar.HOUR_OF_DAY, 0);
		objCalendarFinal.set(Calendar.MINUTE, 0);
		objCalendarFinal.set(Calendar.SECOND, 0);
		log.debug("dateTerMonth():"+objCalendarFinal.getTime());
		long casi = (objCalendarFinal.getTimeInMillis() / 1000);
		return casi-1;
	}

	// cambiar la fecha enviada a la misma fecha para una hora y minuto
	// determinada con 00 segundos
	public static Long dateChange(Date d, int hour, int minute) {
		return dateChange(d, hour, minute, 0);
	}

	// cambiar la fecha enviada a la misma fecha para una hora y minuto
	// determinada con 00 segundos
	public static Long dateChange(Date d, int hour, int minute, int segundo) {
		Locale localidad = new Locale("es", "PE");
		Calendar objCalendar = Calendar.getInstance(TimeZone.getTimeZone("America/Lima"), localidad);
		objCalendar.setTime(d);
		Calendar objCalendarFinal = Calendar.getInstance();
		objCalendarFinal.set(Calendar.YEAR, objCalendar.get(Calendar.YEAR));
		objCalendarFinal.set(Calendar.MONTH, objCalendar.get(Calendar.MONTH));
		objCalendarFinal.set(Calendar.DAY_OF_MONTH, objCalendar.get(Calendar.DAY_OF_MONTH));
		objCalendarFinal.set(Calendar.HOUR_OF_DAY, hour);
		objCalendarFinal.set(Calendar.MINUTE, minute);
		objCalendarFinal.set(Calendar.SECOND, segundo);
		//log.debug("dateChange():"+objCalendarFinal.getTime());
		return (objCalendarFinal.getTimeInMillis() / 1000);
	}
	// cambiar la fecha enviada a la misma fecha para una hora y minuto
	// determinada con 00 segundos
	public static Date createDateFromMonthAndYear(int year, int month) {
		Calendar objCalendarFinal = Calendar.getInstance();
		objCalendarFinal.set(Calendar.YEAR, year);
		objCalendarFinal.set(Calendar.MONTH, month);
		objCalendarFinal.set(Calendar.DAY_OF_MONTH, 1);
		objCalendarFinal.set(Calendar.HOUR_OF_DAY, 0);
		objCalendarFinal.set(Calendar.MINUTE, 0);
		objCalendarFinal.set(Calendar.SECOND, 0);
		return objCalendarFinal.getTime();
	}
	
	public static String ReadSession() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		return (String) session.getAttribute(SistConstants.SESSION_INFO);
	}

	public static String ReadUserID() {
		try {
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			return (String) session.getAttribute(SistConstants.SESSION_USUARIO_ID);
		} catch (Exception e) {
			return "";
		}
	}

	public static boolean ReadUserAccessIsAdmin() {
		try {
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			if ((boolean) session.getAttribute(SistConstants.SESSION_USUARIO_ADMIN)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public static String ReadValorSession(String key) {
		try {
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			if (session.getAttribute(key) != null) {
				return (String) session.getAttribute(key);
			} else {
				return "";
			}
		} catch (Exception e) {
			return "";
		}
	}

	public static void CrearMensaje(String tipo, String titulo, String texto) { // cambiado
																				// temporalmente
		FacesMessage msg;
		if (tipo.compareTo("INFO") == 0) {
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, texto);
		} else if (tipo.compareTo("ERROR") == 0) {
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, titulo, texto);
		} else if (tipo.compareTo("FATAL") == 0) {
			msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, titulo, texto);
		} else {
			msg = new FacesMessage(FacesMessage.SEVERITY_WARN, titulo, texto);
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public static String textSearch(String txt, String field) {
		String[] txtSearch = txt.split(" ");
		String filtroFinal = "";

		for (int i = 0; i < txtSearch.length; i++) {
			if (txtSearch[i].length() > 0) {
				filtroFinal = filtroFinal + " AND " + field + " LIKE '%" + txtSearch[i] + "%'";
			}
		}
		if (filtroFinal.length() > 4) {
			if (filtroFinal.substring(0, 4).equals(" AND")) {
				filtroFinal = filtroFinal.replaceFirst(" AND", " ");
			}
		}
		return filtroFinal;
	}

	public static String GenerarNombreArchivo() {
		String cadenaAleatoria = "";
		File fichero;
		long milis = new java.util.GregorianCalendar().getTimeInMillis();
		Random r = new Random(milis);
		while (true) {
			cadenaAleatoria = "";
			int i = 0;
			while (i < 20) {
				char c = (char) r.nextInt(255);
				if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z')) {
					cadenaAleatoria += c;
					i++;
				}
			}
			fichero = new File(SistConstants.DIRECTORIOFILE + cadenaAleatoria + ".pdf");
			if (!fichero.exists()) {
				break;
			}
		}
		return cadenaAleatoria;
	}

	public static String cryptMD5(String textoPlano) {
		try {
			final char[] HEXADECIMALES = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
					'f' };

			MessageDigest msgdgt = MessageDigest.getInstance("MD5");
			byte[] bytes = msgdgt.digest(textoPlano.getBytes());
			StringBuilder strCryptMD5 = new StringBuilder(2 * bytes.length);
			for (int i = 0; i < bytes.length; i++) {
				int low = (int) (bytes[i] & 0x0f);
				int high = (int) ((bytes[i] & 0xf0) >> 4);
				strCryptMD5.append(HEXADECIMALES[high]);
				strCryptMD5.append(HEXADECIMALES[low]);
			}
			return strCryptMD5.toString();
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

	public static Map<String, Object> ConvertObjectToMap(Object obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Method[] methods = obj.getClass().getMethods();

			for (Method m : methods) {
				if (m.getName().startsWith("get") && !m.getName().startsWith("getClass")) {
					Object value;
					value = (Object) m.invoke(obj);
					map.put(m.getName().substring(3).toLowerCase(), (Object) value);
				}
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return map;
	}

	public static String ConvertSecondsToDayHourMinuteSecond(Long longSeconds) {
		if (longSeconds == null) {
			return "";
		}
		String result = "";
		try {
			Long days = 0L;
			Long hours = 0L;
			Long minutes = 0L;
			Long seconds = 0L;
			days = longSeconds / 60L / 60L / 24L;
			hours = longSeconds / 60L / 60L % 24L;
			minutes = longSeconds / 60L % 60L;
			seconds = longSeconds % 60L;
			result = days > 0L ? days + " día(s)," : "";
			result += hours > 0L ? hours + " hora(s)," : "";
			result += minutes > 0L ? minutes + " minuto(s)," : "";
			result += seconds > 0L ? seconds + " segundo(s) " : "";
			result = result.substring(0, result.length() - 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.trim();
	}
	
	public static String String_format(Long number) {
		return ("00"+number).substring(("00"+number).length()-2);
	}

	public static String ConvertSecondsToDayHourMinuteSecondShort(Long longSeconds) {
		if (longSeconds == null) {
			return "";
		}
		String result = "";
		try {
			Long days = 0L;
			Long hours = 0L;
			Long minutes = 0L;
			Long seconds = 0L;
			days = longSeconds / 60L / 60L / 24L;
			hours = longSeconds / 60L / 60L % 24L;
			minutes = longSeconds / 60L % 60L;
			seconds = longSeconds % 60L;
			result = days > 0L ? days + "d " : "";
			result += hours > 0L ? String_format(hours) + "h " : "";
			result += minutes > 0L ? String_format(minutes) + "m " : "00m ";
			result += seconds > 0L ? String_format(seconds) + "s " : "00s ";
			result = result.substring(0, result.length() - 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.trim();
	}
	
	public static String ConvertSecondsToHourMinuteSecond(Long longSeconds) {
		if (longSeconds == null) {
			return "";
		}
		String result = "";
		try {

			Long hours = 0L;
			Long minutes = 0L;
			Long seconds = 0L;

			hours = longSeconds / 60L / 60L ;
			minutes = longSeconds / 60L % 60L;
			seconds = longSeconds % 60L;

			/*
			 * result += hours > 0L ? hours + "h " : ""; result += minutes > 0L
			 * ? minutes + "m " : ""; result += seconds > 0L ? seconds + "s " :
			 * ""; // result = result.substring(0, result.length() - 1);
			 */
			result = String.format("%02d", hours) + "h " + String.format("%02d", minutes) + "m "
					+ String.format("%02d", seconds) + "s";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.trim();
	}

	public static String ConvertSecondsToHourMinute(Long longSeconds) {
		if (longSeconds == null) {
			return "";
		}
		String result = "";
		try {

			Long hours = 0L;
			Long minutes = 0L;

			hours = longSeconds / 60L / 60L % 24L;
			minutes = longSeconds / 60L % 60L;

			result = String.format("%02d", hours) + "h " + String.format("%02d", minutes) + "m ";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.trim();
	}

	public static JSONObject objectToJSONObject(Object object) {
		Object json = null;
		JSONObject jsonObject = null;
		try {
			json = new JSONTokener(object.toString()).nextValue();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		if (json instanceof JSONObject) {
			jsonObject = (JSONObject) json;
		}
		return jsonObject;
	}
	
	public static float round(float value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (float) tmp / factor;
	}
	
	public static String convertFloatToCurrency(float amount) {
		NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
		DecimalFormat formatter = (DecimalFormat)nf;
		formatter.applyPattern("###,###,###.00");
		return formatter.format(amount);
	}

	
	public static long stringHourToSecun(String list[]) {
		long hour = (long) (Integer.parseInt(list[0])*60*60);
		long min = (long) (Integer.parseInt(list[1])*60);
		long sec = (long) (Integer.parseInt(list[2]));
		return hour + min + sec;
	}
	
	public static String convertIntToMillar(int cantidad) {
		NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
		DecimalFormat formatter = (DecimalFormat)nf;
		formatter.applyPattern("###,###,###");
		return formatter.format(cantidad);
	}
	

    public static String encrypt(String data) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(Algoritmo);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encVal);
    }

    public static String decrypt(String encryptedData) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(Algoritmo);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = Base64.getDecoder().decode(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        return new String(decValue);
    }

    public static Key generateKey() {
        byte[] keyValue = KEYENCRYPT.getBytes();
        return new SecretKeySpec(keyValue,Algoritmo);
    }
    
 // en GMT-5
 	public static Date ConvertStringToDate(String fecha) throws ParseException {
 		if (fecha == null) {
 			return null;
 		}
 		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse(fecha);

 		return date;
 	}
 	
 	public static Date ConvertStringToHour(String fecha) throws ParseException {
 		System.out.println("fecha:"+fecha);
 		if (fecha == null) {
 			return null;
 		}
 		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        Date date = formatter.parse(fecha);

 		return date;
 	}
}
