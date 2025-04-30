public class MiddleClass extends NurseryClass {
    public MiddleClass(String classId) {
        super(classId, "Middle Class", 20);
    }

    public boolean isTeacherValid(Teacher teacher) {
        return teacher.teacherRole != null;
    }

    public void enrollStudent(Student student) {
        if (student.getAge() < 3 || student.getAge() > 4) {
            System.out.println("❌ Invalid age for Middle Class");
        } else if (getStudents().size() >= getMaxCapacity()) {
            System.out.println("❌ Middle Class is full");
        } else if (student.getRegisteredClass() != null) {
            System.out.println("❌ Student already registered in another class");
        } else {
            getStudents().add(student);
            student.setRegisteredClass(this);
            System.out.println("✅ Student enrolled in Middle Class");
        }
    }

    public void trackProgress() {
        setProgressNote("Focused on language development and basic counting.");
    }

    public void conductActivity(String activityName) {
        getActivities().add(activityName);
        System.out.println("📘 Activity conducted: " + activityName);
    }

    public void generateClassReport() {
        System.out.println("\n📘 Middle Class Report");
        System.out.println("Teacher: " + (getAssignedTeacher() != null ? getAssignedTeacher().teacherName : "None"));
        System.out.println("Students: " + getStudents().size());
        System.out.println("Activities: " + String.join(", ", getActivities()));
        System.out.println("Progress: " + getProgressNote());
    }
}