package com.example.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lifecycle.databinding.ActivityMainBinding
import com.example.lifecycle.databinding.ActivityTopBinding

class Top : AppCompatActivity() {
    private lateinit var binding: ActivityTopBinding
    private lateinit var lifecycleAdapter: LifecycleAdapter
    private val lifecycleEventsList = mutableListOf<LifecycleEvent>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTopBinding.inflate(layoutInflater)
        setContentView(binding.root)
       // Toast.makeText(this, "onCreate() of Top is called", Toast.LENGTH_SHORT).show()


        lifecycleAdapter = LifecycleAdapter(LifecycleData.lifecycleEventsList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = lifecycleAdapter
        val observer = object : RecyclerView.AdapterDataObserver() {
            override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                binding.recyclerView.smoothScrollToPosition(positionStart)
            }
        }
        lifecycleAdapter.notifyItemInserted(lifecycleEventsList.lastIndex)
        //lifecycleAdapter.registerAdapterDataObserver(observer)


        binding.recyclerView.postDelayed({
            binding.recyclerView.smoothScrollToPosition(0)
        }, 100)

        binding.recyclerView.postDelayed({
            binding.recyclerView.smoothScrollToPosition(lifecycleAdapter.itemCount - 3)
        }, 1000)
        binding.recyclerView.postDelayed({
            binding.recyclerView.smoothScrollToPosition(lifecycleAdapter.itemCount - 3)
        }, 1000)


        binding.recyclerView.postDelayed({
            binding.recyclerView.smoothScrollToPosition(lifecycleAdapter.itemCount - 1)
        }, 10000)
        addLifecycleEvent("onCreate()", "Second Activity is created")

    }
    override fun onStart() {
        super.onStart()
        //Toast.makeText(this, "onStart() of Top is called", Toast.LENGTH_SHORT).show()
        addLifecycleEvent("onStart()", "Second Activity is Started")
    }
    override fun onResume() {
        super.onResume()
       // Toast.makeText(this, "onResume() of Top is called", Toast.LENGTH_SHORT).show()
        addLifecycleEvent("onResume()", "Second Activity is Resumed")
    }

    override fun onPause() {
        super.onPause()
        //Toast.makeText(this, "onPause() of Top is called", Toast.LENGTH_SHORT).show()
        addLifecycleEvent("onPause()", "Second Activity is Paused")
    }

    override fun onStop() {
        super.onStop()
       // Toast.makeText(this, "onStop() of Top is called", Toast.LENGTH_SHORT).show()
        addLifecycleEvent("onStop()", "Second Activity is Stopped")

    }



    override fun onDestroy() {
        super.onDestroy()
       // Toast.makeText(this, "onDestroy() of Top is called", Toast.LENGTH_SHORT).show()
        addLifecycleEvent("onDestroy()", "Second Activity is Destroyed")
    }

    override fun onRestart() {
        super.onRestart()
        //Toast.makeText(this, "onRestart() of Top is called", Toast.LENGTH_SHORT).show()
        addLifecycleEvent("onRestart()", "Second Activity is Restarted")

    }
    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        //Toast.makeText(this, "onSaveInstanceState() of Top is called", Toast.LENGTH_SHORT).show()
        addLifecycleEvent("onSaveInstanceState()", "Second Activity is onSaveInstanceState")

    }

    private fun addLifecycleEvent(eventName: String, eventDescription: String) {
        val lifecycleEvent = LifecycleEvent(eventName, eventDescription)
        val insertPosition = lifecycleEventsList.size
        LifecycleData.lifecycleEventsList.add(lifecycleEvent)
        //lifecycleAdapter.notifyDataSetChanged()
        lifecycleAdapter.notifyItemInserted(insertPosition)

       // binding.recyclerView.scrollToPosition(lifecycleAdapter.itemCount - 1)


    }

}