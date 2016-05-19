package ua.shop.util;

import java.util.ResourceBundle;


/**
 * Provides configs for general settings
 *
 * @author Oleg Dashkevych.
 */
public final class ConfigManager {

	private final ResourceBundle CONFIGS = ResourceBundle.getBundle("config");

	public ConfigManager() {
	}

	/**
	 * @return string value by key
	 */
	public String getConfigString(String key) {
		return CONFIGS.getString(key);
	}

	/**
	 * @return integer value by key
	 */
	public Integer getConfigInteger(String key) {
		return Integer.valueOf(CONFIGS.getString(key));
	}
}
