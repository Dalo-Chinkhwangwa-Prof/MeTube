package com.americanairlines.wrapup

import android.util.Log
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.*
import androidx.recyclerview.widget.RecyclerView

class VideoSwipeHelper(val videoAdapter: VideoAdapter): ItemTouchHelper.SimpleCallback(0, LEFT or RIGHT or UP or DOWN ) {
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {

        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        if(direction == LEFT)
            Log.d("TAG_X", "Swiped left")
        else
            Log.d("TAG_X", "Swiped Right")
        videoAdapter.play(viewHolder.adapterPosition)
    }
}