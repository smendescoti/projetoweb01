package br.com.cotiinformatica.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.repositories.UsuarioRepository;

@Controller
public class LoginController {

	// m�todo para mapear a rota da p�gina de login (raiz do projeto)
	@RequestMapping(value = "/")
	public ModelAndView login() {

		// WEB-INF/views/login.jsp
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}

	// m�todo para capturar o SUBMIT POST do formul�rio
	@RequestMapping(value = "/autenticar-usuario", method = RequestMethod.POST)
	public ModelAndView autenticarUsuario(HttpServletRequest request) {

		// WEB-INF/views/login.jsp
		ModelAndView modelAndView = new ModelAndView("login");
		
		try {			
			//capturar os campos enviados pelo formul�rio
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			//consultar no banco de dados o usu�rio atraves do email da senha
			UsuarioRepository usuarioRepository = new UsuarioRepository();
			Usuario usuario = usuarioRepository.obterPorEmailESenha(email, senha);
			
			//verificando se o usu�rio foi encontrado
			if(usuario != null) {

				//armazenar os dados do usu�rio em uma sess�o
				request.getSession().setAttribute("usuario_autenticado", usuario);
				
				//redirecionar para a p�gina home do sistema
				modelAndView.setViewName("redirect:home");
			}
			else {
				throw new Exception("Acesso negado, email e senha inv�lidos.");
			}
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}
		
		return modelAndView;
	}

}















