package br.com.cotiinformatica.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Compromisso;
import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.repositories.CompromissoRepository;

@Controller
public class CompromissoConsultaController {

	@RequestMapping(value = "/consultar-compromissos")
	public ModelAndView consulta(HttpServletRequest request) {

		// WEB-INF/views/agenda/consulta.jsp
		ModelAndView modelAndView = new ModelAndView("agenda/consulta");
		
		try {
			
			//capturando o usu�rio autenticado na sess�o
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario_autenticado");
			
			CompromissoRepository compromissoRepository = new CompromissoRepository();
			List<Compromisso> lista = compromissoRepository.obterTodos(usuario.getIdUsuario());
			
			modelAndView.addObject("compromissos", lista);			
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/pesquisar-compromissos", method = RequestMethod.POST)
	public ModelAndView pesquisarCompromissos(HttpServletRequest request) {
		
		// WEB-INF/views/agenda/consulta.jsp
		ModelAndView modelAndView = new ModelAndView("agenda/consulta");
		
		try {
			
			//capturar as datas enviadas pelo formul�rio
			Date dataMin = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dataMin"));
			Date dataMax = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dataMax"));
			
			//capturar o usu�rio autenticado no sistema
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario_autenticado");
			
			//consultar os compromissos no banco de dados
			CompromissoRepository compromissoRepository = new CompromissoRepository();
			List<Compromisso> lista = compromissoRepository.obterTodos(usuario.getIdUsuario(), dataMin, dataMax);
			
			modelAndView.addObject("compromissos", lista);
			modelAndView.addObject("dataMin", request.getParameter("dataMin"));
			modelAndView.addObject("dataMax", request.getParameter("dataMax"));
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}
		
		return modelAndView;
	}
}








