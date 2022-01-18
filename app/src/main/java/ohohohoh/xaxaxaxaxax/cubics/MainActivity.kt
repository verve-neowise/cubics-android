package ohohohoh.xaxaxaxaxax.cubics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getColorStateList
import ohohohoh.xaxaxaxaxax.cubics.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val colors = arrayOf(R.color.red, R.color.blue, R.color.green, R.color.yellow)
    private val buttons = Array(25) { 0 }

    private lateinit var binding: ActivityMainBinding
    private var requiredColor: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val factor = binding.root.context.resources.displayMetrics.density

        binding.grid.rowCount = 3
        binding.grid.columnCount = 3

        binding.reset.setOnClickListener {
            randomize()
        }

        for(i in 0..8) {
            val button = AppCompatButton(this)
            val layoutParams = ViewGroup.LayoutParams((60 * factor).toInt(), (60 * factor).toInt())

            button.layoutParams = layoutParams
            button.requestLayout()

            binding.grid.addView(button)
        }

        randomize()
    }

    private fun randomize() {

        requiredColor = colors.random()
        binding.indicator.backgroundTintList = getColorStateList(this, requiredColor)

        val count = binding.grid.childCount
        for (i in 0 until count) {
            val button = binding.grid.getChildAt(i) as AppCompatButton
            button.randomColor(i)

            button.setOnClickListener {
                button.randomColor(i)
                check()
            }
        }
    }

    private fun check() {
        if (buttons.all { it == requiredColor }) {
            Toast.makeText(this, "You win!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun AppCompatButton.randomColor(i: Int) {
        val color = colors.random()
        buttons[i] = color
        this.backgroundTintList = getColorStateList(this@MainActivity, color)
    }
}

/*

https://<username>:<token>@<repo-url>

Remote:
    https://verve-neowise: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@github.com/verve-neowise/cubics-android.git

 https://verve-neowise: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@github.com/verve-neowise/cubics-android.git

username:
token:
repo:

 */