package com.example.strollers.strollers.UnitTests;

import android.content.Context;
import android.location.Location;

import com.example.strollers.strollers.BuildConfig;
import com.example.strollers.strollers.Helpers.RouteHelper;
import com.example.strollers.strollers.Models.Destination;
import com.example.strollers.strollers.Models.DestinationComparator;
import com.example.strollers.strollers.Models.Destinations;
import com.example.strollers.strollers.Utilities.GenerateRoutesUtility;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static junit.framework.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class CalorieTest {

    private Context context = RuntimeEnvironment.application;
    private Location sampleLocation;
    private Double sampleDistance;
    private static final String results = "results";

    @Before
    public void setup() {
        sampleLocation = new Location("Test");
        sampleLocation.setLatitude(42.7309885);
        sampleLocation.setLongitude(-73.6820253);
        sampleDistance = RouteHelper.convertMilesToMeters(10.0);

    }

    @Test
    public void calorieChecker() throws ExecutionException, InterruptedException, JSONException, IOException {
        GenerateRoutesUtility testRoute = new GenerateRoutesUtility();
        String data = testRoute.getJson("AIzaSyCnF4sg6MaCkXXYs8LUNcf8hRWI5eJ4XpI", "distance", sampleLocation, sampleDistance);
        JSONObject responseOb = new JSONObject(data);
        responseOb.getJSONArray(results);

        /* Serialize JSON into Destination and add to list */
        Destinations destinations = Destinations.parseJson(data);
        destinations.initializeDistances(sampleLocation.getLatitude(), sampleLocation.getLongitude());

        String file = "/calorieCheck.txt";
        InputStream is = context.getAssets().open(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;
        List<Destination> destsList = destinations.getDestsList();

        Comparator<Destination> destComparator = new DestinationComparator();
        Collections.sort(destsList, destComparator);

        Iterator<Destination> iter = destsList.iterator();
        while (iter.hasNext()) {
            Destination d = iter.next();
            Double calsBurned = (d.getDistance() * 102.6);
            if (650 >= calsBurned) {
                iter.remove();
            }
        }

        for (int i = 0; i < destsList.size(); i++) {
            line = reader.readLine();
            assertEquals(line, destsList.get(i).getName());
            line = reader.readLine();
            assertEquals(line, destsList.get(i).getDistance().toString());
        }
    }
}
