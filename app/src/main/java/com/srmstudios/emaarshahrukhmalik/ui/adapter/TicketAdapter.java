package com.srmstudios.emaarshahrukhmalik.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.srmstudios.emaarshahrukhmalik.R;
import com.srmstudios.emaarshahrukhmalik.data.model.response.GenderResponse;
import com.srmstudios.emaarshahrukhmalik.ui.adapter.model.Ticket;
import com.srmstudios.emaarshahrukhmalik.util.Utils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Shahrukh Malik on 12/28/2017.
 */

public class TicketAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Ticket> tickets;
    private Utils utils;

    public TicketAdapter(List<Ticket> tickets, Utils utils){
        this.tickets = tickets;
        this.utils = utils;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.ticket_item,parent,false);
        TickerViewHolder tickerViewHolder = new TickerViewHolder(v);
        return tickerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Ticket ticket = this.tickets.get(position);
        if(holder instanceof TickerViewHolder) {
            TickerViewHolder tickerViewHolder = (TickerViewHolder) holder;
            tickerViewHolder.txtTicketNumber.setText(utils.getStringFromResourceId(R.string.ticket_number)+
                    String.valueOf(ticket.getTicketNumber()));
            tickerViewHolder.spinnerGender.setAdapter(new GenderSpinnerAdapter(ticket.getGenders()));
            tickerViewHolder.spinnerAge.setAdapter(new AgeSpinnerAdapter(ticket.getAgeList()));
            if(ticket.getSelectedGender() != null){
                tickerViewHolder.spinnerGender.setSelection(getSpinnerPositionByGenderName(ticket.getGenders(),ticket.getSelectedGender()));
            }
            tickerViewHolder.spinnerAge.setSelection(getSpinnerPositionByAge(ticket.getAgeList(),ticket.getSelectedAge()));
            if(ticket.getName() != null) {
                tickerViewHolder.edtName.setText(ticket.getName());
            }
        }
    }

    @Override
    public int getItemCount() {
        return tickets.size();
    }

    public List<Ticket> getTickets(){
        return tickets;
    }

    public void add(Ticket ticket){
        this.tickets.add(ticket);
        notifyItemInserted(tickets.size());
    }

    public void removeLast(){
        this.tickets.remove(tickets.size()-1);
        notifyItemRemoved(tickets.size());
    }

    public class TickerViewHolder extends RecyclerView.ViewHolder implements TextWatcher{
        @BindView(R.id.txtTicketNumber)
        TextView txtTicketNumber;
        @BindView(R.id.spinnerGender)
        protected Spinner spinnerGender;
        @BindView(R.id.spinnerAge)
        protected Spinner spinnerAge;
        @BindView(R.id.edtName)
        protected EditText edtName;

        public TickerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            edtName.addTextChangedListener(this);
            spinnerGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    tickets.get(getLayoutPosition()).setSelectedGender(tickets.get(getLayoutPosition()).getGenders().get(i).getDescription());
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
            spinnerAge.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    tickets.get(getLayoutPosition()).setSelectedAge(tickets.get(getLayoutPosition()).getAgeList().get(i));
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            tickets.get(getLayoutPosition()).setName(charSequence.toString());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    }

    private int getSpinnerPositionByGenderName(List<GenderResponse> genders,String name){
        for(int i=0;i<genders.size();i++){
            if(genders.get(i).getDescription().equals(name)){
                return i;
            }
        }
        return 0;
    }

    private int getSpinnerPositionByAge(List<Integer> ageList,int age){
        for(int i=0;i<ageList.size();i++){
            if(ageList.get(i) == age){
                return i;
            }
        }
        return 0;
    }

}

















