import java.util.Date;

public class IndustrialLand extends Land {
    private boolean hasEnvironmentalClearance;

    public IndustrialLand(String landId, String ownerName, String location, double sizeInAcres, Date registrationDate, String landUseStatus, boolean hasEnvironmentalClearance) {
        super(landId, ownerName, location, sizeInAcres, registrationDate, landUseStatus);
        this.hasEnvironmentalClearance = hasEnvironmentalClearance;
    }

    @Override
    public boolean validateOwnership() {
        return ownerName != null && !ownerName.trim().isEmpty();
    }

    @Override
    public boolean checkZoningCompliance() {
        return location.toLowerCase().contains("industrial") && hasEnvironmentalClearance;
    }

    @Override
    public double calculateTax() {
        return 12000 * sizeInAcres * 0.03;
    }

    @Override
    public String generateLandReport() {
        return String.format("""
        ── Industrial Land Report ──
        ID: %s | Owner: %s
        Location: %s | Size: %.2f acres | Clearance: %b
        Status: %s
        Ownership Valid: %b
        Zoning Compliant: %b
        Tax: $%.2f
        """, landId, ownerName, location, sizeInAcres, hasEnvironmentalClearance, landUseStatus,
                validateOwnership(), checkZoningCompliance(), calculateTax());
    }
}
