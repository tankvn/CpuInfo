package pho.cpu.inf.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import pho.cpu.inf.R
import pho.cpu.inf.fragments.AboutUsFragment
import pho.cpu.inf.fragments.ContactUsFragment
import pho.cpu.inf.fragments.HomeFragment

class PageAdapter(val context: Context, manager: FragmentManager) : FragmentPagerAdapter(manager) {

    companion object {
        const val HOME_POS = 0
        const val CPU_POS = 1
        const val GPU_POS = 2
        const val RAM_POS = 3
        const val STORAGE_POS = 4
        const val SCREEN_POS = 5
        const val ANDROID_POS = 6
        const val HARDWARE_POS = 7
        const val SENSORS_POS = 8

        const val INFO_PAGE_AMOUNT = 9
    }

    private val mFragmentList = ArrayList<Fragment>()
    private val mFragmentTitleList = ArrayList<String>()

    override fun getCount(): Int {
        return mFragmentList.size
//		return INFO_PAGE_AMOUNT
    }

    /*override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            HOME_POS -> context.getString(R.string.home)
            CPU_POS -> context.getString(R.string.cpu)
            GPU_POS -> context.getString(R.string.gpu)
            RAM_POS -> context.getString(R.string.ram)
            STORAGE_POS -> context.getString(R.string.storage)
            SCREEN_POS -> context.getString(R.string.screen)
            ANDROID_POS -> context.getString(R.string.android)
            HARDWARE_POS -> context.getString(R.string.hardware)
            SENSORS_POS -> context.getString(R.string.sensors)
            else -> {
                return context.getString(R.string.home)
            }
        }
    }*/

    override fun getPageTitle(position: Int): CharSequence? =
//		return null
//		return mFragmentTitleList[position]
        when (position) {
            HOME_POS -> context.getString(R.string.home)
            CPU_POS -> context.getString(R.string.cpu)
            GPU_POS -> context.getString(R.string.gpu)
            RAM_POS -> context.getString(R.string.ram)
            STORAGE_POS -> context.getString(R.string.storage)
            SCREEN_POS -> context.getString(R.string.screen)
            ANDROID_POS -> context.getString(R.string.android)
            HARDWARE_POS -> context.getString(R.string.hardware)
            SENSORS_POS -> context.getString(R.string.sensors)
            else -> throw IllegalArgumentException("Unknown position for ViewPager")
        }

    /*override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }*/

    //override fun getItem(position: Int): androidx.fragment.app.Fragment =
    override fun getItem(position: Int): Fragment =
        when (position) {
            HOME_POS -> HomeFragment()
            CPU_POS -> AboutUsFragment()
            GPU_POS -> ContactUsFragment()
//			CPU_POS -> CpuInfoFragment()
//			GPU_POS -> GpuInfoFragment()
//			RAM_POS -> RamInfoFragment()
//			STORAGE_POS -> StorageInfoFragment()
//			SCREEN_POS -> ScreenInfoFragment()
//			ANDROID_POS -> AndroidInfoFragment()
//			HARDWARE_POS -> HardwareInfoFragment()
//			SENSORS_POS -> SensorsInfoFragment()
            else -> throw IllegalArgumentException("Unknown position for ViewPager")
        }

//    fun addFragment(fragment: Fragment, title: String) {
//        mFragmentList.add(fragment)
//        mFragmentTitleList.add(title)
//    }
}