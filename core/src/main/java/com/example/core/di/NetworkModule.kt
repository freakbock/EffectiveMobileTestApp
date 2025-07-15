import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.data.remote.CourseApi


val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://your-api.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CourseApi::class.java)
    }
}