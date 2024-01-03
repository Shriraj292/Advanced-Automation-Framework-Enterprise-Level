package org.opencart.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

import org.opencart.constants.FrameworkConstants;
import org.opencart.enums.ConfigProperties;
import org.opencart.exceptions.FileOperationsFailedException;
import org.opencart.exceptions.InvalidPropertyFilePathException;
import org.opencart.exceptions.InvalidPropertyKeyException;
import org.opencart.exceptions.PropertyKeyNullException;
import org.opencart.exceptions.PropertyValueEmptyException;

public final class PropertyUtilities {

	private PropertyUtilities() {
	}

	private static final Properties ENV_PROPERTIES = new Properties();

	static {
		try (FileInputStream fis = new FileInputStream(FrameworkConstants.getEnvConfigPropFile())) {
			ENV_PROPERTIES.load(fis);
		} catch (FileNotFoundException e) {
			throw new InvalidPropertyFilePathException(
					"Invalid properties file path " + FrameworkConstants.getEnvConfigPropFile()
							+ ". Please check file path in FrameworkConstants.java class",
					e);
		} catch (IOException e) {
			throw new FileOperationsFailedException("Some I/O exception occured while working with properties file.",
					e);
		}
	}

	public static String getPropertyValue(ConfigProperties key) {
		if (Objects.isNull(key)) {
			throw new PropertyKeyNullException("Property key is null. Please mention valid key.");
		}
		if (ENV_PROPERTIES.getProperty(key.toString().toLowerCase()) == null) {
			throw new InvalidPropertyKeyException("Property name " + key.toString().toLowerCase() + " not found."
					+ " Please check ConfigProperties.java and environmentConfig.properties file.");
		}
		if (ENV_PROPERTIES.getProperty(key.toString().toLowerCase()).isEmpty()) {
			throw new PropertyValueEmptyException("Value of property " + key.toString().toLowerCase() + " is empty."
					+ " Please check environmentConfig.properties file.");
		}

		return ENV_PROPERTIES.getProperty(key.toString().toLowerCase());
	}
}
