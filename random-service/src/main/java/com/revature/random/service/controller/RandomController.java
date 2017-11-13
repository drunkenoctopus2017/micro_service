package com.revature.random.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomController {
	
	@GetMapping("/getRandom")
	//@Transactional
	public String getRandom() {
		int i = (int) Math.floor(10 * Math.random());
		StringBuilder sb = new StringBuilder();
		switch (i) {
			case 0: sb.append("You're a zero."); break;
			case 1: sb.append("You're number one."); break;
			case 2: sb.append("You too much."); break;
			case 3: sb.append("Three's company."); break;
			case 4: sb.append("For whom the bell tolls..."); break;
			default: sb.append("Bravely default: " + i);
		}
		return sb.toString();
	}

}
