package resources.enums;

public enum APIResources {

    ADDPLACEAPI("maps/api/place/add/json"),
    GETPLACEAPI("maps/api/place/get/json"),
    DELETEPLACEAPI("maps/api/place/DELETE/json");

     public String url;

    private final String RESOURCE;

    APIResources(final String RESOURCE) {
        this.RESOURCE = RESOURCE;
    }

    public String getResource() {
        return RESOURCE;
    }
}
