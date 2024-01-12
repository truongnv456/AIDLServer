package navigationcomponentturtorialcom.example.aidlserver

import android.app.Service
import android.content.Intent
import android.graphics.Color
import android.os.IBinder
import android.util.Log
import java.util.Random


class AIDLColorService : Service() {

    private val TAG = "AIDLColorService"

    fun AIDLColorService() {}

    override fun onBind(intent: Intent?): IBinder? {
        return binder
    }

    private val binder: IMyAidlInterface.Stub = object : IMyAidlInterface.Stub() {
        override fun getColor(): Int {
            val rnd = Random()
            val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
            Log.d(TAG, "getColor: $color")
            return color
        }
    }

}