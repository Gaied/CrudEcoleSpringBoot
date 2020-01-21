package spring004web.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring004web.dao.IListeProfDAO;
import spring004web.entity.Prof;
import spring004web.entity.Sexe;

@Service
public class ServiceListeProf implements IServiceListeProf {

	@Autowired
	private IListeProfDAO dao;

	@Transactional(readOnly = true)
	public List<Prof> rechercherProfs() {
		// TODO Auto-generated method stub
		return dao.rechercheProfs();
	}

	@Transactional
	public void creerProf(String nom, String prenom, String adresse, Date datenaissance, Sexe sexe) {
		// TODO Auto-generated method stub
		final Prof lProf = new Prof();
		lProf.setNom(nom);
		lProf.setPrenom(prenom);
		lProf.setDate_naissance(datenaissance);
		lProf.setAdresse(adresse);
		lProf.setSexe(sexe);
		dao.creerProf(lProf);

	}

	@Transactional
	public void supprimerProf(Integer pIdProf) {
		// TODO Auto-generated method stub
		final Prof lProf = new Prof();
		lProf.setId(pIdProf);
		dao.supprimerProf(lProf);

	}

	@Transactional
	public void modifierProf(List<Prof> pListeProfs) {
		// TODO Auto-generated method stub
		for (final Prof lProf : pListeProfs) {
			dao.modifierProf(lProf);
		}

	}

}
