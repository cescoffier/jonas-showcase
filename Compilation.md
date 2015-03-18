# Preliminaries #

The build process is based on [Maven](http://maven.apache.org/). So before building the application, you need to install and configure Maven.

# Getting the sources #

Once Maven is installed, download the sources, either from the [download section](http://jonas-showcase.googlecode.com/files/jonas-showcase-1.0.0-src.zip) or by "checkouting" the code from svn with the following command:

`svn checkout http://jonas-showcase.googlecode.com/svn/trunk/`

# Compilation #

Once downloaded, execute the following command:

`mvn clean install`

This will build the modules composing the applications.

