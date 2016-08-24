package com.blackflag.chatbot;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by BlackFlag on 7/14/2016.
 */
public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageHolder> {


    ArrayList<Message> messages;

    public MessageAdapter(ArrayList<Message> messages) {
        this.messages = messages;
    }

    @Override
    public MessageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.message,parent,false);
        MessageHolder ch=new MessageHolder(v);
        return ch;
    }

    @Override
    public void onBindViewHolder(MessageHolder holder, int position) {

        holder.message.setText(messages.get(position).getMessage());
        holder.name.setText(messages.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class MessageHolder extends RecyclerView.ViewHolder{

        TextView name,message;

        public MessageHolder(View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.name);
            message=(TextView)itemView.findViewById(R.id.messageBody);
        }
    }
}
