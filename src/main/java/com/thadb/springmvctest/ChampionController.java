	package com.thadb.springmvctest;

	import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.ServletContextAware;

import com.thadb.springmvctest.Services.ChampionService;
import com.thadb.springmvctest.Services.UserService;
import com.thadb.springmvctest.Services.ZipService;
import com.thadb.springmvctest.dao.Champion;
import com.thadb.springmvctest.dao.User;

	@Controller
	@SessionAttributes({"user","champList"})
	public class ChampionController implements ServletContextAware {
		
		//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

		@Autowired
		private ChampionService champService;
		@Autowired
		private ZipService zipService;
		@Autowired
		private UserService userService;

		private ServletContext servletContext;
		
		//generates a new user session if it is null.
		@ModelAttribute("user")
		public User populateUser() {
	        System.out.println(servletContext.getContextPath());
			return userService.getNewUser();
		}
		
		//adds an instance of the champion list to the model if it doesn't exist.
		@ModelAttribute("champList")
		public List<Champion> populateChampList() {
			return champService.getChampions(); 
		}

		@RequestMapping(value = "", method = RequestMethod.GET)
		public String getChampSelect(Model model) {
			return "champselect";
		}
		
		@RequestMapping(value = "", method = RequestMethod.POST)
		public String postChampSelect(Model model) {
			return "champselect";
		}
		
		@RequestMapping(value = "/{champName}/add", method = RequestMethod.GET)
		public String addChamp(@ModelAttribute("user") User user, Model model, @PathVariable String champName) {
				user.addChamp(champName);
			return "champselect";
		}
		
		@RequestMapping(value = "/{champName}/delete", method = RequestMethod.GET)
		public String deleteChamp(@ModelAttribute("user") User user, Model model, @PathVariable String champName) {
				user.deleteChamp(champName);
			return "champselect";
		}
		
		@RequestMapping(value = "/{champName}/selected-div", method = RequestMethod.GET)
		public String get(@ModelAttribute("user") User user, Model model, @PathVariable String champName) {
				if (user.isChampSelected(champName)){
					Champion c = user.getChamp(champName);
					model.addAttribute("champion", c);
					return "champ-div";
				}else{
					return "error";//TODO implement champ not found error handling
				}
		}
		
		@RequestMapping(value = "/{champName}/available-div", method = RequestMethod.GET)
		public String getAvailableDiv(@ModelAttribute("user") User user, Model model, @PathVariable String champName) {
				if (!user.isChampSelected(champName)){
					Champion c = user.getAvailableChamp(champName);
					model.addAttribute("champion", c);
					return "available-champ-div";
				}else{
					return "error";//TODO implement champ not found error handling
				}
		}
		
		@RequestMapping(value = "/{champName}/item", method = RequestMethod.GET)
		public String editChamp(@ModelAttribute("user") User user, Model model, @PathVariable String champName) {
			if (user.isChampSelected(champName)){
				Champion c = user.getChamp(champName);
				model.addAttribute("champion", c);
				return "champedit";
			}else{
				return "error";//TODO implement champ not found error handling
			}
			
		}
		
		@RequestMapping(value = "/{champName}/item/{itemName}/add", method = RequestMethod.GET)
		public String addItem(@ModelAttribute("user") User user, Model model, @PathVariable String champName, @PathVariable String itemName) {
			if (user.isChampSelected(champName)){
				Champion c = user.getChamp(champName);
				c.addItem(itemName);
				model.addAttribute("champion", c);
				return "champedit";
			}else{
				return "error";//TODO implement champ not found error handling
			}
		}
		
		@RequestMapping(value = "/{champName}/item/{itemName}/delete", method = RequestMethod.GET)
		public String deleteItem(@ModelAttribute("user") User user, Model model, @PathVariable String champName, @PathVariable String itemName) {
			if (user.isChampSelected(champName)){
				Champion c = user.getChamp(champName);
				c.deleteItem(itemName);
				model.addAttribute("champion", c);
				return "champedit";
			}else{
				return "error";//TODO implement champ not found error handling
			}
		}

		
		
		@RequestMapping(value = "/{champName}/add2", method = RequestMethod.GET, produces = "text/plain")
		@ResponseBody
		public String addChamp2(@ModelAttribute("user") User user, Model model, @PathVariable String champName) {
				user.addChamp(champName);
			return "1";
		}
		
		@RequestMapping(value = "/{champName}/delete2", method = RequestMethod.GET, produces = "text/plain")
		@ResponseBody
		public String deleteChamp2(@ModelAttribute("user") User user, Model model, @PathVariable String champName) {
				user.deleteChamp(champName);
			return "1";
		}
		
		@RequestMapping(value = "/{champName}/item2", method = RequestMethod.GET)
		public String editChamp2(@ModelAttribute("user") User user, Model model, @PathVariable String champName) {
			if (user.isChampSelected(champName)){
				Champion c = user.getChamp(champName);
				model.addAttribute("champion", c);
				return "champedit-div";
			}else{
				return "error";//TODO implement champ not found error handling
			}
			
		}
		
		@RequestMapping(value = "/{champName}/item/{itemName}/add2", method = RequestMethod.GET, produces = "text/plain")
		@ResponseBody
		public String addItem2(@ModelAttribute("user") User user, Model model, @PathVariable String champName, @PathVariable String itemName) {
			if (user.isChampSelected(champName)){
				Champion c = user.getChamp(champName);
				if (c.getSelectedItemCount() < 6){
				c.addItem(itemName);
				return "1";
				}else{
					return "2";
				}
			}else{
				return "3";//TODO implement champ not found error handling
			}
		}
		
		@RequestMapping(value = "/{champName}/item/{itemName}/delete2", method = RequestMethod.GET, produces = "text/plain")
		@ResponseBody
		public String deleteItem2(@ModelAttribute("user") User user, Model model, @PathVariable String champName, @PathVariable String itemName) {
			if (user.isChampSelected(champName)){
				Champion c = user.getChamp(champName);
				c.deleteItem(itemName);
				return "1";
			}else{
				return "error";//TODO implement champ not found error handling
			}
		}
		
		
		@RequestMapping(value = "/build", method = RequestMethod.GET, produces = "application/java-archive")
		@ResponseBody
		public FileSystemResource getFile(@ModelAttribute("user") User user) {
		    return new FileSystemResource(zipService.getFileFor(user)); 
		}
		
		
		public void setServletContext(ServletContext context) {
			this.servletContext = context;
		}
		
		@RequestMapping(value = "/test", method = RequestMethod.GET)
		public String runTest(Model model) {
			return "test";
		}

		

		
	}


