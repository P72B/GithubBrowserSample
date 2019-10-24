package de.p72b.umi.github.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import de.p72b.umi.github.R
import de.p72b.umi.github.services.Repository
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : Fragment() {
    private lateinit var rootView: View
    private var repository: Repository? = null

    companion object {
        val TAG: String = DetailsFragment::class.java.simpleName

        private const val EXTRAS_KEY_REPOSITORY : String = "EXTRAS_KEY_REPOSITORY"

        fun newInstance(repository: Repository): DetailsFragment {
            val dialogFragment = DetailsFragment()
            val bundle = Bundle()
            bundle.putParcelable(EXTRAS_KEY_REPOSITORY, repository)
            dialogFragment.arguments = bundle
            return dialogFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.arguments?.let {
            repository = it.getParcelable(EXTRAS_KEY_REPOSITORY)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_details, null)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (repository == null) {
            return
        }
        vDetailsId.text = repository?.id.toString()
    }
}