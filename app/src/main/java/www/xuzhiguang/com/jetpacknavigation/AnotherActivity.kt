package www.xuzhiguang.com.jetpacknavigation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_deep_link.*

class AnotherActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deep_link)
        setTextViewValue()
    }

    /**
     * AnotherActivityArgs 是管理参数的类,内部的方法等简单易懂
     */
    fun setTextViewValue() {
        var argumentString = AnotherActivityArgs.fromBundle(intent.extras).argumentString
        Log.e(logTag, argumentString)
        tv_show_arguments.text = argumentString
    }
}
