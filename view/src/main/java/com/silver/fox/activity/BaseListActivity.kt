package com.silver.fox.activity

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.silver.fox.view.R
import kotlinx.android.synthetic.main.view_activity_list.*
import java.util.*

abstract class BaseListActivity : AppCompatActivity() {
    internal var activityMap: MutableMap<String, Class<*>> =
        HashMap()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_activity_list)
        initItem()
        val adapter: ArrayAdapter<*> =
            ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                ArrayList(activityMap.keys)
            )
        lv.adapter = adapter
        lv.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            if (view is TextView) {
                val s = view.text.toString()
                startActivity(Intent(this@BaseListActivity, activityMap[s]))
            }
        }
    }

    protected abstract fun initItem()
}