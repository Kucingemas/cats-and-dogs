package com.example.catsanddogs.detail.view

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.squareup.picasso.Picasso


class DetailViewPagerAdapter() : PagerAdapter() {
    private var context: Context? = null
    private var imageUrls: List<String> = listOf()

    fun setItems(
        context: Context?,
        imageUrls: List<String>
    ) {
        this.context = context
        this.imageUrls = imageUrls
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return imageUrls.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imageView = ImageView(context)
        Picasso.get()
            .load(imageUrls[position])
            .into(imageView)
        container.addView(imageView)
        return imageView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}