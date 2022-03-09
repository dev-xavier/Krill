package com.xavier.krill

import android.os.Bundle
import com.xavier.krill.base.ViewBindingActivity
import com.xavier.krill.databinding.ActivityMainBinding

class MainActivity : ViewBindingActivity<ActivityMainBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, BrowseFragment())
            .commit()
    }
}