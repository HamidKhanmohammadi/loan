package ir.mebank.loan.core.module

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import java.util.*

class PTab(activity: AppCompatActivity, viewPagerId: Int, tabLayoutId: Int) {
    class Item {
        var fragment: Fragment? = null
            private set
        var title: String? = null
        var icon = 0

        constructor(
            fragmentClass: Class<out Fragment?>,
            title: String?,
            icon: Int
        ) {
            try {
                fragment = fragmentClass.newInstance()
                this.title = title
                this.icon = icon
            } catch (e: InstantiationException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            }
        }

        constructor(fragment: Fragment?, title: String?, icon: Int) {
            this.fragment = fragment
            this.title = title
            this.icon = icon
        }

    }

    inner class Adapter(fragmentManager: FragmentManager?) :
        FragmentPagerAdapter(fragmentManager!!) {
        private val items: MutableList<Item> =
            ArrayList()

        override fun getItem(position: Int): Fragment {
            return items[position].fragment!!
        }

        fun getRawItem(position: Int): Item {
            return items[position]
        }

        override fun getCount(): Int {
            return items.size
        }

        fun add(item: Item) {
            items.add(item)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return items[position].title
        }
    }

    private val viewPager: ViewPager
    private val tabLayout: TabLayout
    private val adapter: Adapter
    private fun refreshIcons() {
        for (i in 0 until adapter.count) {
            val itemIcon = adapter.getRawItem(i).icon
            if (itemIcon != 0) {
                tabLayout.getTabAt(i)!!.setIcon(adapter.getRawItem(i).icon)
            }
        }
    }

    @JvmOverloads
    fun add(
        fragmentClass: Class<out Fragment?>,
        title: String?,
        icon: Int = 0
    ) {
        val item = Item(fragmentClass, title, icon)
        adapter.add(item)
        adapter.notifyDataSetChanged()
        refreshIcons()
    }

    fun add(
        fragmentClass: Class<out Fragment?>,
        icon: Int
    ) {
        add(fragmentClass, null, icon)
    }

    fun setIcon(index: Int, icon: Int) {
        adapter.getRawItem(index).icon = icon
        refreshIcons()
    }

    fun setTitle(index: Int, title: String?) {
        adapter.getRawItem(index).title = title
        adapter.notifyDataSetChanged()
        refreshIcons()
    }

    init {
        val view = activity.window.decorView
        viewPager = view.findViewById(viewPagerId)
        tabLayout = view.findViewById(tabLayoutId)
        adapter = Adapter(activity.supportFragmentManager)
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }
}