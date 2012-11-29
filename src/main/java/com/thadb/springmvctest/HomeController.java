package com.thadb.springmvctest;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.thadb.springmvctest.enums.ChampionType;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/home")
@SessionAttributes({"fname","champList"})
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! the client locale is "+ locale.toString());
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		return "home";
	}
	
//	@RequestMapping(value = "/")
//	public String homeDefault(Model model) {
//		logger.info("Welcome home!");
//		model.addAttribute("fname", "NODATA");
//		return "home";
//	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home2(Model model, @RequestParam String fname) {
		model.addAttribute("fname", fname);
		return "home";
	}
	
	@RequestMapping(value = "/tefdfdst", method = RequestMethod.GET)
	public String testPersistence(@ModelAttribute("fname") String fname, Model model) { 
		return "persistence";
	}
	
	@RequestMapping(value = "/dropdown", method = RequestMethod.GET)
	public String dropDownTest(Model model) {
		List<ChampionType> champList = new ArrayList<ChampionType>( Arrays.asList(ChampionType.values() ));
		model.addAttribute("champList", champList);		
		model.addAttribute("champName", "NODATA");
		return "dropdownpopulate";
	}
	
	@RequestMapping(value = "/dropdown/persistence", method = RequestMethod.GET)
	public String dropDownPersistence(@ModelAttribute("champList") List<ChampionType> champList, Model model) {
		//List<Champion> champList = new ArrayList<Champion>( Arrays.asList(Champion.values() ));
		//model.addAttribute("champList", champList);		
		//model.addAttribute("champName", "NODATA");
		return "dropdownpersistence";
	}
	
	@RequestMapping(value = "/dropdown", method = RequestMethod.POST)
	public String dropDownTest(Model model, @RequestParam String option) {
		logger.info("test");
		List<ChampionType> champList = new ArrayList<ChampionType>( Arrays.asList(ChampionType.values() ));
		model.addAttribute("champList", champList);		
		model.addAttribute("champName", option);
		return "dropdownpopulate";
	}
	
}
