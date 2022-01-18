package ohohohoh.xaxaxaxaxax.cubics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat.getColorStateList
import ohohohoh.xaxaxaxaxax.cubics.databinding.ActivityMainBinding

class AsosiyActivity : AppCompatActivity() {

    private val colors = arrayOf(R.color.red, R.color.blue, R.color.green, R.color.yellow)
    private val buttons = Array(25) { 0 }

    private lateinit var binding: ActivityMainBinding
    private var requiredColor: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        requiredColor = colors.random()
        binding.indicator.backgroundTintList = getColorStateList(this, requiredColor)

        val factor = binding.root.context.resources.displayMetrics.density

        binding.grid.rowCount = 3
        binding.grid.columnCount = 3

        for(i in 0..8) {
            val button = AppCompatButton(this)
            val layoutParams = ViewGroup.LayoutParams((60 * factor).toInt(), (60 * factor).toInt())

            button.layoutParams = layoutParams
            button.requestLayout()

            button.randomColor(i)

            button.setOnClickListener {
                button.randomColor(i)
                check()
            }

            binding.grid.addView(button)
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
        this.backgroundTintList = getColorStateList(this@AsosiyActivity, color)
    }
}