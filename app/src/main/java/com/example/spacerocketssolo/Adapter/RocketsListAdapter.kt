package com.example.spacerocketssolo.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.spacerocketssolo.Model.SpaceResponse
import com.example.spacerocketssolo.R
import com.example.spacerocketssolo.Util.getProgressDrawable
import com.example.spacerocketssolo.Util.loadImage
import com.example.spacerocketssolo.View.ListFragmentDirections
import kotlinx.android.synthetic.main.item_rocket.view.*

class RocketsListAdapter (val rocketsList: ArrayList<SpaceResponse>) : RecyclerView.Adapter<RocketsListAdapter.RocketViewHolder>(){

    fun updateRocketList(newRocketList: List<SpaceResponse>) {
        rocketsList.clear()
        rocketsList.addAll(newRocketList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RocketViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_rocket, parent, false)
        return RocketViewHolder(view)
    }

    override fun getItemCount() = rocketsList.size

    override fun onBindViewHolder(holder: RocketViewHolder, position: Int) {
        holder.view.missionName.text = rocketsList[position].missionName
        holder.view.rocketName.text = rocketsList[position].rocket?.rocketName
        holder.view.launchSite.text = rocketsList[position].launchSite?.siteName
        holder.view.launchDate.text = rocketsList[position].launchDateLocal
        holder.view.setOnClickListener {
            Navigation.findNavController(it).navigate(ListFragmentDirections.actionDetailFragment())
        }
        holder.view.imageView.loadImage(rocketsList[position].links?.missionPatch, getProgressDrawable(holder.view.imageView.context))
    }

    class RocketViewHolder(var view: View) : RecyclerView.ViewHolder(view)
}