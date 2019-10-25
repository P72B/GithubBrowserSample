package de.p72b.umi.github.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import de.p72b.umi.github.R
import de.p72b.umi.github.databinding.FragmentDetailsBinding
import de.p72b.umi.github.services.Repository

class DetailsFragment : Fragment() {

    private lateinit var viewModel: DetailsViewModel
    private lateinit var viewModelFactory: DetailsViewModelFactory

    companion object {
        val TAG: String = DetailsFragment::class.java.simpleName

        private const val EXTRAS_KEY_REPOSITORY: String = "EXTRAS_KEY_REPOSITORY"

        fun newInstance(repository: Repository): DetailsFragment {
            val dialogFragment = DetailsFragment()
            val bundle = Bundle()
            bundle.putParcelable(EXTRAS_KEY_REPOSITORY, repository)
            dialogFragment.arguments = bundle
            return dialogFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentDetailsBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_details,
            container,
            false
        )

        this.arguments?.let { bundle ->
            val repository: Repository? = bundle.getParcelable(EXTRAS_KEY_REPOSITORY)
            repository?.let {
                viewModelFactory = DetailsViewModelFactory(it)
                viewModel = ViewModelProviders.of(this, viewModelFactory)
                    .get(DetailsViewModel::class.java)
                binding.detailsViewModel = viewModel
                binding.lifecycleOwner = this
            }
        }

        return binding.root
    }
}
