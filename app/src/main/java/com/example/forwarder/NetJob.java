package com.example.forwarder;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NetJob extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String[] params) {
        Log.i("job", Arrays.toString(params));
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(params[2]);
        try {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
            nameValuePairs.add(new BasicNameValuePair("NO.", params[0]));
            nameValuePairs.add(new BasicNameValuePair("msg", params[1]));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs, HTTP.UTF_8));
            httpclient.execute(httppost);
            Log.i("OK", "no exception");
        } catch (ClientProtocolException e) {
            Log.e("e", e.getMessage());
        } catch (IOException e) {
            Log.e("e", e.getMessage());
        }
        return "";
    }

    @Override
    protected void onPostExecute(String message) {
        //process message
    }
}