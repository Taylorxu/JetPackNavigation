package www.xuzhiguang.com.jetpacknavigation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_blank.view.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class BlankFragmentA : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_blank, container, false)
        view.bt_go.setOnClickListener {
            //跳转到其它界面，并传递参数
            navigateByGraphId()
        }
        return view
    }

    /**
     * 方法名 actionBlankFragmentAToAnotherActivity 在后面都用 aDirectionFun 代替
     * 如果参数配置如 <argument ... android:defaultValue="XXXXX"../>  aDirectionFun
     * 所以当使用direction 跳转传参数 不需要defaultValue;
     * 由此推出aDirectionFun的参数个数、类型由配置的参数个数和类型所决定
     *参数获取 请进 [AnotherActivity.onCreate]
     */
    fun navigatieByDirectionObject() {
        var direction = BlankFragmentADirections.actionBlankFragmentAToAnotherActivity("这是我要传的参数")
        findNavController().navigate(direction)
    }

    /**
     * 这种方式跳转很显然，直接传递bundle就可以了；
     * resId 对应着  <action  android:id="@+id/action_blankFragmentA_to_anotherActivity".... />
     * 参数获取 请进 [AnotherActivity.onCreate]
     * [argumentName] 值必须与 navigation xml中 action 目标的 一致
     */
    fun navigateByGraphId() {
        var argument = Bundle()
        argument.putString(argumentName, "这是我要传的参数")
        findNavController().navigate(R.id.action_blankFragmentA_to_anotherActivity, argument)
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                BlankFragmentA().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
