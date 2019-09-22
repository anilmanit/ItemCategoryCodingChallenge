package demo.infra;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import demo.constants.ItemCategoryConstants;

/**
 * This class holds the logic to load a resource which have necessary config
 * properties during run time. This is a singleton class which loads only once
 * during the application life-cycle.
 * 
 * @author AnilT
 */
public class ResourceLoader {
	private static Properties properties = new Properties();
	/**
	 * This attribute represents the component name.
	 */
	private static final String THIS_COMPONENT_NAME = ResourceLoader.class.getName();
	/**
	 * This creates a instance of logger for the component name as class name.
	 */
	private static Logger logger = EntityLogger.getUniqueInstance().getLogger(THIS_COMPONENT_NAME);
	private static URL resourceURL = null;
	private static List<String> props = new ArrayList<String>();
	static {
		props.add(ItemCategoryConstants.CONNECTION_FILE_WITH_PATH_FOR_APP);
		props.add(ItemCategoryConstants.CONNECTION_FILE_WITH_PATH_FOR_JUNIT);
		props.forEach(prop -> {
			resourceURL = Thread.currentThread().getContextClassLoader().getResource(prop);
			try {
				properties.load(resourceURL.openStream());
			} catch (FileNotFoundException exp) {
				logger.log(Level.WARNING, "FileNotFoundException thrown in ResourceLoader during property load.");
			} catch (IOException exp) {
				logger.log(Level.WARNING, "IOException thrown in ResourceLoader during property load.");
			}
		});

	}

	/**
	 * Returns the properties value based on key
	 * 
	 * @param propertyKey
	 * @return
	 */
	public static String getPropertyValue(String propertyKey) {
		if (propertyKey != null && !propertyKey.isEmpty()) {
			return properties.getProperty(propertyKey);
		}
		return null;
	}

	/**
	 * Returns the properties of all the config attributes defined in the
	 * properties file.
	 * 
	 * @return
	 */
	public static Map<String, String> getProperties() {
		Map<String, String> propertyMap = new HashMap<String, String>();
		for (String propertyKey : properties.stringPropertyNames()) {
			propertyMap.put(propertyKey, properties.getProperty(propertyKey));
		}
		return propertyMap;
	}
}
