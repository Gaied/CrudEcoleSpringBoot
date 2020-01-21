package spring004web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring004web.entity.Prof;
import spring004web.services.IServiceListeProf;

@Controller
public class SupprimerListeProf {
	
	@Autowired
	private IServiceListeProf service;

	@RequestMapping(value = "/afficherSuppressionListeProf", method = RequestMethod.GET)
	public String afficher(final ModelMap pModel) {
		final List<Prof> lListeProfs = service.rechercherProfs();
		pModel.addAttribute("listeCourses", lListeProfs);
		return "suppression";
	}

	@RequestMapping(value = "/supprimerSuppressionListeProf", method = RequestMethod.GET)
	public String supprimer(@RequestParam(value = "idProf") final Integer pIdProf , final ModelMap pModel) {
		service.supprimerProf(pIdProf);
		;
		return afficher(pModel);
	}

}
