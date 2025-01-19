package com.myjb.dev.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mattprecious.telescope.EmailDeviceInfoLens
import com.mattprecious.telescope.TelescopeLayout
import com.myjb.dev.R
import com.myjb.dev.databinding.TelescopeBinding

class TelescopeActivity : AppCompatActivity() {
    private val binding by lazy {
        TelescopeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        configureTelescope()

        binding.toggleVibrate.setOnCheckedChangeListener { _, bool ->
            binding.telescopeLayout.setVibrate(bool)
        }

        binding.radioGroupFingers.setOnCheckedChangeListener { _, id ->
            val count = when (id) {
                R.id.fingers_count_2 -> 2
                R.id.fingers_count_3 -> 3
                R.id.fingers_count_4 -> 4
                R.id.fingers_count_5 -> 5
                else -> 3
            }
            binding.telescopeLayout.setPointerCount(count)
        }
    }

    private fun configureTelescope() {
        // Clean up any old screenshots in telescope folder.
        TelescopeLayout.cleanUp(this)

        binding.telescopeLayout.apply {
            setPointerCount(3)

            setLens(
                EmailDeviceInfoLens(
                    this@TelescopeActivity,
                    "[Debug Report] Here are the screen captures and device information.",
                    "help@gmail.com"
                )
            )
        }
    }
}