package br.com.phdigitalcode.mk_lead.endpoint;


import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.List;
import java.util.Optional;

import br.com.phdigitalcode.mk_lead.model.Lead;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CallbackLeadEndPoint implements Callback<List<Lead>>{
    private Optional<List<Lead>> list ;

    public CallbackLeadEndPoint(Optional<List<Lead>> list) {
        this.list = list;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onResponse(Call<List<Lead>> call, Response<List<Lead>> response) {
            if(response.isSuccessful()){
                switch (response.code()){
                    case 200:
                        list = Optional.<List<Lead>>of(response.body());
                        break;
                    default:
                        list = Optional.<List<Lead>>empty();
                }
            }
            else
            {
                list = Optional.<List<Lead>>empty();
            }

    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onFailure(Call<List<Lead>> call, Throwable t) {
        list = Optional.<List<Lead>>empty();
    }
}
