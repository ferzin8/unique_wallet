package com.fersman.uniquewallet.ui.view

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.fersman.uniquewallet.R
import com.fersman.uniquewallet.`object`.TokenItemObject
import java.util.concurrent.Executors

class TokenItemInListView(context: Context, attributeSet: AttributeSet) : ConstraintLayout(context, attributeSet) {
    private lateinit var imageIpfsURL: String
    private lateinit var name: String
    private lateinit var collectionName: String

    private lateinit var imageView: ImageView
    private lateinit var tokenName: TextView
    private lateinit var collectionNameView: TextView

    fun init (tokenItemObject: TokenItemObject) {
        imageIpfsURL = tokenItemObject.tokenImage
        name = tokenItemObject.tokenName
        collectionName = tokenItemObject.collectionName

        imageView = this.findViewById(R.id.token_image)
        tokenName = this.findViewById(R.id.token_name)
        collectionNameView = this.findViewById(R.id.collection_name)

        setParams()
        downloadImage()
    }

    private fun setParams () {
        tokenName.text = name
        collectionNameView.text = collectionName
    }

    private fun downloadImage () {
        val executor = Executors.newSingleThreadExecutor()
        // Once the executor parses the URL
        // and receives the image, handler will load it
        // in the ImageView
        val handler = Handler(Looper.getMainLooper())
        var image: Bitmap? = null
        // Only for Background process (can take time depending on the Internet speed)
        executor.execute {
            val imageURL = imageIpfsURL

            try {
                val `in` = java.net.URL(imageURL).openStream()
                image = BitmapFactory.decodeStream(`in`)
                // Only for making changes in UI
                handler.post {
                    imageView.setImageBitmap(image)
                }
            }
            catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}