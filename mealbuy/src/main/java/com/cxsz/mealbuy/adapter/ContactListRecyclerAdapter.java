package com.cxsz.mealbuy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cxsz.mealbuy.R;
import com.cxsz.mealbuy.bean.ContactBean;

import java.util.ArrayList;

/**
 * 联系人列表显示适配器
 */
public class ContactListRecyclerAdapter extends RecyclerView.Adapter<ContactListRecyclerAdapter.ViewHolder> {

    public ArrayList<ContactBean> mobiles = new ArrayList<ContactBean>();//勾选的联系人列表

    public ContactListRecyclerAdapter(ArrayList<ContactBean> mobiles) {
        this.mobiles = mobiles;
    }

    public void refreshContacts(ArrayList<ContactBean> contactBeans) {
        if (!this.mobiles.isEmpty()) {
            this.mobiles.clear();
        }
        this.mobiles.addAll(contactBeans);
        notifyDataSetChanged();
    }

    public void checkAll() {
        initCheck(true);
        notifyDataSetChanged();
    }

    public void unCheckAll() {
        initCheck(false);
        notifyDataSetChanged();
    }

    private void initCheck(boolean isCheck) {
        for (int i = 0; i < mobiles.size(); i++) {
            mobiles.set(i, new ContactBean(mobiles.get(i).getContactPhoneNumber(), isCheck));
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.contactPhoneNumber.setText(mobiles.get(position).getContactPhoneNumber() + "");
        holder.chooseContactItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mobiles.set(position, new ContactBean(mobiles.get(position).getContactPhoneNumber(), isChecked));
            }
        });
        holder.chooseContactItem.setChecked(mobiles.get(position).isCheck());
    }


    @Override
    public int getItemCount() {
        return this.mobiles.size();
    }

    public void deleteContact() {
        for (int i = 0; i < mobiles.size(); i++) {
            if (mobiles.get(i).isCheck()) {
                mobiles.remove(i);
                i--;
            }
        }
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView contactPhoneNumber;
        public CheckBox chooseContactItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            contactPhoneNumber = itemView.findViewById(R.id.contact_phone_number);
            chooseContactItem = itemView.findViewById(R.id.choose_contact_item);
        }
    }
}
