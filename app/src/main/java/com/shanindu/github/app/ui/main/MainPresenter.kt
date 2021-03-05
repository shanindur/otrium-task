package com.shanindu.github.app.ui.main

import android.util.Log
import com.shanindu.github.app.api.ServiceInterface
import com.shanindu.github.app.models.Repo
import com.shanindu.github.app.models.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Shanindu on 03/03/2021.
 */
class MainPresenter : MainContract.Presenter {
    private val subscriptions = CompositeDisposable()
    private val api: ServiceInterface = ServiceInterface.create()
    private lateinit var view: MainContract.View


    override fun subscribe() {

    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: MainContract.View) {
        this.view = view
    }

    override fun loadUserData() {
        var subscribe = api.getUserData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ user: User? ->
                    Log.d("api.getUserData -> ", user.toString())
                    view.showProgress(false)
                    user?.let { view.showUserData(it) }
                }, { error ->
                    Log.d("error -> ", error.toString())
                    view.showProgress(false)
                    view.showErrorMessage(error.localizedMessage)
                })

        subscriptions.add(subscribe)
    }

    override fun loadPinnedRepos() {
        var subscribe = api.getPinnedRepos().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ list: List<Repo>? ->
                    view.showProgress(false)
                    view.showPinnedRepos(list!!.take(3))
                    view.showTopRepos(list!!.take(10))
                }, { error ->
                    view.showProgress(false)
                    view.showErrorMessage(error.localizedMessage)
                })

        subscriptions.add(subscribe)
    }

    override fun loadStarredRepos() {
        var subscribe = api.getStarredRepos().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ list: List<Repo>? ->
                    view.showProgress(false)
                    view.showStarredRepos(list!!.take(10))
                }, { error ->
                    view.showProgress(false)
                    view.showErrorMessage(error.localizedMessage)
                })

        subscriptions.add(subscribe)
    }

}