package com.cardona.leagueteamsapp.presentation.fragments


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.cardona.leagueteamsapp.BaseApp

import com.cardona.leagueteamsapp.R
import com.cardona.leagueteamsapp.presentation.viewmodels.TeamsViewModel
import timber.log.Timber
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class TeamsListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var vm: TeamsViewModel

    override fun onAttach(context: Context) {
        (activity?.application as BaseApp).getComponent()?.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this) {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val layoutView = inflater.inflate(R.layout.fragment_teams_list, container, false)

        vm = ViewModelProvider(this, viewModelFactory)[TeamsViewModel::class.java]

        vm.commandInvokerEmitter.observe(viewLifecycleOwner, Observer { invoker ->
            Log.d("dataRoute", "fragment "+invoker.toString())
            invoker.start(layoutView)
        })

        vm.getForTeams("Spain")

        return layoutView
    }


}
