package com.khata.springboot.khataapp.khata;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.servlet.http.HttpServletResponse;

//import com.shibhudhala.springboot.myfirstwebapp.todo.Todo;

@Controller
//@SessionAttributes("name") // eg. diff user will see his name on page when he will login. we have to write this to all the controller for which we need to show.
public class KhataControllerJpa {

	private KhataService khataService;
	private KhataRepository khataRepository;
	private static int idCount = 0;

//	public KhataControllerJpa() {
//		this.khataService = khataService;
//	}
	public KhataControllerJpa(KhataService khataService, KhataRepository khataRepository) {
		super();
		this.khataService = khataService;
		this.khataRepository = khataRepository;
	}

	@RequestMapping(value = "khataapi", method = RequestMethod.GET)
	public String listKhata(ModelMap model) {
		String nm = "Demo name";
//		List<Khata> khata = khataRepository.findByName(nm);
		List<Khata> khata = khataRepository.findAll();
		System.out.println(khata);
//		List<Khata> khata = khataService.findByUsername();
//		model.addAttribute("khatas", khata);
		model.addAttribute("khatas", khata);

//		model.addAttribute("ids", khata.get(0));
		return "listkhata";
	}

	@RequestMapping(value = "add-khata", method = RequestMethod.GET)
	public String addKhata(ModelMap model) {
//		List<Khata> khata = khataService.addUser();
//		model.addAttribute("khatas", khata);
		return "addKhata";
	}

	@RequestMapping(value = "add-khata", method = RequestMethod.POST)
	public String addNewKhata(ModelMap model, Khata khata, BindingResult result, @RequestParam String name,
			HttpServletResponse response) {
//		String username = getLoggedInUsername(model);
//		if(result.hasErrors())
//			return "addTodoJsp";
//		khata.setName("Shibhudhala4");
//		khataService.addUser(name);
		int count = (int) khataRepository.count();
		System.out.println("Print for add api count :" + (int) khataRepository.count());
		Khata kh = new Khata();
		kh.setName(name);
		khataRepository.save(kh);

//		todoService.addTodo(username,todo.getDescription(), todo.getTargetDate(), false);
		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		return "redirect:khataapi";

	}

	@RequestMapping(value = "del-khata")
	public String deleteKhata(ModelMap model, @Validated Khata khata, @RequestParam long id) {
//		String username = getLoggedInUsername(model);
		khataRepository.deleteById(id);
//		todoService.addTodo(username,todo.getDescription(), todo.getTargetDate(), false);
		System.out.println("Print for delete api count :" + (int) khataRepository.count());

		return "redirect:khataapi";

	}

	@RequestMapping(value = "update-khata", method = RequestMethod.GET)
	public String updateKhataGet(ModelMap model, @RequestParam long id) {
//		List<Khata> khata = khataService.addUser();
//		model.addAttribute("khatas", khata);
//		model.put("name", name);
//		return "updateKhata";
		String name1 = khataRepository.findById(id).get().getName();
//		System.out.println(khata.getName());
		model.put("khata", name1);
		return "updateKhata";
	}

	@RequestMapping(value = "update-khata", method = RequestMethod.POST)
	public String updateKhataPost(ModelMap model, @RequestParam long id, @RequestParam String name, Khata khata) {
//		List<Khata> khata = khataService.addUser();
//		model.addAttribute("khatas", khata);
		khataRepository.save(khata);
		return "redirect:khataapi";
	}

}
