import java.util.List;
import java.util.ArrayList;

public class TopClass extends NurseryClass {
    private List<String> assessments = new ArrayList<>();

    public TopClass(String classId) {
        super(classId, "Top Class", 25);
    }

    public boolean isTeacherValid(Teacher teacher) {
        return teacher.teacherRole != null;
    }

    public void enrollStudent(Student student) {
        if (student.getAge() < 4 || student.getAge() > 5) {
            System.out.println("❌ Invalid age for Top Class");
        } else if (getStudents().size() >= getMaxCapacity()) {
            System.out.println("❌ Top Class is full");
        } else if (student.getRegisteredClass() != null) {
            System.out.println("❌ Student already registered in another class");
        } else {
            getStudents().add(student);
            student.setRegisteredClass(this);
            System.out.println("✅ Student enrolled in Top Class");
        }
    }

    public void trackProgress() {
        setProgressNote("Preparing students for reading, writing, and arithmetic.");
    }

    public void conductActivity(String activityName) {
        getActivities().add(activityName);
        System.out.println("📗 Activity conducted: " + activityName);
    }

    public void addAssessment(String assessment) {
        assessments.add(assessment);
        System.out.println("📑 Assessment added: " + assessment);
    }

    public void generateClassReport() {
        System.out.println("\n📗 Top Class Report");
        System.out.println("Teacher: " + (getAssignedTeacher() != null ? getAssignedTeacher().teacherName : "None"));
        System.out.println("Students: " + getStudents().size());
        System.out.println("Activities: " + String.join(", ", getActivities()));
        System.out.println("Assessments: " + String.join(", ", assessments));
        System.out.println("Progress: " + getProgressNote());
    }
}
