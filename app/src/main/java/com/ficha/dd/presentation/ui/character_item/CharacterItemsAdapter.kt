package com.ficha.dd.presentation.ui.character_item

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ficha.dd.databinding.ItemsListItemBinding
import com.ficha.dd.databinding.SpellsListItemBinding
import com.ficha.dd.domain.model.Item
import com.ficha.dd.domain.model.Spell

class CharacterItemsAdapter() :
    RecyclerView.Adapter<CharacterItemsAdapter.ViewHolder>() {

    private val items: MutableList<Item> = mutableListOf()

    fun setItems(itemsList: List<Item>?) {
        if(!itemsList.isNullOrEmpty()){
            items.clear()
            items.addAll(itemsList)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ItemsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    class ViewHolder (private val itemBinding: ItemsListItemBinding) : RecyclerView.ViewHolder(itemBinding.root){
        fun bind (item: Item) = with(itemBinding) {
            this.itemName.text = item.name
            this.itemDamage.text = item.url
            this.itemIndex.text = item.index
        }
    }
}