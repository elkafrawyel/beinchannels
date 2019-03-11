package com.beinChannels.app.ui

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.beinChannels.app.R
import com.iptv.player.SurfaceSize
import com.iptv.player.VlcPlayerActivity
import com.iptv.player.components.Component
import com.iptv.player.components.UIView
import com.iptv.player.components.controllers.ControllersPresenter
import com.iptv.player.components.controllers.ControllersView
import com.iptv.player.components.loading.LoadingPresenter
import com.iptv.player.components.loading.LoadingView
import com.iptv.player.components.signalStrength.SignalStrengthPresenter
import com.iptv.player.components.signalStrength.SignalStrengthView

class PlayerActivity : VlcPlayerActivity() {


    var url: String? = ""
    var name: String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_player)

        url = intent?.extras?.getString("channelUrl")
        name = intent?.extras?.getString("channelName")

        Log.i("BeinChannels", "channelUrl : $url")
        Log.i("BeinChannels", "channelName : $name")

        playChannel()
    }

    private fun playChannel() {
        if (url != "" && name != "") {
            setScreenSize(SurfaceSize.SURFACE_FILL)
            setAndPlay(url)
        }
    }

    override fun getComponents(): MutableList<Component<UIView>> {
        val components = ArrayList<Component<UIView>>()

//        val controllersViewComponent = Component<ControllersView>(
//            ControllersView(),
//            ViewModelProviders.of(this).get(ControllersPresenter::class.java)
//        )

        val loadingViewComponent = Component<LoadingView>(
            LoadingView(),
            ViewModelProviders.of(this).get(LoadingPresenter::class.java)
        )

        val signalStrengthViewComponent = Component<SignalStrengthView>(
            SignalStrengthView(),
            ViewModelProviders.of(this).get(SignalStrengthPresenter::class.java)
        )

//        components.add(controllersViewComponent as Component<UIView>)
        components.add(loadingViewComponent as Component<UIView>)
        components.add(signalStrengthViewComponent as Component<UIView>)

        return components
    }

}
