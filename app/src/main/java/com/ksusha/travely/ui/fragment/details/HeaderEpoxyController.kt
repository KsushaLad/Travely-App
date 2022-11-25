package com.ksusha.travely.ui.fragment.details

import com.airbnb.epoxy.EpoxyController
import com.ksusha.travely.R
import com.ksusha.travely.databinding.ModelHeaderImageBinding
import com.ksusha.travely.ui.epoxy.ViewBindingKotlinModel
import com.squareup.picasso.Picasso

class HeaderEpoxyController(
    val imageUrls: List<String>
): EpoxyController() {

    override fun buildModels() {
        imageUrls.forEachIndexed { index, url ->
            HeaderImageEpoxyModel(url).id(index).addTo(this)
        }
    }

    inner class HeaderImageEpoxyModel(
        val imageUrl: String
    ): ViewBindingKotlinModel<ModelHeaderImageBinding>(R.layout.model_header_image) {

        override fun ModelHeaderImageBinding.bind() {
            Picasso.get().load(imageUrl).into(imageView)
        }
    }
}