package com.ibm.zosconnect.sample.buildtoolkit.plugin;

import java.util.Map;

import com.ibm.zosconnect.buildtoolkit.InvalidPropertyException;
import com.ibm.zosconnect.buildtoolkit.ProviderProperty;
import com.ibm.zosconnect.buildtoolkit.ProviderProperty.ProviderPropertyType;
import com.ibm.zosconnect.buildtoolkit.SARGeneratorPlugin;
import com.ibm.zosconnect.buildtoolkit.ServiceArtifact;

public class SampleSarGenerator implements SARGeneratorPlugin {
    
    private String timezone;

    @Override
    public String getProviderName() {
        return "DateTimeSample";
    }

    @Override
    public String getRequestSchema() {
        return "{\"$schema\": \"http://json-schema.org/draft-04/schema#\",\"type\": \"object\",\"properties\": {\"input\": {\"type\": \"string\"}},\"required\": [\"input\"]}";
    }

    @Override
    public String getResponseSchema() {
        return "{\"$schema\":\"http://json-schema.org/draft-04/schema#\",\"type\":\"object\",\"properties\":{\"date\":{\"type\":\"string\"},\"output\":{\"type\":\"string\"}},\"required\":[\"date\",\"output\"]}";
    }

    @Override
    public ProviderProperty[] getProviderProperties() {
        return new ProviderProperty[]{new ProviderProperty("timezone", ProviderPropertyType.STRING, timezone)};
    }

    @Override
    public ServiceArtifact[] getSarContents() {
        return null;
    }

    @Override
    public void setParameters(Map<String, String> parameters) throws InvalidPropertyException {
        String timeZoneParm = parameters.get("timezone");
        if(timeZoneParm == null){
            throw new InvalidPropertyException("timezone", "Required parameter not specified");
        } else {
            timezone = timeZoneParm;
        }

    }

}
