import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Course
import com.example.presentation.R

class CourseAdapter(
    private val onFavoriteClick: (Course) -> Unit
) : ListAdapter<Course, CourseAdapter.CourseViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_course, parent, false)
        return CourseViewHolder(view, onFavoriteClick)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class CourseViewHolder(
        itemView: View,
        private val onFavoriteClick: (Course) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {

        private val titleText: TextView = itemView.findViewById(R.id.title)
        private val descriptionText: TextView = itemView.findViewById(R.id.description)
        private val priceText: TextView = itemView.findViewById(R.id.price)
        private val rateText: TextView = itemView.findViewById(R.id.star)
        private val startDateText: TextView = itemView.findViewById(R.id.date)
        private val hasLike: ImageView = itemView.findViewById(R.id.hasLike)

        fun bind(course: Course) {
            titleText.text = course.title
            descriptionText.text = course.text
            priceText.text = course.price.toString() + "₽"
            rateText.text = course.rate.toString()
            startDateText.text = course.startDate.toString()
            hasLike.setImageResource(
                if (course.hasLike) com.example.core.R.drawable.favorite_green
                else com.example.core.R.drawable.favorite_white
            )

            hasLike.setOnClickListener { onFavoriteClick(course) }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Course>() {
            override fun areItemsTheSame(oldItem: Course, newItem: Course) = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Course, newItem: Course) = oldItem == newItem
        }
    }
}
