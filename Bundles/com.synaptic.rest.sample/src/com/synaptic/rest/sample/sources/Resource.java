package com.synaptic.rest.sample.sources;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class Resource extends ServerResource {

	static final String MESSAGE = "Hello Rest Sample";
	
	@Get("txt")
	public String sayHello()
	{
		return MESSAGE;
	}

	@Get("html")
	public String getDocument()
	{
		StringBuilder html = new StringBuilder();
		html.append("<html>\n");
		html.append("  <body>\n");
		html.append("    <h2>Hello Rest Sample</h2>\n");
		html.append("   </body>\n");
		html.append("</html>\n");
		return html.toString();
	}
}
