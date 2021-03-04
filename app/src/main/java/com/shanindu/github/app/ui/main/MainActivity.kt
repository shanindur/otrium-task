package com.shanindu.github.app.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.View
import com.shanindu.github.app.R
import com.shanindu.github.app.di.component.DaggerActivityComponent
import com.shanindu.github.app.di.module.ActivityModule
import com.shanindu.github.app.models.Repo
import com.shanindu.github.app.models.User
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

/**
 * Created by Shanindu on 03/03/2021.
 */
class MainActivity : AppCompatActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        injectDependency()

        presenter.attach(this)
        init();
    }

    override fun onResume() {
        super.onResume()
    }

    private fun init() {
        showProgress(true)
        presenter.loadUserData()
        presenter.loadPinnedRepos()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onBackPressed() {
    }

    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .build()

        activityComponent.inject(this)
    }

    override fun showProgress(show: Boolean) {
        if (show) {
            main_view.visibility = View.GONE
            progressBar.visibility = View.VISIBLE

        } else {
            main_view.visibility = View.VISIBLE
            progressBar.visibility = View.GONE
        }
    }

    override fun showUserData(user: User) {
        textViewName.text = user.name
        textViewEmail.text = user.company
        textViewBio.text = user.bio
        textViewFollowers.text = user.followers.toString() + " followers"
        textViewFollowings.text = user.following.toString() + " followings"
        Picasso
                .get()
                .load(user.avatar_url)
                .into(imageViewAvatar);
    }

    override fun showPinnedRepos(repo: List<Repo>) {
        textViewName1.text = repo[0].full_name
        textViewRepo1.text = repo[0].name
        textViewDescription1.text = repo[0].description
        textViewLanguage1.text = repo[0].language
        textViewStar1.text = repo[0].watchers.toString()
        Picasso
                .get()
                .load(repo[0].owner.avatar_url)
                .into(imageViewAvatar1);

        textViewName2.text = repo[1].full_name
        textViewRepo2.text = repo[1].name
        textViewDescription2.text = repo[1].description
        textViewLanguage2.text = repo[1].language
        textViewStar2.text = repo[1].watchers.toString()
        Picasso
                .get()
                .load(repo[1].owner.avatar_url)
                .into(imageViewAvatar2);

        textViewName3.text = repo[2].full_name
        textViewRepo3.text = repo[2].name
        textViewDescription3.text = repo[2].description
        textViewLanguage3.text = repo[2].language
        textViewStar3.text = repo[2].watchers.toString()
        Picasso.get()
                .load(repo[2].owner.avatar_url)
                .into(imageViewAvatar3);
    }

    override fun showErrorMessage(error: String) {

    }


}