# User Registration
A Spring Boot application that allows users to register and log in using Spring Security for authentication and BCrypt for secure password hashing.

## Features
- User Registration: Users can register with a username, password, and confirm password.
- Password Hashing: User passwords are securely hashed using BCrypt.
- Login: Users can log in using their username and password.
- Form-based Authentication: Uses Spring Security for login and session management.

## Technologies Used
- Spring Boot 3.4.2
- Spring Security (for authentication)
- BCrypt (for password hashing)
- MySQL (for storing user data)
- HTML/JS (for the front-end forms)
- Maven (for dependency management)

## Setup & Installation

### 1️⃣ Clone the Repository
Clone the repository to your local machine:

```bash
git clone https://github.com/Kaloyanov5/user-registration.git
cd user-registration
```

### 2️⃣ Database Setup
This application uses MySQL for storing user credentials.

- Create a MySQL database (for example, "registration_app").

```sql
CREATE DATABASE registration_app;
```

- Update the application properties file with your MySQL connection details.

```properties
spring.datasource.url=jdbc:mysql://localhost:port/registration_app
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

### 3️⃣ Build the Application
Using IntelliJ IDEA:
- Open the project in IntelliJ IDEA.
- Ensure Maven dependencies are loaded.
- Select the main class (`RegistrationLoginAppApplication.java`) and run the project.

Using Command Line:
- If you're using Maven via the command line:
```bash
mvn clean install
mvn spring-boot:run
```

### 4️⃣ Create Users Table in MySQL
This step is automated by Spring Boot, no need to create a table manually.

### 5️⃣ Test the Application
1. Run the application.
2. Open your browser and navigate to `/index.html`.
3. Use the registration section to create a new user account.
4. Use the login section to log in using the credentials you just created.

## License
This project is open-source and available under the MIT License.

## Contributing
Feel free to submit pull requests!
For major changes, please open an issue first to discuss your ideas.
