import java.util.Date;

public class AgriculturalLand extends Land {

    public AgriculturalLand(String landId, String ownerName, String location, double sizeInAcres, Date registrationDate, String landUseStatus) {
        super(landId, ownerName, location, sizeInAcres, registrationDate, landUseStatus);
    }

    @Override
    public boolean validateOwnership() {
        return ownerName != null && !ownerName.trim().isEmpty();
    }

    @Override
    public boolean checkZoningCompliance() {
        return location.toLowerCase().contains("farm") && sizeInAcres >= 1.0;
    }

    @Override
    public double calculateTax() {
        return 5000 * sizeInAcres * 0.01;
    }

    @Override
    public String generateLandReport() {
        return String.format("""
        ── Agricultural Land Report ──
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
