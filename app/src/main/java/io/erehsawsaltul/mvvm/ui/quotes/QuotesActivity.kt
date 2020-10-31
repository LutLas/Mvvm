package io.erehsawsaltul.mvvm.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import io.erehsawsaltul.mvvm.R
import io.erehsawsaltul.mvvm.data.Quote
import io.erehsawsaltul.mvvm.utilities.InjectorUtils

class QuotesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote)
        initializeUi()
    }

    private fun initializeUi(){
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProvider(this,factory).get(QuotesViewModel::class.java)

        viewModel.getQuotes().observe(this,
                Observer {
                    val stringBuilder = StringBuilder()
                    it.forEach {
                        stringBuilder.append("$it\n\n")
                    }
                    /*var textViewQuotes = findViewById<TextView>(R.id.textView_quotes)
                    textViewQuotes.text = stringBuilder.toString()*/
                    findViewById<TextView>(R.id.textView_quotes).text = stringBuilder.toString()

                }
            )
        findViewById<Button>(R.id.button_add_quote).setOnClickListener {
            val quote = Quote(
                    findViewById<EditText>(R.id.editText_quote).text.toString(),
                    findViewById<EditText>(R.id.editText_author).text.toString()
            )
            viewModel.addQuote(quote)
            findViewById<EditText>(R.id.editText_quote).setText("")
            findViewById<EditText>(R.id.editText_author).setText("")
        }
    }
}