package spring004web.dao;

import java.util.List;

import spring004web.entity.Prof;

public interface IListeProfDAO {
	
	List<Prof> rechercheProfs();
	void creerProf(final Prof pProf);
	void supprimerProf(final Prof pProf);
	void modifierProf(final Prof pProf);
	
}
