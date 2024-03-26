package no.hvl.dat109.prosjekt.bruker;

import java.util.Objects;

public class Passord {

	private String hash;
	private String salt;
	
	public Passord() {
		
	}
	
	public Passord(String hash, String salt) {
		this.hash = hash;
		this.salt = salt;
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

	@Override
	public int hashCode() {
		return Objects.hash(hash, salt);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passord other = (Passord) obj;
		return Objects.equals(hash, other.hash) && Objects.equals(salt, other.salt);
	}

	@Override
	public String toString() {
		return "Passord [hash=" + hash + ", salt=" + salt + "]";
	}
	
}
