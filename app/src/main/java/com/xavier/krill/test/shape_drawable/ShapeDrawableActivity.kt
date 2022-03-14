package com.xavier.krill.test.shape_drawable

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Outline
import android.graphics.Paint
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import com.google.android.material.shape.*
import com.xavier.installer.utils.dp2px
import com.xavier.installer.utils.dpTpx
import com.xavier.krill.R
import com.xavier.krill.base.ViewBindingActivity
import com.xavier.krill.databinding.ActivityShapeDrawableBinding
import com.xavier.krill.utils.color

class ShapeDrawableActivity : ViewBindingActivity<ActivityShapeDrawableBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        roundOne()
        roundTwo()
        roundThree()
        roundFour()
        roundFive()
        roundSix()
        roundSeven()
        roundEight()
        roundNine()
        roundTen()
    }

    private fun roundTen() {
        val shapeAppearanceModel = ShapeAppearanceModel.builder()
            .setAllEdges(ArgEdgeTreatment(16F.dpTpx, false))
            .build()
        val shapeDrawable = MaterialShapeDrawable(shapeAppearanceModel).apply {
            setTint(R.color.purple_500.color())
            paintStyle = Paint.Style.FILL
        }
        binding.imageTen.background = shapeDrawable
    }

    private fun roundNine() {
        /*val viewOutlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View?, outline: Outline?) {
                if (view == null || outline == null) return
                val radius = 16F.dpTpx
                val radiusInt = radius.toInt()
                //outline.setRoundRect(0, 0, view.width + radiusInt, view.height + radiusInt, radius)
                //outline.setRect(0, 0, view.width + radiusInt, view.height + (radiusInt / 2))
                //outline.setRect(0, 0, view.width - radiusInt, view.height - radiusInt)
            }
        }
        binding.imageNine.run {
            clipToOutline = true
            outlineProvider = viewOutlineProvider
        }*/
        val shapeAppearanceModel = ShapeAppearanceModel.builder()
            .setAllEdges(ArgEdgeTreatment(16F.dpTpx, true))
            .build()
        val shapeDrawable = MaterialShapeDrawable(shapeAppearanceModel).apply {
            setTint(R.color.purple_500.color())
            paintStyle = Paint.Style.FILL
        }
        binding.imageNine.background = shapeDrawable
    }

    private fun roundEight() {
        val shapeAppearanceModel = ShapeAppearanceModel.builder()
            .setAllCorners(ExtraRoundCornerTreatment())
            .setAllCornerSizes(16F.dpTpx)
            .build()
        val shapeDrawable = MaterialShapeDrawable(shapeAppearanceModel).apply {
            setTint(R.color.purple_500.color())
            paintStyle = Paint.Style.FILL
        }
        binding.imageEight.background = shapeDrawable
    }

    private fun roundSeven() {
        val shapeAppearanceModel = ShapeAppearanceModel.builder()
            .setAllCorners(InnerRoundCornerTreatment())
            .setAllCornerSizes(16F.dpTpx)
            .build()
        val shapeDrawable = MaterialShapeDrawable(shapeAppearanceModel).apply {
            setTint(R.color.purple_500.color())
            paintStyle = Paint.Style.FILL
        }
        binding.imageSeven.background = shapeDrawable
    }

    private fun roundSix() {
        val shapeAppearanceModel = ShapeAppearanceModel.builder()
            .setAllCorners(InnerCutCornerTreatment())
            .setAllCornerSizes(16F.dpTpx)
            .build()
        val shapeDrawable = MaterialShapeDrawable(shapeAppearanceModel).apply {
            setTint(R.color.purple_500.color())
            paintStyle = Paint.Style.FILL
        }
        binding.imageSix.background = shapeDrawable
    }

    /*@SuppressLint("RestrictedApi")
    private fun roundSix() {
        val shapeAppearanceModel = ShapeAppearanceModel.builder()
            .setAllCorners(CornerFamily.ROUNDED, 16F.dpTpx)
            .build()
        val shapeDrawable = MaterialShapeDrawable(shapeAppearanceModel).apply {
            setTint(R.color.purple_500.color())
            paintStyle = Paint.Style.FILL
            shadowCompatibilityMode = MaterialShapeDrawable.SHADOW_COMPAT_MODE_ALWAYS
            initializeElevationOverlay(context)
            shadowRadius = 16F.dpTpx.toInt()
            setShadowColor(Color.DKGRAY)
            shadowVerticalOffset = 2F.dpTpx.toInt()
        }
        binding.run {
            (imageSix.parent as ViewGroup).clipChildren = false
            imageSix.background = shapeDrawable
        }
    }*/

    private fun roundFive() {
        val shapeAppearanceModel = ShapeAppearanceModel.builder()
            .setAllCorners(CornerFamily.ROUNDED, 16F.dpTpx)
            .build()
        val shapeDrawable = MaterialShapeDrawable(shapeAppearanceModel).apply {
            setTint(Color.TRANSPARENT)
            strokeWidth = 2F.dpTpx
            setStrokeTint(R.color.teal_200.color())
            paintStyle = Paint.Style.FILL_AND_STROKE
        }
        binding.imageFive.background = shapeDrawable
    }

    private fun roundFour() {
        val shapeAppearanceModel = ShapeAppearanceModel.builder()
            .setAllEdges(TriangleEdgeTreatment(8F.dpTpx, false))
            .build()
        val shapeDrawable = MaterialShapeDrawable(shapeAppearanceModel).apply {
            setTint(R.color.purple_500.color())
            paintStyle = Paint.Style.FILL
        }
        binding.run {
            (imageFour.parent as ViewGroup).clipChildren = false
            imageFour.background = shapeDrawable
        }
    }

    private fun roundThree() {
        val shapeAppearanceModel = ShapeAppearanceModel.builder()
            .setAllEdges(TriangleEdgeTreatment(8F.dpTpx, true))
            .build()
        val shapeDrawable = MaterialShapeDrawable(shapeAppearanceModel).apply {
            setTint(R.color.purple_500.color())
            paintStyle = Paint.Style.FILL
        }
        binding.imageThree.background = shapeDrawable
    }

    private fun roundTwo() {
        val shapeAppearanceModel = ShapeAppearanceModel.builder()
            .setAllCorners(CornerFamily.CUT, 16F.dpTpx)
            .build()
        val shapeDrawable = MaterialShapeDrawable(shapeAppearanceModel).apply {
            setTint(R.color.purple_500.color())
            paintStyle = Paint.Style.FILL
        }
        binding.imageTwo.background = shapeDrawable
    }

    private fun roundOne() {
        val shapeAppearanceModel = ShapeAppearanceModel.builder()
            .setAllCorners(CornerFamily.ROUNDED, 16F.dpTpx)
            .build()
        val shapeDrawable = MaterialShapeDrawable(shapeAppearanceModel).apply {
            paintStyle = Paint.Style.FILL
        }
        binding.imageOne.background = shapeDrawable
    }

    class InnerCutCornerTreatment : CornerTreatment() {
        override fun getCornerPath(shapePath: ShapePath, angle: Float, f: Float, size: Float) {
            val radius = size * f
            shapePath.reset(0f, radius, 180f, 180 - angle)
            shapePath.lineTo(radius, radius)
            shapePath.lineTo(radius, 0f)
        }
    }

    class InnerRoundCornerTreatment : CornerTreatment() {
        override fun getCornerPath(shapePath: ShapePath, angle: Float, f: Float, size: Float) {
            val radius = size * f
            shapePath.reset(0f, radius, 180f, 180 - angle)
            shapePath.addArc(-radius, -radius, radius, radius, angle, -90f)
        }
    }

    class ExtraRoundCornerTreatment : CornerTreatment() {
        override fun getCornerPath(shapePath: ShapePath, angle: Float, f: Float, size: Float) {
            val radius = size * f
            shapePath.reset(0f, radius, 180f, 180 - angle)
            shapePath.addArc(-radius, -radius, radius, radius, angle, 270f)
        }
    }

    class ArgEdgeTreatment(val size: Float, val inside: Boolean) : EdgeTreatment() {
        override fun getEdgePath(length: Float, center: Float, f: Float, shapePath: ShapePath) {
            val radius = size * f
            shapePath.lineTo(center - radius, 0f)
            shapePath.addArc(
                center - radius, -radius,
                center + radius, radius,
                180f,
                if (inside) -180f else 180f
            )
            shapePath.lineTo(length, 0f)
        }
    }

    class QuadEdgeTreatment(val size: Float) : EdgeTreatment() {
        override fun getEdgePath(length: Float, center: Float, f: Float, shapePath: ShapePath) {
            shapePath.quadToPoint(center, size * f, length, 0f)
        }
    }

}