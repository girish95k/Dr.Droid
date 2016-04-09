package com.example.giris.drdroid.fragments.finddoctorsfragments.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.devspark.robototextview.widget.RobotoTextView;
import com.example.giris.drdroid.R;
import com.example.giris.drdroid.fragments.finddoctorsfragments.data.SlotListModel;
import com.example.giris.drdroid.fragments.finddoctorsfragments.doctorlistfragments.BookAppointmentActivity;
import com.example.giris.drdroid.fragments.finddoctorsfragments.doctorlistfragments.bookappointmentfragments.BookFragment;
import com.example.giris.drdroid.libraries.LabelTextView;
import com.rey.material.widget.Button;

import java.util.ArrayList;

/**
 * Created by Abhishek on 08-04-2016.
 */
public class SlotListAdapter extends RecyclerView.Adapter<SlotListAdapter.MyViewHolder>{
    public static Context context;

    private ArrayList<SlotListModel> dataSet;
    public SlotListAdapter(ArrayList<SlotListModel> data, Context context) {
        this.dataSet = data;
        this.context =context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.doctor_list_card, parent, false);

        view.setOnClickListener(BookFragment.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        LabelTextView name = holder.name;
        RobotoTextView area = holder.area;
        RobotoTextView addresss = holder.address;
        RobotoTextView rating = holder.rating;
        RobotoTextView specialization = holder.specialization;

        name.setText(dataSet.get(listPosition).timeslot+" PM");
        //name.setLabelText(dataSet.get(listPosition).rating);
        name.setLabelBackgroundColor(Color.RED);

       /* area.setText("Area: "+dataSet.get(listPosition).area);
        String secondaryText = "Address: "+dataSet.get(listPosition).address+"\n"+
                "Specialization: "+dataSet.get(listPosition).specialization;
        addresss.setText(secondaryText);*/
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        LabelTextView name;
        RobotoTextView area;
        RobotoTextView address;
        RobotoTextView rating;
        RobotoTextView specialization;

        Button book;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.name = (LabelTextView) itemView.findViewById(R.id.name);
            this.area = (RobotoTextView) itemView.findViewById(R.id.area);
            this.address = (RobotoTextView) itemView.findViewById(R.id.secondary);
            this.book = (Button) itemView.findViewById(R.id.button);
            this.book.setOnClickListener(this);
        }
        // onClick Listener for view
        @Override
        public void onClick(View v) {

            if (v.getId() == book.getId()){
                Toast.makeText(v.getContext(), "ITEM PRESSED = " + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
                context.startActivity(new Intent(context, BookAppointmentActivity.class));
            }
        }

    }
}
