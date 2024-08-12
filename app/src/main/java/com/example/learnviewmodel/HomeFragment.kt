package com.example.learnviewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.learnviewmodel.databinding.FragmentHomeBinding

class  HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!
    private lateinit var signalAdapter: MyAdapter
    private fun getUserdata3(): ArrayList<MessageItem>{
        return arrayListOf(
            MessageItem(R.drawable.redarrow,
                "NIP DR/OPA/MAYOWA",
                "-NGN5,000.00",
                ""
            ),
            MessageItem(R.drawable.redarrow,
                "NIP DR/EGP/FEMI",
                "-NGN115,000.00",
                ""

            ),
            MessageItem(R.drawable.greenarrow,
                "NIP CR/EGP/BANKOLE",
                "NGN900,000.00",
                ""

            ),

            )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        signalAdapter = MyAdapter(getUserdata3())
       binding.recyclerview.apply {
           setLayoutManager(LinearLayoutManager(requireContext()))
           setHasFixedSize(true)
           setAdapter(signalAdapter)
       }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}