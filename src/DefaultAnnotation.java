@Default(Student.class)
public class DefaultAnnotation {
    private String faculty;

    public DefaultAnnotation() {
        this.faculty = "Computer Science";
    }

    public String getDepartment() {
        return faculty;
    }

    public void processStudent(Student student) {
        System.out.println("Обработка студента: " + student.getName() +
                ", курс: " + student.getCourse() +
                ", факультет: " + faculty);
    }
}