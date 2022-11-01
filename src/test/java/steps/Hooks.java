package steps;


import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {

    @Before("@DeletePlace")
    public void beforeScenario() throws IOException {

        PlaceValidationDefinitions placeValidationDefinitions = new PlaceValidationDefinitions();
        if(PlaceValidationDefinitions.id == null) {
            placeValidationDefinitions.add_place_payload_with("Anne", "portuguese","Bernado Reiter");
            placeValidationDefinitions.user_calls_with_post_http_request("ADDPLACEAPI", "POST");
            placeValidationDefinitions.verify_place_id_created_maps_to_using("Anne", "GETPLACEAPI");
        }
    }
}
