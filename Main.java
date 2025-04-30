import java.util.*;

public class Main {
    public static void main(String[] args) {
        Personnel p1 = new Personnel("P001", "Alice", "Scout");
        Personnel p2 = new Personnel("P002", "Bob", "Scout");

        Resource drone = new Resource("R001", "Drone", 1, "Equipment");
        List<Resource> resources = new ArrayList<>();
        resources.add(drone);

        Calendar cal = Calendar.getInstance();
        cal.set(2025, Calendar.APRIL, 22);
        Date startDate = cal.getTime();
        cal.set(2025, Calendar.APRIL, 25);
        Date endDate = cal.getTime();

        Mission reconMission = new ReconMission("M001", "Border Surveillance", startDate, endDate, "PLANNED");
        reconMission.addPersonnel(p1);
        reconMission.addPersonnel(p2);

        if (!reconMission.validateDates()) {
            System.out.println("Invalid mission dates.");
            return;
        }

        if (reconMission.hasDuplicatePersonnel()) {
            System.out.println("Duplicate personnel found.");
            return;
        }

        reconMission.assignTask();
        reconMission.allocateResources(resources);
        reconMission.trackMissionProgress();
        reconMission.generateMissionReport();
    }
}
