# Assessment Starter

To use this project, you need to fork it in Gitlab.

Then, remove the fork relationship using Settings/Advanced.

Then, clone the project to your local environment.

When you load the project into IntelliJ, make sure that you select the ```build.gradle``` file and then import as a project.

IntelliJ may well ask you to select a Java SDK. Pick a OpenJDK 17 SDK.

For running in CMD make sure to switch to UTF-8 encoding to display characters like dashes and pound signs etc do this by typing
chcp 65001.


## On NSA Laptops or Cloud Desktop

The Java SDK package is already installed. It has set the ```CLASSPATH``` environment variable and this interferes with the Gradle build.

I have provided two scripts that will unset the ```CLASSPATH``` environment variable.

For Powershell, there is ```build.ps1``` which you can run with ```.\build.ps1```.

For Git Bash, there is ```build.sh``` which you can run with ```./build.sh```.

Both of these scripts will run the Gradle task ```buildAndReport```. which is the same as what will be run on Gitlab CI.