package br.com.cotiinformatica.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	// m�todo para mapear a rota que ir� abrir a p�gina
	@RequestMapping(value = "/home")
	public ModelAndView home(HttpServletRequest request) {

		// definir qual p�gina jsp ser� aberta na rota /home
		// WEB-INF/views/agenda/home.jsp
		ModelAndView modelAndView = new ModelAndView("agenda/home");

		//verificar se n�o h� um usu�rio autenticado em sess�o
		if(request.getSession().getAttribute("usuario_autenticado") == null) {
			//redirecionar de volta para a p�gina inicial do sistema
			modelAndView.setViewName("redirect:/");
		}
		
		// abrindo a p�gina
		return modelAndView;
	}
	
	//m�todo para mapear a rota de logout do sistema
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest request) {
		
		//apagar os dados gravados na sess�o
		request.getSession().removeAttribute("usuario_autenticado");
		
		//redirecionar de volta para a p�gina de login
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/");
		
		return modelAndView;
	}	
}







