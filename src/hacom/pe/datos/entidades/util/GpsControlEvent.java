package hacom.pe.datos.entidades.util;

import hacom.pe.util.GenerateExpressions;
import lombok.Data;

@Data
public class GpsControlEvent {

	private String routeName;
	private String padron;
	private String placa;
	private String motor;
	private Long timestamp;
	private Long creationTime;
	private int diffTime_CreationMin;
	private int diffTime_EpochMin;
	private int diffCreation_EpochMin;
	private Long saltos;
	private boolean apagado=false;
	private boolean problema=false;

	public GpsControlEvent() {
		super();
	}

	public GpsControlEvent(String routeName, String padron, String placa, String motor, Long timestamp,
			Long creationTime, int diffTime_CreationMin, int diffTime_EpochMin, int diffCreation_EpochMin) {
		this.routeName = routeName;
		this.padron = padron;
		this.placa = placa;
		this.motor = motor;
		this.timestamp = timestamp;
		this.creationTime = creationTime;
		this.diffTime_CreationMin = diffTime_CreationMin;
		this.diffTime_EpochMin = diffTime_EpochMin;
		this.diffCreation_EpochMin = diffCreation_EpochMin;
	}

	public String getTimestampText() {
		if (this.timestamp == null) {
			return null;
		}
		return GenerateExpressions.ConvertEpochToDateFormat(this.timestamp, "dd/MM/yyyy HH:mm:ss");
	}

	public String getCreationTimeText() {
		if (this.creationTime == null) {
			return null;
		}
		return GenerateExpressions.ConvertEpochToDateFormat(this.creationTime, "dd/MM/yyyy HH:mm:ss");
	}

}
