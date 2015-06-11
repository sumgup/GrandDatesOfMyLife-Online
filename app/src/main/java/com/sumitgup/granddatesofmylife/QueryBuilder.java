package com.sumitgup.granddatesofmylife;

/**
 * Created by Sumit.Gupta on 6/9/2015.
 */
public class QueryBuilder {

    /**
     * Specify your database name here
     * @return
     */
    public String getDatabaseName() {
        return "granddatesofmylife";
    }

    /**
     * Specify your MongoLab API here
     * @return
     */
    public String getApiKey() {
        return "Mki0i9USzNmtv-UOtCcfTKoyqGNlGI8S";
    }

    /**
     * This constructs the URL that allows you to manage your database,
     * collections and documents
     * @return
     */
    public String getBaseUrl()
    {
        return "https://api.mongolab.com/api/1/databases/"+getDatabaseName()+"/collections/";
    }

    /**
     * Completes the formating of your URL and adds your API key at the end
     * @return
     */
    public String docApiKeyUrl()
    {
        return "?apiKey="+getApiKey();
    }

    /**
     * Returns the docs101 collection
     * @return
     */
    public String documentRequest()
    {
        return "myDates";
    }

    /**
     * Builds a complete URL using the methods specified above
     * @return
     */
    public String buildDatesSaveURL()
    {
        return getBaseUrl()+documentRequest()+docApiKeyUrl();
    }


    public String createDate(MyDate myDate)
    {
        return String
                .format("{\"document\"  : {\"date\": \"%s\", "
                                + "\"description\": \"%s\"}, \"safe\" : true}",
                        myDate.date, myDate.description);
    }
}
