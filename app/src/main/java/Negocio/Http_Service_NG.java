package Negocio;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

public class Http_Service_NG extends AsyncTask<Void, Void, Usuario_NG> {

    @Override
    protected Usuario_NG doInBackground(Void... voids) {
        StringBuilder resposta = new StringBuilder();
        try {
            URL url = new URL("http://192.168.108.241:7010/api/Login?pEmail=charlesdevelop@hotmail.com&pSenha=30031");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-type", "application/xml");
            connection.setRequestProperty("Accept", "application/xml");
            connection.setDoOutput(true);
            connection.setConnectTimeout(5000);
            connection.connect();

            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                resposta.append(scanner.next());
            }

            Gson gson = new Gson();
            Usuario_NG user = gson.fromJson(resposta.toString(), Usuario_NG.class);

            Scanner scanner1 = null;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.getMessage();
        }
        return new Gson().fromJson(resposta.toString(), Usuario_NG.class);
    }
}