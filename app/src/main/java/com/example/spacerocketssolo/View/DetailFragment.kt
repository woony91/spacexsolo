package com.example.spacerocketssolo.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation

import com.example.spacerocketssolo.R
import com.example.spacerocketssolo.ViewModel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.item_rocket.*

class DetailFragment : Fragment() {

    private lateinit var viewModel: DetailViewModel

    private var spaceUuid = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        viewModel.fetch()

        arguments?.let {
            spaceUuid = DetailFragmentArgs.fromBundle(it).spaceUuid
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.rocketLiveData.observe(viewLifecycleOwner, Observer { rocket ->
            rocket?.let {
                tv_mission_name.text = rocket.missionName
                tv_rocket_name.text = rocket.rocket?.rocketName
                tv_launch_site.text = rocket.launchSite?.siteName
                tv_launch_date.text = rocket.launchDateLocal
                tv_mission_details.text = rocket.details
            }
        })
    }
}
