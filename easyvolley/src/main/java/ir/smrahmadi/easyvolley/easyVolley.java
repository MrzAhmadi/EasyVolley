package ir.smrahmadi.easyvolley;


import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class easyVolley {


    public static void sendRequest(Context context, String PageUrl, final ArrayList<String> Keys, final ArrayList<String> Values, int Method, final GetJson callback) {
        int MethodSend ;
        if (Method==0)
            MethodSend = Request.Method.POST ;
        else
            MethodSend = Request.Method.GET;

//        if(Keys==null || Values== null){
//            Keys.add("");
//            Values.add("");
//        }

        if(TextUtils.isEmpty(PageUrl)) {
            callback.onError("PageUrl is empty",4000);
            Log.i("Query Server --> ","PageUrl is empty");
            return;
        }

//        if (Keys.size()==0 || Values.size()==0){
//            callback.onError("Parameters miss",4000);
//            Log.i("Query Server --> ","Parameters miss . Keys or Values is empty");
//            return;
//        }

        if(Keys.size()!=Values.size()){

            Log.i("Query Server --> ","Keys and Values not Equales");

            callback.onError("Keys and Values not Equales",4000);

            return;
        }







        StringRequest stringRequest = new StringRequest(MethodSend, PageUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Disimissing the progress dialog

                        //Showing toast message of the response


                        Log.e("Response --> ", response);

                        callback.onSuccess(response);



                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        //Dismissing the progress dialog

                        Log.i("Query Server --> ","Not communicate");


                        try {
                            callback.onError(volleyError.toString(),volleyError.networkResponse.statusCode);
                        }catch (Exception e){}



                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {


                Map<String, String> params = new Hashtable<String, String>();

                for (int i=0;i<Keys.size();i++) {
                    params.put(Keys.get(i), Values.get(i));
                }


                //returning parameters
                return params;
            }
        };

        //Creating a Request Queue
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        //Adding easyVolley to the queue
        requestQueue.add(stringRequest);






    }



    public interface GetJson {
        void onSuccess(String result);
        void onError(String result, int errCode);
    }

    }








