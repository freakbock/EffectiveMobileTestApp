import com.example.data.repository.CourseRepositoryImpl
import com.example.domain.repository.CourseRepository
import com.example.domain.usecase.GetCoursesUseCase
import org.koin.dsl.module

val repositoryModule = module {
    single<CourseRepository> { CourseRepositoryImpl(get()) }
    factory { GetCoursesUseCase(get()) }
}
