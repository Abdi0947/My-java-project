import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;


public class MainTest {
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testStudentRegistrationSystem() {
        String input = "1\nJohn\nDoe\n1234/56\nCollege of Engineering\nRegular\n123 Main St\n1\n2022\n3\n1234/56\n3\n0000/00\n4\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Main.main(new String[]{});

        String expectedOutput = "✨✨✨ Hooray! 🎉🎉 Your registration is complete, and you've unlocked a world of endless enchantment and remarkable adventures! ✨✨✨\n" +
                "NAME: JOHN     DOE\n" +
                "___________________Here is your slip---------------------------------\n" +
                "|Course--------------------------------------|ECTS|-----------|cr.hr.|-------Lectures\n" +
                "|course--1....................................| - |...........|  -   |.........|TBA\n" +
                "|course--2....................................| - |...........|  -   |.........|TBA\n" +
                "|course--3....................................| - |...........|  -   |.........|TBA\n" +
                "|course--4....................................| - |...........|  -   |.........|TBA\n" +
                "|course--5....................................| - |...........|  -   |.........|TBA\n" +
                "|course--6....................................| - |...........|  -   |.........|TBA\n" +
                " \n" +
                "\n" +
                "Please select an option:\n" +
                "1. Add a new student\n" +
                "2. Remove a student\n" +
                "3. Display student information\n" +
                "4. Exit\n" +
                "Enter your choice: Student removed: John Doe\n" +
                "\n" +
                "Please select an option:\n" +
                "1. Add a new student\n" +
                "2. Remove a student\n" +
                "3. Display student information\n" +
                "4. Exit\n" +
                "Enter your choice: Sorry, student not found with ID: 0000/00\n" +
                "\n" +
                "Please select an option:\n" +
                "1. Add a new student\n" +
                "2. Remove a student\n" +
                "3. Display student information\n" +
                "4. Exit\n" +
                "Enter your choice: Exiting the program...\n";

        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testInvalidInput() {
        String input = "invalid\n4\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Main.main(new String[]{});

        String expectedOutput = "Invalid input. Please enter a number.\n" +
                "\n" +
                "Please select an option:\n" +
                "1. Add a new student\n" +
                "2. Remove a student\n" +
                "3. Display student information\n" +
                "4. Exit\n" +
                "Enter your choice: Exiting the program...\n";

        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testInvalidIdFormat() {
        String input = "1\nJohn\nDoe\n123456\nCollege of Engineering\nRegular\n123 Main St\n1\n2022\n4\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Main.main(new String[]{});

        String expectedOutput = "Invalid ID format. Please enter the ID in the correct format (e.g., number/year).\n" +
                "\n" +
                "Please select an option:\n" +
                "1. Add a new student\n" +
                "2. Remove a student\n" +
                "3. Display student information\n" +
                "4. Exit\n" +
                "Enter your choice: Exiting the program...\n";

        Assertions.assertEquals(expectedOutput, outContent.toString());
    }
}