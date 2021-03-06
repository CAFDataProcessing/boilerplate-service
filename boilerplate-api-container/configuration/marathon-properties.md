# Marathon Properties


## Properties List
### Common CAF Properties
#### marathon-group
- This name will be used to group together applications in Marathon, enabling the ability to make applications dependant on others. Changing this between runs of Marathon Loader would allow you to launch separate sets of the applications alongside each other that would be independent.

#### force-pull
- This is used to tell Marathon that it should always pull the docker image for the application rather than relying on a locally cached version of the image. This should be set to either 'true' or 'false', defaulted to 'false' in the properties file.

#### marathon-uris-root
- The root folder that contains all files available for Marathon to copy into containers.

#### docker-login-config
- Following the steps [here](https://mesosphere.github.io/marathon/docs/native-docker-private-registry.html) this property specifies the path to the tar containing your docker login configuration file. This is required for each container to be able to pull their image down from Artifactory. **Note this value must be replaced.**

### Boilerplate API
#### boilerplate-admin-cpus
- Configures the amount of CPU of each Boilerplate API container. This does not have to be a whole number.

#### boilerplate-admin-mem
- Configures the amount of RAM of each Boilerplate API container. Note that this property does not configure the amount of RAM available to the container but is instead an upper limit. If the container's RAM exceeds this value it will cause docker to destroy and restart the container.

#### boilerplate-admin-instances
- Configures the number of instances of the boilerplate API container to start on launch.

#### boilerplate-admin-version
- This property specifies the version number of the Boilerplate API to pull down from Docker Hub.

#### boilerplate-admin-8080-serviceport
- This property specifies the external port number on the host machine that will be forwarded to the containers internal 8080 port. This port is used to call the boilerplate API web service.

#### boilerplate-admin-healthcheck-graceperiodseconds
- This property specifies the time in seconds Marathon must wait before calling the Boilerplate API's health check. This allows the application time to finish starting up as a premature health check will return a failure.

#### boilerplate-admin-healthcheck-intervalseconds
- This property specifies the time in seconds between each health check call.

#### boilerplate-admin-healthcheck-maxconsecutivefailures
- This property specifies the maximum number of times the Boilerplate API can fail its health check before Marathon considers the application failed and restarts it.

#### boilerplate-admin-healthcheck-timeoutseconds
- This property specifies the time in seconds Marathon will wait for the health check to return a response before failing the check.

#### boilerplate-admin-java-mem-min
- Configures the minimum memory size available to Java. This value is used by the JVM to reserve an amount of system RAM on start up.

#### boilerplate-admin-java-mem-max
- Configures the maximum memory size available to Java. This value is used by the JVM to specify the upper limit of system RAM the Java can consume. This limits the issue of Workers attempting to consume more memory that the container allows causing the application to fail.

#####boilerplate-admin-hibernate.connectionstring
- A string that specifies the JDBC connection to the Boilerplate database the web service will save and read from to.

#####boilerplate-admin-hibernate.user
- The username to connect to the Boilerplate database.

#####boilerplate-admin-hibernate.password
- The password to use to connect to the Boilerplate database.