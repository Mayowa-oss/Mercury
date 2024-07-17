import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.learnviewmodel.R

class MyAdapter(private val signalList: ArrayList<MessageItem>):
RecyclerView.Adapter<MyAdapter.MyViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
     val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,
     parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val currentItem = signalList[position]
        holder.profile.setImageResource(currentItem.profile)
        holder.username.text = currentItem.name
    }

    override fun getItemCount(): Int {
      return signalList.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val profile : ImageView = itemView.findViewById(R.id.profilebackground)
        val username : TextView = itemView.findViewById(R.id.username)
    }

}