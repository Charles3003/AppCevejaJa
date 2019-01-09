package com.sample.cervejaj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

import javax.net.ssl.HttpsURLConnection;

import Negocio.Http_Service_NG;
import Negocio.Usuario_NG;

public class Login_MainActivity_TL extends AppCompatActivity {

    private Button btn_Logar;
    private EditText txt_Email;
    private EditText txt_Senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main_tl);

        btn_Logar = findViewById(R.id.btn_Logar);
        txt_Email = findViewById(R.id.txt_Email);
        txt_Senha = findViewById(R.id.txt_Senha);

        btn_Logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                    Usuario_NG retorno = new Http_Service_NG().execute().get();

                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }



                /*URL githubEndpoint = null;
                try {
                    githubEndpoint = new URL("https://api.github.com/");
                    HttpsURLConnection myConnection =
                            (HttpsURLConnection) githubEndpoint.openConnection();

                    myConnection.setRequestProperty("Accept",
                            "application/vnd.github.v3+json");
                    myConnection.setRequestProperty("Contact-Me",
                            "hathibelagal@example.com");

                    //if (myConnection.getResponseCode() == 200) {

                        InputStream responseBody = myConnection.getInputStream();

                        InputStreamReader responseBodyReader =
                                new InputStreamReader(responseBody, "UTF-8");

                        JsonReader jsonReader = new JsonReader(responseBodyReader);

                   // } else {
                        // Error handling code goes here
                    //}

                } catch (IOException e) {
                    e.printStackTrace();
                }*/
            }
        });
    }
}
