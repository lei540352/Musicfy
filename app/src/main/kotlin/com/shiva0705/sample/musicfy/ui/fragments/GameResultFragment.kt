package com.shiva0705.sample.musicfy.ui.fragments

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.Button
import android.widget.TextView
import butterknife.bindView
import com.shiva0705.sample.musicfy.R
import com.shiva0705.sample.musicfy.domain.GameEngine
import com.shiva0705.sample.musicfy.ui.fragments.core.BaseFragment
import javax.inject.Inject

class GameResultFragment : BaseFragment(){

    override val viewId = R.layout.fragment_game_result
    var score : Int = 0

    val scoreView: TextView by bindView(R.id.score)
    val tryAgain : Button by bindView(R.id.try_again)

    @Inject lateinit var gameEngine: GameEngine

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tryAgain.setOnClickListener({tryAgain()})
    }

    override fun onResume() {
        super.onResume()
        animateNumberChange()
    }

    private fun animateNumberChange() {

        val animator = ValueAnimator()

        animator.setObjectValues(0, score)
        animator.duration = 3000
        animator.interpolator = DecelerateInterpolator()
        animator.addUpdateListener { animation -> scoreView.text = "" + animation.animatedValue as Int }
        animator.start()
    }

    fun tryAgain(){
        gameEngine.reset(activity)
    }

    companion object {
        fun newInstance(score: Int): GameResultFragment {
            var fragment = GameResultFragment()
            fragment.score = score
            return fragment
        }
    }
}