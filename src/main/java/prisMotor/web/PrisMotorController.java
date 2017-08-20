package prisMotor.web;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import prisMotor.Bestilling;
import prisMotor.PrisMotor;

@Controller
public class PrisMotorController {

	// Henter og viser liste over 1-50 enheter.
	@RequestMapping(value={"/"}, method = RequestMethod.GET)
	public ModelAndView produktListe(){    
		System.out.println("PrisMotorController");

		PrisMotor po = new PrisMotor();

		List<String> pingvinListe = po.prisMotor("Pingvinører");
		List<String> hesteListe = po.prisMotor("Hestesko");

		ModelAndView map = new ModelAndView("prisMotor");
		map.addObject("pingvinListe", pingvinListe);
		map.addObject("hesteListe", hesteListe);

		return map;
	}

	// Setter opp kalkulatorskjemaet.
	@RequestMapping(value = "/kalkulator", method = RequestMethod.GET)
	public ModelAndView showForm() {
		ModelAndView model = new ModelAndView("prisKalkulator", "bestilling", new Bestilling());

		populateDefaultModel(model);

		return model;
	}

	// Regner ut og viser prisen på input.
	@RequestMapping(value = "/kalkulator", method = RequestMethod.POST)
	public String submit(@Valid @ModelAttribute("bestilling")Bestilling bestilling, BindingResult bindingResult, ModelMap model) {


		// Kontrollerer at antall enheter er positivt tall.
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult.toString());
			return "redirect:/kalkulator";
		}

		// Må fylle inn listen med produktvalg for å kunne gjøre ny utregning fortløpende.
		String bestillingsProdukt1;
		String bestillingsProdukt2;

		if(bestilling.produktNavn == "Pingvinører"){
			bestillingsProdukt1 = "Pingvinører";
			bestillingsProdukt2 = "Hestesko";
		}else {
			bestillingsProdukt1 = "Hestesko";
			bestillingsProdukt2 = "Pingvinører";
		}

		Map<String, String> produktValg2 = new LinkedHashMap<String, String>();
		produktValg2.put(bestillingsProdukt1, bestillingsProdukt1);
		produktValg2.put(bestillingsProdukt2, bestillingsProdukt2);


		model.addAttribute("produktValg",produktValg2);
		model.addAttribute("antEnh", bestilling.antEnh);
		model.addAttribute("antKart", bestilling.antKart);

		model.addAttribute("pris", bestilling.kalkulator(bestilling.produktNavn, bestilling.antEnh , bestilling.antKart));

		return "prisKalkulator";
	}

	// Funksjon for å fylle drop-down liste.
	private void populateDefaultModel(ModelAndView model) {
		Map<String, String> produktValg = new LinkedHashMap<String, String>();
		produktValg.put("Pingvinører", "Pingvinører");
		produktValg.put("Hestesko", "Hestesko");
		model.addObject("produktValg", produktValg);

	}

}
