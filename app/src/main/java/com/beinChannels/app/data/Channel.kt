package com.beinChannels.app.data

class Channel(
    val channelId: Long,
    val channelName: String,
    val channelGroupName: String
){
    override fun toString(): String {
        return "ChannelName : $channelName"
    }
}