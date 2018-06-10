package com.relfor.demodesignjune;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class PersonViewHolder extends RecyclerView.ViewHolder {
    TextView txtName, txtAddress, txtPhone;

    public PersonViewHolder(View itemView) {
        super(itemView);
        txtName = itemView.findViewById(R.id.txt_name);
        txtAddress = itemView.findViewById(R.id.txt_address);
        txtPhone = itemView.findViewById(R.id.txt_phone);
    }
}
