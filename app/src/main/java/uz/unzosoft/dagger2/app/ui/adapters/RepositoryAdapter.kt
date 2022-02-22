package uz.unzosoft.dagger2.app.ui.adapters

import android.view.View
import coil.load
import coil.transform.CircleCropTransformation
import uz.unzosoft.dagger2.R
import uz.unzosoft.dagger2.app.ui.base.SuperListAdapter
import uz.unzosoft.dagger2.databinding.ItemRepositoryBinding
import uz.unzosoft.dagger2.domain.models.ItemsDto

/**
 * Created by Abdurashidov Shahzod on 22/02/22 23:33.
 * company QQBank
 * shahzod9933@gmail.com
 */
class RepositoryAdapter(private val listener: Callback) : SuperListAdapter<ItemsDto>(
    R.layout.item_repository,
    { oldItem, newItem -> oldItem == newItem },
    { oldItem, newItem -> oldItem == newItem },
) {

    override fun bind(t: ItemsDto, view: View, adapterPosition: Int) {
        val binding = ItemRepositoryBinding.bind(view)
        binding.title.text = t.name
        binding.author.text = t.owner?.login
        binding.description.text = t.description
        binding.forks.text = t.forks.toString()
        binding.stars.text = t.watchers.toString()
        binding.image.load(t.owner?.avatarUrl) {
            crossfade(true)
            transformations(CircleCropTransformation())
        }
        binding.root.setOnClickListener {
            listener.repository(t)
        }
    }

    interface Callback {
        fun repository(dto: ItemsDto)
    }

}