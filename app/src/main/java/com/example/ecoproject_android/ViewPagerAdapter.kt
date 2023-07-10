import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.ecoproject_android.R

class ViewPagerAdapter(private val context: Context, private var banner: List<Int>) :
    RecyclerView.Adapter<ViewPagerAdapter.Pager2ViewHolder>() {

    inner class Pager2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val banner: ImageView = itemView.findViewById(R.id.banner)

        init {
            banner.setOnClickListener { v: View ->
                val position = adapterPosition
                //Toast.makeText(itemView.context, "You clicked on item #${position}", Toast.LENGTH_SHORT).show()
               when (position) {
                   0 -> {
                       val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.greenpeace.org/korea/make-a-change/"))
                       context.startActivity(myIntent)
                   }
                   1 -> {
                       val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://tmoneywelfarefoundation.or.kr/pages/?p=23&b=B_1_1&m=read&bn=2104&vn="))
                       context.startActivity(myIntent)
                   }
                   2 -> {
                       val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.me.go.kr/home/web/board/read.do?pagerOffset=0&maxPageItems=6&maxIndexPages=10&searchKey=&searchValue=&menuId=10392&orgCd=&boardId=1605300&boardMasterId=713&boardCategoryId=&rn=5"))
                       context.startActivity(myIntent)
                   }
                   3 -> {
                       val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.me.go.kr/home/web/board/read.do?menuId=10392&boardMasterId=713&boardId=1606280"))
                       context.startActivity(myIntent)
                   }
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
