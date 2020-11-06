package com.example.catsanddogs.dashboard.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.catsanddogs.R
import com.example.catsanddogs.models.CatCollection
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_content.view.*

class ContentAdapter : RecyclerView.Adapter<ContentAdapter.ContentViewHolder>() {

    private val catCollectionList = listOf(
        CatCollection.generateCats1(),
        CatCollection.generateCats2(),
        CatCollection.generateCats3(),
        CatCollection.generateCats4(),
        CatCollection.generateCats5()
    )

    private lateinit var listener: Listener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        return ContentViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_content, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return catCollectionList.size
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        holder.bind(catCollection = catCollectionList[position], listener = listener)
    }

    fun bindListener(listener: Listener) {
        this.listener = listener
    }

    class ContentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(catCollection: CatCollection, listener: Listener) {
            with(itemView) {
                Picasso.get()
                    .load(catCollection.cats[0].imageUrl)
                    .into(ivContent)
                ivContent.setOnClickListener {
                    listener.onClickItem(catCollection)
                }
            }
        }
    }

    interface Listener {
        fun onClickItem(catCollection: CatCollection)
    }

}

