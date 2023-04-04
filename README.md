Insurance Management System



The Insurance Management System is a web-based application built using Spring Boot and MySQL that enables users to manage insurance policies, claims, and client information. This system helps insurance companies to streamline their operations, reduce costs, and improve customer satisfaction.



Prerequisites

Before installing and running the application, make sure you have the following installed:

Java 8 or higher

Maven 3.6 or higher

MySQL 5.7 or higher

Installation

Clone the repository or download the source code as a zip file.

Create a MySQL database and update the application.properties file with your database credentials.

Build the application using Maven:

mvn clean package

Running Tests

C:\Users\Abhishek shukla\Downloads\myteam\myteam\target\myteam-0.0.1-SNAPSHOT.jar

Run Locally
  Open your web browser and navigate to http://localhost:5002 to access the application.
Usage
Admin First Register the client and then then add Insurence policy and then add claim client ,Insurence Policy and claims are associated with each other.

Use the navigation menu to manage policies, claims, and customers.

Documentation
Documentation

For Client

1 : Register Client : "/client".

2 : Get All Client data from database : "/client".

3 : Fetch data using id from database :"/client/{id1}".

4: Uelete data using id : "/client/{id1}".

5 : Update Data using id : "/client/{id1}".

For Insurence Policy

1: Post insurence policy : "/insurencepolicy"

2 : Get All data From databs=ase : "/insurencepolicy".

3 : Get data using id from database "/insurencepolicy/{id1}".

4: Update data using id :" /insurencepolicy/{id1}".

5 Delete data from database : "/insurencepolicy/{id1}".

5 : Get Data using clientid from database : "/insurencepolicyclient/{clientid1}".

For Claim

1: Put the claim :"\claim" in database.

2: Get all Claim :"\claim" from database.

3: Get Claim using id from database :"\claim{id1}"

4 Update claim using id in database : "\claim{id1}".

5 : Delete Claim using id from database :"\claim{id1}".

6 : Get claim using insurencepolicy : "\claim{policyId}"

Support
If you encounter any issues while using the application, please create an issue in the GitHub repository.

Credits
The Insurance Management System was built using the following technologies:

1: SpringBoot

2: Spring Data Jpa

3: MySQL

4 : Hibernate Validation
