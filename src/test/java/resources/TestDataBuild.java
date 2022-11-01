package resources;

import pojo.AddPlace;
import pojo.Location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {

    public AddPlace addPlacePayload() {

        AddPlace place = new AddPlace();
        place.setAccuracy(50);
        place.setAddress("29, side layout, cohen 09");
        place.setLanguage("French-IN");
        place.setPhone_number("(+91) 983 893 9191");
        place.setWebsite("https://www.rahulshetty.com");
        place.setName("Frontline house");
        List<String> myList = new ArrayList<>();
        myList.add("show park");
        myList.add("shop");

        place.setTypes(myList);
        Location location = new Location();
        location.setLat(-38.383494);
        location.setLng(33.427362);
        place.setLocation(location);
        return place;
    }
}
