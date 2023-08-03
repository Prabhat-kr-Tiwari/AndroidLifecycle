package com.example.lifecycle

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Prabhat","BlankFragment: onCreate()")
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("Prabhat","BlankFragment: onCreateView()")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }
    override fun onStart() {
        super.onStart()

        Toast.makeText(requireContext(), "onStart() of MainActivity is called", Toast.LENGTH_SHORT).show()
        Log.d("Prabhat","BlankFragment: onStart()")
    }
    override fun onResume() {
        super.onResume()
        Toast.makeText(requireContext(), "onResume() of MainActivity is called", Toast.LENGTH_SHORT).show()
        Log.d("Prabhat","BlankFragment: onResume()")
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(requireContext(), "onPause() of MainActivity is called", Toast.LENGTH_SHORT).show()
        Log.d("Prabhat","BlankFragment: onCreate()")
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(requireContext(), "onStop() of MainActivity is called", Toast.LENGTH_SHORT).show()
        Log.d("Prabhat","BlankFragment: onPause()")

    }



    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(requireContext(), "onDestroy() of MainActivity is called", Toast.LENGTH_SHORT).show()
        Log.d("Prabhat","BlankFragment: onDestroy()")
    }



    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Toast.makeText(requireContext(), "onSaveInstanceState() of MainActivity is called", Toast.LENGTH_SHORT).show()
        Log.d("Prabhat","BlankFragment: onSaveInstanceState()")

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}