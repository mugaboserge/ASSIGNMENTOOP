public class BabyClass extends NurseryClass {
    public BabyClass(String classId) {
        super(classId, "Baby Class", 15);
    }

    public boolean isTeacherValid(Teacher teacher) {
        return "Early Childhood Educator".equals(teacher.teacherRole);
    }

    public void enrollStudent(Student student) {
        if (student.getAge() < 2 || student.getAge() > 3) {
            System.out.println("❌ Invalid age for Baby Class");
        } else if (getStudents().size() >= getMaxCapacity()) {
            System.out.println("❌ Baby Class is full");
        } else if (student.getRegisteredClass() != null) {
            System.out.println("❌ Student already registered in another class");
        } else {
            getStudents().add(student);
            student.setRegisteredClass(this);
            System.out.println("✅ Student enrolled in Baby Class");
        }
    }

    public void trackProgress() {
        setProgressNote("Focused on motor skills and play-based learning.");
    }

    public void conductActivity(String activityName) {
        getActivities().add(activityName);
        System.out.println("🎨 Activity conducted: " + activityName);
    }

    public void generateClassReport() {
        System.out.println("\n📘 Baby Class Report");
        System.out.println("Teacher: " + (getAssignedTeacher() != null ? getAssignedTeacher().teacherName : "None"));
        System.out.println("Students: " + getStudents().size());
        System.out.println("Activities: " + String.join(", ", getActivities()));
        System.out.println("Progress: " + getProgressNote());
    }
}
