package com.example.giris.drdroid.fragments.diagnosefragments.adapters;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devspark.robototextview.widget.RobotoTextView;
import com.example.giris.drdroid.R;
import com.example.giris.drdroid.fragments.diagnosefragments.ShowDoctorsFragment;
import com.example.giris.drdroid.fragments.diagnosefragments.data.ShowDoctorsModel;
import com.example.giris.drdroid.libraries.LabelTextView;

import java.util.ArrayList;

/**
 * Created by Abhishek on 08-04-2016.
 */
public class ShowSlotAdapter extends RecyclerView.Adapter<ShowSlotAdapter.MyViewHolder> {
    private ArrayList<ShowDoctorsModel> dataSet;
    public ShowSlotAdapter(ArrayList<ShowDoctorsModel> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.show_slots_card, parent, false);

        view.setOnClickListener(ShowDoctorsFragment.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        LabelTextView time = holder.name;
       /* RobotoTextView area = holder.area;
        RobotoTextView addresss = holder.address;
        RobotoTextView rating = holder.rating;
        RobotoTextView specialization = holder.specialization;
        */

        time.setText("Dr. "+dataSet.get(listPosition).name);
        time.setLabelText(dataSet.get(listPosition).rating);
        time.setLabelBackgroundColor(Color.RED);

        /*area.setText("Area: "+dataSet.get(listPosition).area);
        String secondaryText = "Address: "+dataSet.get(listPosition).address+"\n"+
                "Specialization: "+dataSet.get(listPosition).specialization;
        addresss.setText(secondaryText);
    */}

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        LabelTextView name;
        RobotoTextView area;
        RobotoTextView address;
        RobotoTextView rating;
        RobotoTextView specialization;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.name = (LabelTextView) itemView.findViewById(R.id.name);
            this.area = (RobotoTextView) itemView.findViewById(R.id.area);
            this.address = (RobotoTextView) itemView.findViewById(R.id.secondary);
        }
    }
}
