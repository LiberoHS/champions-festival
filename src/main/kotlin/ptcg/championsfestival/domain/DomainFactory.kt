package ptcg.championsfestival.domain

import org.springframework.stereotype.Service
import ptcg.championsfestival.db.TournamentRepository
import ptcg.championsfestival.service.ResultsService

@Service
class DomainFactory(
    private val resultService: ResultsService,
) {
    fun tournaments(id: Long): TournamentDomain = TournamentDomain(id, resultService, this)
    fun players(id: Long): PlayerDomain = PlayerDomain(id, this)
}