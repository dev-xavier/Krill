package com.xavier.krill.vs

import android.annotation.SuppressLint
import android.graphics.Outline
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewOutlineProvider
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel
import com.xavier.installer.utils.dpTpx
import com.xavier.krill.R
import com.xavier.krill.base.ViewBindingActivity
import com.xavier.krill.databinding.ActivityRoundedBinding
import com.xavier.krill.utils.color

@SuppressLint("SetTextI18n")
class RoundedActivity : ViewBindingActivity<ActivityRoundedBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        roundOne()
        roundTwo()
        roundThree()
        roundFour()
        roundFive()
        roundOther()
    }

    private fun roundOther() {
        binding.run {
            otherTitle.text = "其他 EMMMMMMMMM"
            otherDirections.text = "椭圆?如果算圆角的话? \n" +
                    "ShapeableImageView MaterialShapeDrawable ViewOutlineProvider all out"
        }
    }

    private fun roundFive() {
        val cornerSize = 16F.dpTpx
        val shapeAppearanceModel = ShapeAppearanceModel.builder()
            .setTopRightCorner(CornerFamily.ROUNDED, cornerSize)
            .setBottomLeftCorner(CornerFamily.ROUNDED, cornerSize)
            .build()
        val shapeDrawable = MaterialShapeDrawable(shapeAppearanceModel).apply {
            setTint(R.color.purple_500.color())
            paintStyle = Paint.Style.FILL
        }
        val viewOutlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View?, outline: Outline?) {
                if (view == null || outline == null) return
                val radius = 16F.dpTpx
                val path = Path()
                val rectF = RectF(0F, 0F, view.width.toFloat(), view.height.toFloat())
                //val radii = floatArrayOf(0F, 0F, radius, radius, 0F, 0F, radius, radius)
                val radii =
                    floatArrayOf(radius, radius, radius, radius, radius, radius, radius, radius)
                //path.addRoundRect(rectF, radii, Path.Direction.CW)
                path.addRoundRect(
                    0F, 0F,
                    view.width.toFloat(), view.height.toFloat(),
                    radius, radius,
                    Path.Direction.CW
                )
                outline.canClip()
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    outline.setPath(path)
                } else {
                    outline.setConvexPath(path)
                }
            }
        }
        binding.run {
            roundFiveTitle.text = "Round four: \n" +
                    "(1 使用 MaterialShapeDrawable 实现对 '对角' 的圆角背景 \n" +
                    "(2 使用 ViewOutlineProvider 实现对 '对角' 的圆角裁剪"
            imageFive.background = shapeDrawable
            endImageFive.run {
                outlineProvider = viewOutlineProvider
                clipToOutline = true
            }
            roundFiveDirections.text =
                "Round five 使用 ViewOutlineProvider 实现对 '对角' 的圆角裁剪 defeated: \n" +
                        "暂认为 ViewOutlineProvider 在形状表现上仅适用于 矩形裁剪 圆角矩形裁剪"
        }
    }

    private fun roundFour() {
        val cornerSize = 16F.dpTpx
        val shapeAppearanceModel = ShapeAppearanceModel.builder()
            .setTopLeftCorner(CornerFamily.ROUNDED, cornerSize)
            .build()
        val shapeDrawable = MaterialShapeDrawable(shapeAppearanceModel).apply {
            setTint(R.color.purple_500.color())
            paintStyle = Paint.Style.FILL
        }
        val viewOutlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View?, outline: Outline?) {
                if (view == null || outline == null) return
                val radius = 16F.dpTpx
                val radiusInt = radius.toInt()
                outline.setRoundRect(
                    0, 0, view.width + radiusInt, view.height + radiusInt, radius
                )
            }
        }
        binding.run {
            roundFourTitle.text = "Round four: \n" +
                    "(1 使用 MaterialShapeDrawable 实现对 'topLeft' 的圆角背景 \n" +
                    "(2 使用 ViewOutlineProvider 实现对 'topLeft' 的圆角裁剪"
            imageFour.background = shapeDrawable
            endImageFour.run {
                outlineProvider = viewOutlineProvider
                clipToOutline = true
            }
        }
    }

    private fun roundThree() {
        val cornerSize = 16F.dpTpx
        val shapeAppearanceModel = ShapeAppearanceModel.builder()
            .setTopLeftCorner(CornerFamily.ROUNDED, cornerSize)
            .setTopRightCorner(CornerFamily.ROUNDED, cornerSize)
            .build()
        val shapeDrawable = MaterialShapeDrawable(shapeAppearanceModel).apply {
            setTint(R.color.purple_500.color())
            paintStyle = Paint.Style.FILL
        }
        val viewOutlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View?, outline: Outline?) {
                if (view == null || outline == null) return
                val radius = 16F.dpTpx
                outline.setRoundRect(
                    0, 0, view.width, view.height + radius.toInt(), radius
                )
            }
        }
        binding.run {
            roundThreeTitle.text = "Round three: \n" +
                    "(1 使用 MaterialShapeDrawable 实现对 'top' 的圆角背景 \n" +
                    "(2 使用 ViewOutlineProvider 实现对 'top' 的圆角裁剪"
            imageThree.background = shapeDrawable
            endImageThree.run {
                outlineProvider = viewOutlineProvider
                clipToOutline = true
            }
        }
    }

    private fun roundTwo() {
        val viewOutlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View?, outline: Outline?) {
                if (view == null || outline == null) return
                val width = view.width
                val height = view.height
                val radius = minOf(width, height) / 2F
                outline.setRoundRect(0, 0, view.width, view.height, radius)
            }
        }
        binding.run {
            roundTwoTitle.text = "Round two: \n" +
                    "(1 使用 MaterialShapeDrawable 实现圆形背景 \n" +
                    "(2 使用 ViewOutlineProvider 实现圆形裁剪"
            imageTwo.run {
                post {
                    val shapeAppearanceModel = ShapeAppearanceModel.builder()
                        .setAllCorners(CornerFamily.ROUNDED, minOf(width, height) / 2F)
                        .build()
                    val shapeDrawable = MaterialShapeDrawable(shapeAppearanceModel).apply {
                        setTint(R.color.purple_500.color())
                        paintStyle = Paint.Style.FILL
                    }
                    background = shapeDrawable
                }
            }
            endImageTwo.run {
                outlineProvider = viewOutlineProvider
                clipToOutline = true
            }
        }
    }

    private fun roundOne() {
        val shapeAppearanceModel = ShapeAppearanceModel.builder()
            .setAllCorners(CornerFamily.ROUNDED, 16F.dpTpx)
            .build()
        val shapeDrawable = MaterialShapeDrawable(shapeAppearanceModel).apply {
            setTint(R.color.purple_500.color())
            paintStyle = Paint.Style.FILL
        }
        val viewOutlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View?, outline: Outline?) {
                if (view == null || outline == null) return
                outline.setRoundRect(0, 0, view.width, view.height, 16F.dpTpx)
            }
        }
        binding.run {
            roundOneTitle.text = "Round one: \n" +
                    "(1 使用 MaterialShapeDrawable 实现圆角背景 \n" +
                    "(2 使用 ViewOutlineProvider 实现圆角裁剪"
            imageOne.background = shapeDrawable
            endImageOne.run {
                outlineProvider = viewOutlineProvider
                clipToOutline = true
            }
        }
    }
}