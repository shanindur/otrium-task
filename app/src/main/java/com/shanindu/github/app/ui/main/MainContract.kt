package com.shanindu.github.app.ui.main

import com.shanindu.github.app.models.Repo
import com.shanindu.github.app.models.User
import com.shanindu.github.app.ui.base.BaseContract

/**
 * Created by Shanindu on 03/03/2021.
 */
interface MainContract {

    interface View : BaseContract.View {
        fun showProgress(show: Boolean)
        fun showUserData(user: User)
        fun showPinnedRepos(repo: List<Repo>)
        fun showTopRepos(repo: List<Repo>)
        fun showStarredRepos(repo: List<Repo>)
        fun showErrorMessage(error: String)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun loadUserData()
        fun loadPinnedRepos()
        fun loadStarredRepos()
    }
}