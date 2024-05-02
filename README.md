# Devices Price Classification System using Python and Spring Boot

The project is a Flask and Spring Boot application that manages mobile device data and predicts prices based on specifications. It uses an SQLite database to store device information and a machine learning model (SVM) to predict prices. The Spring Boot application provides endpoints to add new device records, retrieve device prices by ID, and predict prices using the SVM model. The Spring Boot application provides an endpoint to predict prices using the Flask API. The project demonstrates how to integrate Flask and Spring Boot with an SQLite database and a machine learning model for predicting prices based on device specifications.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Technologies Used](#technologies-used)
- [Features](#features)
- [Contributing](#contributing)
- [License](#license)

## Installation

1. Clone the repository:

   ```sh
   git clone https://github.com/elmeilgyahmed/AI-Developer-Task---Maid

   ```sh
   cd AI-Developer-Task---Maid

# install dependencies based on your project (if any)
Usage

Apache Maven 3.6.3
Java version: 11.0.22
pom.xml 

      ```sh
   	<parent>
   		<groupId>org.springframework.boot</groupId>
   		<artifactId>spring-boot-starter-parent</artifactId>
   		<version>2.6.3</version>
   		<relativePath/>
   	</parent>
    ```
dependcies
   ```sh
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

reqirments

Explain how to use your project. Provide examples or screenshots if possible to illustrate usage.
Technologies Used

    List the technologies, frameworks, and libraries used in your project.

Features

    List the features of your project and how they can be used. You can also mention any future features or improvements planned.

Contributing

    Fork the repository.
    Create a new branch (git checkout -b feature/fooBar).
    Make your changes.
    Commit your changes (git commit -am 'Add some fooBar').
    Push to the branch (git push origin feature/fooBar).
    Create a new Pull Request.

License

Specify the license under which your project is distributed.

Replace `your-username` and `your-repository` with your GitHub username and repository name, respectively. Adjust the content as needed to fit your project's details. Save this text in a file named `README.md` in the root directory of your project.
