import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.ecoproject_android.R

class ViewPagerAdapter(private val context: Context, private var banner: List<Int>) :
    RecyclerView.Adapter<ViewPagerAdapter.Pager2ViewHolder>() {

    inner class Pager2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val banner: ImageView = itemView.findViewById(R.id.banner)

        init {
            banner.setOnClickListener { v: View ->
                val position = adapterPosition
                Toast.makeText(itemView.context, "You clicked on item #${position}", Toast.LENGTH_SHORT).show()
               if (position == 1){
                   val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.naver.com"))
                   context.startActivity(myIntent)
               }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerAdapter.Pager2ViewHolder {
        return Pager2ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.activity_main_banner_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewPagerAdapter.Pager2ViewHolder, position: Int) {
        holder.banner.setImageResource(banner[position])
    }

    override fun getItemCount(): Int {
        return banner.size
    }
}
