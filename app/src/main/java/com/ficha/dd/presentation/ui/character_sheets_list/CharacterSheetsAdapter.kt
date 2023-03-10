package com.ficha.dd.presentation.ui.character_sheets_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ficha.dd.databinding.CharacterSheetItemBinding
import com.ficha.dd.domain.CharacterSheet

class CharacterSheetsAdapter() :
    RecyclerView.Adapter<CharacterSheetsAdapter.ViewHolder>() {

    private val characters: MutableList<CharacterSheet> = mutableListOf()

    fun setItems(charactersSheetList: List<CharacterSheet>) {
        characters.clear()
        characters.addAll(charactersSheetList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = CharacterSheetItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = characters[position]
        holder.bind(character)
    }

    class ViewHolder(private val itemBinding: CharacterSheetItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind (character : CharacterSheet) = with(itemBinding) {
            this.characterName.text = character.name
            this.characterLevel.text = character.level.toString()
            this.characterClassy.text = character.classy
        }
    }
}