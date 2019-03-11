package com.beinChannels.app.data

class ChannelsOperations(
    private val helper: PreferenceHelper
) {
    private val channels = ArrayList<Channel>()

    fun getChannelsList(): ArrayList<Channel> = if (channels.size == 0) {

        //=============================== SD Group =============================
        val channel1Sd = Channel(74, "Bein Sports 1 SD.", "BEIN SPORTS")
        val channel2Sd = Channel(75, "Bein Sports 2 SD.", "BEIN SPORTS")
        val channel3Sd = Channel(76, "Bein Sports 3 SD.", "BEIN SPORTS")
        val channel4Sd = Channel(77, "Bein Sports 4 SD.", "BEIN SPORTS")
        val channel5Sd = Channel(78, "Bein Sports 5 SD.", "BEIN SPORTS")
        val channel6Sd = Channel(79, "Bein Sports 6 SD.", "BEIN SPORTS")
        val channel7Sd = Channel(80, "Bein Sports 7 SD.", "BEIN SPORTS")
        val channel8Sd = Channel(81, "Bein Sports 8 SD.", "BEIN SPORTS")
        val channel9Sd = Channel(82, "Bein Sports 9 SD.", "BEIN SPORTS")
        val channel10Sd = Channel(83, "Bein Sports 10 HD.", "BEIN SPORTS")

        channels.add(channel1Sd)
        channels.add(channel2Sd)
        channels.add(channel3Sd)
        channels.add(channel4Sd)
        channels.add(channel5Sd)
        channels.add(channel6Sd)
        channels.add(channel7Sd)
        channels.add(channel8Sd)
        channels.add(channel9Sd)
        channels.add(channel10Sd)

        //=============================== HD Group =============================
        val channel1Hd = Channel(6133, "Bein Sports 1 HD.", "BEIN SPORTS")
        val channel2Hd = Channel(6134, "Bein Sports 2 HD.", "BEIN SPORTS")
        val channel3Hd = Channel(6135, "Bein Sports 3 HD.", "BEIN SPORTS")
        val channel4Hd = Channel(6136, "Bein Sports 4 HD.", "BEIN SPORTS")
        val channel5Hd = Channel(6137, "Bein Sports 5 HD.", "BEIN SPORTS")
        val channel6Hd = Channel(6138, "Bein Sports 6 HD.", "BEIN SPORTS")
        val channel7Hd = Channel(6139, "Bein Sports 7 HD.", "BEIN SPORTS")
        val channel8Hd = Channel(6140, "Bein Sports 8 HD.", "BEIN SPORTS")
        val channel9Hd = Channel(6141, "Bein Sports 9 HD.", "BEIN SPORTS")
        val channel10Hd = Channel(6142, "Bein Sports 10 HD.", "BEIN SPORTS")

        channels.add(channel1Hd)
        channels.add(channel2Hd)
        channels.add(channel3Hd)
        channels.add(channel4Hd)
        channels.add(channel5Hd)
        channels.add(channel6Hd)
        channels.add(channel7Hd)
        channels.add(channel8Hd)
        channels.add(channel9Hd)
        channels.add(channel10Hd)

        //=============================== Full HD Group =============================
        val channel1FullHd = Channel(6227, "Bein Sports 1 Full Hd.", "BEIN SPORTS")
        val channel2FullHd = Channel(6228, "Bein Sports 2 Full Hd.", "BEIN SPORTS")
        val channel3FullHd = Channel(6229, "Bein Sports 3 Full Hd.", "BEIN SPORTS")
        val channel4FullHd = Channel(6230, "Bein Sports 4 Full Hd.", "BEIN SPORTS")
        val channel5FullHd = Channel(6231, "Bein Sports 5 Full Hd.", "BEIN SPORTS")
        val channel6FullHd = Channel(6232, "Bein Sports 6 Full Hd.", "BEIN SPORTS")
        val channel7FullHd = Channel(6233, "Bein Sports 7 Full Hd.", "BEIN SPORTS")
        val channel8FullHd = Channel(6234, "Bein Sports 8 Full Hd.", "BEIN SPORTS")
        val channel9FullHd = Channel(6235, "Bein Sports 9 Full Hd.", "BEIN SPORTS")
        val channel10FullHd = Channel(6236, "Bein Sports 10 Full Hd.", "BEIN SPORTS")

        channels.add(channel1FullHd)
        channels.add(channel2FullHd)
        channels.add(channel3FullHd)
        channels.add(channel4FullHd)
        channels.add(channel5FullHd)
        channels.add(channel6FullHd)
        channels.add(channel7FullHd)
        channels.add(channel8FullHd)
        channels.add(channel9FullHd)
        channels.add(channel10FullHd)

        channels
    } else {
        channels
    }

    fun getChannelUrl(channelId: Long): String {
        return "http://apk2tv.zalhd.net:20002/live/${helper.userName}/${helper.password}/$channelId.ts"
    }
}