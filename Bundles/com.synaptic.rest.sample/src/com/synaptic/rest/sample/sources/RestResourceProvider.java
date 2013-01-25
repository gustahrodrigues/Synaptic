package com.synaptic.rest.sample.sources;

import org.eclipselabs.restlet.ResourceProvider;
import org.restlet.Context;
import org.restlet.resource.Finder;

public class RestResourceProvider extends ResourceProvider {

	@Override
	protected Finder createFinder(Context context) {
		return new Finder(context, Resource.class);
	}

}
