package com.tailwebs.tailwebsappointmentapp.controller

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tailwebs.tailwebsappointmentapp.R
import com.tailwebs.tailwebsappointmentapp.model.Sales_person_shops_List
import com.tailwebs.tailwebsappointmentapp.model.Trunk_shows_list
import com.tailwebs.tailwebsappointmentapp.utils.GlobalValue
import com.tailwebs.tailwebsappointmentapp.view.DashboardActivity
import com.tailwebs.tailwebsappointmentapp.view.ShowShopsAndTrunkShowDetails
import java.util.*

class AdapterForShpoAndTrunkShow(
    showShopsAndTrunkShowDetails: ShowShopsAndTrunkShowDetails,
    shopsArrayList: ArrayList<Sales_person_shops_List?>?,
    trunkShowsArrayList: ArrayList<Trunk_shows_list?>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object{
        private val TYPE_HEADER = 0
        private val TYPE_ITEM = 1
    }
    private var context: Context? = null
    private var s:String? = null;
    private var arrayList: ArrayList<Sales_person_shops_List?>? = null
    private var trunkShowsListArrayList: ArrayList<Trunk_shows_list?>? = null

    fun AdapterForShpoAndTrunkShow( context: Context?,arrayList: ArrayList<Sales_person_shops_List?>?,trunkShowsListArrayList: ArrayList<Trunk_shows_list?>?)
     {
        Log.d("chk","Constructor called 1st")
        this.context = context
        this.arrayList = arrayList
        this.trunkShowsListArrayList = trunkShowsListArrayList
        Log.d("chk",trunkShowsListArrayList!!.size.toString())
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == AdapterForShpoAndTrunkShow.TYPE_ITEM) {
            // Here Inflating your recyclerview item layout
            val itemView: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.row_layout_for_shop_recycler, parent, false)
           myViewHolder(itemView)
        } else if (viewType == AdapterForShpoAndTrunkShow.TYPE_HEADER) {
            // Here Inflating your header view
            val itemView: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.row_layout_for_header, parent, false)
            HeaderViewHolder(itemView)
        } else
        {
            val itemView: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.row_layout_empty, parent, false)
            emptyViewHolder(itemView)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is HeaderViewHolder) {
            val headerViewHolder: HeaderViewHolder =
                holder as HeaderViewHolder
            if (position == 0) {
                headerViewHolder.textView.setText("STORE")
            } else {
                headerViewHolder.textView.setText("TRUNK SHOWS")
            }
        } else if (holder is myViewHolder) {
            val itemViewHolder: myViewHolder =
                holder as myViewHolder
            if (position > arrayList!!.size) {
                myViewHolder.name.setText(trunkShowsListArrayList!![position - arrayList!!.size - 2]!!.getCode())
                myViewHolder.address.setText(
                    trunkShowsListArrayList!![position - arrayList!!.size - 2]!!.getAddress()!!
                        .getLine1()
                )
                val color = Color.parseColor(
                    trunkShowsListArrayList!![position - arrayList!!.size - 2]!!.getColor_code()!!
                        .getLight_color()
                )
                myViewHolder.linearLayout.setBackgroundColor(color)
            } else {
                myViewHolder.name.setText(arrayList!![position - 1]!!.getShop()!!.getName())
                myViewHolder.address.setText(
                    arrayList!![position - 1]!!.getShop()!!.getAddress()!!.getLine1()
                )
                val color = Color.parseColor(
                    arrayList!![position - 1]!!.getShop()!!.getLight_color_code()
                )
                myViewHolder.linearLayout.setBackgroundColor(color)
            }
            myViewHolder.linearLayout.setOnClickListener(View.OnClickListener {
                if (position > arrayList!!.size) {
                    GlobalValue.trunk_shows_lists = ArrayList<Trunk_shows_list?>()
                    GlobalValue.trunk_shows_lists!!.add(trunkShowsListArrayList!![position - arrayList!!.size - 2])
                    GlobalValue.ShopName =
                        trunkShowsListArrayList!![position - arrayList!!.size - 2]!!.getCode()
                            .toString()
                    GlobalValue.selectedId =
                        trunkShowsListArrayList!![position - arrayList!!.size - 2]!!.getId()
                            .toString()
                    GlobalValue.isSelectedShop = false
                    GlobalValue.isSelectedTrunkShow = true
                } else {
                    GlobalValue.shops_lists = ArrayList<Sales_person_shops_List>()
                    arrayList!![position - 1]?.let { it1 -> GlobalValue.shops_lists!!.add(it1) }
                    GlobalValue.ShopName =
                        arrayList!![position - 1]!!.getShop()!!.getName().toString()
                    GlobalValue.selectedId =
                        arrayList!![position - 1]!!.getShop()!!.getId().toString()
                    GlobalValue.isSelectedShop = true
                    GlobalValue.isSelectedTrunkShow = false
                }
                val intent = Intent(context, DashboardActivity::class.java)
                context!!.startActivity(intent)
                (context as Activity).finish()
            })
        }
    }

    override fun getItemCount(): Int {
        Log.d("chk","getItemCount called")
        this.context = context
        this.arrayList = GlobalValue.shopsLists
        this.trunkShowsListArrayList = GlobalValue.trunkShowsLists
        return GlobalValue.trunkShowsLists!!.size + GlobalValue.shopsLists!!.size + 2
    }

    private class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textView: TextView

        init {
            textView = view.findViewById(R.id.textId)
        }
    }

    private class emptyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
    //1


    class myViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        companion object{
            lateinit var name: TextView
            lateinit var address: TextView
            lateinit var time_slot: TextView
            lateinit var linearLayout: LinearLayout
        }


        init {
            name = itemView.findViewById(R.id.textview1Id)
            address = itemView.findViewById(R.id.textview3Id)
            time_slot = itemView.findViewById(R.id.textview2Id)
            linearLayout = itemView.findViewById(R.id.layoutId)
        }
    }
}