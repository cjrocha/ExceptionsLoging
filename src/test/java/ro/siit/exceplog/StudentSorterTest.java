package ro.siit.exceplog;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static ro.siit.exceplog.Randomization.*;

class StudentSorterTest {

    @Test
    void compare() {
        int expected, actual;
        Student o1 = new Student(randStrings(), randStrings(), randomDate(), randomGender(), randCNP());
        Student o2 = new Student(randStrings(), randStrings(), randomDate(), randomGender(), randCNP());
        StudentSorter s = new StudentSorter();
        if (o1.getLastName().compareTo(o2.getLastName()) > 0){
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
