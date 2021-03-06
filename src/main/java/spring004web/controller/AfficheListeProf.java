package spring004web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring004web.entity.Prof;
import spring004web.services.IServiceListeProf;

@Controller
@RequestMapping(value = "/listprofs")
public class AfficheListeProf {
	
	@Autowired
	private IServiceListeProf service;
	
	@RequestMapping(method = RequestMethod.GET)
	public String afficher(ModelMap pModel) {
		final List<Prof> lListProfs = service.rechercherProfs();
		pModel.addAttribute("listProfs", lListProfs);
		return "listProfs";
	}


}
