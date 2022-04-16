package ptcg.championsfestival.domain

import org.springframework.stereotype.Service
import ptcg.championsfestival.service.ResultsService

@Service
class DomainFactory(
    private val resultService: ResultsService
) {
    fun tournaments(id: Int): TournamentDomain = TournamentDomain(id, this)
    fun players(id: Int): PlayerDomain = PlayerDomain(id, this)
}