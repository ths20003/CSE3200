import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.program.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: App created")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: App started")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: App resumed")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: App paused")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: App stopped")
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}
