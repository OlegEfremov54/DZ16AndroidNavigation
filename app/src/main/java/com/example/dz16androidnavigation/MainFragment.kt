package com.example.dz16androidnavigation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController

import com.example.dz16androidnavigation.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private var buttonSwitcher: ButtonSwitcher? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        buttonSwitcher = context as ButtonSwitcher
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        buttonSwitcher?.switchUpButton(false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.redBtn.setOnClickListener {
            buttonSwitcher?.switchUpButton(true)
            val action = MainFragmentDirections.actionMainFragmentToLightFragment("СТОП!", R.color.red, R.color.black)
            val extras = FragmentNavigatorExtras(
                binding.redBtn to "btn"
            )
            findNavController().navigate(action, extras)

        }
        binding.yellowBtn.setOnClickListener {
            buttonSwitcher?.switchUpButton(true)
            val action = MainFragmentDirections.actionMainFragmentToLightFragment("Внимание!", R.color.yellow, R.color.black)
            val extras = FragmentNavigatorExtras(
                binding.yellowBtn to "btn"
            )
            findNavController().navigate(action, extras)
        }
        binding.greenBtn.setOnClickListener {
            buttonSwitcher?.switchUpButton(true)
            val action = MainFragmentDirections.actionMainFragmentToLightFragment("Движение разрешено!", R.color.green, R.color.black)
            val extras = FragmentNavigatorExtras(
                binding.greenBtn to "btn"
            )
            findNavController().navigate(action, extras)
        }
    }


}

