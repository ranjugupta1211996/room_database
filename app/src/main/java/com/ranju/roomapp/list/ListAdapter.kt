package com.ranju.roomapp.list

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.ranju.roomapp.R
import com.ranju.roomapp.data.remote.model.Baseurl
import com.ranju.roomapp.data.remote.model.Group
import kotlinx.android.synthetic.main.row_layout.view.*

data class GroupWithBaseUrl(
    val group: Group,
    val baseurl: Baseurl
)

class ListAdapter : RecyclerView.Adapter<ListAdapter.ListviewHolder>() {
    inner class ListviewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    private val diffCallback = object : DiffUtil.ItemCallback<GroupWithBaseUrl>() {
        override fun areItemsTheSame(
            oldItem: GroupWithBaseUrl,
            newItem: GroupWithBaseUrl
        ): Boolean {
            return oldItem.group.id == newItem.group.id
        }

        override fun areContentsTheSame(
            oldItem: GroupWithBaseUrl,
            newItem: GroupWithBaseUrl
        ): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    fun submitList(list: List<GroupWithBaseUrl>) {
        differ.submitList(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListviewHolder {
        return ListviewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ListviewHolder, position: Int) {
        val currentItem = differ.currentList[position]
        holder.itemView.firstNameValue.text = currentItem.group.crop_group_name
        if (currentItem.group.group_type.equals("1")) {
            holder.itemView.lastNameValue.text = "crop group"
            holder.itemView.imageView.load("${currentItem.baseurl.crop_group}/${currentItem.group.crop_group_img}") {
                transformations(CircleCropTransformation())
                Log.d( "ADAPTER", "onBindViewHolder: "+currentItem.baseurl.crop_group+"/"+currentItem.group.crop_group_img)
            }

        } else if (currentItem.group.group_type.equals("2")) {
            holder.itemView.lastNameValue.text = "mandatory group"
            holder.itemView.imageView.load("${currentItem.baseurl.mandatory_group}/${currentItem.group.crop_group_img}") {
                transformations(CircleCropTransformation())
                Log.d( "ADAPTER", "onBindViewHolder: "+currentItem.baseurl.mandatory_group+"/"+currentItem.group.crop_group_img)
            }
        } else if (currentItem.group.group_type.equals("3")) {
            holder.itemView.lastNameValue.text = "krushi group"
        } else if (currentItem.group.group_type.equals("4")){
            holder.itemView.lastNameValue.text = "dealer group"
            holder.itemView.imageView.load("${currentItem.baseurl?.dealer_group}/${currentItem.group.crop_group_img}") {
                transformations(CircleCropTransformation())
                Log.d( "ADAPTER", "onBindViewHolder: "+currentItem.baseurl.dealer_group+"/"+currentItem.group.crop_group_img)
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}