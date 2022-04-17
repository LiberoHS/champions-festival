package ptcg.championsfestival.domain

open class PlayerDomain internal constructor (
    val id: Long,
    protected val domainFactory: DomainFactory
) {
    fun deck(tournamentId: Int) = {}
    fun details() = {}
    fun totalCP(season: Int) = {}
}