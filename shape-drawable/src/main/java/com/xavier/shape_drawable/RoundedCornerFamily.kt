package com.xavier.shape_drawable

import android.graphics.Color
import android.graphics.Paint
import android.view.View
import androidx.annotation.ColorInt
import androidx.databinding.BindingAdapter
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel
import com.xavier.installer.utils.dpTpx

object RoundedCornerFamily
// event_dispatch
@BindingAdapter(*["shapeCorner", "shapeCornerSize", "shapeTintColor"], requireAll = false)
fun View.bindShapeRounded(corner: Int?, cornerSize: Float?, @ColorInt tintColor: Int?) {
    val cornerFinish = corner ?: resources.getInteger(R.integer.shape_all_corner)
    val tintColorFinish = tintColor ?: Color.TRANSPARENT
    if (cornerSize == null) {
        post {
            shapeRounded(cornerFinish, if (height == 0) 0F else height / 2F, tintColorFinish)
        }
    } else {
        shapeRounded(cornerFinish, cornerSize.dpTpx, tintColorFinish)
    }
}

fun View.shapeRounded(corner: Int, cornerSize: Float, @ColorInt tintColor: Int) {
    val builder = ShapeAppearanceModel.builder()
    val cornerFamily = CornerFamily.ROUNDED
    when (corner) {
        resources.getInteger(R.integer.shape_all_corner) -> builder.setAllCorners(
            cornerFamily, cornerSize
        )
        resources.getInteger(R.integer.shape_top_corner) -> builder.setTopLeftCorner(
            cornerFamily, cornerSize
        ).setTopRightCorner(cornerFamily, cornerSize)
        resources.getInteger(R.integer.shape_bottom_corner) -> builder.setBottomLeftCorner(
            cornerFamily, cornerSize
        ).setBottomRightCorner(cornerFamily, cornerSize)
        resources.getInteger(R.integer.shape_left_corner) -> builder.setTopLeftCorner(
            cornerFamily, cornerSize
        ).setTopLeftCorner(cornerFamily, cornerSize)
        resources.getInteger(R.integer.shape_right_corner) -> builder.setBottomLeftCorner(
            cornerFamily, cornerSize
        ).setBottomRightCorner(cornerFamily, cornerSize)
        resources.getInteger(R.integer.shape_top_left_corner) -> builder.setTopLeftCorner(
            cornerFamily, cornerSize
        )
        resources.getInteger(R.integer.shape_top_right_corner) -> builder.setTopRightCorner(
            cornerFamily, cornerSize
        )
        resources.getInteger(R.integer.shape_bottom_left_corner) -> builder.setBottomLeftCorner(
            cornerFamily, cornerSize
        )
        resources.getInteger(R.integer.shape_bottom_right_corner) -> builder.setBottomRightCorner(
            cornerFamily, cornerSize
        )
        resources.getInteger(R.integer.shape_top_left_diagonal) -> builder.setTopLeftCorner(
            cornerFamily, cornerSize
        ).setBottomRightCorner(cornerFamily, cornerSize)
        resources.getInteger(R.integer.shape_top_right_diagonal) -> builder.setTopRightCorner(
            cornerFamily, cornerSize
        ).setBottomLeftCorner(cornerFamily, cornerSize)
        else -> builder.setAllCorners(
            cornerFamily, cornerSize
        )
    }
    val shapePathModel = builder.build()
    background = MaterialShapeDrawable(shapePathModel)
        .apply {
            setTint(tintColor)
            paintStyle = Paint.Style.FILL
        }
}
