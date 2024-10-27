package com.app.mvc.dbz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.mvc.dbz.entities.Tutorial;
import com.app.mvc.dbz.services.TutorialService;

@Controller
public class ToturialController {
	@Autowired
	TutorialService tutorialService;

	@GetMapping("/tutorial")
	public String getTutorial(Model model) {
		List<Tutorial> tutorials = tutorialService.getAllTutorial();
		model.addAttribute("tutorialList", tutorials);
		return "tutorial/index";
	}

	@PostMapping("/create")
	public String createTutorial(@RequestParam("title") String title, @RequestParam("description") String description,
			@RequestParam("count") String count) {
		tutorialService.createTutorial(title, description,count);
		return "index";

	}

	@GetMapping("/tutorial/{id}")
	public String deleteTutorial(@PathVariable int id) {
		String result = "redirect:/tutorial";
		tutorialService.delectTutorial(id);
		return result;
	}

	@GetMapping("/editTutorial/{id}")
	public String editTutorial(@PathVariable("id") int id, Model model) {
		String result = "tutorial/update-tutorial";
		Tutorial tutorial = tutorialService.getTutorialById(id);
		model.addAttribute("tutorial", tutorial);
		return result;
	}

	@PostMapping("/updateTutotrial")
	public String updateTutotrial(Tutorial tutotrial) {
		String result = "redirect:/tutorial";
		tutorialService.updateTutorialById(tutotrial);
		return result;

	}

	@GetMapping("/searchTutorial")
	public String searchTutorial(@RequestParam("searchKey") String searchKey, Model model) {
		List<Tutorial> tutorials = tutorialService.searchTutorial(searchKey);
		model.addAttribute("tutorialList", tutorials);
		model.addAttribute("keySearch", searchKey);
		return "tutorial/index";
	}

}
