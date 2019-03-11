package com.beinChannels.app.ui

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.beinChannels.app.R
import com.beinChannels.app.data.Channel
import com.beinChannels.app.data.ChannelsOperations
import com.beinChannels.app.data.PreferenceHelper
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : Activity(), ChannelsAdapter.IChannelsCallback {
    override fun openPlayer(channel: Channel) {
        val intent = Intent(this, PlayerActivity::class.java)
        intent.putExtra(
            "channelUrl",
            ChannelsOperations(PreferenceHelper(this)).getChannelUrl(channelId = channel.channelId)
        )
        intent.putExtra("channelName", channel.channelName)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val adapter = ChannelsAdapter(this)

        ChannelRv.setHasFixedSize(true)
        ChannelRv.layoutManager = LinearLayoutManager(this)
        adapter.setChannels(this)
        ChannelRv.adapter = adapter

        edit.setOnClickListener { showDialog() }
    }

    private fun showDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_view, null)
        val userNameTv = dialogView.findViewById<EditText>(R.id.userNameTv)
        val passwordTv = dialogView.findViewById<EditText>(R.id.passwordTv)

        MaterialAlertDialogBuilder(this)
            .setTitle(resources.getString(R.string.app_name))
            .setView(dialogView)
            .setPositiveButton("Save") { dialogInterface: DialogInterface?, _: Int ->

                if(!TextUtils.isEmpty(userNameTv.text.toString())
                    &&!TextUtils.isEmpty(passwordTv.text)){
                    val helper = PreferenceHelper(this)
                    Log.i("BeinChannels", "Name : ${userNameTv.text}")
                    Log.i("BeinChannels", "Pass: ${passwordTv.text}")
                    helper.userName = userNameTv.text.toString()
                    helper.password = passwordTv.text.toString()
                    dialogInterface?.cancel()
                    Toast.makeText(this,"Info Saved",Toast.LENGTH_LONG).show()
                }
            }.setNegativeButton("Cancel") { dialogInterface: DialogInterface?, _: Int ->
                Log.i("BeinChannels", "Canceled")
                dialogInterface?.cancel()
            }.show()
    }

}
