package com.metaformltd.ecosystem.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.metaformltd.ecosystem.model.KimlikModel;
import com.metaformltd.ecosystem.service.MyService;

@Controller
public class LoginRestController {
	
	@Autowired
	private MyService myService;
	
	@RequestMapping("/")
	public String listPerson(Model mod) throws IOException{
		List<KimlikModel> listPerson = myService.getAllPerson();
		mod.addAttribute("listPerson", listPerson);
		return "../pages/home";
	}
	@RequestMapping(value = "/newPerson", method = RequestMethod.GET)
	public String newContact(Model mod) {
		KimlikModel person = new KimlikModel();
		mod.addAttribute("person",person);
		return "../pages/PersonForm";
	}
	
	@RequestMapping(value = "/savePerson", method = RequestMethod.POST)
	public String savePerson(@ModelAttribute KimlikModel person) {
		if (person.getId() == 0) { 
			myService.addPerson(person);
		} else {
			myService.updatePerson(person);
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/deletePerson", method = RequestMethod.GET)
	public String deleteEmployee(@RequestParam(value="id",required = true) int id) {
		myService.deletePerson(id);
		return "redirect:/";
	}

	@RequestMapping(value = "/editPerson", method = RequestMethod.GET) 
	public String editContact(Model mod,@RequestParam(value="id",required = true) int id) {
		KimlikModel person=myService.getPerson(id);
		mod.addAttribute("person",person);

		return "../pages/PersonForm";
	}
}
