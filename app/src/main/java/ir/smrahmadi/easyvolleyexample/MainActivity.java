package ir.smrahmadi.easyvolleyexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

import ir.smrahmadi.easyvolley.easyVolley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> keys= new ArrayList<String>();
        ArrayList<String> values= new ArrayList<String>();


        easyVolley.sendRequest(this, "https://api.androidhive.info/volley/person_object.json", keys, values, 1, new easyVolley.GetJson() {
            @Override
            public void onSuccess(String result) {
                // your Code is here

            }

            @Override
            public void onError(String result, int errCode) {
                // your code is here
            }
        });
    }
}
