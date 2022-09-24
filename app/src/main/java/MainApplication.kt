import android.app.Application
import androidx.lifecycle.LifecycleObserver


public class MainApplication : Application(), LifecycleObserver {
    override fun onCreate() {
        super.onCreate()
    }
}