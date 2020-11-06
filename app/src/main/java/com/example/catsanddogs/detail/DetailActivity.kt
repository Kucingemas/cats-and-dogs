package com.example.catsanddogs.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.catsanddogs.R
import com.example.catsanddogs.detail.view.DetailViewPagerAdapter
import com.example.catsanddogs.models.CatCollection
import kotlinx.android.synthetic.main.activity_detail.*

private const val CATS = "cats_collection"

class DetailActivity : AppCompatActivity() {
    private lateinit var viewPagerAdapter: DetailViewPagerAdapter
    private var catCollection: CatCollection? = null

    companion object {
        fun intent(context: Context?, catCollection: CatCollection?): Intent {
            return Intent(context, DetailActivity::class.java).apply {
                putExtra(CATS, catCollection)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setupViewPager()
    }

    private fun getImageUrls(): List<String>? {
        catCollection = intent.getParcelableExtra(CATS)
        return catCollection?.cats?.map { cat ->
            cat.imageUrl
        }
    }

    private fun setupViewPager() {
        viewPagerAdapter = DetailViewPagerAdapter()
        vpContents.adapter = viewPagerAdapter
        pivContents.setViewPager(vpContents)
        getImageUrls()?.let { imageUrls ->
            viewPagerAdapter.setItems(this, imageUrls)

        }
    }

}