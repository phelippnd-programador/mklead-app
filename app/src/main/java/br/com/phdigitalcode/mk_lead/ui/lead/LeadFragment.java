package br.com.phdigitalcode.mk_lead.ui.lead;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import br.com.phdigitalcode.mk_lead.adapter.LeadAdapter;
import br.com.phdigitalcode.mk_lead.databinding.FragmentLeadBinding;

public class LeadFragment extends Fragment {
    private LeadViewModel leadViewModel;
    private FragmentLeadBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        leadViewModel =new ViewModelProvider(this).get(LeadViewModel.class);
        binding = FragmentLeadBinding.inflate(inflater,container,false);
        View root = binding.getRoot();
        leadViewModel.getLeads().observe(getViewLifecycleOwner(),leads->{
            leads.ifPresent(lead->{
                LeadAdapter adapter = new LeadAdapter(lead,getContext());
                binding.recyclerView.setAdapter(adapter);
            });
        });
        return root;
    }
}
