package br.com.phdigitalcode.mk_lead.endpoint;

import java.util.List;

import br.com.phdigitalcode.mk_lead.model.Funcionario;
import br.com.phdigitalcode.mk_lead.model.Lead;
import br.com.phdigitalcode.mk_lead.model.Ligacao;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LeadEndPoint {
    public static final String URL_BASE ="";
    @GET("leads")
    Call<List<Lead>> listLead();
    @GET("ligacao")
    Call<List<Ligacao>> listLigacao(Funcionario funcionario);
    @FormUrlEncoded
    @POST("leads")
    boolean selectLead(@Field("lead_id") Long leadId, @Field("funcionario_id")Long funcionarioId);
}
