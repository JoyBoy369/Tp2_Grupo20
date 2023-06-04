package ar.edu.unju.fi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaConsejo;
import ar.edu.unju.fi.model.Consejo;
import jakarta.validation.Valid;
@Controller
@RequestMapping("/consejos")
public class ConsejoController {
	@Autowired
	ListaConsejo listaConsejos;
	@Autowired
	private Consejo consejo;
	
	@GetMapping("/listado")
	public String getConsejosPage(Model model) {
		model.addAttribute("consejos", listaConsejos.getConsejoList());
		return "consejos";
	}
	@GetMapping("/Nuevo_Consejo")
	public String getNuevoConsejo(Model model){
		boolean editar = false;
		model.addAttribute("consejo", consejo);
		model.addAttribute("editar", editar);
		return "Nuevo_Consejo";
	}
	@PostMapping("/Guardar_Consejo")
	public ModelAndView getGuardarConsejo(@Valid @ModelAttribute("consejo")Consejo consejo, BindingResult resultado){
		ModelAndView modelView = new ModelAndView("consejos");
		if(resultado.hasErrors()) {
			modelView.setViewName("Nuevo_Consejo");
			modelView.addObject("consejo", consejo);
			return modelView;
		}
		listaConsejos.getConsejoList().add(consejo);
		modelView.addObject("consejos", listaConsejos.getConsejoList());
		return modelView;
	}
	@GetMapping("/editar/{consejo}")
	public String getEditarConsejo(Model model,@PathVariable(value = "consejo")String consejo) {
		Consejo posicionConsejo = new Consejo();
		boolean editar = true;
		for(Consejo consej:listaConsejos.getConsejoList()){
			if(consej.getTitulo().equals(consejo)){
				posicionConsejo = consej;
				break;
			}
		}
		model.addAttribute("consejo", posicionConsejo);
		model.addAttribute("editar", editar);
		return "Nuevo_Consejo";
	}
	@PostMapping("/editar")
	public String editarConsejo(@Valid @ModelAttribute("consejo")Consejo consejo, BindingResult resultado, Model model){
		if(resultado.hasErrors()){
			boolean editar = true;
			model.addAttribute("editar", editar);
			return "Nuevo_Consejo";
		}
		for(Consejo consej: listaConsejos.getConsejoList()){
			if(consej.getTitulo().equals(consejo.getTitulo())) {
				consej.setTitulo(consejo.getTitulo());
				consej.setConsejo(consejo.getConsejo());
				break;
			}
			}
		return "redirect:/consejos/listado";
	}
	@GetMapping("/eliminar/{titulo}")
	public String eliminarConsejo(@PathVariable(value = "titulo")String titulo){
		for(Consejo consej:listaConsejos.getConsejoList()){
			if(consej.getTitulo().equals(titulo)) {
				listaConsejos.getConsejoList().remove(consej);
				break;
			}
		}
		return "redirect:/consejos/listado";
	}
}
