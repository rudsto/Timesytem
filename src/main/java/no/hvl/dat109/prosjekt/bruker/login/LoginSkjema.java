package no.hvl.dat109.prosjekt.bruker.login;

import jakarta.validation.constraints.NotNull;

public class LoginSkjema {
	
	@NotNull
	private String mobil;
	
	@NotNull
	private String passord;
	
	public LoginSkjema() {}
	
	public LoginSkjema(String mobil, String passord) {
		this.mobil = mobil;
		this.passord = passord;
	}

	public String getMobil() {
		return mobil;
	}
	
	public void setMobil(String mobil) {
		this.mobil = mobil;
	}
	
	public String getPassord() {
		return passord;
	}
	
	public void setPassord(String passord) {
		this.passord = passord;
	}
	
}
