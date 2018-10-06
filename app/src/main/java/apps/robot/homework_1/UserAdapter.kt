package apps.robot.homework_1

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapter(val context: Context, val items: ArrayList<User>, private val clickListener: UsersListClickListener) : RecyclerView.Adapter<UserAdapter.UserHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder =
            UserHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false), clickListener)

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.tvName.text = items[position].name
        holder.tvInterests.text = items[position].interests
        holder.ivPhoto.setImageResource(items[position].photo)
    }

    class UserHolder(view: View, clickListener: UsersListClickListener?) : RecyclerView.ViewHolder(view), View.OnClickListener {
        private var mListener: UsersListClickListener? = null
        var ivPhoto = view.iv_photo
        var tvName = view.tv_name
        var tvInterests = view.tv_interests

        init {
            mListener = clickListener
            view.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            mListener?.onClick(v, adapterPosition)
        }
    }
}