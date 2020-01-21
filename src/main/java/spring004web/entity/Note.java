package spring004web.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="t-notes")
public class Note {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idnotes;
	@Column(name = "note", length = 11, nullable = false)
	private Integer note;
	@Column(name = "avencement",nullable = false)
	private float avencement;
	@Column(name = "avis", length = 100, nullable = false)
	private String avis;
	@Temporal(TemporalType.DATE)
	@Column(name = "date_saisie", nullable = false)
	private Date date_saisie;
	
	@ManyToOne
	@JoinColumn(name = "id_prof", nullable = false)
	private Prof prof;

}
