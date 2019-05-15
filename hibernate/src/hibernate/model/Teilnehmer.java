package hibernate.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "teilnehmer")
public class Teilnehmer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTeilnehmer;
	@Column(name = "vorname")
	private String vorname;
	@Column(name = "name")
	private String name;
	@Column(name = "abteilung")
	private String abteilung;
	@Column(name = "email")
	private String email;
	@Column(name = "telefon")
	private String telefon;
	@Column(name = "mobil")
	private String mobil;
	
	
	public Teilnehmer() {
		// TODO Auto-generated constructor stub
	}

	

	public Teilnehmer( String vorname, String name, String abteilung, String email, String telefon,
			String mobil) {
		super();
		this.vorname = vorname;
		this.name = name;
		this.abteilung = abteilung;
		this.email = email;
		this.telefon = telefon;
		this.mobil = mobil;
	}



	public int getIdTeilnehmer() {
		return idTeilnehmer;
	}


	public String getVorname() {
		return vorname;
	}


	public String getName() {
		return name;
	}


	public String getAbteilung() {
		return abteilung;
	}


	public String getEmail() {
		return email;
	}


	public String getTelefon() {
		return telefon;
	}


	public String getMobil() {
		return mobil;
	}
	
	
}
