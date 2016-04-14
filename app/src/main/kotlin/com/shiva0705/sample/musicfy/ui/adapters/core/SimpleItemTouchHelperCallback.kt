package com.shiva0705.sample.musicfy.ui.adapters.core

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper


class SimpleItemTouchHelperCallback(val adapter: ItemTouchHelperAdapter) : ItemTouchHelper.Callback(){
    val ALPHA_FULL = 1.0f

    override fun isLongPressDragEnabled(): Boolean {
        return true
    }

    override fun isItemViewSwipeEnabled(): Boolean {
        return true
    }

    override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder?): Int {
        if (recyclerView.layoutManager is GridLayoutManager ) {
            val dragFlags = ItemTouchHelper.UP
            val swipeFlags = 0;
            return makeMovementFlags(dragFlags, swipeFlags);

        } else {
            val dragFlags = ItemTouchHelper.UP
            val swipeFlags = ItemTouchHelper.START
            return makeMovementFlags(dragFlags, swipeFlags);
        }
    }

    override fun onMove(recyclerView: RecyclerView?, source: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder?): Boolean {
        if(source.itemViewType != target?.itemViewType){
            return false
        }

        adapter.onItemMove(source.adapterPosition, target?.adapterPosition ?: 0)
        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder?, direction: Int) {

    }

    override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
        if(actionState != ItemTouchHelper.ACTION_STATE_IDLE){
            if(viewHolder is ItemTouchHelperViewHolder){
                viewHolder.onItemSelected()
            }
        }

        super.onSelectedChanged(viewHolder, actionState)
    }

    override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder?) {
        super.clearView(recyclerView, viewHolder)
        viewHolder?.itemView?.alpha = ALPHA_FULL
        if(viewHolder is ItemTouchHelperViewHolder){
            viewHolder.onItemClear()
        }
    }


}