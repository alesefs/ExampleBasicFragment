package com.example.fragmentexample.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentexample.Utils.px
import com.example.fragmentexample.databinding.ItemCustomButtonBinding
import com.example.fragmentexample.models.DashboardButtonsModel
import kotlin.math.floor

class DashboardButtonAdapter(
    private val listButton: List<DashboardButtonsModel>,
    private val  width: Int,
    private val onClickListener: (buttonItem: DashboardButtonsModel) -> Unit
) : RecyclerView.Adapter<DashboardButtonAdapter.DashboardButtonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardButtonViewHolder {
        val binding = ItemCustomButtonBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return DashboardButtonViewHolder(binding, onClickListener)
    }

    override fun onBindViewHolder(holder: DashboardButtonViewHolder, position: Int) {
        holder.bind(listButton[position])

        if (listButton.size < 2) {
            // default by xml
        } else if (listButton.size == 2) {
            holder.itemBinding.itemBtnCast.maxWidth = floor(width / 2.5).toInt()
            holder.itemBinding.itemBtnCast.minimumWidth = floor(width / 2.5).toInt()
        } else {
            holder.itemBinding.itemBtnCast.maxWidth = 120.px
            holder.itemBinding.itemBtnCast.minimumWidth = 120.px
        }
    }

    override fun getItemCount(): Int = listButton.size

    class DashboardButtonViewHolder(
        val itemBinding: ItemCustomButtonBinding,
        private val onClickListener: (buttonItem: DashboardButtonsModel) -> Unit
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(item: DashboardButtonsModel) {
            itemBinding.txtBtn.text = item.title
            itemBinding.imgBtn.setImageDrawable(ContextCompat.getDrawable(itemView.context, item.image))
            itemBinding.itemBtnCast.setOnClickListener {
                onClickListener.invoke(item)
            }
        }
    }
}
