## Spring MVC Film C.R.U.D. Project

### Week 8 Homework Project for Skill Distillery

### Overview

This is a team project: you will collaborate with your teammates to complete this project.

One teammate will own the Github repository that the rest of the team will share.

This teammate will start the project in Spring Tool Suite, initialize it with Git, create the Github repository, and link and push the project to Github.

The rest of the team will clone the project and import it into their STS.

This application implements full web-based C.R.U.D. functionality, using Spring MVC and the DAO pattern. The DAO implementation uses JDBC to persist and retrieve data.

### Technologies

Java Version 1.8, SQL, MySQL, Git, Github, Eclipse IDE, Atom

### Topics Applied



### Lessons Learned



### How to Run

You must compile this program to run it. Current version will only work on the console of an IDE. Download or clone this repository to a local directory. Open Eclipse IDE (or your favorite Java compiler) and import the project under the File menu. Alternatively, you can clone the repository directly into your IDE via terminal. Once you have compiled it, click run and follow the prompts.

Clone with SSH:



Clone with HTTPS:





## Context

Below you will find a copy of the assignment's tasks. I am providing this context for anyone evaluating my code. This project builds on a lab written in class. We were guided through the first JDBC connection, along with the matching entity for that connection. The remainder of the lab work was performed independently. For better or worse, the code is my own. The only resources referenced were from the prior week's course material and my class notes. I am not a fan of copy and paste code because it does not aid in the learning process. I am attending this bootcamp so that I can thoroughly understand how to properly develop software using Java.

### The Following Task Overview and User Stories Were Provided by Skill Distillery



## User Stories

### User Story 1

A user can enter a Film's ID and see the details of the film in a web page. If the film is not found, they see an appropriate message.

### User Story 2

A user can choose to add a new film. They can enter all the properties of the film. Their input will be used to create Film object, which the DAO implementation will save in the database. If the insert fails, the user is informed of this.

### User Story 3

When a user retrieves a film, they have the option of deleting it. If they delete the film, it is removed from the database. If the delete fails (such as, due to child records), the user is informed of this.

  * Note: It is not necessary to be able to delete existing films, which have child records in various tables. Test your delete   functionality using new films you've created via User Story 2.

### User Story 4

When a user retrieves a film, they have the option of editing it. If they choose this, all the film's current properties are displayed in a form, allowing them to change any property except the film's ID. When they submit the form, that film's record is updated in the database. If the update fails, the user is informed of this.

### User Story 5

A user can search for films by keyword/pattern in title or description. From the resulting list of films, the user can choose to update or delete a record.

### User Story 6

When a film's details are displayed, its actors and categories are also listed.

### Requirements

* The project source is pushed to Github.

* The running application is deployed to Amazon EC2.

* All user stories are implemented.

* The project has a detailed README.md

* Each team will present their work to the class.

### Stretch Goals

### Goal 1

A user can add an Actor to the database.


### Goal 2

A user can update or delete an actor.

### Goal 3

A user can add an actor to a film.

### Goal 4

A user can remove an actor from a film.

### Goal 5

A user can choose to list all inventory items for a film.

### Goal 6

A user can choose to list all rentals of a film, including the customer name and location.

### Goal 7

Use Bootstrap to make your film site look fabulous.

### Grading

The application pushed to Github must satisfy all of the user stories without throwing any exceptions.
