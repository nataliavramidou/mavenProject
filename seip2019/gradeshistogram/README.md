# This is a Java project built with Maven. 
This module is called gradeshistogram. It generates a histogram with students' grades' frequencies. This module has as depedency a java library named 'jfreechart', that is included in the pom file of the module.

To run the application:
1. Clone the repository
2. Install java and add the bin directory to the PATH environmental variable
3. Install maven and add the bin directory to the PATH environmental variable
4. Download eclipse workspace
5. Open the project in the eclipse workspace and run maven install
6. The maven install order creates two executable jars in the target folder of the gradeshistogram module. Bring git bash in the target folder and execute the command
"java -jar <jar-with-depedencies> ../src/main/resources/grades.txt"

After these steps a histogram with students' grades' frequencies will be generated on your screen.

To built this application i have used:
1.java version "1.8.0_161"
2.Apache Maven 3.6.0


