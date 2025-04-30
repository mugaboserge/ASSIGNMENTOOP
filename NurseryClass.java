import java.util.ArrayList;
import java.util.List;

public abstract class NurseryClass {
    private String classId;
    private String className;
    private int maxCapacity;
    private Teacher assignedTeacher;
    private List<Student> students = new ArrayList<>();
    private List<String> activities = new ArrayList<>();
    private String progressNote = "";

    public NurseryClass(String classId, String className, int maxCapacity) {
        this.classId = classId;
        this.className = className;
        this.maxCapacity = maxCapacity;
    }

    public abstract boolean isTeacherValid(Teacher teacher);
    public abstract void enrollStudent(Student student);
    public abstract void trackProgress();
    public abstract void conductActivity(String activityName);
    public abstract void generateClassReport();

    public void assignTeacher(Teacher teacher) {
        if (isTeacherValid(teacher)) {
            this.assignedTeacher = teacher;
            teacher.assignedClass = this;
            System.out.println("✅ Teacher assigned to " + className);
        } else {
            System.out.println("❌ Invalid teacher role for " + className);
        }
    }

    public String getClassName() {
        return className;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public Teacher getAssignedTeacher() {
        return assignedTeacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<String> getActivities() {
        return activities;
    }

    public String getProgressNote() {
        return progressNote;
    }

    public void setProgressNote(String progressNote) {
        this.progressNote = progressNote;
    }
}
