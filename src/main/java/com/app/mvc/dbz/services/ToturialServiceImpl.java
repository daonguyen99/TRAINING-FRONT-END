package com.app.mvc.dbz.services;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.app.mvc.dbz.entities.Tutorial;
import com.app.mvc.dbz.repository.ToturialRepository;

@Service
public class ToturialServiceImpl implements TutorialService {
	@Autowired
	ToturialRepository tutorialRepository;

	@Override
	public Tutorial createTutorial(String title, String description,String count) {
		Tutorial tutorial = new Tutorial();
		tutorial.setTitle(title);
		tutorial.setDescription(description);
		
		int countVar = Integer.parseInt(count);
		tutorial.setCount(countVar);
		
		Date date = new Date();
		Timestamp createDate = new Timestamp(date.getTime());
		tutorial.setCreate_date(createDate);
		tutorialRepository.save(tutorial);
		return tutorial;
	}

	@Override
	public List<Tutorial> getAllTutorial() {
		List<Tutorial> tutorialList = null;
		tutorialList = tutorialRepository.findAll();
		return tutorialList;
	}

	@Override
	public void delectTutorial(int id) {
//		Tutorial tutorial = tutorialRepository.findById(id).get();
		tutorialRepository.deleteById(id);
//		return tutorial;
	}

	@Override
	public Tutorial getTutorialById(int id) {
		
		return tutorialRepository.findById(id).get();
	}

	@Override
	public Tutorial updateTutorialById(Tutorial tutorial) {
		
		return tutorialRepository.save(tutorial);
	}

	@Override
	public List<Tutorial> searchTutorial(String searchKey) {
		List<Tutorial> tutorials = new ArrayList<Tutorial>();
		
		if (searchKey == null || searchKey.length() ==0) {
			tutorials = tutorialRepository.findAll();
		}else {
			tutorials = tutorialRepository.findByTitle(searchKey);
		}
		
		return tutorials;
	}

	
	
}
