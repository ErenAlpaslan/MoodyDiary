package com.easylife.mooddiary.utils.helper.review

import android.app.Activity
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/**
 * Created by erenalpaslan on 8.09.2022
 */
object ReviewManager: KoinComponent {
/*
    private val manager: com.google.android.play.core.review.ReviewManager by inject()
    private var reviewInfo: ReviewInfo? = null

    init {
        val request = manager.requestReviewFlow()
        request.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // We got the ReviewInfo object
                reviewInfo = task.result
            } else {
                // There was some problem, log or handle the error code.
            }
        }
    }

    fun showReviewDialog(activity: Activity) {
        reviewInfo?.let {
            val flow = manager.launchReviewFlow(activity, it)
            flow.addOnCompleteListener { _ ->
            }
        }

    }
*/
}