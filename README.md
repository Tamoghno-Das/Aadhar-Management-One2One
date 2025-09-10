Aadhaar Management System
--------------------------------------------



strial-grade Aadhaar Management System built with Spring Boot (Backend) and React (Frontend).
It supports CRUD operations for managing people and their Aadhaar details, with a professional web interface.


🚀 Features
-------------------------------------------

Backend (Spring Boot)

REST APIs for Person + Aadhaar management

JPA one-to-one mapping

Oracle/PostgreSQL database integration

JUnit-based testing

Frontend (React)

Form to add person + Aadhaar

Table view for all records

Connects seamlessly with backend APIs

Runs independently on http://localhost:3000



🖥 Software & Setup
-----------------------------------------------------

Here is a quick overview of the software running and screenshots of the project in action.


| Software / Tool | Version | Description |
|-----------------|---------|-------------|
| Java            | 21      | Programming language used for backend logic |
| Spring Boot     | 3.2     | Framework used to create REST APIs |
| H2 Database     | 2.2     | In-memory database used for testing |
| Postman         | 10.15   | Used for testing REST APIs |
| IntelliJ IDEA   | 2025.2  | IDE used for coding and debugging |

<p align="center">
  <img src="https://github.com/user-attachments/assets/1719a2e6-121c-47a5-b1fe-510ad05e1eb1" width="100" alt="Java">
</p>

<p align="center">
  <img src="https://github.com/user-attachments/assets/0eeef4ea-c10c-48d7-9470-6bfc1e219643" width="100" alt="Spring Boot">
</p>

<p align="center">
  <img src="https://github.com/user-attachments/assets/3d804e37-b449-42ec-a86d-568d70728108" width="100" alt="H2 Database">
</p>

<p align="center">
  <img src="https://github.com/user-attachments/assets/d897ff1f-f2c9-4b57-9b4a-d2800b94c37e" width="100" alt="Postman">
</p>

<p align="center">
  <img src="https://github.com/user-attachments/assets/075da697-0f01-4a32-a9ae-f91ecae9a815" width="100" alt="IntelliJ IDEA">
</p>





📂 Project Structure
-----------------------------------------

<pre>
<code>
Adhaar-Management/
 ├── backend/ (Spring Boot project)
 │    ├── src/main/java/com/example/adhaar
 │    └── ...
 ├── frontend/ (React project)
 │    ├── src/
 │    ├── public/
 │    └── package.json
 └── README.md
</code>
</pre>

⚙️ Setup & Installation
-----------------------------
1. Clone Repository
   ---------------------------------

<pre>
<code>
git clone https://github.com/<your-username>/adhaar-management.git
cd adhaar-management
</code>
</pre>


2. Backend Setup (Spring Boot)
   --------------------------------------

   
<pre>
<code>
cd backend
mvn clean install
mvn spring-boot:run
</code>
</pre>


Runs on:
👉 http://localhost:8888

Database Config (backend/src/main/resources/application.properties)
----------------------------------------------------------------------------


<pre>
<code>
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:xe
spring.datasource.username=your_db_user
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.OracleDialect
</code>
</pre>


3. Frontend Setup (React)
   ------------------------------------------------------------------


<pre>
<code>
cd frontend
npm install
npm start
</code>
</pre>



📌 API Endpoints
----------------------------------------------------------
Create Person with Aadhaar

POST ```http://localhost:8888/api/person```

Request:
<pre>
<code>
{
  "name": "John",
  "age": 30,
  "aadhar": {
    "aadharNumber": "123456789012",
    "address": "Delhi"
  }
}
</code>
</pre>


Response:
<pre>
<code>
{
  "id": 1,
  "name": "John",
  "age": 30,
  "aadhar": {
    "id": 1,
    "aadharNumber": "123456789012",
    "address": "Delhi"
  }
}

</code>
</pre>



Get All Persons
------------------------------

GET ```http://localhost:8888/api/person```



🖥️ Frontend Features
--------------------------------------------
Add Person

Fill form with Name, Age, Aadhaar Number, Address

Submits via POST → stored in DB

View Records

Auto-refreshes table after adding person

Displays all persons with linked Aadhaar


📸 Screenshots
-------------------------------------------------------


✅ JUnit Test Execution
------------------------------------------------


<p align="center">
  <img 
      alt="Screenshot 2025-09-11 002207" 
      src="https://github.com/user-attachments/assets/03320f71-0a18-4ae0-a026-cbc1081083b7" 
      width="800"
      >
</p>



✅ API Request via Postman
-------------------------------------------------------------


<p align="center">
  <img 
      alt="Screenshot 2025-09-11 002739" 
      src="https://github.com/user-attachments/assets/bffec0dc-8c2c-4e89-a2d8-806ae1250599" 
      width="800" 
      >
</p>



✅ Person Table (Database)
-----------------------------------------------------------------------


<p align="center">
  <img 
      src="https://github.com/user-attachments/assets/77992520-f173-40f9-9237-2fd027751877" 
      alt="Screenshot 2025-09-11 003107" 
      width="800">
</p>



✅ Aadhaar Table Data
---------------------------------------------------------------


<p align="center">
  <img 
      src="https://github.com/user-attachments/assets/42202e13-4d76-46ea-b794-5cd02000d7e9" 
      alt="Screenshot 2025-09-11 003132" 
      width="800">
</p>



🧪 Testing
---------------------------------

Run tests with:
------------------------

```mvn test```


Sample JUnit Test:
----------------------------

<pre>
<code>
assertNotNull(saved.getAadhar());
assertEquals("123456789012", saved.getAadhar().getAadharNumber());
</code>
</pre>



🗄️ Database Schema
------------------------------------------------

***Person Table***

| ID  |  NAME | AGE | AADHAR\_ID |
|:---:|:----: |:--: |:----------: |
| 30 | John   | 30  | 30         |
| 31 | Rahul  | 40  | 31         |
| 32 | Meena  | 19  | 32         |
| 33 | Sophia | 28  | 33         |



***Aadhar Table***

| ID | AADHAR\_NUMBER | ADDRESS   | PERSON\_ID |
| -- | -------------- | --------- | ---------- |
| 30 | 123456789012   | Delhi     | 30         |
| 31 | 555566667777   | Bangalore | 31         |
| 32 | 111122223333   | Kolkata   | 32         |
| 33 | 999988887777   | Hyderabad | 33         |






















    



















   
   
