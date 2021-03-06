package com.andalus.agora.Objects

data class Election(
    var name: String = "",
    var description: String = "",
    var startDate: String = "",
    var finishDate: String = "",
    var algorithm: String = "",
    var realTimeResults: Boolean = false,
    var inviteVoters: Boolean = false,
    var secrets: String = "",
    var whoCanSeeVotersList: String = "",
    var status: String = "",
    val candidates: MutableList<String> = mutableListOf()
)