package ptcg.championsfestival.domain

open class PlayerDomain internal constructor (
    val id: Int,
    protected val domainFactory: DomainFactory
) {
    fun deck() = {}
    fun details() = {}
}