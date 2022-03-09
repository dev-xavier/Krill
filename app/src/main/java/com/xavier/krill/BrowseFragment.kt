package com.xavier.krill

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.fragment.app.ListFragment
import com.xavier.krill.test.FullScreenExperienceActivity
import com.xavier.krill.test.ImmersiveActivity
import com.xavier.krill.test.ImmersiveSystemBarActivity
import com.xavier.krill.test.SystemBarActivity
import com.xavier.krill.vs.RoundedActivity

class BrowseFragment : ListFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listAdapter = SimpleAdapter(
            requireContext(), getData(),
            android.R.layout.simple_list_item_1, arrayOf("title"),
            intArrayOf(android.R.id.text1)
        )
    }

    private fun getData(): List<Map<String, Any>> {
        return mutableListOf(
            mapOf(
                "title" to "system bar",
                "intent" to activityToIntent(SystemBarActivity::class.java.name)
            ),
            mapOf(
                "title" to "全面屏幕体验？",
                "intent" to activityToIntent(FullScreenExperienceActivity::class.java.name)
            ),
            mapOf(
                "title" to "全面屏幕体验1",
                "intent" to activityToIntent(ImmersiveSystemBarActivity::class.java.name)
            ),
            mapOf(
                "title" to "全面屏幕体验2",
                "intent" to activityToIntent(ImmersiveActivity::class.java.name)
            ),
            mapOf(
                "title" to "VS ShapeableImageView : 圆角裁剪和 Drawable 背景",
                "intent" to activityToIntent(RoundedActivity::class.java.name)
            )
        )
    }

    private fun activityToIntent(activity: String): Intent =
        Intent(Intent.ACTION_VIEW).setClassName(requireContext().packageName, activity)

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        val map = listView.getItemAtPosition(position) as Map<*, *>
        val intent = Intent(map["intent"] as Intent)
        intent.addCategory(Intent.CATEGORY_SAMPLE_CODE)
        startActivity(intent)
    }

}