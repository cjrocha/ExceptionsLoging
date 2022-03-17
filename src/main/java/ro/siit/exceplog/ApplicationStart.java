package ro.siit.exceplog;

import java.util.logging.Logger;

/**
 *
 */
public class ApplicationStart {
    private static Logger logger = Logger.getLogger("exceptions.txt");

    public static void main(String[] args)  {
        int n = 0;
        logger.info("start main");
        StudentRepository myStudents = new StudentRepository();
        logger.info("Adding Content to Student Repository");
        myStudents.addStudent("PE","MT","2023.03.04", "Male", 159l);
        n++;
        myStudents.addStudent("St","Rt","04/03.2005", "FEMALE", 1930303L);
        n++;
        myStudents.addStudent("Sm","Re","1996.03.04", "MALE", 1950306L);
        n++;
        myStudents.addStudent("Sr","Ro","1994.03.04", "male", 1940304L);
        n++;
        myStudents.addStudent("Se","Rb","1995.03.04", "female", 1950305L);
        n++;
        myStudents.addStudent("Se","Rb","1995.03.04", "male", 1950305L);
        n++;
        logger.info("Added "+n+" entries to Student Repository");
        myStudents.deleteStudent("Sr", "Ro", "1994.03.04", "MALE", 1940304L);

        logger.info("Displaying Students by age");
        //myStudents.deleteStudent("Sr","Ro","1994.03.04", "male", 1940304L);
        myStudents.displayStudentsByAge(28);
        logger.info("Displaying list sorted by Last Name");
        myStudents.sortStudentsByLastName();
        logger.info("Displaying list sorted by Birth Date");
        myStudents.sortStudentsByBirthDate();
    }
}

