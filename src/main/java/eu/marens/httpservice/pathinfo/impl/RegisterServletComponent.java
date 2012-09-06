package eu.marens.httpservice.pathinfo.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.http.HttpService;
import org.osgi.service.http.NamespaceException;

public class RegisterServletComponent {

	public void setHttp(HttpService http) throws ServletException,
			NamespaceException {
		http.registerServlet("/pathElementServlet", new PathElementServlet(),
				null, null);
	}
}

class PathElementServlet extends HttpServlet {

	public void doGet(HttpServletRequest rq, HttpServletResponse rsp)
			throws IOException {
		rsp.getWriter()
				.append(String.format(
						"ServletPath: %s PathInfo: %s RequestURI: %s",
						rq.getServletPath(), rq.getPathInfo(),
						rq.getRequestURI())).flush();
	}
}
