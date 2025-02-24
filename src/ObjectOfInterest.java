public class ObjectOfInterest {
    private String title;
    private String detailDescription;
    private boolean isOwnedByInstitution;
    private boolean canBeAuctioned;
    private String objectType;

    // Constructors
    public ObjectOfInterest() {}

    public ObjectOfInterest(String title, String detailDescription, boolean isOwnedByInstitution,
                            boolean canBeAuctioned, String objectType) {
        this.title = title;
        this.detailDescription = detailDescription;
        this.isOwnedByInstitution = isOwnedByInstitution;
        this.canBeAuctioned = canBeAuctioned;
        this.objectType = objectType;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetailDescription() {
        return detailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }

    public boolean isOwnedByInstitution() {
        return isOwnedByInstitution;
    }

    public void setOwnedByInstitution(boolean ownedByInstitution) {
        isOwnedByInstitution = ownedByInstitution;
    }

    public boolean isCanBeAuctioned() {
        return canBeAuctioned;
    }

    public void setCanBeAuctioned(boolean canBeAuctioned) {
        this.canBeAuctioned = canBeAuctioned;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    // UML method
    public void displayInfo() {
        // TODO implement
    }
}
