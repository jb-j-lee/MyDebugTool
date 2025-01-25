package com.myjb.dev.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.myjb.dev.databinding.DebugDrawerBinding
import io.palaima.debugdrawer.DebugDrawer
import io.palaima.debugdrawer.actions.ActionsModule
import io.palaima.debugdrawer.actions.ButtonAction
import io.palaima.debugdrawer.actions.SpinnerAction
import io.palaima.debugdrawer.actions.SwitchAction
import io.palaima.debugdrawer.commons.BuildModule
import io.palaima.debugdrawer.commons.DeviceModule
import io.palaima.debugdrawer.commons.NetworkModule
import io.palaima.debugdrawer.commons.SettingsModule
import io.palaima.debugdrawer.fps.FpsModule
import io.palaima.debugdrawer.logs.LogsModule
import io.palaima.debugdrawer.network.quality.NetworkQualityModule
import io.palaima.debugdrawer.scalpel.ScalpelModule
import io.palaima.debugdrawer.timber.TimberModule
import jp.wasabeef.takt.Seat
import jp.wasabeef.takt.Takt
import timber.log.Timber

class DebugDrawerActivity : AppCompatActivity() {
    private val binding by lazy {
        DebugDrawerBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        enableDebugDrawable()
    }

    private fun enableDebugDrawable() {
        Timber.e("enableDebugDrawable")

        val switchAction = SwitchAction("Test switch") {
            Toast.makeText(this, "Switch checked", Toast.LENGTH_LONG).show()
        }

        val buttonAction = ButtonAction("Test button") {
            Toast.makeText(this, "Button clicked", Toast.LENGTH_LONG).show()
        }

        val spinnerAction = SpinnerAction(
            listOf("First", "Second", "Third")
        ) {
            Toast.makeText(this, "Spinner item selected - $it", Toast.LENGTH_LONG).show()
        }

        DebugDrawer.Builder(this).modules(
            BuildModule(),
            DeviceModule(),

            NetworkModule(),
            NetworkQualityModule(this),

            FpsModule(Takt.stock(application).seat(Seat.CENTER)),
            ScalpelModule(this),

            LogsModule(),
            TimberModule(application.packageName + ".provider"),

            SettingsModule(),

            ActionsModule(switchAction, buttonAction, spinnerAction),
        ).build()
    }
}