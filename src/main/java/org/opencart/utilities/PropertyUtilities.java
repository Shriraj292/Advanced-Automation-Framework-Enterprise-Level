package org.opencart.utilities;

import org.opencart.constants.FrameworkConstants;
import org.opencart.enums.ConfigProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public final class PropertyUtilities {

    private PropertyUtilities() {}
    private static final Properties ENV_PROPERTIES = new Properties();

    static {
        try(FileInputStream fis = new FileInputStream(FrameworkConstants.getEnvConfigPropFile()))
        {
            ENV_PROPERTIES.load(fis);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getPropertyValue(ConfigProperties key) {
        if (Objects.isNull(key)){
            throw new RuntimeException("Property key is null. Please mention valid key.");
        }
        if (ENV_PROPERTIES.getProperty(key.toString().toLowerCase()) == null){
            throw new RuntimeException("Property name " + key.toString().toLowerCase() + " not found." +
                    "Please check environmentConfig.properties file.");
        }

        return ENV_PROPERTIES.getProperty(key.toString().toLowerCase());
    }
}
