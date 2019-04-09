# This is a Java project built with Maven. 
This module is called designpatterns. It includes the factory, strategy, facade and the utility class pattern. It takes as input from the terminal a
java file and analyzes it to find out the number of lines of code, the number of classes and the number of methods of this file. The analysis of the file 
can be executed with two methods defined by the user: string comparison or regular expressions. After the analysis a scv file with this metrics will be generated.

To run the application:
1. Clone the repository
2. Install java and add the bin directory to the PATH environmental variable
3. Install maven and add the bin directory to the PATH environmental variable
4. Download eclipse workspace
5. Open the project in the eclipse workspace and run maven install
6. The maven install order creates an executable jar in the target folder of the designpatterns module. Bring git bash in the target folder and execute the command
"java -jar <jar> <path-of-the-java-file> <string or regex>".

After these steps a csv file with the metrics of the java file will be generated in the target folder of the module.

To built this application i have used:
1.java version "1.8.0_161"
2.Apache Maven 3.6.0


