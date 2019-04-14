# Tweethub

![Alt text](images/tweethub.png?raw=true "Title")

## Description

A simple **Java** command line mashup of the **GitHub** and **Twitter** API's

### Features

This project features:
* An user-friendly command line environment with auto completion and help utilities
* Ability to search **GitHub** for *reactive* projects, alongside their associated Tweets from **Twitter**

### Technologies

This project makes use of the following dependencies:
* **git** SCM following **GitFlow** branching model
* **Maven** for build and dependency management
* **Spring MVC** for Dependency Injection
* **Spring Shell** for user-friendly command line environment
* **Jackson** for JSON parsing
* **JUnit** for Unit Testing and Integration Testing
* **Mockito** for mocking
* **Twitter4j** for wrapping Twitter API interractions
* **Lombok** for removing Java boilerplate

## Build Guide

### Prerequisites

The only prerequisites for this proejct are that:
* You have a command line environment available(e.g. *Terminal.app*, *Git Bash*, Linux CLI)
* You have **git** installed
* You have a Twitter developer account and have generated the relevant Consumer API Keys and Access Tokens for this app

Maven will automatically install the required Spring dependencies

### Clone the Project

To clone the project to your local machine, open a shell environment and run the following command:

**git clone https://github.com/shanesully/tweethub**

### Checkout the Release Tag

To checkout the initial production recent release tag, run the following command:

**git checkout releases/1.0**

### Change Directory

Once the project has been cloned, run the following command:

**cd tweethub**

### Configure Twitter Developer Credentials

From the project directory, edit the *'src/main/resources/application.properties'* file and enter the Twitter developer credentials that you generated for this app.

### Execute Tests

Once you've configured the Twitter developer credentials, execute the tests in isolation by running the following command:

**mvn test**

### Build and Run

To buiild and run the project, run the following command:

**mvn spring-boot:run**

## Usage Guide

### Getting Around

Once the project is up and running, you will be presented with a shell prompt that looks like the following:

**shell>**

From here you can enter shell commands to interract with the application.

### Shell Commands

#### Help

Enter the **'help'** command from the Spring Shell prompt at any time to be presented with a list of available actions

#### Search GitHub Projects

To get a list of **GitHub** projects with their associated Tweets, run the following command:

**search_reactive_projects**

This will return a list of five recent *reactive* **GitHub** projects with up to ten **Tweets** associated with them.

To view a different five projects, run the same command with the addition of a *page* option:

**search_reactive_project --page 2**

This will return the next five projects from **GitHub**

####Search Tweets for Arbitrary Project####

To get a list of up to ten **Tweets** for any given GitHub project, run the following command, specifying the name of that project:

**search_tweets_by_project [PROJECT_NAME]**

*e.g.* '**search_tweets_by_project rxjs**' will return a list of up to ten tweets related to the **rxjs** project

### Auto Completion

To auto-complete any command without having to type out it's lengthy name, enter the **[TAB]** key when typing out a command to save keystrokes

### Exiting the Application Shell

To exit the application shell at any time, type the **'exit'** command from the Spring Shell and then enter **[CTRL] + C** to forcibly halt the application*

\* Likely an input issue caused by using **Spring Shell** with **Spring Boot**

