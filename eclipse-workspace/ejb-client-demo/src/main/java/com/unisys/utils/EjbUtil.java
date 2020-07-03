package com.unisys.utils;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public final class EjbUtil {

	private EjbUtil() {
	}

	public static Object getEjbProxy(String jndiName) {
		try {
			Properties props = new Properties();
			props.setProperty(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

			// reference to the JNDI service maintained by the remote wildfly server
			Context ctx = new InitialContext(props);

			return ctx.lookup(jndiName);
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}

	}
}
