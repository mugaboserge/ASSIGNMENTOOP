// ReconMission.java
import java.util.*;

public class ReconMission extends Mission {

    public ReconMission(String id, String name, Date start, Date end, String status) {
        super(id, name, start, end, status);
    }

    @Override
    public void assignTask() {
        if (assignedPersonnel.size() < 2) {
            System.out.println("Error: At least two personnel must be assigned to the ReconMission.");
            return;
        }
        System.out.println("Recon tasks assigned to personnel.");
    }

    @Override
    public void allocateResources(List<Resource> availableResources) {
        for (Resource res : availableResources) {
            if (res.getResourceName().equalsIgnoreCase("Drone") && res.getQuantity() > 0) {
                allocatedResources.add(res);
                res.setQuantity(res.getQuantity() - 1);
                System.out.println("Allocated Drone to ReconMission.");
                return;
            }
        }
        System.out.println("Error: No drones available for ReconMission.");
    }

    @Override
    public void trackMissionProgress() {
        System.out.println("Tracking ReconMission progress...");
        status = "IN_PROGRESS";
    }

    @Override
    public void generateMissionReport() {
        System.out.println("--- Recon Mission Report ---");
        System.out.println("Mission Name: " + missionName);
        System.out.println("Status: " + status);
        System.out.println("Personnel Assigned: " + assignedPersonnel.size());
        System.out.println("Resources Allocated: " + allocatedResources.size());
    }
}
