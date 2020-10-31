package io.erehsawsaltul.mvvm.utilities

import io.erehsawsaltul.mvvm.data.FakeDatabase
import io.erehsawsaltul.mvvm.data.QuoteRepository
import io.erehsawsaltul.mvvm.ui.quotes.QuotesViewModelFactory

object InjectorUtils {
    fun provideQuotesViewModelFactory():QuotesViewModelFactory{
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}