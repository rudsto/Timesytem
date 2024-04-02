package no.hvl.dat109.prosjekt.entity;

import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "bruker", schema = "dat109_prosjekt")
public class Bruker {
	
	@Id
	@Column(name = "mobil", length = 8)
	@Size(min = 8, max = 8, message = "Mobilnummer må være 8 siffer")
	@NotNull(message = "Mobilnummer er obligatorisk")
	@Pattern(regexp = "[0-9]{8}", message = "Mobilnummer må være 8 siffer")
	private String mobil;
	
	@Column(name = "hash", length = 64)
	private String hash;
	
	@Column(name = "salt", length = 32)
	private String salt;
	
	@Column(name = "fornavn", length = 40)
	@Size(min = 2, max = 20, message = "Fornavn må være mellom 2 og 20 tegn")
	@NotNull(message = "Fornavn er obligatorisk")
	@Pattern(regexp = "[\\p{L} -]+", message = "Fornavn kan bare inneholde bokstaver, bindestrek og mellomrom")
	private String fornavn;
	
	@Column(name = "etternavn", length = 40)
	@Size(min = 2, max = 20, message = "Etternavn må være mellom 2 og 20 tegn")
	@NotNull(message = "Etternavn er obligatorisk")
	@Pattern(regexp = "[\\p{L}-]+", message = "Etternavn kan bare inneholde bokstaver og bindestrek")
	private String etternavn;
	
	@OneToMany(mappedBy = "bruker")
	private List<Time> timeliste;

	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
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

}
