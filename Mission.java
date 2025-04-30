import java.util.*;

public abstract class Mission {
    protected String missionId;
    protected String missionName;
    protected Date missionStartDate;
    protected Date missionEndDate;
    protected String status;
    protected List<Personnel> assignedPersonnel = new ArrayList<>();
    protected List<Resource> allocatedResources = new ArrayList<>();

    public Mission(String id, String name, Date start, Date end, String status) {
        this.missionId = id;
        this.missionName = name;
        this.missionStartDate = start;
        this.missionEndDate = end;
        this.status = status;
    }

    public boolean validateDates() {
        return missionStartDate.before(missionEndDate);
    }

    public boolean hasDuplicatePersonnel() {
        Set<String> ids = new HashSet<>();
        for (Personnel p : assignedPersonnel) {
            if (!ids.add(p.getPersonnelId())) return true;
        }
        return false;
    }

    public abstract void assignTask();
    public abstract void allocateResources(List<Resource> availableResources);
    public abstract void trackMissionProgress();
    public abstract void generateMissionReport();

    public void addPersonnel(Personnel p) {
        if (!assignedPersonnel.contains(p)) {
            assignedPersonnel.add(p);
            p.setAssignedMission(this);
        }
    }

    public List<Personnel> getAssignedPersonnel() {
        return assignedPersonnel;
    }
}
