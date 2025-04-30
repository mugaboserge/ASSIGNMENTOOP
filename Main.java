public class Main {
    public static void main(String[] args) {
        Teacher t1 = new Teacher("T001", "Ms. Alice", "Early Childhood Educator");
        Teacher t2 = new Teacher("T002", "Mr. Ben", "Assistant");
        Teacher t3 = new Teacher("T003", "Ms. Claire", "Early Childhood Educator");

        BabyClass baby = new BabyClass("BC01");
        MiddleClass middle = new MiddleClass("MC01");
        TopClass top = new TopClass("TC01");

        baby.assignTeacher(t1);
        middle.assignTeacher(t2);
        top.assignTeacher(t3);

        Student s1 = new Student("S001", "Liam", 2, "Guardian A");
        Student s2 = new Student("S002", "Emma", 3, "Guardian B");
        Student s3 = new Student("S003", "Noah", 4, "Guardian C");
        Student s4 = new Student("S004", "Ava", 5, "Guardian D");

        baby.enrollStudent(s1);
        middle.enrollStudent(s2);
        top.enrollStudent(s3);
        top.enrollStudent(s4);

        baby.conductActivity("Singing songs");
        middle.conductActivity("Basic counting");
        top.conductActivity("Reading practice");
        top.addAssessment("Term 1 Test");

        baby.trackProgress();
        middle.trackProgress();
        top.trackProgress();

        baby.generateClassReport();
        middle.generateClassReport();
        top.generateClassReport();
    }
}