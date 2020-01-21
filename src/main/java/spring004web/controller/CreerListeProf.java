package spring004web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring004web.entity.Prof;
import spring004web.services.IServiceListeProf;

@Controller
public class CreerListeProf {
	
	@Autowired
	private IServiceListeProf service;
	
	@RequestMapping(value="/afficherCreationListeProf", method = RequestMethod.GET)
	public String afficher(final ModelMap pModel) {
		final List<Prof> lListeProfs = service.rechercherProfs();
		pModel.addAttribute("listeprofs", lListeProfs);
		if (pModel.get("creation") == null) {
			pModel.addAttribute("creation", new CreationForm());
		}
		return "creation";
	}
	
	@RequestMapping(value="/creerCreationListeProfs", method = RequestMethod.POST)
	public String creer(@Valid @ModelAttribute(value = "creation") final CreationForm pCreation,
			final BindingResult pBindingResult, final ModelMap pModel) {
		if (!pBindingResult.hasErrors()) {
			
			service.creerProf(pCreation.getNom(), pCreation.getPrenom(), pCreation.getAdresse(),
					pCreation.getDatenaissance(),pCreation.getSexe());
		}
		return afficher(pModel);
	}

}
