package spring004web.services;

import java.util.Date;
import java.util.List;

import spring004web.entity.Prof;
import spring004web.entity.Sexe;

public interface IServiceListeProf {
	
	List<Prof> rechercherProfs();
	void creerProf(String nom, String prenom, String adresse, Date datenaissance, Sexe sexe);
	void supprimerProf(final Integer pIdProf);
	void modifierProf(final List<Prof> pListeProfs);

}
