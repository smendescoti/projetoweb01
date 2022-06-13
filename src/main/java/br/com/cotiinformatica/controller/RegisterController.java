package br.com.cotiinformatica.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.repositories.UsuarioRepository;

@Controller
public class RegisterController {

	//Método para abrir a página (ROTA)
	@RequestMapping(value = "/register-user")
	public ModelAndView register() {

		// WEB-INF/views/register.jsp
		ModelAndView modelAndView = new ModelAndView("register");
		return modelAndView;
	}
	
	//Método para receber a requisição do formulário
	//POST -> /cadastrar-usuario
	@RequestMapping(value = "/cadastrar-usuario", method = RequestMethod.POST)
	public ModelAndView cadastrarUsuario(HttpServletRequest request) {

		// WEB-INF/views/register.jsp
		ModelAndView modelAndView = new ModelAndView("register");
		
		try {
			
			//capturar todos os campos enviados pelo formulário
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			String senhaConfirmacao = request.getParameter("senhaConfirmacao");
			
			//verificar se as senhas foram digitadas diferentes
			if( ! senha.equals(senhaConfirmacao)) {
				throw new Exception("Senhas não conferem, por favor verifique.");
			}
			
			UsuarioRepository usuarioRepository = new UsuarioRepository();
			//verificar se já existe um usuário cadastrado no banco de dados com o email informado
			if(usuarioRepository.obterPorEmail(email) != null) {
				throw new Exception("O email " + email + " informado já está cadastrado, por favor tente outro.");
			}
			
			//criando um objeto da classe de entidade Usuario
			Usuario usuario = new Usuario();
			usuario.setNome(nome);
			usuario.setEmail(email);
			usuario.setSenha(senha);
			
			//gravar o usuário no banco de dados			
			usuarioRepository.inserir(usuario);
			
			//gerando mensagem de sucesso
			modelAndView.addObject("mensagem_sucesso", "Parabéns " + usuario.getNome() + ", sua conta foi criada com sucesso.");
		}
		catch(Exception e) {
			//gerando mensagem de erro
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}		
		
		return modelAndView;
	}

}
