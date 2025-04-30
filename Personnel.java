public class Personnel {
    private String personnelId;
    private String personnelName;
    private String personnelRole;
    private Mission assignedMission;

    public Personnel(String id, String name, String role) {
        this.personnelId = id;
        this.personnelName = name;
        this.personnelRole = role;
    }

    public String getPersonnelId() { return personnelId; }
    public String getPersonnelName() { return personnelName; }
    public String getPersonnelRole() { return personnelRole; }
    public Mission getAssignedMission() { return assignedMission; }
    public void setAssignedMission(Mission mission) { this.assignedMission = mission; }
}
