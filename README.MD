## z/OS Connect Enterprise Edition Sample Build Toolkit Plug-in

A plug-in for the z/OS Connect Enterprise Edition build toolkit which builds service archive files for the
[z/OS Connect Sample Service Provider](https://github.com/zosconnect/zosconnect-sample-serviceprovider).

### Building the plug-in

1. Compile the source code with the `com.ibm.zosconnect.buildtoolkit.jar` on the classpath.
1. Build the compiled source into a jar file.

### Installing the plug-in

1. Copy the jar file created previously into the `plugins` directory of the build toolkit.
1. Update the `plugin.properties` file in the `lib` directory to include: 
```
dateTime=com.ibm.zosconnect.sample.buildtoolkit.plugin.SampleSarGenerator
```

### Building a SAR file

Create a properties file with the following format.

```
name=DateTimeService
version=0.1
provider=dateTime
description=A sample service using the sample provider
timezone=PST
```

### Notice

&copy; Copyright IBM Corporation 2016

### License
```
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```