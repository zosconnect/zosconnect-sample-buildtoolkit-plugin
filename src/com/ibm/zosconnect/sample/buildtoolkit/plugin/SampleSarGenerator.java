/*
 Copyright IBM Corporation 2016
 
 LICENSE: Apache License
          Version 2.0, January 2004
          http://www.apache.org/licenses/
          
 The following code is sample code created by IBM Corporation.
 This sample code is not part of any standard IBM product and
 is provided to you solely for the purpose of assisting you in
 the development of your applications.  The code is provided
 'as is', without warranty or condition of any kind.  IBM shall
 not be liable for any damages arising out of your use of the
 sample code, even if IBM has been advised of the possibility
 of such damages.
*/
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
        //Retrieve the timezone property that was set by the user
        String timeZoneParm = parameters.get("timezone");
        //If the property was not set by the user then throw an exception
        if(timeZoneParm == null){
            throw new InvalidPropertyException("timezone", "Required parameter not specified");
        } else {
            timezone = timeZoneParm;
        }
    }

}
