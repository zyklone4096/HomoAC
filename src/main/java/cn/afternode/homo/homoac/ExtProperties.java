package cn.afternode.homo.homoac;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Properties;

public class ExtProperties {
    private final Properties properties;

    public ExtProperties(Properties properties) {
        this.properties = properties;

        NOCOM_ENABLED = Boolean.getBoolean(properties.getProperty("nocom.enabled", "false"));
    }

    public boolean NOCOM_ENABLED;
}
