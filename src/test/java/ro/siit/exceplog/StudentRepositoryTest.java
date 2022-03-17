package ro.siit.exceplog;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;
import static ro.siit.exceplog.Randomization.*;

class StudentRepositoryTest {
    int expected, actual;
    Student o1 = new Student(randStrings(), randStrings(), randomDate(), randomGender(), randCNP());

    @Test
    void getAgeInYears() throws ParseException {
        String dateOfBirth = o1.getBirthDate();
        DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        Calendar currentDate = new GregorianCalendar();
        Date date = dateFormat.parse(dateOfBirth);
        Calendar dob = new GregorianCalendar();
        dob.setTime(date);
        expected = currentDate.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        StudentRepository s = new StudentRepository();
        actual = s.getAgeInYears(o1.getFirstName(), o1.getLastName(), o1.getBirthDate(), String.valueOf(o1.getGender()), o1.getCnp());
        if (expected-1 == actual){
            assertEquals(expected-1, actual);
        } else{
            assertEquals(expected, actual);
        }
    }
}