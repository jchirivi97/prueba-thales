# **Employee Management Application**  

## **📌 Project Overview**  
This project is a **Java MVC application** designed to manage employee information. It follows **good design and coding practices**, including **SOLID principles** and **Object-Oriented Programming (OOP)** concepts such as **inheritance, abstraction, and encapsulation**.  

The application consumes an external REST API, calculates **annual salaries**, and displays employee data in a user-friendly interface.  

---

## **📂 Baseline Requirements**  
✔️ The application must follow good software design and coding practices.  
✔️ Developed using an **Open Source Java IDE** (Recommended: **IntelliJ IDEA Community, NetBeans, Eclipse**).  
✔️ The solution must be published in a **public GitHub repository** and include:  
   - All necessary artifacts  
   - Clear instructions to **compile** and **execute** the application  
✔️ Uses **SOLID principles** and **OOP best practices**.  

---

## **📌 Application Requirements**  

### **1️⃣ Project Setup**  
- The application must be structured following the **MVC (Model-View-Controller) pattern**.  
- The backend must be implemented using **Spring Boot**, **JSF**, **Struts**, or **Vaadin**.  
- The final application must be packaged as a **WAR file**.  
- It must be **deployable on Wildfly Server** or **Spring Boot's embedded container**.  
- Requires **JDK 1.8+**.  

### **2️⃣ Data Access Layer**  
- The application must consume the following **REST APIs**:  
  - Get all employees: `http://dummy.restapiexample.com/api/v1/employees`  
  - Get an employee by ID: `http://dummy.restapiexample.com/api/v1/employee/{id}`  

### **3️⃣ Business Logic Layer**  
- A business class (e.g., **EJB**) must compute the **annual salary** of an employee using:  
  ```java
  employee_anual_salary = employee_salary * 12;
