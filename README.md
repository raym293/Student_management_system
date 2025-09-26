# Student Management System in Java

A comprehensive Student Management System built using Object-Oriented Programming principles in Java. This system allows educational institutions to manage student records, courses, grades, and administrative tasks efficiently.

## Table of Contents

- [Features](#features)
- [System Requirements](#system-requirements)
- [Project Structure](#project-structure)
- [Classes Overview](#classes-overview)
- [Installation](#installation)
- [Usage](#usage)
- [Functionality](#functionality)
- [Object-Oriented Concepts Used](#object-oriented-concepts-used)
- [Future Enhancements](#future-enhancements)
- [Contributing](#contributing)
- [License](#license)

## Features

- **Student Management**
  - Add new students
  - Update student information
  - Delete student records
  - Search students by ID, name, or other criteria
  - View all students

- **Course Management**
  - Add new courses
  - Update course details
  - Delete courses
  - Assign students to courses
  - View course enrollment

- **Grade Management**
  - Record student grades
  - Calculate GPA
  - Generate grade reports
  - Track academic performance

- **Administrative Features**
  - User authentication
  - Data persistence
  - Report generation
  - Search and filter capabilities

## System Requirements

- **Java Version**: Java 8 or higher
- **IDE**: Any Java IDE (Eclipse, IntelliJ IDEA, NetBeans, VS Code)
- **Operating System**: Windows, macOS, or Linux
- **Memory**: Minimum 512 MB RAM
- **Storage**: 100 MB free disk space

## Project Structure

```
Student_management_system/
├── src/
│   ├── main/
│   │   ├── Student.java
│   │   ├── Course.java
│   │   ├── Grade.java
│   │   ├── Teacher.java
│   │   ├── StudentManagementSystem.java
│   │   └── Main.java
│   ├── utils/
│   │   ├── FileManager.java
│   │   ├── InputValidator.java
│   │   └── ReportGenerator.java
│   └── exceptions/
│       ├── StudentNotFoundException.java
│       └── InvalidGradeException.java
├── data/
│   ├── students.txt
│   ├── courses.txt
│   └── grades.txt
├── docs/
│   └── user_manual.md
├── README.md
└── .gitignore
```

## Classes Overview

### 1. Student Class
```java
public class Student {
    private String studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date dateOfBirth;
    private String address;
    private double gpa;
    
    // Constructors, getters, setters, and methods
}
```

**Key Methods:**
- `addCourse(Course course)`: Enrolls student in a course
- `removeCourse(String courseId)`: Removes student from a course
- `calculateGPA()`: Calculates and returns current GPA
- `getFullName()`: Returns concatenated first and last name

### 2. Course Class
```java
public class Course {
    private String courseId;
    private String courseName;
    private String description;
    private int creditHours;
    private String instructor;
    private int maxCapacity;
    private List<Student> enrolledStudents;
    
    // Constructors, getters, setters, and methods
}
```

**Key Methods:**
- `enrollStudent(Student student)`: Adds student to course
- `dropStudent(String studentId)`: Removes student from course
- `getEnrollmentCount()`: Returns number of enrolled students
- `isCourseFull()`: Checks if course has reached maximum capacity

### 3. Grade Class
```java
public class Grade {
    private String studentId;
    private String courseId;
    private double score;
    private String letterGrade;
    private Date dateRecorded;
    
    // Constructors, getters, setters, and methods
}
```

**Key Methods:**
- `calculateLetterGrade()`: Converts numeric score to letter grade
- `isPassingGrade()`: Checks if grade meets passing criteria

### 4. StudentManagementSystem Class
```java
public class StudentManagementSystem {
    private List<Student> students;
    private List<Course> courses;
    private List<Grade> grades;
    
    // Core system methods
}
```

**Key Methods:**
- `addStudent(Student student)`: Adds new student to system
- `updateStudent(String studentId, Student updatedInfo)`: Updates student information
- `deleteStudent(String studentId)`: Removes student from system
- `searchStudent(String criteria)`: Searches for students
- `generateReport()`: Creates various reports

## Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/student-management-system.git
   cd student-management-system
   ```

2. **Compile the Java files**
   ```bash
   javac -d bin src/**/*.java
   ```

3. **Run the application**
   ```bash
   java -cp bin main.Main
   ```

## Usage

### Starting the Application

1. Run the main class to start the system
2. Choose from the main menu options:
   - Student Management
   - Course Management
   - Grade Management
   - Reports
   - Exit

### Adding a New Student

```java
// Example code snippet
Student newStudent = new Student(
    "STU001",
    "John",
    "Doe",
    "john.doe@email.com",
    "123-456-7890",
    new Date(),
    "123 Main St"
);

studentManagementSystem.addStudent(newStudent);
```

### Enrolling Student in Course

```java
// Example enrollment
Course javaCourse = new Course("CS101", "Introduction to Java", "Basic Java programming", 3, "Dr. Smith", 30);
Student student = studentManagementSystem.getStudentById("STU001");

javaCourse.enrollStudent(student);
student.addCourse(javaCourse);
```

### Recording Grades

```java
// Example grade recording
Grade grade = new Grade("STU001", "CS101", 85.5, new Date());
studentManagementSystem.recordGrade(grade);
```

## Functionality

### 1. Student Operations
- **Add Student**: Create new student records with personal information
- **Update Student**: Modify existing student details
- **Delete Student**: Remove student from the system
- **Search Student**: Find students using various criteria
- **View All Students**: Display complete student roster

### 2. Course Operations
- **Create Course**: Add new courses to the system
- **Update Course**: Modify course information
- **Delete Course**: Remove courses from the system
- **Enroll Students**: Register students for courses
- **View Enrollment**: Check course enrollment status

### 3. Grade Management
- **Record Grades**: Enter student grades for courses
- **Update Grades**: Modify existing grade entries
- **Calculate GPA**: Compute student grade point averages
- **Generate Transcripts**: Create academic transcripts

### 4. Reporting Features
- **Student Reports**: Individual student academic records
- **Course Reports**: Course enrollment and performance statistics
- **Grade Reports**: Grade distribution and analytics
- **Performance Reports**: Overall system performance metrics

## Object-Oriented Concepts Used

### 1. Encapsulation
- Private data members with public getter/setter methods
- Data validation within setter methods
- Controlled access to object properties

### 2. Inheritance
- Base `Person` class extended by `Student` and `Teacher` classes
- Common attributes and methods inherited from parent class
- Method overriding for specialized behavior

### 3. Polymorphism
- Method overloading for different parameter combinations
- Interface implementation for different report types
- Runtime polymorphism through inheritance

### 4. Abstraction
- Abstract classes for common functionality
- Interfaces for defining contracts
- Hiding implementation details from users

### 5. Composition and Aggregation
- `Student` class contains `Course` objects (composition)
- `Course` class has collection of `Student` objects (aggregation)
- Proper relationship modeling between entities

## Data Persistence

The system supports multiple data storage options:

### File-Based Storage
```java
// Example file operations
public void saveStudentsToFile(List<Student> students) {
    // Implementation for saving to text file
}

public List<Student> loadStudentsFromFile() {
    // Implementation for loading from text file
}
```

### Database Integration (Optional)
- JDBC connectivity for database operations
- Support for MySQL, PostgreSQL, SQLite
- Prepared statements for secure data access

## Exception Handling

The system includes custom exceptions:

```java
public class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}

public class InvalidGradeException extends Exception {
    public InvalidGradeException(String message) {
        super(message);
    }
}
```

## Testing

### Unit Tests
```java
@Test
public void testAddStudent() {
    StudentManagementSystem sms = new StudentManagementSystem();
    Student student = new Student("STU001", "John", "Doe", "john@email.com");
    
    sms.addStudent(student);
    assertEquals(1, sms.getStudentCount());
}
```

### Integration Tests
- Test complete workflows
- Verify data persistence
- Check system integration points

## Future Enhancements

- **Web Interface**: Develop web-based frontend using Spring Boot
- **Mobile App**: Create mobile application for students and faculty
- **Advanced Analytics**: Implement data analytics and visualization
- **Notification System**: Add email/SMS notifications for important events
- **Multi-language Support**: Internationalization for different languages
- **Cloud Integration**: Deploy system on cloud platforms
- **API Development**: RESTful API for third-party integrations
- **Security Enhancements**: Advanced authentication and authorization

## Best Practices Implemented

1. **Clean Code**: Meaningful variable names and method names
2. **SOLID Principles**: Following single responsibility, open-closed, and other principles
3. **Design Patterns**: Observer, Factory, Singleton patterns where applicable
4. **Error Handling**: Comprehensive exception handling and validation
5. **Documentation**: Inline comments and JavaDoc documentation
6. **Testing**: Unit and integration tests for reliability

## Sample Code Snippets

### Main Menu Implementation
```java
public void displayMainMenu() {
    System.out.println("=== Student Management System ===");
    System.out.println("1. Manage Students");
    System.out.println("2. Manage Courses");
    System.out.println("3. Manage Grades");
    System.out.println("4. Generate Reports");
    System.out.println("5. Exit");
    System.out.print("Enter your choice: ");
}
```

### Input Validation
```java
public boolean isValidEmail(String email) {
    String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
    return email.matches(emailRegex);
}
```

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

- **Developer**: [Your Name]
- **Email**: [your.email@example.com]
- **Project Link**: [https://github.com/yourusername/student-management-system](https://github.com/yourusername/student-management-system)

---

**Note**: This is an educational project designed to demonstrate Object-Oriented Programming concepts in Java. It serves as a learning tool for understanding software design patterns, data structures, and system architecture principles.