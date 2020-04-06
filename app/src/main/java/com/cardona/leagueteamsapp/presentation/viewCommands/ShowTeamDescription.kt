package com.cardona.leagueteamsapp.presentation.viewCommands

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.cardona.leagueteamsapp.R
import com.cardona.leagueteamsapp.presentation.viewCommands.wrappers.Command

class ShowTeamDescription(
    private val name: String,
    private val description: String,
    private val year: String,
    private val badge: String
): Command {

    override fun execute(view: View) {

        val nameTV = view.findViewById<TextView>(R.id.tvTeamNameFragmentDescription)
        val descriptionTV = view.findViewById<TextView>(R.id.tvDescriptionFragmentDescription)
        val yearTV = view.findViewById<TextView>(R.id.tvYearFragmentDescription)

        nameTV.text = name
        descriptionTV.text = description
        yearTV.text = year

        val badgeIV = view.findViewById<ImageView>(R.id.ivBadgeFragmentDescription)

        Glide.with(view.context).load(badge).into(badgeIV)
    }
}