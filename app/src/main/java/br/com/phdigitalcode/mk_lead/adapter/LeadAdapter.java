package br.com.phdigitalcode.mk_lead.adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.phdigitalcode.mk_lead.R;
import br.com.phdigitalcode.mk_lead.databinding.ListaLeadBinding;
import br.com.phdigitalcode.mk_lead.model.Lead;
import br.com.phdigitalcode.mk_lead.model.Ligacao;

public class LeadAdapter extends RecyclerView.Adapter<LeadAdapter.LeadViewHolder> {
    private List<Lead> ligacoes;
    private Context context;
    public LeadAdapter(List<Lead> ligacoes, Context context) {
        this.ligacoes = ligacoes;
        this.context = context;
    }

    @NonNull
    @Override
    public LeadViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        ListaLeadBinding binding = ListaLeadBinding.inflate(layoutInflater, parent, false);
        return new LeadViewHolder(binding);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull LeadViewHolder holder, int position) {
        Lead ligacao = ligacoes.get(position);
//        holder.imageStatus.setImageDrawable(ligacao.getStatus());
//        holder.binding.textCurso.setText(ligacao.);
        holder.binding.textNomeLead.setText(ligacao.getNome());
//        holder.binding.dataUltimaLigacao.setText(ligacao.getUltimaLigacao().
//                format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
    }

    @Override
    public int getItemCount() {
        return ligacoes.size();
    }
    public class LeadViewHolder extends RecyclerView.ViewHolder {
        ListaLeadBinding binding;
        public LeadViewHolder(ListaLeadBinding binding) {
            super((View)binding.getRoot());
            this.binding=binding;

        }
    }
}
