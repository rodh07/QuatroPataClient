package br.univel.EJBClient;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.univel.dao.bichoDao;

public class RemoteEJBClient {

	public static bichoDao lookupRemoteStatelessCalculator() throws NamingException {

		final Hashtable<String, String> jndiProperties = new Hashtable<>();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		final Context ctx = new InitialContext(jndiProperties);

		return (bichoDao) ctx.lookup("ejb:/QuatroPata/bichoImpl!" + 
		bichoDao.class.getName());
	}
}
