package br.com.boraviajar.apiwatcher.service

import java.time.LocalDate

interface TravelService {

    fun deleteById(id: String);

    fun deleteTravelsByDate(date: LocalDate);
}