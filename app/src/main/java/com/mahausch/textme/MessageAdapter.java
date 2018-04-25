package com.mahausch.textme;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    private Context context;
    private List<TextMeMessage> messageList;


    public MessageAdapter(Context context, List<TextMeMessage> objects) {
        this.context = context;
        this.messageList = objects;
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_message, parent, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        TextMeMessage message = messageList.get(position);

        //If TextMeMessage object has PhotoURL then it is an image and gets displayed
        boolean isPhoto = message.getPhotoUrl() != null;
        if (isPhoto) {
            holder.messageTextView.setVisibility(View.GONE);
            holder.photoImageView.setVisibility(View.VISIBLE);
            Glide.with(holder.photoImageView.getContext())
                    .load(message.getPhotoUrl())
                    .into(holder.photoImageView);
        } else {
            holder.messageTextView.setVisibility(View.VISIBLE);
            holder.photoImageView.setVisibility(View.GONE);
            holder.messageTextView.setText(message.getText());
        }
        holder.nameTextView.setText(message.getName());
    }

    @Override
    public int getItemCount() {
        if (messageList == null) return 0;
        return messageList.size();
    }

    public void swapData(List<TextMeMessage> list) {
        messageList = list;
        notifyDataSetChanged();
    }


    class MessageViewHolder extends RecyclerView.ViewHolder {

        ImageView photoImageView;
        TextView messageTextView;
        TextView nameTextView;

        public MessageViewHolder(View itemView) {
            super(itemView);
            photoImageView = itemView.findViewById(R.id.photoImageView);
            messageTextView = itemView.findViewById(R.id.messageTextView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
        }

    }
}
