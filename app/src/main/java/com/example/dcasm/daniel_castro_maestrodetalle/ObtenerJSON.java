package com.example.dcasm.daniel_castro_maestrodetalle;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dcasm on 14/02/2017.
 */

public class ObtenerJSON {

    private HttpURLConnection conn;
    public static final int CONNECTION_TIMEOUT = 10 * 1000;

    public ObtenerJSON() {
        this.conn = null;
    }

    public JSONArray sendRequest(String link) throws JSONException {

        JSONArray jArray = null;

        try {
            URL url = new URL(link);

            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(CONNECTION_TIMEOUT);
            conn.setConnectTimeout(CONNECTION_TIMEOUT);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.connect();

            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {

                InputStream is = conn.getInputStream();
                InputStreamReader isReader = new InputStreamReader(is, "UTF-8");
                BufferedReader reader = new BufferedReader(isReader);

                String result = "";
                String line = null;
                StringBuilder sb = new StringBuilder();

                while ((line = reader.readLine()) != null)
                    sb.append(line + "\n");

                reader.close();
                isReader.close();
                is.close();

                result = sb.toString();

                try {
                    jArray = new JSONArray(result);
                    return jArray;
                } catch (JSONException e) {
                    Log.e("ERROR => ", "Error convirtiendo los datos a JSON: " + e.toString());
                    e.printStackTrace();
                    return null;
                }
            }
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
        return jArray;
    }
}
