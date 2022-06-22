package br.com.cotiinformatica.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.repositories.UsuarioRepository;

@Controller
public class ConfiguracoesUsuarioController {

	@RequestMapping(value = "/configuracoes-usuario")
	public ModelAndView configuracoes() {
		
		//WEB-INF/views/agenda/configuracoes.jsp
		ModelAndView modelAndView = new ModelAndView("agenda/configuracoes");
		return modelAndView;
	}
	
	@RequestMapping(value = "/atualizar-senha", method = RequestMethod.POST)
	public ModelAndView atualizarSenha(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("agenda/configuracoes");
		
		try {			
			//resgatar os dados do formul�rio
			String novaSenha = request.getParameter("novaSenha");
			String novaSenhaConfirmacao = request.getParameter("novaSenhaConfirmacao");
			
			//comparando as senhas informadas
			if(novaSenha.equals(novaSenhaConfirmacao)) {
				
				//capturar o usu�rio autenticado na aplica��o
				Usuario usuario = (Usuario) request.getSession().getAttribute("usuario_autenticado");
				
				//atualizar a senha do usu�rio
				UsuarioRepository usuarioRepository = new UsuarioRepository();
				usuarioRepository.alterarSenha(usuario.getIdUsuario(), novaSenha);
				
				modelAndView.addObject("mensagem_sucesso", "Senha atualizada com sucesso!");
			}
			else {
				modelAndView.addObject("mensagem_erro", "Senhas n�o conferem, por favor tente novamente.");
			}
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}
		
		return modelAndView;
	}
	
}









