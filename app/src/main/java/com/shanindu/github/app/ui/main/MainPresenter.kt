package com.shanindu.github.app.ui.main

import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Shanindu on 03/03/2021.
 */
class MainPresenter : MainContract.Presenter {

    private val subscriptions = CompositeDisposable()
    private lateinit var view: MainContract.View

    override fun subscribe() {

    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: MainContract.View) {
        this.view = view
    }
}