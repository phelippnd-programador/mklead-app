package br.com.phdigitalcode.mk_lead.ui.lead;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.Optional;

import br.com.phdigitalcode.mk_lead.adapter.LeadAdapter;
import br.com.phdigitalcode.mk_lead.model.Lead;

public class LeadViewModel extends ViewModel {
    private MutableLiveData<String>numberTelefone;
    private MutableLiveData<Optional<List<Lead>>> leads;
    private LeadService service;
    public LeadViewModel() {
        numberTelefone = new MutableLiveData<>();
        leads= new MutableLiveData<>();
        leads.setValue(service.capturaListaLead());

    }

    public LiveData<String> getNumberTelefone(){
        return numberTelefone;
    }
    public LiveData<Optional<List<Lead>>> getLeads(){
        return leads;
    }
}
