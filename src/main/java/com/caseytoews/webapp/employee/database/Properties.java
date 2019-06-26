package com.caseytoews.webapp.employee.database;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

public class Properties {
	private static Logger LOG = Logger.getLogger(Properties.class);

	public static String getString(ResourceBundle resourceBundle, String key) {
		try {
			if (System.getenv(key) != null) {
				return System.getenv(key);
			}
			return resourceBundle.getString(key);
		} catch (MissingResourceException e) {
			LOG.error(System.out.format("Unable to find key %s]", key));
			return '!' + key + '!';
		}
	}

	public static String getString(ResourceBundle resourceBundle, String key, Object... args) {
		try {
			if (System.getenv(key) != null) {
				return System.getenv(key);
			}
			String s = resourceBundle.getString(key);
			return MessageFormat.format(s, args);
		} catch (MissingResourceException e) {
			LOG.error(System.out.format("Unable to find key %s]", key));
			return '!' + key + '!';
		}
	}

}
