# Devices Price Classification System using Python and Spring Boot

The project is a Flask and Spring Boot application that manages mobile device data and predicts prices based on specifications. It uses an SQLite database to store device information and a machine learning model (SVM) to predict prices. The Spring Boot application provides endpoints to add new device records, retrieve device prices by ID, and predict prices using the SVM model. The Spring Boot application provides an endpoint to predict prices using the Flask API. The project demonstrates how to integrate Flask and Spring Boot with an SQLite database and a machine learning model for predicting prices based on device specifications.

## Table of Contents

- [Installation](#installation)
- [Files](#files)
- [Usage](#usage)
- [Results](#results)
- [Improvement](#improvement)
- [Contributors](#contributors)

## Installation

1. Clone the repository:

   ```sh
   $ git clone https://github.com/elmeilgyahmed/AI-Developer-Task---Maid
   $ cd AI-Developer-Task---Maid

## Files
1. Dataset - This folder contains the raw data and database files in SQLite format.
2. Maids_EDA - Notebook for EDA process and training the model as well as all insights for the trained model.
3. endpoint.py - Flask API endpoint to receive requests from the Spring Boot app to make predictions on the device price.
4. svm_model.joblib - the trained model weights. To be used in the prediction process.
5. endpoint - This folder has Spring Boot app files and dependencies.
6. Documentation and Results.pdf - Documentation of the project and results of the endpoints.

## Usage
### Dependencies
Make sure you have the following packages:
- Apache Maven : 3.6.3
- Java version : 11.0.22
- In your VS Code, install the Spring Boot pack (VS Code Spring Boot Application Development Extension Pack) to run Spring Boot apps and Java Extension Pack.
- That will install Spring Boot Version : 2.6.3 
Build your Java product and choose Spring Boot App and Maven. Now your pom.xml file should look like this:
  ```sh
   	<parent>
   		<groupId>org.springframework.boot</groupId>
   		<artifactId>spring-boot-starter-parent</artifactId>
   		<version>2.6.3</version>
   		<relativePath/>
   	</parent>

         <dependencies>
      		<!-- Spring Boot Starter Web -->
      		<dependency>
      			<groupId>org.springframework.boot</groupId>
      			<artifactId>spring-boot-starter-web</artifactId>
      		</dependency>
      
      		<!-- Spring Boot Starter Test -->
      		<dependency>
      			<groupId>org.springframework.boot</groupId>
      			<artifactId>spring-boot-starter-test</artifactId>
      			<scope>test</scope>
      		</dependency>
      		<!-- SQLite JDBC Driver -->
      		<dependency>
      			<groupId>org.xerial</groupId>
      			<artifactId>sqlite-jdbc</artifactId>
      			<version>3.34.0</version>
      		</dependency>
      		<!-- Spring Boot Starter JDBC -->
      		<dependency>
      			<groupId>org.springframework.boot</groupId>
      			<artifactId>spring-boot-starter-jdbc</artifactId>
      		</dependency>
      
      	</dependencies>
```
Then install requirements
   ```sh
    $ pip install requirements.txt
   ```
Run the Flask endpoint; it will utilize port 5000 by default:
   ``` sh
$ ./endpoint.py
```
Then Spring Boot Application 
    
    ./mvnw clean spring-boot:run
OR run Spring Boot Application using VS Code; it will utilize port 8080 by default.

Now, you can test the implemented endpoints.

## Results

- The model achieved an accuracy of 98% on the training data and 97% on the test data.
- Postman is utilized to test the endpoints.
- The endpoints that we have

 ● GET /api/devices/
: Retrieve a list of all devices

![image](https://github.com/elmeilgyahmed/AI-Developer-Task---Maid/assets/50087016/093f69c7-6f53-483f-bd2d-3c206c10eac9)

● POST /api/devices/{id}
: Retrieve details of a specific device by ID.

![image](https://github.com/elmeilgyahmed/AI-Developer-Task---Maid/assets/50087016/bb1fb3e2-4a88-488a-a537-b22c61b1ab55)

● POST /api/devices
: Add a new device.

![image](https://github.com/elmeilgyahmed/AI-Developer-Task---Maid/assets/50087016/37f8bf9f-cfeb-41d4-b01e-e96b75c4aeb7)

● POST /api/predict/{deviceId}
: Last endpoint and the most important that will call Python API to predict the model price then save the result in
the entity.

![image](https://github.com/elmeilgyahmed/AI-Developer-Task---Maid/assets/50087016/642edf29-2a35-417c-8dc2-1f87e79257c1)

Please refer to the Documentation and Result file for a more detailed explanation of the endpoints' functionalities.

## Improvement

To achieve faster query response from an SQLite database, the following enhancement can be implemented:

   1.Utilize the pipeline method during model training to produce pre-defined scaler weights.
   
   2.These pre-defined weights can be stored and used during query processing for faster normalization of input data.
   
   3.This approach can significantly reduce request processing time, as most of the time is typically spent on the normalization process.

By incorporating this enhancement, the system can achieve faster response times for queries, improving overall performance.
## Contributors:

-Ahmed Kamal




