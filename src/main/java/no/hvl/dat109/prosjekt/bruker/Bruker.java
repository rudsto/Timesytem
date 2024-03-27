package no.hvl.dat109.prosjekt.bruker;

import java.util.Objects;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "DAT109_PROSJEKT")
public class Bruker {

	@Id
	private String mobil;
	private String fornavn;
	private String etternavn;
	
	@Embedded
	private Passord passord;
	
	public Bruker() {
		
	}

	public Bruker(String mobil, String fornavn, String etternavn, 
			Passord passord) {
		this.mobil = mobil;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.passord = passord;
	}

	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}
	
	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public Passord getPassord() {
		return passord;
	}

	public void setPassord(Passord passord) {
		this.passord = passord;
	}

	@Override
	public int hashCode() {
		return Objects.hash(etternavn, fornavn, mobil, passord);
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
		return Objects.equals(etternavn, other.etternavn) 
				&& Objects.equals(fornavn, other.fornavn)
				&& Objects.equals(mobil, other.mobil) 
				&& Objects.equals(passord, other.passord);
	}

	@Override
	public String toString() {
		return "Bruker [mobil=" + mobil + ", fornavn=" + fornavn 
				+ ", etternavn=" + etternavn + ", passord=" + passord + "]";
	}
	
}
