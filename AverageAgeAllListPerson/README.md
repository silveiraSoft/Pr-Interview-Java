## Getting Started
To get started with the code in this repository, follow these steps:
1. Clone the repository to your local machine using the following command:
git clone


How to run a java project
1. Make sure you have Java Development Kit (JDK) installed on your machine. You can download it from the official Oracle website or use a package manager like Homebrew (for macOS) or apt-get (for Linux).
2. Set up your environment variables. Ensure that the JAVA_HOME variable points to your JDK installation directory and that the PATH variable includes the bin directory of your JDK.
3. Open a terminal or command prompt.
4. Navigate to the directory where your Java project is located using the cd command.
5. Compile your Java files using the javac command. For example, if your main file is named Main.java, you can compile it with:
   javac Main.java
   This will generate .class files in the same directory.

1. If your project is a simple one with multiple files, you can compile all Java files in the directory using:
   javac *.java
2. If your project uses packages, make sure to maintain the directory structure that matches the package names.
3. Once compiled, you can run your Java program using the java command. If your main class is named Main, you can run it with:
   java Main
4. If your project is packaged as a JAR file, you can run it using the java -jar command. First, ensure that your JAR file has a manifest file specifying the main class. Then, run it with:  
    java -jar yourproject.jar

Example:
PS C:\Users\adalb\OneDrive\Documentos\2025\Java\Pr-Interview-Java\AverageAgeAllListPerson> javac AverageAgeAllListPerson.java  
PS C:\Users\adalb\OneDrive\Documentos\2025\Java\Pr-Interview-Java\AverageAgeAllListPerson> java AverageAgeAllListPerson      
Average age: 31.6
Average age by department: 31.375
Average age by department (V2): {Finance=35.0, HR=30.0, IT=32.5, Marketing=28.0}
Names with first character in lower case: {ethan=40.0, bob=25.0, alice=30.0, diana=28.0, charlie=35.0}    

Creating the jar for the classes
javac *.java
jar cfm AverageAgeAllListPerson.jar MANIFEST.MF *.class
java -jar AverageAgeAllListPerson.jar

Create manifest file (MANIFEST.MF) - specifies main class

Create JAR: jar cfm AverageAgeAllListPerson.jar MANIFEST.MF *.class

Run JAR: java -jar AverageAgeAllListPerson.jar


5. If your project has dependencies, consider using a build tool like Maven or Gradle to manage them. These tools can also help with compiling and running your project.
6. If you encounter any errors during compilation or runtime, carefully read the error messages to identify and fix the issues.
7. Optionally, you can use an Integrated Development Environment (IDE) like IntelliJ IDEA, Eclipse, or NetBeans to manage, compile, and run your Java projects more easily. These IDEs provide features like code completion, debugging, and project management.
# Pr-Interview-Java
This repository contains Java code examples and solutions for common interview questions and problems. It is designed to help individuals prepare for technical interviews by providing practical coding exercises and explanations.


##The MANIFIEST file
Follow one code example of a MANIFIEST.MF
--------------------
Manifest-Version: 1.0
Main-Class: AverageAgeAllListPerson.AverageAgeAllListPerson
Created-By: 1.8.0_281 (Oracle Corporation)
Class-Path: .
---------------------

###Note about MANIFIEST.MF
The MANIFEST.MF file is needed to tell Java which class contains the main method when running java -jar. Here's when it's needed and when it's not:

When MANIFEST.MF is NEEDED:
Running with java -jar - Java needs to know which class to execute

Multiple classes with main methods - Specifies which one to use

Executable JAR files - For double-click execution

When MANIFEST.MF is NOT needed:
Running with java -cp - You specify the main class manually:

java -cp myapp.jar AverageAgeAllListPerson

Copy
Library JARs - JARs used as dependencies don't need a main class

Web applications - Application servers handle execution

No Default Name Recognition:
Java has NO default naming convention for main classes. It doesn't automatically look for:

Main.class

Application.class

Classes matching the JAR name

Alternative JAR Creation Methods:
Creating JAR without manifest and running with -cp

shell


Run
javac *.java
jar cf AverageAgeLibrary.jar *.class
java -cp AverageAgeLibrary.jar AverageAgeAllListPerson
--------------------------------















