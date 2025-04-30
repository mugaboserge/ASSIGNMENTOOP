import java.util.ArrayList;
import java.util.List;

public class LandRegistry {
    private List<Land> lands = new ArrayList<>();

    public void addLand(Land land) {
        lands.add(land);
    }

    public void showAllReports() {
        for (Land land : lands) {
            System.out.println(land.generateLandReport());
        }
    }

    public void searchByOwner(String ownerName) {
        lands.stream()
                .filter(land -> land.getOwnerName().equalsIgnoreCase(ownerName))
                .forEach(land -> System.out.println(land.generateLandReport()));
    }

    public void searchByLocation(String location) {
        lands.stream()
                .filter(land -> land.getLocation().toLowerCase().contains(location.toLowerCase()))
                .forEach(land -> System.out.println(land.generateLandReport()));
    }
}

