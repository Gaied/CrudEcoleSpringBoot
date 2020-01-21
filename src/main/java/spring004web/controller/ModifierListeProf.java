package spring004web.controller;

import java.util.LinkedList;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring004web.entity.Prof;
import spring004web.services.IServiceListeProf;

public class ModifierListeProf {
	
	@Autowired
	private IServiceListeProf service;

	@RequestMapping(value = "/afficherModificationListeProf", method = RequestMethod.GET)
	public String afficher(final ModelMap pModel) {
		if (pModel.get("modification") == null) {
			final List<Prof> lListeProfs = service.rechercherProfs();
			final ModificationForm lModificationForm = new ModificationForm();
			final List<ModificationProf> lListe = new LinkedList<ModificationProf>();
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			for (final Prof lProf : lListeProfs) {
				final ModificationProf lModificationProf = new ModificationProf();
				lModificationProf.setId(lProf.getId());
				lModificationProf.setNom(lProf.getNom());
				lModificationProf.setPrenom(lProf.getPrenom());
				lModificationProf.setAdresse(lProf.getAdresse());
				lModificationProf.setDate_naissance(lProf.getDate_naissance());
				lModificationProf.setSexe(lProf.getSexe());
				lListe.add(lModificationProf);
			}
			lModificationForm.setListeProfs(lListe);
			pModel.addAttribute("modification", lModificationForm);
		}
		return "modification";
	}
	
	@RequestMapping(value = "/modifierModificationListeProf", method = RequestMethod.POST)
	public String modifier(@Valid @ModelAttribute(value = "modification") final ModificationForm pModification,
			final BindingResult pBindingResult, final ModelMap pModel) {
		if (!pBindingResult.hasErrors()) {
			final List<Prof> lListeProfs = new LinkedList<Prof>();
			for (final ModificationProf lModificationProf : pModification.getListeProfs()) {
				final Prof lListe = new Prof();
				lListe.setId(lModificationProf.getId());
				lListe.setNom(lModificationProf.getNom());
				lListe.setPrenom(lModificationProf.getPrenom());
				lListe.setAdresse(lModificationProf.getAdresse());
				lListe.setDate_naissance(lModificationProf.getDate_naissance());
				lListe.setSexe(lModificationProf.getSexe());
				lListeProfs.add(lListe);
				
			}
			service.modifierProf(lListeProfs);
		}
		return afficher(pModel);
	}

}
