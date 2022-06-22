package br.com.cotiinformatica.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.messages.EmailMessage;
import br.com.cotiinformatica.repositories.UsuarioRepository;

@Controller
public class PasswordController {

	@RequestMapping(value = "/password-recover")
	public ModelAndView password() {
	
		//WEB-INF/views/password.jsp
		ModelAndView modelAndView = new ModelAndView("password");
		return modelAndView;
	}
	
	@RequestMapping(value = "/recuperar-senha", method = RequestMethod.POST)
	public ModelAndView recuperarSenha(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("password");
	
		try {
			
			String email = request.getParameter("email");
			
			UsuarioRepository usuarioRepository = new UsuarioRepository();
			//procurar o usu�rio no banco de dados atrav�s do email
			Usuario usuario = usuarioRepository.obterPorEmail(email);
			
			//verificar se o usu�rio foi encontrado
			if(usuario != null) {
				
				//gerando uma nova senha para o usu�rio
				String novaSenha = String.valueOf(new Random().nextInt(999999999));
				
				//enviando a nova senha para o email do usu�rio
				EmailMessage.sendMessage(usuario.getEmail(), "Recupera��o de Senha - AgendaWeb", 
						"Ol�, " + usuario.getNome() + 
						"\n\nSua senha foi redefinida com sucesso para que voc� possa acessar a agenda." + 
						"\nUtilize a senha: " + novaSenha + 
						"\n\nVoc� pode atualizar a senha futuramente atrav�s do menu Configura��es do Usu�rio." +
						"\n\nAtt\nEquipe AgendaWeb.");
				
				//atualizando a senha no banco de dados
				usuarioRepository.alterarSenha(usuario.getIdUsuario(), novaSenha);
				
				modelAndView.addObject("mensagem_sucesso", "Recupera��o de senha realizada com sucesso, por favor verifique seu email.");
			}
			else {
				modelAndView.addObject("mensagem_erro", "Email inv�lido. Usu�rio n�o encontrado.");
			}
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}
		
		return modelAndView;
	}	
}
