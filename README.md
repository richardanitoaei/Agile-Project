# Team Olingo Members:

Alexandru Anitoaei
Erikas Banys
Alexander Jermstad
Kai Rycroft.

## APIs
We used Gradle and JUnit for testing and JSwing for creating the GUI.

## Video
Video overview of the finished product: https://youtu.be/JHWSIq4JJkg

# Agile Project

The Agile Project is 6-week development project where you develop a small Java application. This is the assignment you are required to complete in this project.

## Task

In the Agile Project, you are required to:

Develop a prototype project planning tool that maintains an inventory of tasks, effort estimates, resource requirements and dependencies between tasks and is able to compute a schedule of work.

Maintain a shared repository of your code using KCL GitHub Enterprise. The repository must be linked to your team's records on Team Feedback.

Have regular meetings to coordinate the work of the team and make decisions collectively. The suggested meeting frequency is 2 meetings per week, with each meeting lasting no longer than 30 minutes. One member of your team must take minutes of those meetings using Team Feedback.

Ensure that the application can be run and build on a *NIX machine that has Java JDK 1.8 and Gradle 3.2 installed and relies on nothing else. To build the code, it must be sufficient to execute:
$ gradle build

To run the tests, it must be sufficient to execute:
$ gradle test

To run the application, it must be sufficient to execute:
$ gradle run

Note that this means that you cannot rely on other software that may or may not be preinstalled on the system, such as a database.

## Project Brief

This project requires you to develop a project planning application. The application is aimed at projects in the most general sense of the work, not just software engineering projects. However, because your team's development time is very limited, only a small prototype implementation is required and you are free to make your own simplifying assumption if that enables you to produce a better prototype.

The application must enable a project manager to enter a list of tasks. For each task, it must be possible to identify at least a name, an effort estimate and a list of tasks that must be completed before this task is started. The application must enable a project manager to enter a list of people. It may also allow other resources to be entered into the system, but only if that information can be used for planning purposes. The application must be able to compute a schedule of tasks that satisfies the resource constraints (as a minimum, people are treated as indivisible resources: i.e. they can work on only one task at a time). The application must be able to show the schedule to the project manager.

The project brief intentionally leaves some unanswered questions. For example, it does not state whether two or more people can be assigned to the same task and what impact that has on the time it takes to complete the task. You need to think about those questions as and when they arise and try to come up with a justifiable answer, that enable you to implement the prototype.

## Deliverables

At the end of the project, you must submit a single tar.gz or zip file that has the name of your team and contains a directory with the following:

A README.md that contains the name of your team and the members of your team. If you have reused any code or used any APIs, these must be listed here and attributed, along with a short description as to what functionality that code/API provides.
All your source code and tests.

A short screencast video that shows how one uses the application. Keep this very short, just enough to demonstrate how you enter some tasks and other information and how a plan is produced. Aim for a 2-3 minute video. The maximum duration is 5 minutes.

A PDF document of no more than 4 sides of A4 that describes the design of your application. The design document must be accurate and easy to read/understand by someone who is not familiar with your team's work, but it does not have to be complete. The design document must be named design.pdf

If the team used an online Kanban board to organise its project that is not hosted on KCL GitHub, the team should add the module organiser (Jeroen Keppens) as a team member.  If the team used the Kanban board feature on KCL GitHub, it is sufficient to ensure that the repository is registered on Team Feedback.  Alternatively, the team may also submit screenshots or photographs of the kanban board collated into a PDF document.  If you choose the latter option, make sure that information about the cards, who it is assigned to and all other information is very clear.
