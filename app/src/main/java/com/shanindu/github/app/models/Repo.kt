package com.shanindu.github.app.models

/**
 * Created by Shanindu on 03/03/2021.
 */
data class Repo(val id: Int, val full_name: String, val name: String, val description: String, val language: String, var watchers: Int, val owner: User)