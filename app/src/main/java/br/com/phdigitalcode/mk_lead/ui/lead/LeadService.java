package br.com.phdigitalcode.mk_lead.ui.lead;

import com.google.gson.Gson;
import com.google.gson.internal.GsonBuildConfig;

import java.util.List;
import java.util.Optional;

import br.com.phdigitalcode.mk_lead.endpoint.CallbackLeadEndPoint;
import br.com.phdigitalcode.mk_lead.endpoint.LeadEndPoint;
import br.com.phdigitalcode.mk_lead.model.Funcionario;
import br.com.phdigitalcode.mk_lead.model.Lead;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LeadService {
    private Retrofit retrofit;
    private LeadEndPoint leadEndPoint;
    public LeadService() {
        retrofit = new Retrofit.Builder()
                .baseUrl(LeadEndPoint.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.leadEndPoint =retrofit.create(LeadEndPoint.class);
    }

    public Optional<List<Lead>> capturaListaLead(){
        Optional<List<Lead>> list = null;
        Call<List<Lead>> listCall = leadEndPoint.listLead();
        listCall.enqueue(new CallbackLeadEndPoint(list));
        return list;
    }
    public boolean selectLead(Lead lead, Funcionario funcionario){
        return  leadEndPoint.selectLead(lead.getId(),funcionario.getId());
    }
}
