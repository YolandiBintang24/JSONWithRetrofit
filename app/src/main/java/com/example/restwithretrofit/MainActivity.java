package com.example.restwithretrofit;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity {
    private TextView txtResult;
    KontakApi kontakApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtResult = (TextView) findViewById(R.id.txtResult);

        //make retrofit object for base config of retrofit

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(KontakApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        kontakApi = retrofit.create(KontakApi.class);
        putContact();
    }
    public void getAll(){
            Call<List<Kontak>> call = kontakApi.getAllContact();
            call.enqueue(new Callback<List<Kontak>>() {
                @Override
                public void onResponse(Call<List<Kontak>> call, Response<List<Kontak>> response) {
                    if(!response.isSuccessful()){
                        txtResult.setText("Code Response : "+response.code());
                        return;
                    }
                    List<Kontak> kontaks = response.body();
                    for(Kontak kontak: kontaks){
                        String content = "";
                        content+="ID    : "+kontak.getIdContact() + "\n";
                        content+="Nama  : "+kontak.getName() + "\n";
                        content+="Email : "+kontak.getEmail() + "\n";
                        content+="No HP : "+kontak.getPhone() + "\n";
                        content+="Alamat: "+kontak.getAddres() + "\n\n";

                        txtResult.append(content);
                    }
                }

                @Override
                public void onFailure(Call<List<Kontak>> call, Throwable t) {
                    txtResult.setText(t.getMessage());
                }
            });
    }
    public void getID(int id){
        Call<Kontak> call = kontakApi.getContact(id);
        call.enqueue(new Callback<Kontak>() {
            @Override
            public void onResponse(Call<Kontak> call, Response<Kontak> response) {
                if(!response.isSuccessful()){
                    txtResult.setText("Code Response : "+response.code());
                    return;
                }

               Kontak kontak = response.body();
                    String content = "";
                    content+="ID    : "+kontak.getIdContact() + "\n";
                    content+="Nama  : "+kontak.getName() + "\n";
                    content+="Email : "+kontak.getEmail() + "\n";
                    content+="No HP : "+kontak.getPhone() + "\n";
                    content+="Alamat: "+kontak.getAddres() + "\n\n";

                    txtResult.append(content);

            }

            @Override
            public void onFailure(Call<Kontak> call, Throwable t) {
                txtResult.setText(t.getMessage());
            }
        });
    }

    public void postContact(){
        Kontak isi = new Kontak ("yolandi","yolandi@gmail.com","089713","Bsd");
        Call<Kontak> call = kontakApi.saveContact(isi);
        call.enqueue(new Callback<Kontak>() {
            @Override
            public void onResponse(Call<Kontak> call, Response<Kontak> response) {
                if(!response.isSuccessful()){
                    txtResult.setText("Code Response : "+response.code());
                    return;
                }
                Kontak kontak = response.body();
                String content = "";
                content+="ID    : "+kontak.getIdContact() + "\n";
                content+="Nama  : "+kontak.getName() + "\n";
                content+="Email : "+kontak.getEmail() + "\n";
                content+="No HP : "+kontak.getPhone() + "\n";
                content+="Alamat: "+kontak.getAddres() + "\n\n";
                    txtResult.append(content);
                }


            @Override
            public void onFailure(Call<Kontak> call, Throwable t) {
                txtResult.setText(t.getMessage());
            }
        });
    }

    public void deleteContact(int id){
        Call<Void> call = kontakApi.deleteContact(id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(!response.isSuccessful()){

                    return;
                }

                txtResult.setText("Code Response : "+response.code());

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                txtResult.setText(t.getMessage());
            }
        });
    }

    public void putContact(){
        Kontak isi = new Kontak ("yolandi","yolandi@gmail.com","089713","Bsd");
        Call<Kontak> call = kontakApi.putContact(2,isi);
        call.enqueue(new Callback<Kontak>() {
            @Override
            public void onResponse(Call<Kontak> call, Response<Kontak> response) {
                if(!response.isSuccessful()){
                    txtResult.setText("Code Response : "+response.code());
                    return;
                }
                Kontak kontak = response.body();
                String content = "";
                content+="ID    : "+kontak.getIdContact() + "\n";
                content+="Nama  : "+kontak.getName() + "\n";
                content+="Email : "+kontak.getEmail() + "\n";
                content+="No HP : "+kontak.getPhone() + "\n";
                content+="Alamat: "+kontak.getAddres() + "\n\n";
                txtResult.append(content);
            }


            @Override
            public void onFailure(Call<Kontak> call, Throwable t) {
                txtResult.setText(t.getMessage());
            }
        });
    }
}
