package www.xuzhiguang.com.jetpacknavigation

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController = Navigation.findNavController(this@MainActivity, R.id.my_nav_host_fragment)
        navController.addOnNavigatedListener { controller, destination ->
            //导航事件监听
        }
        bottom_nav_view.setupWithNavController(navController)
    }

    /**
     * defaultNavHost="true"属性。这个属性确保my_nav_host_fragment片段拦截系统后退按钮
     * 场景： 底部有四个导航按钮，点击其它的导航按钮再按返回按钮，会按fragment打开的相反顺序
     * 一层层的返回 直到返回到桌面
     * 如果为false，点击返回时则不会拦截，直接返回到桌面
     */
    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this@MainActivity, R.id.my_nav_host_fragment).navigateUp()
    }

}
