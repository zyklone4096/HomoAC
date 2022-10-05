package cn.afternode.homo.homoac;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Properties;

public class ExtProperties {
    final Properties properties;

    public ExtProperties(Properties properties) {
        this.properties = properties;

        NOCOM_ENABLED = Boolean.getBoolean(properties.getProperty("nocom.enabled", "false"));

        EMP_ENABLED = Boolean.getBoolean(properties.getProperty("aa.name", "false"));
        EMP_KICK_MSG = properties.getProperty("aa.message", "Invalid name");

        PHASE_ENABLED = Boolean.getBoolean(properties.getProperty("mm.phase", "false"));
    }

    public boolean NOCOM_ENABLED;

    public boolean EMP_ENABLED;
    public String EMP_KICK_MSG;

    public boolean PHASE_ENABLED;
}
