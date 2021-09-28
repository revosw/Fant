package ntnu.simenwii.fant.repository

import ntnu.simenwii.fant.domain.model.Sellable

interface SellableRepository {
    suspend fun get(token: String, id: Int): Sellable
    suspend fun getAll(token: String): List<Sellable>
    suspend fun search(token: String, query: String): List<Sellable>
}