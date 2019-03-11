package com.beinChannels.app.ui

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.beinChannels.app.R
import com.beinChannels.app.data.Channel
import com.beinChannels.app.data.ChannelsOperations
import com.beinChannels.app.data.PreferenceHelper

class ChannelsAdapter(private val mCallback: IChannelsCallback,
                      private val channels: ArrayList<Channel> = ArrayList())
    : RecyclerView.Adapter<ChannelsAdapter.ChannelsViewHolder>() {

    fun setChannels(context: Context) {
        channels.addAll(ChannelsOperations(PreferenceHelper(context)).getChannelsList())
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChannelsViewHolder {
        return ChannelsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_channel, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return channels.size
    }

    override fun onBindViewHolder(holder: ChannelsViewHolder, position: Int) {
        val channel = channels[position]

        holder.channelName.text = channel.channelName
        holder.arrow.setOnClickListener {
            Log.i("BeinChannels", "channel : ${channel.toString()}")
            openPlayer(channel)
        }
        holder.channelCardView.setOnClickListener {
            Log.i("BeinChannels", "channel : ${channel.toString()}")
            openPlayer(channel)
        }
    }

    private fun openPlayer(channel: Channel) {
        mCallback.openPlayer(channel)
    }


    class ChannelsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val channelCardView = itemView.findViewById<CardView>(R.id.channelCard)
        val channelName = itemView.findViewById<TextView>(R.id.channelName)
        val arrow = itemView.findViewById<ImageView>(R.id.arrow)
    }

    interface IChannelsCallback {
        fun openPlayer(channel: Channel)
    }
}