package no.hvl.dat109.prosjekt.bruker.login;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * Klasse brukt til å holde brukerinput ved innlogging. Klassen tar ansvar for
 * validering av input gjennom annotasjoner.
 */
public class LoginSkjema {
	
	@Pattern(regexp = "^\\d{8}$")
	@NotNull
	private String mobil;
	
	@Size(min = 4)
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
