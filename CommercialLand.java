import java.util.Date;

public class CommercialLand extends Land {

    public CommercialLand(String landId, String ownerName, String location, double sizeInAcres, Date registrationDate, String landUseStatus) {
        super(landId, ownerName, location, sizeInAcres, registrationDate, landUseStatus);
    }

    @Override
    public boolean validateOwnership() {
        return ownerName != null && !ownerName.trim().isEmpty();
    }

    @Override
    public boolean checkZoningCompliance() {
        return location.toLowerCase().contains("commercial");
    }

    @Override
    public double calculateTax() {
        return 10000 * sizeInAcres * 0.025;
    }

    @Override
    public String generateLandReport() {
        return String.format("""
        ── Commercial Land Report ──
        ID: %s | Owner: %s
        Location: %s | Size: %.2f acres
        Status: %s
        Ownership Valid: %b
        Zoning Compliant: %b
        Tax: $%.2f
        """, landId, ownerName, location, sizeInAcres, landUseStatus,
                validateOwnership(), checkZoningCompliance(), calculateTax());
    }
}
