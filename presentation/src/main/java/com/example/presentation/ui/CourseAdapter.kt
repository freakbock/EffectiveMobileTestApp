import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Course
import com.example.presentation.R

class CourseAdapter : ListAdapter<Course, CourseAdapter.CourseViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_course, parent, false)
        return CourseViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleText: TextView = itemView.findViewById(R.id.courseTitle)
        private val descriptionText: TextView = itemView.findViewById(R.id.courseDescription)
        private val priceText: TextView = itemView.findViewById(R.id.coursePrice)
        private val rateText: TextView = itemView.findViewById(R.id.courseRate)
        private val startDateText: TextView = itemView.findViewById(R.id.courseStartDate)

        fun bind(course: Course) {
            titleText.text = course.title
            descriptionText.text = course.text
            priceText.text = "Цена: ${course.price}"
            rateText.text = "Рейтинг: %.1f".format(course.rate)
            startDateText.text = "Дата: ${course.startDate}"
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Course>() {
            override fun areItemsTheSame(oldItem: Course, newItem: Course): Boolean = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Course, newItem: Course): Boolean = oldItem == newItem
        }
    }
}
