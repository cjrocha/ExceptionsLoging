package ro.siit.exceplog;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static ro.siit.exceplog.Randomization.*;


class StudentSorterByBirthDateTest {

    @Test
    void compare() {
        int expected, actual;
        Student o1 = new Student(randStrings(), randStrings(), randomDate(), randomGender(), randCNP());
        Student o2 = new Student(randStrings(), randStrings(), randomDate(), randomGender(), randCNP());
        System.out.println(o1);
        System.out.println(o2);
        StudentSorterByBirthDate s = new StudentSorterByBirthDate();
        if (o1.getBirthDate().compareTo(o2.getBirthDate()) > 0){
            expected = 1;
        } else{
            expected = 0;
        }
        if (s.compare(o1, o2) > 0){
            actual = 1;
        } else {
            actual = 0;
        }
        assertEquals(expected, actual);
    }
}