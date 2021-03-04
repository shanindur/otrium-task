package com.shanindu.github.app.models

/**
 * Created by Shanindu on 03/03/2021.
 */
data class User(val id: Int, val name: String, val company: String, val avatar_url: String, val bio: String, val followers: Int, val following: Int)
