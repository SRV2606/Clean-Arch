package com.example.domain

class ApiError(message: String) : Exception(message) {

}

class NoConnectivityException(message: String) : Exception(message) {

}
