## Spring MVC Film C.R.U.D. Project

### Week 8 Homework Project for Skill Distillery

### Overview

This is a team project: you will collaborate with your teammates to complete this project.

One teammate will own the Github repository that the rest of the team will share.

This teammate will start the project in Spring Tool Suite, initialize it with Git, create the Github repository, and link and push the project to Github.

The rest of the team will clone the project and import it into their STS.

This application implements full web-based C.R.U.D. functionality, using Spring MVC and the DAO pattern. The DAO implementation uses JDBC to persist and retrieve data.

### Technologies

Java Version 1.8, JEE, JSP & JEL, Spring MVC, Spring STS, Gradle, Apache Tomcat 8.5, SQL, MySQL, MySQL Workbench, AWS EC2, HTML, CSS, XML, Bootstrap Git, Github, Eclipse IDE, Atom

### Topics Applied

The primary topics applied from Week 8 at Skill Distillery were using Dynamic Web Apps, Java Database Connectivity (JDBC), relational databases such as SQL and more specifically MySQL in this exercise, Object-Relational Mapping (ORM), CRUD, Dependency Injection/Autowiring/Components, MVC, MVC annotations, and Inversion of Control.

### Lessons Learned

### Cesar Moreno's Lessons Learned

Communication is key to prevent merger, this was a big lesson learn for us even though we didn’t have many issues but
the few we had communication helped with the solution.

For inputs we implemented required=“required” for the input so we could catch empty fields right before it hit the 
backend.
    
At the beginning we rushed into big ideas, such as adding users and logins, but soon realized that we needed MVP and
refocused on the initial user story.
    
We learned that small changes can make big impacts, specially from the backend, implementations of new logic in
controllers affected the the program as a whole.
    
    
### Richard Newman's Lessons Learned

Invaluable project. Learned lessons from each step of the task assignments and from pair programming with version control.
Initially, we felt unprepared for this project. We felt that the material covered during the week was too complex for such
a short period of time but the madness of the method proved to be invaluable. Struggling with connecting the all the
moving parts, I.e. ORM (object relational mapping), the DAO (database accessor objects), autowired entities, dependency
injection and inversion of control, taught me more in one weekend than I could ever learn by simply listening to lectures
or reading in a book. It was the hands on keyboard and talking through the process and logic with my partner that helped
tremendously.  

In hindsight, we should have used better naming practices. As our project grew and as our request mapping became more
complex, it became apparent that we should have used a better naming system for our JSPs. They work for now but will
definitely have to be refactored.

Another valuable lessoned learned in keeping the code DRY. The navigation bar is a great example. As it stands now, the
navigation bar is hardcoded into every jsp and html page. In order to add one new link, I would have to edit each page to
change the site functionality. Instead, perhaps one JSP containing the navbar links which could then be referenced through
    
Java Expression Language on the rest of the pages could be used. We will have to investigate this option further to see if
it could be implemented.


### How to Run

You must compile this program to run it. Current version will only work on the console of an IDE. Download or clone this repository to a local directory. Open Eclipse IDE (or your favorite Java compiler) and import the project under the File menu. Alternatively, you can clone the repository directly into your IDE via terminal. Once you have compiled it, click run and follow the prompts.

Clone with SSH:

git@github.com:CMoreno04/SpringMVCFilmCRUD.git

Clone with HTTPS:

https://github.com/CMoreno04/SpringMVCFilmCRUD.git


## Context

Below you will find a copy of the assignment's tasks. We are providing this context for anyone evaluating our code. This project builds on labs written in class. We were guided through the first JDBC connection, along with the matching entity for that connection. The remainder of the lab work was performed independently. For better or worse, the code is our own. The only resources referenced were from the prior week's course material and our class notes. We are not a fan of copy and paste code because it does not aid in our learning process. We are attending this bootcamp so that we can thoroughly understand how to properly develop software using Java.

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
