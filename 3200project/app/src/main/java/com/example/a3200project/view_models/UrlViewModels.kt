package com.example.a3200project.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a3200project.models.ListOfDomainObjectIDs

class UrlViewModel : ViewModel() {

    private var imageUrl: String? = null
    private var metaDataUrl: String? = null
    private var currentImageIndex = MutableLiveData<Int>()

    init {
        currentImageIndex.value = 0
    }

    fun setImageUrl(iurl: String) {
        imageUrl = iurl
    }

    fun setMetaDataUrl(mdurl: String) {
        metaDataUrl = mdurl
    }
    fun getImageUrl() : String? {
        return imageUrl
    }

    fun getMetaDataUrl() : String? {
        return metaDataUrl
    }

    fun nextImageNumber() : Int {
        currentImageIndex.value = currentImageIndex.value?.plus(1)
        currentImageIndex.value = currentImageIndex.value?.rem(ListOfDomainObjectIDs.size())
        return ListOfDomainObjectIDs.getAllMyIds().get(currentImageIndex.value!!).id
    }


}