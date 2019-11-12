package hacom.pe.datos.entidades;

import org.apache.poi.hpsf.Decimal;

public class Geozona {

	private String id;
	private String geozoneName;
	private String geozoneReference;
	private Decimal latitude;
	private Decimal longitude;
	private Decimal radius;
	private String first_name;
	private String last_name;
	
	
	
	public Geozona() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGeozoneName() {
		return geozoneName;
	}
	public void setGeozoneName(String geozoneName) {
		this.geozoneName = geozoneName;
	}
	public String getGeozoneReference() {
		return geozoneReference;
	}
	public void setGeozoneReference(String geozoneReference) {
		this.geozoneReference = geozoneReference;
	}
	

	public Decimal getLatitude() {
		return latitude;
	}
	public void setLatitude(Decimal latitude) {
		this.latitude = latitude;
	}
	public Decimal getLongitude() {
		return longitude;
	}
	public void setLongitude(Decimal longitude) {
		this.longitude = longitude;
	}
	public Decimal getRadius() {
		return radius;
	}
	public void setRadius(Decimal radius) {
		this.radius = radius;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	
}
