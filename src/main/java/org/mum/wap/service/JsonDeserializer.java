package org.mum.wap.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.mum.wap.model.RoutePoint;


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

            lstRoutPoints= (List<RoutePoint>)parser.parse(pJsonStr);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return lstRoutPoints;

    }
}
