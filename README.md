# About this repository

This repository contains the implementation of the lab assignments for the 2021 Applied Software Engineering course. The repository consists of the following:

* The **grade histogram** module, which is used for generating a histogram with student grades from a file.
* The **[unit testing](unittesting/README.md)** module, which is about getting familiar with JUnit.

# Technologies and tools

* Java: Java JDK 1.8 is being used for the purposes of the assignments. You can download the latest version [here](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html).

* Maven: The latest version of Apache Maven is also being used for building the project. You can find instructions on how to download, install and run Maven [here](https://maven.apache.org/).


# Building and running the project

### Cloning the repository
In order to build and run the project, 

* To clone the repository, run the following command on your terminal: 

    `git clone https://github.com/gliargovas/applied-software-engineering-assignments.git`

***Note:*** you must have installed Git in your local machine. You can alternatively download the project in a zipped format or import the project via your preferred IDE.

### Building and running directly from the command line

In order to build and run the project, you must have Java JDK 1.8 installed and configured on your local machine. Additionally, you will need Apache Maven for building the project.

* To build the project and generate the executable jar files of each module, run:

    `mvn package` 

You must see the execution messages of Maven along with a BUILD SUCCESS message at the end of the process.
A target directory, containing the executable fat jar file will be generated for each module.

### Running histogram generator
 
In order to generate a histogram from a grade file using histogram generator, from the project's main directory, run:

    java -jar .\gradehistogram\target\gradehistogram-1.0-SNAPSHOT-jar-with-dependencies.jar <FILE_PATH>

where `<FILE_PATH>` the relative or absolut path to the grades file.
