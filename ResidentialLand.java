import java.util.Date;

public class ResidentialLand extends Land {
    private int residentialUnits;

    public ResidentialLand(String landId, String ownerName, String location, double sizeInAcres, Date registrationDate, String landUseStatus, int residentialUnits) {
        super(landId, ownerName, location, sizeInAcres, registrationDate, landUseStatus);
        this.residentialUnits = residentialUnits;
    }

    @Override
    public boolean validateOwnership() {
        return ownerName != null && !ownerName.trim().isEmpty();
    }

    @Override
    public boolean checkZoningCompliance() {
        return residentialUnits <= sizeInAcres * 2;
    }

    @Override
    public double calculateTax() {
        return 8000 * sizeInAcres * 0.015;
    }

    @Override
    public String generateLandReport() {
        return String.format("""
        ── Residential Land Report ──
        ID: %s | Owner: %s
        Location: %s | Size: %.2f acres | Units: %d
        Status: %s
        Ownership Valid: %b
        Zoning Compliant: %b
        Tax: $%.2f
        """, landId, ownerName, location, sizeInAcres, residentialUnits, landUseStatus,
                validateOwnership(), checkZoningCompliance(), calculateTax());
    }
}
