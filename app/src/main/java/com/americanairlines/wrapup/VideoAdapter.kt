package com.americanairlines.wrapup

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VideoAdapter(val videos: List<Video>, val videoInterface: VideoInterface) : RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

    private lateinit var animation: Animation

    interface VideoInterface{
        fun playVideo(video: Video)
    }

    inner class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val videoTitleTextView = itemView.findViewById<TextView>(R.id.my_video_textview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.video_item_layout, parent, false)

        animation = AnimationUtils.loadAnimation(parent.context, R.anim.slide_in)

        return VideoViewHolder(itemView)
    }

    override fun getItemCount(): Int = videos.size

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {

        holder.itemView.animation = (animation)

        holder.videoTitleTextView.text = videos[position].videoTitle
    }

    fun play(adapterPosition: Int) {
        Log.d("TAG_X", videos[adapterPosition].videoTitle)
        videoInterface.playVideo(videos[adapterPosition])
    }
}