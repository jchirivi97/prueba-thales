
The Candidate must deliver a software application according to the following requirements:
1 Baseline Requirements
 The application must be designed using good design practices and coding (describe the most relevant)
 The application must be done using an Open Source Java IDE of choice (recommended: IntelliJ Idea community, Netbeans IDE, Eclipse IDE)
 The solution must be published in a public DVCS repository, such as GitHub
 The solution will be downloaded, compiled and executed in a developer machine to verify a correct configuration management approach. Therefore, the solution must be published with all the artifacts and instructions to compile and execute the application
 Basic Object Oriented Programming principles must be used, such as Inheritance, abstraction, encapsulation
 SOLID principles must be used
2 Application Requirements ID Summary
1
Create an MVC application.
Can be based in Spring(or Spring Boot), JSF, Struts or Vaadin
2
The application must be delivered in a WAR file
3
The application must be deploy-able in a Wildfly Server or Spring boot auto container
4
The application must use JDK 1.8+
5
Create a Data Access Layer to consume the following REST APIs:
 http://dummy.restapiexample.com/api/v1/employees
 http://dummy.restapiexample.com/api/v1/employee/1
These API methods return a list of employees and employee data by ID
6
Create a Business class (EJB, for example) to compute the following value:
employee_anual_salary = employee_salary x 12
7
Create a Controller Class with methods to return the employees list and employee data by ID
8
Create a view to show the employee information, the view must present the following components and behavior:
 One text box, where the user can input the employee ID
 One button to execute the Employee search
 If the input text box is empty, the search result must return the complete employee list
 If the text box contains a valid employee ID, the search result must return the particular employee information
 The returned employee list must be shown in a table or grid, including the employee_anual_salary computation
9
User Interface Guidelines:
* The application must use Bootstrap or Material Design
* The application must contain a Menu and brand Image
Desirable technologies to use on the front-end (use 1, complementary to the Application framework selected):
1. Javascript/Typescript
2. Angular
3. JQuery
4. ReactJS
5. VueJS
   
10 The application must include Unitary Tests for at least one of the Business Layer methods. Using JUnit5


