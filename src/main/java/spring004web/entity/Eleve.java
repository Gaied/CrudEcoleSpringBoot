package spring004web.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "t_eleve")
public class Eleve {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nom", length = 100, nullable = false)
	private String nom;
	@Column(name = "prenom", length = 100)
	private String prenom;
	@Column(name = "adresse", length = 250)
	private String adresse;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_naissance", nullable = false)
	private Date date_naissance;
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "enum('HOMME', 'FEMME')")
	private Sexe sexe;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "classe", nullable = false)
	private Classe classe;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Date getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}

	public Sexe getSexe() {
		return sexe;
	}

	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}

	@Override
	public String toString() {
		return "Eleve [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", date_naissance="
				+ date_naissance + ", sexe=" + sexe + "]";
	}

}
