package com.americanairlines.wrapup

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.sprylab.android.widget.TextureVideoView

class MainActivity : AppCompatActivity(), VideoAdapter.VideoInterface {

    private lateinit var recyclerView: RecyclerView
    private lateinit var videoPlayer: TextureVideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = mutableListOf<Video>()

        for (i in 1..40) {

            if (i < 10)
                list.add(Video("Episode $i", "https://soniczone.net/Downloads/Video/Underground/E0$i.mp4"))
            else
                list.add(Video("Episode $i", "https://soniczone.net/Downloads/Video/Underground/E$i.mp4"))
        }

        videoPlayer = findViewById(R.id.main_player)
        videoPlayer.setOnPreparedListener {
            it.start()
        }

        recyclerView = findViewById(R.id.main_recyclerview)


        val vAdapter = VideoAdapter(list, this)
        recyclerView.adapter = vAdapter

        val itemTouchHelper = ItemTouchHelper(VideoSwipeHelper(vAdapter))
        itemTouchHelper.attachToRecyclerView(recyclerView)

       Log.d("TAG_X", "Key is..... ${BuildConfig.SONICTUBE_API}")

    }

    override fun playVideo(video: Video) {
        videoPlayer.setVideoPath(video.videoURL)
        recyclerView.visibility = View.GONE
        videoPlayer.visibility = View.VISIBLE
    }

    override fun onBackPressed() {
        if (videoPlayer.visibility == View.VISIBLE) {
            videoPlayer.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
            videoPlayer.stopPlayback()
        } else
            super.onBackPressed()
    }
}







