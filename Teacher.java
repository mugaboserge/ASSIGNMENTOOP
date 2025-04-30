public class Teacher {
    public String teacherId;
    public String teacherName;
    public String teacherRole;
    public NurseryClass assignedClass;

    public Teacher(String teacherId, String teacherName, String teacherRole) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherRole = teacherRole;
    }
}