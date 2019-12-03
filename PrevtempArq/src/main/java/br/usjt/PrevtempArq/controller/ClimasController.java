package br.usjt.PrevtempArq.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.PrevtempArq.model.Clima;
import br.usjt.PrevtempArq.service.ClimasService;

import java.util.List;


@Controller
public class ClimasController {


    @Autowired
    private ClimasService climasService;
    
    

    @GetMapping("/tempo")
    public ModelAndView listarPeriodos() {
        ModelAndView mv = new ModelAndView("lista_tempo");
        mv.addObject(new Clima());
        List<Clima> climas = climasService.listarTodos();
        mv.addObject("climas", climas);
       return mv;
    }
   
      //Busca Cidade
    @PostMapping("/buscarCidade")
    public ModelAndView buscarCidade(String nome){
        ModelAndView mv = new ModelAndView("lista_tempo");
        mv.addObject(new Clima());
           List<Clima> climas = climasService.buscarCidade(nome);
        mv.addObject("climas", climas);
        return mv;
    }
      //Busca Latitude e longitude
    @PostMapping("/buscarLateLon")
    public ModelAndView buscarLateLon(Double lat, Double lon){
        ModelAndView mv = new ModelAndView("lista_tempo");
        mv.addObject(new Clima());
        List<Clima> climas = climasService.buscarLateLon(lat,lon);
        mv.addObject("climas", climas);
        return mv;
    }
    

    //Salvar Tempo
    @PostMapping("/salvartempo")
	public String salvar (Clima clim) {
		climasService.salvar(clim);
		return "redirect:/clima";
	}
    
    //BuscarTodos
    @PostMapping("/tempo")
    public ModelAndView Home() {
        ModelAndView mv = new ModelAndView("lista_tempo");
        mv.addObject(new Clima());
        List<Clima> climas = climasService.listarTodos();
        mv.addObject("climas", climas);
        return mv;
    }
   
}
