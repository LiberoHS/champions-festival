package ptcg.championsfestival.domain

import ptcg.championsfestival.db.TournamentRepository
import ptcg.championsfestival.model.Tournament
import ptcg.championsfestival.model.TournamentStandings
import ptcg.championsfestival.service.ResultsService

open class TournamentDomain internal constructor (
    val id: Long,
    protected val resultsService: ResultsService,
    protected val domainFactory: DomainFactory
) {
    fun details(): Tournament? = resultsService.getTournamentById(id)
    fun standings(): Set<TournamentStandings>? = details()?.tournamentStandings
}