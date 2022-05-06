# CMPE 202 Individual Project

Java Billing Application:

# Design Patterns used are :

1) Factory Pattern is used in this project to handle the file generation object depending upon the validation result of the order and take a decision whether to create an object of "CreateErrorLogs"(for writing error to txt) class or a "CreateBillCsv"(for writing the output to csv) .

2) Singleton Pattern is used to create a single global instance of the database object which can be used among various classes of the project.

## Steps to Build: 

1) Download the code from the Repo
2) Import the extracted code to Eclipse as shown in the below pictures

![image](https://github.com/gopinathsjsu/individual-project-rajuptvs/blob/main/Screenshots/import.png)

![image](https://github.com/gopinathsjsu/individual-project-rajuptvs/blob/main/Screenshots/import2.png)

![image](https://github.com/gopinathsjsu/individual-project-rajuptvs/blob/main/Screenshots/import3.png)

## Follow the below steps to build a Jar file 

1) Go to the root structure --> right click --> export

![image](https://github.com/gopinathsjsu/individual-project-rajuptvs/blob/main/Screenshots/export.png)


2) Select Jar type while exporting

![image](https://github.com/gopinathsjsu/individual-project-rajuptvs/blob/main/Screenshots/exportjar.png)

3) Choose the location where built jar needs to be placed and click next and next until you see the manifest config 

![image](https://github.com/gopinathsjsu/individual-project-rajuptvs/blob/main/Screenshots/exportpath.png)

4) Select the main class and click finish

![image](https://github.com/gopinathsjsu/individual-project-rajuptvs/blob/main/Screenshots/exportmanifest.png)

## Steps to run the JAR file

1) Go to the location of the jar file and open the terminal and run the followinf command : java -jar billing.jar

![image](https://github.com/gopinathsjsu/individual-project-rajuptvs/blob/main/Screenshots/jarrun.png)

2) Provide the input path file

![image](https://github.com/gopinathsjsu/individual-project-rajuptvs/blob/main/Screenshots/jarsuccess.png)

