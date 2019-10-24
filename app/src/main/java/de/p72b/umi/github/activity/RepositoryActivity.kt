package de.p72b.umi.github.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import de.p72b.umi.github.R
import de.p72b.umi.github.services.Repository


class RepositoryActivity : AppCompatActivity() {

    private var listFragment = ListFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(listFragment, ListFragment.TAG)
    }

    override fun onBackPressed() {
        val fragmentManager = supportFragmentManager
        if (fragmentManager.backStackEntryCount > 1) {
            fragmentManager.popBackStackImmediate()
        } else {
            finish()
        }
    }

    fun showDetails(repository: Repository) {
        loadFragment(DetailsFragment.newInstance(repository), DetailsFragment.TAG)
    }

    private fun loadFragment(fragment: Fragment?, tag: String): Boolean {
        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.vFragmentContainer, fragment)
                .addToBackStack(tag)
                .commit()
            return true
        }
        return false
    }
}
