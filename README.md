Exceptions and logging

Create a student repository which supports:

- add student

    * exceptions when validating conditions mentioned bellow

- delete student (by ID)

    * exceptions: ID is empty, student does not exist

- retrieve all students with Age X (for each student the age must be calculated, not stored in a field).

    * exceptions: age is not a number, age is negative

- (optional) list students order by Last Name or Birth Date

    * exceptions: any input is empty

These methods must validate inputs and throw exceptions if necessary.

For each Student the following information needs to be collected:

- First Name

- Last Name

- Date of Birth

- Gender

- ID (CNP)


The following validations are expected:

- date of birth between 1900 and current year - 18

- first name and last name should not be empty

- gender should be male or female (or M and F), upper/lower case should both be accepted


For all the validations, the corresponding exception(s) should be thrown when a Student is created with data which breaks the validation constraint.
The testing application can demonstrate the implementation of the above requirements without requiring a special menu for creating the students or for choosing the operation. Just create several test methods which perform separately a given scenario.
Additionally, you should use Logger for tracing and error handling.