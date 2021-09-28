package ntnu.simenwii.fant.network.model

import ntnu.simenwii.fant.domain.model.Photo
import ntnu.simenwii.fant.domain.model.Sellable
import ntnu.simenwii.fant.domain.util.DomainMapper

class SellableDtoMapper : DomainMapper<SellableDto, Sellable> {
    override fun mapToDomainModel(model: SellableDto): Sellable {
        return Sellable(
            id = model.id,
            description = model.description,
            price = model.price,
            created = model.created,
            photos = model.photos as List<Photo>,
            seller = model.seller,
            title = model.title,
            version = model.version
        )
    }

    override fun mapFromDomainModel(domainModel: Sellable): SellableDto {
        TODO("Not yet implemented")
    }

    fun toDomainList(initial: List<SellableDto>): List<Sellable> {
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<Sellable>): List<SellableDto> {
        return initial.map { mapFromDomainModel(it) }
    }
}