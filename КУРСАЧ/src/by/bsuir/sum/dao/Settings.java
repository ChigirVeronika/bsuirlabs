
package by.bsuir.sum.dao;

import java.io.*;
import java.util.Properties;

/**
 * Singleton.
 *
 *
 */
public final class Settings {

	private final static File SETTINGS_FILE = new File("settings.properties");
	private final Properties props;
	
	private Settings() {
		props = new Properties();
		
		if (!SETTINGS_FILE.exists()) {
			try {
				SETTINGS_FILE.createNewFile();
			} catch (IOException ex) {
				throw new RuntimeException(
					"Could not create file '" + filename() + "'."
				);
			}
		}

		try (final InputStream is = new FileInputStream(SETTINGS_FILE)) {
			props.load(is);
		} catch (Exception e) {
			throw new RuntimeException(
				"Could not find file '" + filename() + "'."
			);
		}
	}
	
	public boolean has(String key) {
		return props.containsKey(key);
	}
	
	public <T> void set(String key, T value) {
		props.setProperty(key, value.toString());
		storeChanges();
	}
	
	public String get(String key) {
		return props.getProperty(key);
	}
	
	public String get(String key, String defaultValue) {
		return props.getProperty(key, defaultValue);
	}
	
	public Boolean get(String key, Boolean defaultValue) {
		return Boolean.parseBoolean(props.getProperty(key, Boolean.toString(defaultValue)));
	}
	
	public Integer get(String key, Integer defaultValue) {
		return Integer.parseInt(props.getProperty(key, Integer.toString(defaultValue)));
	}
	
	private void storeChanges() {
		try (final OutputStream out = new FileOutputStream(SETTINGS_FILE, false)) {
			props.store(out, "Social Photo Network Settings");
		} catch (IOException ex) {
			throw new RuntimeException(
				"Could not save file '" + filename() + "'."
			);
		}
	}
	
	private static String filename() {
		return SETTINGS_FILE.getAbsolutePath();
	}
	
	private static class Holder {
		private final static Settings INSTANCE = new Settings();
	}
	
	public static Settings inst() {
		return Holder.INSTANCE;
	}
}