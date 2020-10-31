package io.erehsawsaltul.mvvm.ui.quotes

import androidx.lifecycle.ViewModel
import io.erehsawsaltul.mvvm.data.Quote
import io.erehsawsaltul.mvvm.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository):ViewModel() {
    fun getQuotes() = quoteRepository.getQuotes()
    fun addQuote(quote:Quote) = quoteRepository.addQuote(quote)
}