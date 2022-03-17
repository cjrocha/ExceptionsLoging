package ro.siit.exceplog;

import java.util.Objects;

public  class Student {

    private final String firstName;
    private final String lastName;
    private final String birthDate;
    private final Gender gender;
    private final Long cnp;

    /**
     * Constructor for object student
     * @param firstName - student first name
     * @param lastName - student last name
     * @param birthDate - student date of birth, should have 'yyyy.mm.dd' format
     * @param gender - gender of the student is an enumerator with available options: Male, Female or Undeclared. Not case sensitive!
     * @param id - student personal id (long)
     */
    public Student(String firstName, String lastName, String birthDate, String gender, Long id) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.birthDate = birthDate;
            this.cnp = id;
            this.gender = Gender.valueOf(gender.toUpperCase());
    }

    /**
     * Override of equals and hashCode methods to remove duplicates
     * from the students map generated in StudentRepository
     * @param o - the student object
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(birthDate, student.birthDate) &&
                gender == student.gender &&
                Objects.equals(cnp, student.cnp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthDate, gender, cnp);
    }

    /**
     * Getters for student object
     * @return
     */
    public Long getCnp() {
        return cnp;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Gender getGender() {
        return gender;
    }

    /**
     * Translates the object student into readable data
     * @return
     */
    @Override
    public String toString() {
        StudentRepository n = new StudentRepository();
        return  "First name= " + firstName +
                ", Last name= " + lastName +
                ", Birth date= " + birthDate +
                ", Gender= " + gender +
                ", CNP= " + cnp + ", Age= " + n.getAgeInYears(firstName, lastName, birthDate, String.valueOf(gender), cnp) +
                '.';
    }
}