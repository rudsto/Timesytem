package no.hvl.dat109.prosjekt.bruker;

import java.util.Objects;

import jakarta.persistence.Entity;

@Entity
public class Bruker {

	private String mobil;
	private String navn;
	private Passord passord;

	public Bruker() {
		
	}

	public Bruker(String mobil, String navn, Passord passord) {
		this.mobil = mobil;
		this.navn = navn;
		this.passord = passord;
	}

	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public Passord getPassord() {
		return passord;
	}

	public void setPassord(Passord passord) {
		this.passord = passord;
	}

	@Override
	public int hashCode() {
		return Objects.hash(navn, passord, mobil);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bruker other = (Bruker) obj;
		return Objects.equals(navn, other.navn) && Objects.equals(passord, other.passord)
				&& Objects.equals(mobil, other.mobil);
	}

	@Override
	public String toString() {
		return "Bruker [mobil=" + mobil + ", navn=" + navn + ", passord=" + passord + "]";
	}
	
}
