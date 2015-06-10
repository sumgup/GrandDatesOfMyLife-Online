package com.sumitgup.granddatesofmylife;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import android.os.AsyncTask;
/**
 * Created by Sumit.Gupta on 6/9/2015.
 */
public class SaveAsyncTask extends AsyncTask<MyDate, Void, Boolean> {

    @Override
    protected Boolean doInBackground(MyDate... arg0) {
        try
        {
            MyDate myDate = arg0[0];

            QueryBuilder qb = new QueryBuilder();

            HttpClient httpClient = new DefaultHttpClient();
            HttpPost request = new HttpPost(qb.buildDatesSaveURL());

            StringEntity params =new StringEntity(qb.createDate(myDate));
            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);

            if(response.getStatusLine().getStatusCode()<205)
            {
                return true;
            }
            else
            {
                return false;
            }
        } catch (Exception e) {
            //e.getCause();
            String val = e.getMessage();
            String val2 = val; // Adding coment
            return false;
        }
    }

}
