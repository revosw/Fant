package ntnu.simenwii.fant.repository

import ntnu.simenwii.fant.domain.model.Sellable
import ntnu.simenwii.fant.network.SellableService
import ntnu.simenwii.fant.network.model.SellableDtoMapper


class SellableRepositoryImpl(
    private val sellableService: SellableService,
    private val mapper: SellableDtoMapper
): SellableRepository {
    override suspend fun get(token: String, id: Int): Sellable {
        val sellables = sellableService.getAll(token).sellables
        return mapper.mapToDomainModel(sellables.first { it.id == id })
    }

    override suspend fun getAll(token: String): List<Sellable> {
        return mapper.toDomainList(sellableService.getAll(token).sellables)
    }

    override suspend fun search(token: String, query: String): List<Sellable> {
        val sellables = sellableService.getAll(token).sellables
        return mapper.toDomainList(sellables.filter { it.title == query })
    }
}