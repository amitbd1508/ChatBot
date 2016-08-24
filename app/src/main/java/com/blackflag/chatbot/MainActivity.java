package com.blackflag.chatbot;

import android.app.DownloadManager;
import android.app.VoiceInteractor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public String url="http://iftiarahmed.com/amit/bot.php?user_name=_user_name&message=_message&firstName=_firstName&lastName=_lastName&gender=_gender";

    Message userMessage;
    EditText et;
    public  MessageAdapter messageAdapter ;
    ArrayList<Message> messages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messages=new ArrayList<Message>();

        RecyclerView rv=(RecyclerView)findViewById(R.id.recycleview);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(linearLayoutManager);
         messageAdapter=new MessageAdapter(messages);
        rv.setAdapter(messageAdapter);

         et=(EditText)findViewById(R.id.etMessage);
        Button bt=(Button)findViewById(R.id.send);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userMessage=new Message("m","amitbd",et.getText().toString(),"Ghosh","Amit");
                messages.add(userMessage);
                messageAdapter.notifyDataSetChanged();
                getMessage(userMessage);
                et.setText("");


            }
        });
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {



            }
        });





    }




    void initUrl()
    {
        url="http://iftiarahmed.com/amit/bot.php?user_name=_user_name&message='_message'&firstName=_firstName&lastName=_lastName&gender=_gender";
    }
    public void getMessage( Message  msg)
    {

        initUrl();
        url = url.replace("_user_name",msg.getName());
        url = url.replace("_message",msg.getMessage());
        url = url.replace("_firstName","Amit");
        url = url.replace("_lastName","Ghosh");
        url = url.replace("_gender","m");
        Log.d("url",url);

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_SHORT).show();
                        try {
                            Message newMessage=new Message();
                            String status=response.getString("success");
                            String errorMessage=response.getString("errorMessage");

                            if(status=="1") {
                                JSONObject detailMessage = response.getJSONObject("message");
                                newMessage.emotion = detailMessage.getString("emotion");
                                newMessage.message = detailMessage.getString("message");
                                newMessage.chatbotName = detailMessage.getString("chatBotName");
                                messages.add(newMessage);
                                messageAdapter.notifyDataSetChanged();
                            }



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volly Error","VollyError");
                    }
                });
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());

        requestQueue.add(request);



    }
}
