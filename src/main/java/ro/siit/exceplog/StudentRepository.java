package ro.siit.exceplog;

import java.text.*;
import java.util.*;
import java.util.logging.Logger;

public class StudentRepository {
    private static Logger logger = Logger.getLogger("exceptions.txt");
    private final Map<Long, Student> students = new HashMap<>();

    /**
     * based on student date of birth calculates the age of a student
     * format allowed for date of birth 'yyyy.mm.dd', else throws exception
     * Uses Gregorian calendar to generate current date and format date of birth.
     * @return - the age of a student
     */
    public int getAgeInYears(String firstName, String lastName, String birthDate, String gender, Long cnp) {
        //logger.info("Entered in getAgeInYear methode");
        int age = 0;
        Student student = new Student(firstName, lastName, birthDate,  gender, cnp);
        String dateOfBirth = student.getBirthDate();
        //creating a constructor of the Calendar class and passing DOB as a parameter
        DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        Calendar currentDate = new GregorianCalendar();
        try {
            Date date = dateFormat.parse(dateOfBirth);
            Calendar dob = new GregorianCalendar();
            dob.setTime(date);
            age = currentDate.get(Calendar.YEAR) - dob.get(Calendar.YEAR); //determines the year of DOB and current date
            //If current month/day is lower than birth month/day, the age is: age-1
            if ((dob.get(Calendar.MONTH) > currentDate.get(Calendar.MONTH)) ||
                    (dob.get(Calendar.MONTH) == currentDate.get(Calendar.MONTH) && dob.get(Calendar.DAY_OF_MONTH) > currentDate.get(Calendar.DAY_OF_MONTH))) {
                age--;
            }
            //For negative age we throw a new define exception
            if (age < 0 ){
                throw new NegativeAgeException();
            }

        }catch (ParseException e){
            System.err.println("Caught Parse Birth Date Exception: " + e.getMessage() + " for person with CNP: "+ cnp +". Date should have this format 'yyyy.mm.dd'");
            logger.severe("Caught Parse Birth Date Exception: " + e.getMessage() + " for person with CNP: "+ cnp +". Date should have this format 'yyyy.mm.dd'");
        }catch (NegativeAgeException e){
            System.err.println("The age for person with CNP: "+ cnp +" is: " + age);
            logger.severe("The age for person with CNP: "+ cnp +" is: " + age);
        }
        return age;
    }

    /**
     * Extending the exceptions class to handle negative age,
     * Duplicate student entry and age bellow 18.
     */
    class NegativeAgeException extends Exception{
        NegativeAgeException(){
            getMessage();
            //System.err.print("Caught Negative Age Exception! ");
            //logger.severe("Caught Negative Age Exception! ");
        }
    }
    class NotStudentAgeException extends Exception{
        NotStudentAgeException(){
            getMessage();
            //System.err.print("The age is bellow 18! This person can't be a student! ");
            //logger.severe("The age is bellow 18! This person can't be a student! ");
        }
    }
    class DuplicateEntryException extends Exception{
        DuplicateEntryException(){
            getMessage();
            //System.err.print("This student already exists! Not adding to students map! ");
            //logger.severe("This student already exists! Not adding to students map! ");
        }
    }


    /**
     * Adding students to map of students.
     * Throws exception if student is already added to map of students
     * @param firstName - students first name
     * @param lastName - students last name
     * @param birthDate - student's data of birth, allowed format 'yyyy.mm.dd'
     * @param gender - student's gender, allowed type's: Male, Female, Undeclared
     * @param cnp - student personal number
     */
    public void addStudent(String firstName, String lastName, String birthDate, String gender, Long cnp) {
        Student student = new Student(firstName, lastName, birthDate,  gender, cnp);
        try{
            if(firstName.equals("")) throw new IllegalArgumentException();
            if(lastName.equals("")) throw new IllegalArgumentException();
            if(getAgeInYears(firstName, lastName, birthDate,  gender, cnp) < 18) throw new NotStudentAgeException();
            if(students.containsKey(cnp)) {
                throw new DuplicateEntryException();
            } else {
                students.put(cnp, student);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(" The Student with CNP: "+ cnp + " needs to have a name! " + e.getMessage());
            logger.severe(" The Student with CNP: "+ cnp + " needs to have a name! ");
        } catch (NotStudentAgeException e){
            System.err.println(" Student with CNP "+ cnp +" should have 18 or more years!");
            logger.severe(" Student with CNP "+ cnp +" should have 18 or more years!");
        } catch(DuplicateEntryException e){
            System.err.println(" Student with CNP: "+ cnp +" is duplicated!");
            logger.severe(" Student with CNP: "+ cnp +" is duplicated!");
        }
    }


    public void deleteStudent(String firstName, String lastName, String birthDate, String gender, Long cnp)  {
        Student student = new Student(firstName, lastName, birthDate,  gender, cnp);
        try {
            if (cnp == null) {
                throw new NullPointerException();
            }

            if (students.containsKey(cnp)) {
                students.remove(cnp);
            } else {
                throw new NullPointerException();
            }
        } catch(NullPointerException e){
            System.err.println("Null values for CNP are not allowed! Please Fix! Nothing was removed!" + e.getMessage());
            logger.severe("Null values for CNP are not allowed or the student is not found! Please Fix! Nothing was removed!");
        }
    }

    public void displayStudentsByAge (int age) {
        Set<Student> studentsByAge = new HashSet<>();
        System.out.println("List with students that have: " + age + " years old, is: ");
        logger.info("List with students that have: " + age + " years old, is being created");
        for (Student item : students.values()) {
            if (age == getAgeInYears(item.getFirstName(), item.getLastName(), item.getBirthDate(), String.valueOf(item.getGender()), item.getCnp())) {
                studentsByAge.add(item);
            }
        }
        System.out.println(studentsByAge);
        logger.info("Listing the Students by Age order was successfull");
    }

    public void sortStudentsByLastName() {
        Set<Student> nameSortedStudents = new TreeSet<>(new StudentSorter());
        for (Map.Entry<Long, Student> item : students.entrySet()){
            nameSortedStudents.add(item.getValue());
        }
        System.out.println("Ordered by Last name the Students list is: ");
        logger.info("List with students ordered by last name is being created");
        System.out.println(nameSortedStudents);
        logger.info("Listing the Students ordered by last name was successfull");
    }

    public void sortStudentsByBirthDate() {
        Set<Student> nameSortedStudentsByDate = new TreeSet<>(new StudentSorterByBirthDate());
        for (Map.Entry<Long, Student> item : students.entrySet()){
            nameSortedStudentsByDate.add(item.getValue());
        }
        System.out.println("Ordered by birth date the Students list is: ");
        logger.info("Listing the Students ordered by birth date is being created");
        System.out.println(nameSortedStudentsByDate);
        logger.info("Listing the Students ordered by birth date was successfull");
    }
}
