package model;


public class SensoreTabella {
	
	private String codice1;
	private String tipo1;
	private int state1;
	private double last_data1;
	private String anomalia;
	
	public SensoreTabella() {
	}

	public SensoreTabella(String codice1, String tipo1, int state1, double last_data1, String anoma) {
		this.codice1 = codice1;
		this.tipo1 = tipo1;
		this.state1 = state1;
		this.last_data1 = last_data1;
		this.anomalia = anoma;
	}

	public String getCodice1() {
		return codice1;
	}

	public void setCodice1(String codice1) {
		this.codice1 = codice1;
	}

	public String getTipo1() {
		return tipo1;
	}

	public void setTipo1(String tipo1) {
		this.tipo1 = tipo1;
	}

	public int getState1() {
		return state1;
	}

	public void setState1(int state1) {
		this.state1 = state1;
	}

	public double getLast_data1() {
		return last_data1;
	}

	public void setLast_data1(double last_data1) {
		this.last_data1 = last_data1;
	}

	public String getAnomalia() {
		return anomalia;
	}

	public void setAnomalia(String anoma) {
		this.anomalia = anoma;
	}

	@Override
	public String toString() {
		return "SensoreTabella{" +
				"codice1='" + codice1 + '\'' +
				", tipo1='" + tipo1 + '\'' +
				", state1=" + state1 +
				", last_data1=" + last_data1 +
				", anomalia='" + anomalia + '\'' +
				'}';
	}
}
