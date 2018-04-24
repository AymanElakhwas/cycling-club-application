package org.mum.wap.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.mum.wap.model.RoutePoint;
import java.util.Iterator;

import java.util.List;


/**
 *
 * @author Abdelrahman
 *
 */


public class JsonDeserializer {

    public static List<RoutePoint> deserializeRoutePoints(String pJsonStr){

        List<RoutePoint> lstRoutPoints=null;

        JSONParser parser = new JSONParser();
        try {

            JSONObject jsonObject = (JSONObject) parser.parse(pJsonStr);


            JSONArray lang= (JSONArray) jsonObject.get("RoutePoints");

            Iterator i = lang.iterator();

            while (i.hasNext()) {

                JSONObject innerObj = (JSONObject) i.next();

                System.out.println("language "+ innerObj.get("lat") +
                        " with level " + innerObj.get("long"));

            }


        } catch (ParseException e) {
            e.printStackTrace();
        }
        return lstRoutPoints;

    }
}
