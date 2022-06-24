package br.com.cotiinformatica.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
public class AuthenticationFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public AuthenticationFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		//mapear as URLs (ROTAS) do sistema que n�o v�o exigir autentica��o.
		List<String> rotasPermitidas = new ArrayList<String>();
		rotasPermitidas.add("/"); //raiz do sistema
		rotasPermitidas.add("/autenticar-usuario");
		rotasPermitidas.add("/register-user");
		rotasPermitidas.add("/cadastrar-usuario");
		rotasPermitidas.add("/password-recover");
		rotasPermitidas.add("/recuperar-senha");
		
		//fazer com que o FILTER verifique se o usu�rio n�o est� nas rotas acima
		if(!rotasPermitidas.contains(req.getServletPath())) {
			//verificar se o usu�rio n�o est� autenticado
			if(req.getSession().getAttribute("usuario_autenticado") == null) {
				//redirecionar o usu�rio de volta para a p�gina inicial
				resp.sendRedirect("/projetoweb01/");
			}
		}
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
