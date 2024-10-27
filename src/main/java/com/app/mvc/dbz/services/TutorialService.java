package com.app.mvc.dbz.services;

import java.util.List;

import com.app.mvc.dbz.entities.Tutorial;

public interface TutorialService {
	Tutorial createTutorial(String title, String description,String count);
	List<Tutorial> getAllTutorial();
	void delectTutorial(int id);
	Tutorial getTutorialById(int id);
	Tutorial updateTutorialById(Tutorial tutorial);
	List<Tutorial> searchTutorial(String searchKey);
}