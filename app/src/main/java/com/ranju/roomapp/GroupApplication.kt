package com.ranju.roomapp

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.decode.VideoFrameDecoder
import coil.fetch.VideoFrameFileFetcher
import coil.fetch.VideoFrameUriFetcher
import coil.util.CoilUtils
import dagger.hilt.android.HiltAndroidApp
import okhttp3.OkHttpClient

@HiltAndroidApp
class GroupApplication : Application(), ImageLoaderFactory {
    override fun newImageLoader(): ImageLoader {
        return ImageLoader.Builder(this)
            .okHttpClient {
                OkHttpClient.Builder().cache(CoilUtils.createDefaultCache(this)).build()
            }.componentRegistry {
                add(VideoFrameFileFetcher(this@GroupApplication))
                add(VideoFrameUriFetcher(this@GroupApplication))
                add(VideoFrameDecoder(this@GroupApplication))
            }.build()
    }
}