package com.shanindu.github.app.ui.main

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.shanindu.github.app.R
import com.shanindu.github.app.models.Repo
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Shanindu on 03/03/2021.
 */
class MainAdapter(private val context: Context, private val lists: MutableList<Repo>) : RecyclerView.Adapter<MainAdapter.ListViewHolder>() {

    private val list: MutableList<Repo> = lists


    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ListViewHolder?, position: Int) {
        var post = list[position]

        // holder!!.bind(post)
        holder!!.repositary!!.setText(post.name)
        holder.name!!.setText(post.full_name)
        holder.description!!.setText(post.description)
        holder.language!!.setText(post.language)
        holder.star!!.setText(post.watchers.toString())

        Picasso
                .get()
                .load(post.owner.avatar_url)
                .into(holder.avatar)

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ListViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return MainAdapter.ListViewHolder(itemView)
    }

    fun removeAt(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(position)
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var layout = itemView.findViewById<CardView>(R.id.item_layout)
        val name = itemView.findViewById<TextView>(R.id.textViewName)
        val repositary = itemView.findViewById<TextView>(R.id.textViewRepo)
        val description = itemView.findViewById<TextView>(R.id.textViewDescription)
        val star = itemView.findViewById<TextView>(R.id.textViewStar)
        val language = itemView.findViewById<TextView>(R.id.textViewLanguage)
        val avatar = itemView.findViewById<CircleImageView>(R.id.imageViewAvatar)

        fun bind(item: Repo) {
            // title = item.post
            // body etc.
        }
    }

    interface onItemClickListener {
        fun itemRemoveClick(post: Repo)
        fun itemDetail(postId: String)
    }
}