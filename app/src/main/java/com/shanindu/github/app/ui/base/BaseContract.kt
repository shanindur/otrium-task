package com.shanindu.github.app.ui.base

/**
 * Created by Shanindu on 03/03/2021.
 */
class BaseContract {

    interface Presenter<in T> {
        fun subscribe()
        fun unsubscribe()
        fun attach(view: T)
    }

    interface View {

    }
}