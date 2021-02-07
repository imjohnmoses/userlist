package com.john.shadi.ui_helper

import androidx.databinding.ViewDataBinding
import android.view.LayoutInflater
import android.view.ViewGroup

import com.john.shadi.BR.item
import com.john.shadi.databinding.UserItemRowBinding
import com.john.shadi.domain.model.UserData


class HomeAdapter(
        private var items: ArrayList<UserData> = arrayListOf<UserData>()
) : androidx.recyclerview.widget.RecyclerView.Adapter<HomeAdapter.CustomViewHolder>() {
    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.onBind(items[position])
    }
   lateinit var list:OnClickReference;

    fun setListener(liste:OnClickReference){
        list=liste
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val binding  = UserItemRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        binding.setPresenter(list)
        return CustomViewHolder(binding)
    }

    inner class CustomViewHolder(dataBinding: ViewDataBinding)
        : DataBindingViewHolder<UserData>(dataBinding)  {
        override fun onBind(t: UserData): Unit =
            with(t) {
           dataBinding.setVariable(item,t)
        }
    }

    fun add(list: List<UserData>) {
        items.addAll(list)
        notifyDataSetChanged()
    }

    fun clear() {
        items.clear()
        notifyDataSetChanged()
    }

    interface OnClickReference{
        fun onClickUser(userData:UserData)
    }
}

