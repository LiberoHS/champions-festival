package ptcg.championsfestival.domain

open class TournamentDomain internal constructor (
    val id: Int,
    protected val domainFactory: DomainFactory
) {
    fun details() = {}
}