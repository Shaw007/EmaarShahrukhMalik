package com.srmstudios.emaarshahrukhmalik.ui.adapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.srmstudios.emaarshahrukhmalik.R;
import com.srmstudios.emaarshahrukhmalik.data.model.response.GenderResponse;
import com.srmstudios.emaarshahrukhmalik.data.model.response.VisitorTypeResponse;
import com.srmstudios.emaarshahrukhmalik.ui.adapter.model.Ticket;
import com.srmstudios.emaarshahrukhmalik.ui.adapter.model.TotalTicketPurchase;
import com.srmstudios.emaarshahrukhmalik.util.Utils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Shahrukh Malik on 12/28/2017.
 */

public class VisitorTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<VisitorTypeResponse> visitorTypes;
    private List<GenderResponse> genders;
    private Utils utils;
    private ITicketTypeInfoCallback iTicketTypeInfoCallback;
    private int totalTickets = 0;

    public VisitorTypeAdapter(List<VisitorTypeResponse> visitorTypes,List<GenderResponse> genders,Utils utils,ITicketTypeInfoCallback iTicketTypeInfoCallback){
        this.visitorTypes = visitorTypes;
        this.genders = genders;
        this.utils = utils;
        this.iTicketTypeInfoCallback = iTicketTypeInfoCallback;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.visitor_type_item,parent,false);
        VisitorTypeViewHolder visitorTypeViewHolder = new VisitorTypeViewHolder(v);
        return visitorTypeViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        VisitorTypeResponse visitorType = this.visitorTypes.get(position);
        if(holder instanceof VisitorTypeViewHolder){
            VisitorTypeViewHolder visitorTypeViewHolder = (VisitorTypeViewHolder) holder;
            if(visitorType.getDescription() != null){
                visitorTypeViewHolder.txtDesc.setText(visitorType.getDescription());
            }
            if(visitorType.getAgeCriteria() != null){
                visitorTypeViewHolder.txtAgeLimits.setText("("+
                        utils.getStringFromResourceId(R.string.ages)+
                        " "+
                        visitorType.getAgeCriteria()+
                        ")");
            }
            if(visitorType.getPrice() == 0){
                visitorTypeViewHolder.txtPrice.setText(utils.getStringFromResourceId(R.string.free));
            }else {
                visitorTypeViewHolder.txtPrice.setText(utils.getStringFromResourceId(R.string.currency)+
                        "\r\n"+String.valueOf(visitorType.getPrice()));
            }
            if(visitorType.getTicketAdapter() != null){
                visitorTypeViewHolder.txtTicketQty.setText(String.valueOf(visitorType.getTicketAdapter().getItemCount()));
                visitorTypeViewHolder.recyclerViewTickets.setAdapter(visitorType.getTicketAdapter());
            }else {
                visitorTypeViewHolder.txtTicketQty.setText("0");
            }
            if(visitorType.getTicketType().equals("1")){
                visitorTypeViewHolder.imgInfo.setVisibility(View.VISIBLE);
            }else {
                visitorTypeViewHolder.imgInfo.setVisibility(View.INVISIBLE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return visitorTypes.size();
    }

    public List<TotalTicketPurchase> getTotalTicketsSelected(){
        List<TotalTicketPurchase> totalTicketPurchases = new ArrayList<>();
        for(VisitorTypeResponse visitorType : visitorTypes){
            if( (visitorType.getTicketAdapter() != null)) {
                if(visitorType.getTicketAdapter().getItemCount() != 0) {
                    TotalTicketPurchase t1 = new TotalTicketPurchase(visitorType.getDescription(),
                            visitorType.getTicketAdapter().getTickets());
                    totalTickets += visitorType.getTicketAdapter().getItemCount();
                    totalTicketPurchases.add(t1);
                }
            }
        }
        return totalTicketPurchases;
    }

    public class VisitorTypeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.txtDesc)
        protected TextView txtDesc;
        @BindView(R.id.txtAgeLimits)
        protected TextView txtAgeLimits;
        @BindView(R.id.txtPrice)
        protected TextView txtPrice;
        @BindView(R.id.btnMinus)
        protected Button btnMinus;
        @BindView(R.id.txtTicketQty)
        protected TextView txtTicketQty;
        @BindView(R.id.btnPlus)
        protected Button btnPlus;
        @BindView(R.id.recyclerViewTickets)
        protected RecyclerView recyclerViewTickets;
        @BindView(R.id.imgInfo)
        protected ImageView imgInfo;


        public VisitorTypeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            recyclerViewTickets.setLayoutManager(new LinearLayoutManager(itemView.getContext()));
            btnMinus.setOnClickListener(this);
            btnPlus.setOnClickListener(this);
            imgInfo.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            VisitorTypeResponse visitorType = visitorTypes.get(getLayoutPosition());
            switch (view.getId()){
                case R.id.imgInfo:{
                    iTicketTypeInfoCallback.onTicketInfoClick(visitorType.getDescription(),visitorType.getTicketContentURL());
                    break;
                }
                case R.id.btnMinus:{
                    if(visitorType.getTicketAdapter() == null){
                        return;
                    }
                    if(visitorType.getTicketAdapter().getItemCount() == 0){
                        return;
                    }
                    visitorType.getTicketAdapter().removeLast();
                    notifyItemChanged(getLayoutPosition());
                    totalTickets -= 1;
                    break;
                }
                case R.id.btnPlus:{
                    Ticket t1 = getDummnyTicket(visitorType.getMinAge(),visitorType.getMaxAge());
                    if(visitorType.getTicketAdapter() == null){
                        List<Ticket> tickets = new ArrayList<>();
                        tickets.add(t1);
                        visitorType.setTicketAdapter(new TicketAdapter(tickets,utils));
                    }else if(visitorType.getTicketAdapter().getItemCount() < 100){ // i have set max ticket limit to 100
                        visitorType.getTicketAdapter().add(t1);
                    }
                    notifyItemChanged(getLayoutPosition());
                    break;
                }
            }
        }
    }

    private Ticket getDummnyTicket(int minAge,int maxAge){
        List<Integer> ageList = new ArrayList<>();
        for(int i=minAge;i<=maxAge;i++){
            ageList.add(i);
        }

        totalTickets += 1;
        Ticket t1 = new Ticket();
        t1.setTicketNumber(totalTickets);
        t1.setMinAge(minAge);
        t1.setMaxAge(maxAge);
        t1.setAgeList(ageList);
        t1.setGenders(genders);

        t1.setName(null);

        return t1;
    }

    public interface ITicketTypeInfoCallback{
        void onTicketInfoClick(String visitorType,String htmlContent);
    }
}















