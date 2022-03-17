package ro.siit.exceplog;

import java.util.logging.Logger;

/**
 * Student Repository that calculates age based on birthdate and
 * allows user to add, delete, list the content based on: age of student and sort the content
 * based on: student last name and/or student birthdate.
 *
 * Throws exceptions for: student empty name (first or last),
 * student birthdate wrong format, student wrong gender, student
 * with no CNP(id).
 * Throws custom exceptions for: age not suitable for a student (lower than 18 years),
 * student's age negative, student's duplicates.
 *
 ** Maybe a scanner will make all this code look a bit different **
 * @author Andrei Chirila
 */
public class ApplicationStart {
    private static Logger logger = Logger.getLogger("exceptions.txt");

    public static void main(String[] args)  {
        int n = 0;
        logger.info("start main");
        StudentRepository myStudents = new StudentRepository();

        //adding content to students map
        logger.info("Adding Content to Student Repository");
        myStudents.addStudent("PE","MT","2023.03.04", "Male", 159l);
        myStudents.addStudent("St","Rt","04/03.2005", "FEMALE", 1930303L);
        myStudents.addStudent("Sm","Re","1996.03.04", "MALE", 1950306L);
        myStudents.addStudent("Sr","Ro","1994.03.04", "male", 1940304L);
        myStudents.addStudent("Se","Rb","1995.03.04", "female", 1950305L);
        myStudents.addStudent("Se","Rb","1995.03.04", "male", 1950305L);
        logger.info("Added entries to Student Repository");

        //delete content from student map
        logger.info("Deleting from Student Repository");
        myStudents.deleteStudent("Sr", "Ro", "1994.03.04", "MALE", 1940304L);
        logger.info("Delete process ended");

        //Display students with particular age
        logger.info("Displaying Students by age");
        myStudents.displayStudentsByAge(26);

        //Display students sorted by last name
        logger.info("Displaying list sorted by Last Name");
        myStudents.sortStudentsByLastName();

        //Display students sorted by birthdate
        logger.info("Displaying list sorted by Birth Date");
        myStudents.sortStudentsByBirthDate();
    }
}

