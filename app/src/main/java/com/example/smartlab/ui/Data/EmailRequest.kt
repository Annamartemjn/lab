package com.example.smartlab.ui.Data

import com.google.gson.annotations.SerializedName

data class EmailRequest(
    @SerializedName("email") val email: String
)
