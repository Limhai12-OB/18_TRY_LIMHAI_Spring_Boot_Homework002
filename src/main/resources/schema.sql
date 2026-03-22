
CREATE DATABASE my_hw_school;

-- Students table
CREATE TABLE students (
                          student_id SERIAL PRIMARY KEY,
                          student_name VARCHAR(100) NOT NULL,
                          email VARCHAR(100) UNIQUE,
                          phone_number VARCHAR(20)
);

-- Instructors table
CREATE TABLE instructors (
                             instructor_id SERIAL PRIMARY KEY,
                             instructor_name VARCHAR(100) NOT NULL,
                             email VARCHAR(100) UNIQUE
);

-- Courses table
CREATE TABLE courses (
                         course_id SERIAL PRIMARY KEY,
                         course_name VARCHAR(100) NOT NULL,
                         description TEXT,
                         instructor_id INT,
                         CONSTRAINT fk_instructor
                             FOREIGN KEY (instructor_id)
                                 REFERENCES instructors(instructor_id)
                                 ON DELETE SET NULL
);


