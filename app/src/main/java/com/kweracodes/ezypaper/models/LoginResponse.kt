package com.kweracodes.ezypaper.models

import com.kweracodes.ezypaper.models.User

data class LoginResponse(val error:Boolean,
                         val token: String,
                         val message:String,
                         val user: User
)