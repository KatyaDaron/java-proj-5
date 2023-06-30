import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class EducationServiceTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private InstructorDataObject instructorDataObject;

    @Mock
    private ClassDataObject classDataObject;

    @InjectMocks
    private EducationService educationService;

    @Before
    public void setUp() {
        // Set up mock behavior for instructorDataObject.getClassesByInstructor(instructorId)
        when(instructorDataObject.getClassesByInstructor("instructor1")).thenReturn(
                Arrays.asList(
                        new Class("class1", "Geometry"),
                        new Class("class2", "Environmental Science"),
                        new Class("class3", "Comparative Literature")
                )
        );

        // Set up mock behavior for classDataObject.getStudentsInClass(classId)
        when(classDataObject.getStudentsInClass("class1")).thenReturn(
                Arrays.asList(
                        new Student("Joy Ma", "class1", "Spanish"),
                        new Student("Julio Hernandez", "class1", "Algebra")
                )
        );
        when(classDataObject.getStudentsInClass("class2")).thenReturn(
                Arrays.asList(
                        new Student("Jenny Jones", "class2", "Calculus")
                )
        );
    }

    @Test
    public void testGetStudentsBySubject_ShouldReturnListOfStudents() {
        // Given
        String subject = "Algebra";
        List<Student> expectedStudents = Arrays.asList(
                new Student("Julio Hernandez", "class1", "Algebra")
        );

        // When
        List<Student> actualStudents = educationService.getStudentsBySubject(subject);

        // Then
        assertEquals(expectedStudents, actualStudents);
    }

    @Test
    public void testMarkCurrentClassesInactive_ShouldMarkGeometryClassInactive() {
        // Given
        List<Class> classes = Arrays.asList(
                new Class("class1", "Geometry"),
                new Class("class2", "Environmental Science"),
                new Class("class3", "Comparative Literature")
        );

        // When
        educationService.markCurrentClassesInactive();

        // Then
        assertEquals(false, classes.get(0).isActive());
        assertEquals(true, classes.get(1).isActive());
        assertEquals(true, classes.get(2).isActive());
    }
}