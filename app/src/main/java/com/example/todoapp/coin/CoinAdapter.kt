package com.example.todoapp.coin

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import kotlinx.android.synthetic.main.item_coin.view.*

class CoinAdapter(
    private val coins: List<Coin>
) : RecyclerView.Adapter<CoinAdapter.CoinViewHolder>() {

    class CoinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        return CoinViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_coin,parent,false)
        )
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val curCoin = coins[position]
        holder.itemView.apply {
            tv_coinname.text = curCoin.name
            tv_coinvol.text = "Vol ${curCoin.vol}M"
            tv_coinmarjin.text ="${curCoin.margin}x"
            tv_coinprice.text = curCoin.price.toString()
            tv_coinchange.text ="%${curCoin.change}"
            setTextColor(holder, curCoin.change)
        }
    }
    private fun setTextColor(holder:CoinViewHolder, change: Float) {
        holder.itemView.apply {
            if (change > 0) {
                tv_coinprice.setTextColor(Color.parseColor("#04CF33"))
                tv_coinchange.setTextColor(Color.parseColor("#04CF33"))
            } else {
                tv_coinprice.setTextColor(Color.parseColor("#CF041C"))
                tv_coinchange.setTextColor(Color.parseColor("#CF041C"))
            }
        }
    }

    override fun getItemCount(): Int {
        return coins.size
    }
}